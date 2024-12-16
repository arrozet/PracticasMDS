import java.util.Date;

public class Context {
    private PromotionStrategy promotionStrategy;

    public PromotionStrategy getPromotionStrategy() {
        return promotionStrategy;
    }

    public void setPromotionStrategy(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    /**
     * Obtiene el precio final del alquiler
     *
     * @return Precio final
     */
    public int getPrice(Rental rental) {

        long diffInMillis = rental.getEndDate().getTime() - rental.getStartDate().getTime();
        int rentalDays = (int) (diffInMillis / (1000 * 60 * 60 * 24));
        int precioFinah = rentalDays * rental.getCar().getModel().getPricePerDay();
        if (promotionStrategy != null) {
            precioFinah = promotionStrategy.applyPromotion(precioFinah);

        }
        if(rental instanceof  WebRental){
            precioFinah += ((WebRental)rental).getDeliveryOffice().getFeeForDelivery();
        }

        return precioFinah; // Sin promoción aplicada
    }
}

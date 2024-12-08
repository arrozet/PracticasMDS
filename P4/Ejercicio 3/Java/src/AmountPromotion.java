public class AmountPromotion implements Promotion {
    private final int discountAmount;

    public AmountPromotion(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public int applyPromotion(int basePrice) {
        return Math.max(basePrice - discountAmount, 0); // Ensure no negative price
    }
}
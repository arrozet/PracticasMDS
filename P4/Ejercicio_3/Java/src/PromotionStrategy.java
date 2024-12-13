
public interface PromotionStrategy {
	/**
	 *  Función que calcula el precio según la promoción que tenga el alquiler
	 * 
	 * @return precio actualizado
	 */
    int applyPromotion(int basePrice);
}
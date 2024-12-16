public class AmountPromotionStrategy implements PromotionStrategy {
    private final int discountAmount;

    public AmountPromotionStrategy(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public int applyPromotion(int basePrice) {
        return Math.max(basePrice - discountAmount, 0); // Ensure no negative price
    }
}
public class PercentagePromotionStrategy implements PromotionStrategy {
    private final double percentage;

    public PercentagePromotionStrategy(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public int applyPromotion(int basePrice) {
        return (int) (basePrice * (1 - percentage / 100));
    }
}
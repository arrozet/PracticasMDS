public class PercentagePromotion implements Promotion {
    private final double percentage;

    public PercentagePromotion(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public int applyPromotion(int basePrice) {
        return (int) (basePrice * (1 - percentage / 100));
    }
}
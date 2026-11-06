package delivery;
public class ShippingCostVisitor implements PackageVisitor {
    private static final double COST_PER_KG = 500;
    private static final double COST_PER_KM = 10;
    private static final double PROTECTION_FEE = 300;
    private static final double URGENCY_RATE = 0.2;
    @Override
    public void visitStandardPackage(StandardPackage standardPackage) {
        double cost = standardPackage.getWeight() * 500
                + standardPackage.getDistance() * 10;
        System.out.println("Standard Package "
                + standardPackage.getTrackingId()
                + " shipping cost: " + cost + " KZT");
    }
    @Override
    public void visitFragilePackage(FragilePackage fragilePackage) {
        double cost = fragilePackage.getWeight() * 500
                + fragilePackage.getDistance() * 10
                + fragilePackage.getProtectionLevel() * 300;
        System.out.println("Fragile Package "
                + fragilePackage.getTrackingId()
                + " shipping cost: " + cost + " KZT");
    }
    @Override
    public void visitExpressPackage(ExpressPackage expressPackage) {
        double baseCost = expressPackage.getWeight() * 500
                + expressPackage.getDistance() * 10;
        double cost = baseCost
                * (1 + expressPackage.getUrgencyLevel() * 0.2);
        System.out.println("Express Package "
                + expressPackage.getTrackingId()
                + " shipping cost: " + cost + " KZT");
    }
}

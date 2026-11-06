package delivery;
public class DeliveryTimeVisitor implements PackageVisitor {
    private static final double DISTANCE_PER_DAY = 100.0;
    private static final int STANDARD_PROCESSING_DAYS = 2;
    private static final int FRAGILE_PROCESSING_DAYS = 3;
    private static final int MIN_DELIVERY_DAYS = 1;
    @Override
    public void visitStandardPackage(StandardPackage standardPackage) {
        double days = Math.ceil(standardPackage.getDistance() / 100.0) + 2;
        System.out.println("Standard Package "
                + standardPackage.getTrackingId()
                + " delivery time: " + days + " days");
    }
    @Override
    public void visitFragilePackage(FragilePackage fragilePackage) {
        double days = Math.ceil(fragilePackage.getDistance() / 100.0) + 3;
        System.out.println("Fragile Package "
                + fragilePackage.getTrackingId()
                + " delivery time: " + days + " days");
    }
    @Override
    public void visitExpressPackage(ExpressPackage expressPackage) {
        double speed = 100 + expressPackage.getUrgencyLevel() * 100;
        double days = Math.max(1,
                Math.ceil(expressPackage.getDistance() / speed));
        System.out.println("Express Package "
                + expressPackage.getTrackingId()
                + " delivery time: " + days + " days");
    }
}
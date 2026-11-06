package delivery;
public class SafetyCheckVisitor implements PackageVisitor {
    private static final double MAX_STANDARD_WEIGHT = 20.0;
    private static final int MIN_PROTECTION_LEVEL = 3;
    private static final double MAX_EXPRESS_WEIGHT = 10.0;
    @Override
    public void visitStandardPackage(StandardPackage standardPackage) {
        if (standardPackage.getWeight() <= MAX_STANDARD_WEIGHT) {
            System.out.println("Standard Package "
                    + standardPackage.getTrackingId()
                    + ": Safety check PASSED");
        } else {
            System.out.println("Standard Package "
                    + standardPackage.getTrackingId()
                    + ": Safety check FAILED - weight exceeds "
                    + MAX_STANDARD_WEIGHT + " kg");
        }
    }
    @Override
    public void visitFragilePackage(FragilePackage fragilePackage) {
        if (fragilePackage.getProtectionLevel() >= MIN_PROTECTION_LEVEL) {
            System.out.println("Fragile Package "
                    + fragilePackage.getTrackingId()
                    + ": Safety check PASSED");
        } else {
            System.out.println("Fragile Package "
                    + fragilePackage.getTrackingId()
                    + ": Safety check FAILED - insufficient protection");
        }
    }
    @Override
    public void visitExpressPackage(ExpressPackage expressPackage) {
        if (expressPackage.getWeight() <= MAX_EXPRESS_WEIGHT) {
            System.out.println("Express Package "
                    + expressPackage.getTrackingId()
                    + ": Safety check PASSED");
        } else {
            System.out.println("Express Package "
                    + expressPackage.getTrackingId()
                    + ": Safety check FAILED - weight exceeds "
                    + MAX_EXPRESS_WEIGHT + " kg");
        }
    }
}

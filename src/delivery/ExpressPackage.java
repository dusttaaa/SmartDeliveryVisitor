package delivery;
public class ExpressPackage implements PackageElement {
    private String trackingId;
    private double weight;
    private double distance;
    private int urgencyLevel;
    public ExpressPackage(String trackingId, double weight,
                          double distance, int urgencyLevel) {
        this.trackingId = trackingId;
        this.weight = weight;
        this.distance = distance;
        this.urgencyLevel = urgencyLevel;
    }
    public String getTrackingId() {
        return trackingId;
    }
    public double getWeight() {
        return weight;
    }
    public double getDistance() {
        return distance;
    }
    public int getUrgencyLevel() {
        return urgencyLevel;
    }
    @Override
    public void accept(PackageVisitor visitor) {
        visitor.visitExpressPackage(this);
    }
}

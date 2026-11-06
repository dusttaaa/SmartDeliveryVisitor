package delivery;
public class StandardPackage implements PackageElement {
    private String trackingId;
    private double weight;
    private double distance;
    public StandardPackage(String trackingId, double weight, double distance) {
        this.trackingId = trackingId;
        this.weight = weight;
        this.distance = distance;
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
    @Override
    public void accept(PackageVisitor visitor) {
        visitor.visitStandardPackage(this);
    }
}

package delivery;
public class FragilePackage implements PackageElement {
    private String trackingId;
    private double weight;
    private double distance;
    private int protectionLevel;
    public FragilePackage(String trackingId, double weight,
                          double distance, int protectionLevel) {
        this.trackingId = trackingId;
        this.weight = weight;
        this.distance = distance;
        this.protectionLevel = protectionLevel;
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
    public int getProtectionLevel() {
        return protectionLevel;
    }
    @Override
    public void accept(PackageVisitor visitor) {
        visitor.visitFragilePackage(this);
    }
}

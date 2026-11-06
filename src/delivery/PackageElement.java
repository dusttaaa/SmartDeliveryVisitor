package delivery;

public interface PackageElement {
    void accept(PackageVisitor visitor);
}

package delivery;
public interface PackageVisitor {
    void visitStandardPackage(StandardPackage standardPackage);
    void visitFragilePackage(FragilePackage fragilePackage);
    void visitExpressPackage(ExpressPackage expressPackage);
}

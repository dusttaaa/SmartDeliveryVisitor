package delivery;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<PackageElement> packages = new ArrayList<>();
        packages.add(new StandardPackage("STD001", 3.5, 120));
        packages.add(new FragilePackage("FRG001", 2.5, 150, 4));
        packages.add(new ExpressPackage("EXP001", 2.0, 100, 5));

//        packages.add(new StandardPackage("STD002", 25.0, 100));
//        packages.add(new FragilePackage("FRG002", 2.0, 100, 2));
//        packages.add(new ExpressPackage("EXP002", 12.0, 100, 4));
//
//
//        packages.add(new StandardPackage("STD003", 20.0, 100));
//        packages.add(new FragilePackage("FRG003", 2.0, 100, 3));
//        packages.add(new ExpressPackage("EXP003", 10.0, 100, 4));

        PackageVisitor costVisitor = new ShippingCostVisitor();
        PackageVisitor timeVisitor = new DeliveryTimeVisitor();
        PackageVisitor safetyVisitor = new SafetyCheckVisitor();
        System.out.println("=== SHIPPING COST ===");
        for (PackageElement element : packages) {
            element.accept(costVisitor);
        }
        System.out.println("\n=== DELIVERY TIME ===");
        for (PackageElement element : packages) {
            element.accept(timeVisitor);
        }
        System.out.println("\n=== SAFETY CHECK ===");
        for (PackageElement element : packages) {
            element.accept(safetyVisitor);
        }
    }
}


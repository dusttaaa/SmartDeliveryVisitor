# Smart Delivery Management System
## Muratova Albina | SE-2511
## 1. Project Overview
Smart Delivery Management System is a Java console application that demonstrates the **Visitor Design Pattern**.
The application manages different types of delivery packages and performs operations such as shipping cost calculation, delivery time estimation, and safety validation.
The main goal is to separate package data from the operations performed on packages, making the system easier to extend and maintain.

## 2. Design Pattern

**Pattern:** Visitor Pattern  
**Category:** Behavioral Design Pattern  
**Programming Language:** Java 17

The Visitor Pattern allows new operations to be added to existing object structures without modifying the classes of the elements being processed.
The implementation uses **double dispatch** to execute the appropriate operation for each package type.

## 3. Project Structure

```text
SmartDeliveryVisitor/
├── src/
│   └── delivery/
│       ├── PackageElement.java
│       ├── PackageVisitor.java
│       ├── StandardPackage.java
│       ├── FragilePackage.java
│       ├── ExpressPackage.java
│       ├── ShippingCostVisitor.java
│       ├── DeliveryTimeVisitor.java
│       ├── SafetyCheckVisitor.java
│       └── Main.java
└── README.md
```

## 4. Main Components

### Element Interface

`PackageElement` declares the `accept(PackageVisitor visitor)` method.

### Concrete Elements

- `StandardPackage` — represents a regular delivery package.
- `FragilePackage` — represents a package requiring additional protection.
- `ExpressPackage` — represents a package with an urgency level.

Each concrete element implements `accept()` and calls the corresponding visitor method.

### Visitor Interface

`PackageVisitor` declares separate visit methods for each package type:

- `visitStandardPackage()`
- `visitFragilePackage()`
- `visitExpressPackage()`

### Concrete Visitors

**ShippingCostVisitor**

Calculates shipping costs based on weight, distance, and package-specific requirements.

**DeliveryTimeVisitor**

Estimates delivery times based on distance, processing time, and urgency.

**SafetyCheckVisitor**

Checks whether packages satisfy the defined safety requirements.

### Client and Object Structure

`Main` creates a collection of `PackageElement` objects and applies different visitors to the collection.

## 5. Double Dispatch

Double dispatch allows the program to select the correct visitor operation based on the concrete element and visitor objects.

For example:

```java
element.accept(costVisitor);
```

Inside `StandardPackage`:

```java
@Override
public void accept(PackageVisitor visitor) {
    visitor.visitStandardPackage(this);
}
```

This approach avoids long `instanceof` chains and separates operations from package classes.

## 6. Clean Code Principles

The project demonstrates five Clean Code practices.

**1. Meaningful Names**

Classes, methods, and constants have descriptive names, such as `ShippingCostVisitor`, `getTrackingId()`, and `MAX_STANDARD_WEIGHT`.

**2. Single Responsibility Principle (SRP)**

Each concrete visitor performs one main responsibility: cost calculation, delivery time estimation, or safety validation.

**3. Open/Closed Principle (OCP)**

New operations can be introduced by implementing additional visitors without modifying the existing concrete package classes.

**4. Encapsulation**

Package attributes are private and accessed through public getter methods.

**5. Avoiding Type-Checking Chains**

The application uses the Visitor Pattern and double dispatch instead of `instanceof` chains to determine package-specific operations.

## 7. Testing

The application was manually tested with nine package objects across three scenarios.

| Test scenario | Expected result | Actual result |
|---|---|---|
| Valid packages | All safety checks pass | Passed |
| Invalid packages | All safety checks fail | Passed |
| Boundary values | Values exactly at the limits are accepted | Passed |

The shipping cost and delivery time calculations were also checked against the implemented formulas.

## 8. Example Output

```text
=== SHIPPING COST ===
Standard Package STD001 shipping cost: 2950.0 KZT
Fragile Package FRG001 shipping cost: 3950.0 KZT
Express Package EXP001 shipping cost: 4000.0 KZT

=== DELIVERY TIME ===
Standard Package STD001 delivery time: 4.0 days
Fragile Package FRG001 delivery time: 5.0 days
Express Package EXP001 delivery time: 1.0 days

=== SAFETY CHECK ===
Standard Package STD001: Safety check PASSED
Fragile Package FRG001: Safety check PASSED
Express Package EXP001: Safety check PASSED
```

## 9. Conclusion

This project demonstrates how the Visitor Design Pattern separates operations from object structures.

It supports multiple package types, independent visitor operations, and extensibility through new visitors.

The implementation emphasizes readable code, separation of responsibilities, encapsulation, and maintainability.

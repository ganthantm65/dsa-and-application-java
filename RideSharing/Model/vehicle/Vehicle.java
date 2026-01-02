package Model.vehicle;


public abstract class Vehicle {
    String type;
    double basePrice;
    double perKmPrice;

    public abstract double calculateFairPrice(int distance);
}

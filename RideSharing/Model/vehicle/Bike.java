package Model.vehicle;

public class Bike extends Vehicle{

    public Bike(){
        this.type="Bike";
        this.basePrice=200;
        this.perKmPrice=10;
    }

    @Override
    public double calculateFairPrice(int distance) {
        return basePrice+(perKmPrice*distance);
    }
}

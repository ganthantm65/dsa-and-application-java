package Model.vehicle;

public class Car extends Vehicle{

    public Car(){
        this.type="Car";
        this.basePrice=500;
        this.perKmPrice=20;
    }

    @Override
    public double calculateFairPrice(int distance){
        return basePrice+(perKmPrice*distance);
    }

}

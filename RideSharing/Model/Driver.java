package Model;

import Map.Location;
import Model.vehicle.Vehicle;

public class Driver {

    private String name;
    private Location currentLocation;
    private boolean isAvailable;
    private Vehicle vehicle;
    private int distance;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Location getCurrentLocation() { return currentLocation; }
    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailablity(boolean availablity) {
        this.isAvailable = availablity;
    }

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

    public int getDistance() { return distance; }
    public void setDistance(int distance) { this.distance = distance; }
}

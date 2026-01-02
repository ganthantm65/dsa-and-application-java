import Model.Driver;
import Model.Ride;
import Model.User;
import Map.*;
import Model.vehicle.Vehicle;

import java.util.*;

public class RideService {

    private PriorityQueue<Driver> drivers;
    private List<Ride> ridesInProgress;
    private List<User> userInRides;

    private CityMap cityMap;
    private RouteCalculator routeCalculator;

    public RideService() {
        drivers = new PriorityQueue<>(Comparator.comparingInt(Driver::getDistance));
        ridesInProgress = new ArrayList<>();
        userInRides = new ArrayList<>();
        cityMap = new CityMap();
        routeCalculator = new RouteCalculator();
    }

    public Ride allocateRide(User user) {

        FinalRoute finalRoute = routeCalculator.calculateShortestDistance(
                cityMap.getCityMap(),
                user.getFromLocation(),
                user.getToLocation()
        );

        if (finalRoute == null) return null;

        // Update driver distance to user
        List<Driver> temp = new ArrayList<>();
        while (!drivers.isEmpty()) {
            Driver d = drivers.poll();
            int dist = routeCalculator.calculateShortestDistance(
                    cityMap.getCityMap(),
                    d.getCurrentLocation(),
                    user.getFromLocation()
            ).getDistance();
            d.setDistance(dist);
            temp.add(d);
        }

        drivers.addAll(temp);

        Driver selectedDriver = null;
        int size = drivers.size();

        for (int i = 0; i < size; i++) {
            Driver d = drivers.poll();
            if (d.isAvailable()) {
                selectedDriver = d;
                break;
            }
            drivers.offer(d);
        }

        if (selectedDriver == null) return null;

        selectedDriver.setAvailablity(false);

        Vehicle vehicle = selectedDriver.getVehicle();
        double fare = vehicle.calculateFairPrice(finalRoute.getDistance());

        Ride ride = new Ride();
        ride.setUser(user);
        ride.setDriver(selectedDriver);
        ride.setFinalRoute(finalRoute);
        ride.setFairPrice(fare);

        ridesInProgress.add(ride);
        userInRides.add(user);

        return ride;
    }

    public void addRoute(Location from, Location to, int distance) {
        cityMap.addEdges(from, to, distance);
    }

    public void addDriver(Driver driver) {
        driver.setAvailablity(true);
        driver.setDistance(0);
        drivers.offer(driver);
    }
}

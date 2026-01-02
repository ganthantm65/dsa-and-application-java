import Map.Location;
import Model.Driver;
import Model.Ride;
import Model.User;
import Model.vehicle.Bike;
import Model.vehicle.Car;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {

        RideService rideService = new RideService();

        System.out.println("Welcome to Chennai Ride Booking System");

        setupLocations();
        setupRoutes(rideService);
        setupDrivers(rideService);

        while (true) {
            System.out.println("\n1. Book Ride");
            System.out.println("2. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                bookRide(rideService);
            } else {
                System.out.println("Thank you for using the system");
                break;
            }
        }
    }

    private static void setupLocations() {
        locations.put(1, new Location("T Nagar"));
        locations.put(2, new Location("Anna Nagar"));
        locations.put(3, new Location("Adyar"));
        locations.put(4, new Location("Velachery"));
        locations.put(5, new Location("Guindy"));
        locations.put(6, new Location("Tambaram"));
        locations.put(7, new Location("Chennai Central"));
    }

    private static void setupRoutes(RideService service) {
        service.addRoute(locations.get(1), locations.get(5), 6);
        service.addRoute(locations.get(5), locations.get(4), 5);
        service.addRoute(locations.get(4), locations.get(3), 7);
        service.addRoute(locations.get(3), locations.get(1), 8);
        service.addRoute(locations.get(2), locations.get(5), 7);
        service.addRoute(locations.get(2), locations.get(7), 6);
        service.addRoute(locations.get(7), locations.get(1), 5);
        service.addRoute(locations.get(6), locations.get(4), 10);
    }

    private static void setupDrivers(RideService service) {

        Driver d1 = new Driver();
        d1.setName("Ravi");
        d1.setCurrentLocation(locations.get(1));
        d1.setVehicle(new Car());

        Driver d2 = new Driver();
        d2.setName("Karthik");
        d2.setCurrentLocation(locations.get(4));
        d2.setVehicle(new Bike());

        Driver d3 = new Driver();
        d3.setName("Suresh");
        d3.setCurrentLocation(locations.get(7));
        d3.setVehicle(new Car());

        service.addDriver(d1);
        service.addDriver(d2);
        service.addDriver(d3);
    }

    private static void bookRide(RideService service) {

        User user = new User();

        System.out.print("User ID: ");
        user.setId(scanner.nextLine());

        System.out.print("Name: ");
        user.setName(scanner.nextLine());

        locations.forEach((k, v) ->
                System.out.println(k + ". " + v.getLocation())
        );

        System.out.print("Pickup: ");
        user.setFromLocation(locations.get(scanner.nextInt()));

        System.out.print("Drop: ");
        user.setToLocation(locations.get(scanner.nextInt()));
        scanner.nextLine();

        Ride ride = service.allocateRide(user);

        if (ride == null) {
            System.out.println("No ride available");
            return;
        }

        System.out.println("\nRide Confirmed");
        System.out.println("Passenger: " + ride.getUser().getName());
        System.out.println("Driver   : " + ride.getDriver().getName());
        System.out.println("Vehicle  : " +
                ride.getDriver().getVehicle().getClass().getSimpleName());
        System.out.println("Route    : " +
                ride.getFinalRoute().getInternalLocations());
        System.out.println("Distance : " +
                ride.getFinalRoute().getDistance() + " km");
        System.out.println("Fare     : ₹" + ride.getFairPrice());
    }
}

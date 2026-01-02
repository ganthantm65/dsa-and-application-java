package Model;

import Map.FinalRoute;
import Map.Location;

public class Ride {
    private User user;
    private Driver driver;
    private FinalRoute finalRoute;
    private double fairPrice;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public FinalRoute getFinalRoute() {
        return finalRoute;
    }

    public void setFinalRoute(FinalRoute finalRoute) {
        this.finalRoute = finalRoute;
    }

    public double getFairPrice() {
        return fairPrice;
    }

    public void setFairPrice(double fairPrice) {
        this.fairPrice = fairPrice;
    }
}

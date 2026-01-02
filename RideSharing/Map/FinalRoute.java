package Map;

import java.util.List;

public class FinalRoute {
    private Location source;

    private Location destination;

    private List<String> internalLocations;

    private int distance;

    public Location getSource() {
        return source;
    }

    public void setSource(Location source) {
        this.source = source;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public List<String> getInternalLocations() {
        return internalLocations;
    }

    public void setInternalLocations(List<String> internalLocations) {
        this.internalLocations = internalLocations;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}

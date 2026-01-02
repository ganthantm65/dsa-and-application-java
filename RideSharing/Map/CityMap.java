package Map;

import java.util.*;

public class CityMap {

    private Map<Location, List<Edge>> cityMap = new HashMap<>();

    public void addEdges(Location from, Location to, int distance) {

        cityMap.putIfAbsent(from, new ArrayList<>());
        cityMap.putIfAbsent(to, new ArrayList<>());

        Edge e1 = new Edge();
        e1.setToLocation(to);
        e1.setDistance(distance);

        Edge e2 = new Edge();
        e2.setToLocation(from);
        e2.setDistance(distance);

        cityMap.get(from).add(e1);
        cityMap.get(to).add(e2);
    }

    public Map<Location, List<Edge>> getCityMap() {
        return cityMap;
    }
}

package Map;

import java.util.*;

public class RouteCalculator {

    static class Pair {
        Location location;
        int dist;

        Pair(Location location, int dist) {
            this.location = location;
            this.dist = dist;
        }
    }

    public FinalRoute calculateShortestDistance(
            Map<Location, List<Edge>> graph,
            Location source,
            Location dest
    ) {

        Map<Location, Integer> dist = new HashMap<>();
        Map<Location, Location> parent = new HashMap<>();

        for (Location loc : graph.keySet()) {
            dist.put(loc, Integer.MAX_VALUE);
        }

        dist.put(source, 0);

        PriorityQueue<Pair> pq =
                new PriorityQueue<>(Comparator.comparingInt(p -> p.dist));

        pq.offer(new Pair(source, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            Location u = curr.location;

            if (curr.dist > dist.get(u)) continue;

            if (u.equals(dest)) {
                FinalRoute route = new FinalRoute();
                route.setSource(source);
                route.setDestination(dest);
                route.setDistance(dist.get(u));
                route.setInternalLocations(buildPath(parent, source, dest));
                return route;
            }

            for (Edge edge : graph.getOrDefault(u, new ArrayList<>())) {
                Location v = edge.getToLocation();
                int newDist = dist.get(u) + edge.getDistance();

                if (newDist < dist.getOrDefault(v, Integer.MAX_VALUE)) {
                    dist.put(v, newDist);
                    parent.put(v, u);
                    pq.offer(new Pair(v, newDist));
                }
            }
        }
        return null;
    }

    private List<String> buildPath(
            Map<Location, Location> parent,
            Location src,
            Location dest
    ) {
        List<String> path = new ArrayList<>();
        Location curr = dest;

        while (curr != null) {
            path.add(curr.getLocation());
            curr = parent.get(curr);
        }

        Collections.reverse(path);
        return path;
    }
}

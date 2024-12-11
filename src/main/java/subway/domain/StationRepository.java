package subway.domain;

import java.util.*;

public class StationRepository {
    
    private static final List<Station> stations = new ArrayList<>();
    
    public static void init() {
		stations.addAll(StationInfo.createStations());
    }

    public static List<Station> stations() {
        if (stations.isEmpty()) init();
        return Collections.unmodifiableList(stations);
    }
    
    public static Optional<Station> findByName(String name) {
        if (stations().isEmpty()) init();
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                return Optional.of(station);
            }
        }
        return Optional.empty();
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }
}

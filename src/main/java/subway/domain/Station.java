package subway.domain;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.WeightedMultigraph;
import subway.dto.PathFindResult;

import java.util.List;

public class Station {
    
    private final String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public static PathFindResult findLengthShotestPath(
            Station from,
            Station to,
            List<Station> stations,
            List<SubLine> sublines
    ) {
        WeightedMultigraph<Station, SubLine> graph = new WeightedMultigraph<>(SubLine.class);
        for (Station station : stations) {
            graph.addVertex(station);
        }
        for (SubLine subline : sublines) {
            graph.setEdgeWeight(graph.addEdge(subline.getFrom(), subline.getTo()), subline.getLength());
        }
        return getPathFindResult(from, to, graph);
    }
    
    public static PathFindResult findTimeShotestPath(
            Station from,
            Station to,
            List<Station> stations,
            List<SubLine> sublines
    ) {
        WeightedMultigraph<Station, SubLine> graph = new WeightedMultigraph<>(SubLine.class);
        for (Station station : stations) {
            graph.addVertex(station);
        }
        for (SubLine subline : sublines) {
            graph.setEdgeWeight(graph.addEdge(subline.getFrom(), subline.getTo()), subline.getTime());
        }
        return getPathFindResult(from, to, graph);
    }
    
    private static PathFindResult getPathFindResult(Station from, Station to, WeightedMultigraph<Station, SubLine> graph) {
        GraphPath<Station, SubLine> path = new DijkstraShortestPath<>(graph).getPath(from, to);
        List<String> stationNames = path.getVertexList().stream()
                .map(Station::getName)
                .toList();
        int totalLength = 0;
        int totalTime = 0;
        for (SubLine subLine : path.getEdgeList()) {
            totalLength += subLine.getLength();
            totalTime += subLine.getTime();
        }
        return new PathFindResult(totalLength, totalTime, stationNames);
    }
}

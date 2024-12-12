package subway.domain;

import java.util.*;

public class LineRepository {
    
    private static final List<Line> lines = new ArrayList<>();
    
    public static void init() {
        List<Station> stations = StationRepository.stations();
        lines.addAll(LineInfo.createLines(stations));
    }

    public static List<Line> lines() {
        if (lines.isEmpty()) init();
        return Collections.unmodifiableList(lines);
    }
    
    public static List<SubLine> subLines() {
        if (lines.isEmpty()) init();
        return lines.stream()
                .map(Line::getSubLines)
                .flatMap(Collection::stream)
                .toList();
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }
}

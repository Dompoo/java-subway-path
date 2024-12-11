package subway.domain;

import java.util.List;

public class Line {
    
    private final String name;
    private final List<SubLine> subLines;
    
    public Line(String name, List<SubLine> subLines) {
        this.name = name;
        this.subLines = subLines;
    }
    
    public String getName() {
        return name;
    }
    
    public List<SubLine> getSubLines() {
        return subLines;
    }
}

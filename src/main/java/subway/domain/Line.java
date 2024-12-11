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

    // 추가 기능 구현
}

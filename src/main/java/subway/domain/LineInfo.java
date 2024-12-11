package subway.domain;

import subway.CustomExceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static subway.domain.StationInfo.*;

public enum LineInfo {
	
	LINE_2(
			"2호선",
			List.of(교대, 강남, 역삼),
			List.of(2, 2),
			List.of(3, 3)
	),
	LINE_3(
			"3호선",
			List.of(교대, 남부터미널, 양재, 매봉),
			List.of(3, 6, 1),
			List.of(2, 5, 1)
	),
	LINE_신분당(
			"신분당선",
			List.of(강남, 양재, 양재시민의숲),
			List.of(2, 10),
			List.of(8, 3)
	),
	;
	
	private final String lineName;
	private final List<StationInfo> stationInfos;
	private final List<Integer> lengths;
	private final List<Integer> times;
	
	LineInfo(String lineName, List<StationInfo> stationInfos, List<Integer> lengths, List<Integer> times) {
		validate(stationInfos, lengths, times);
		this.lineName = lineName;
		this.stationInfos = stationInfos;
		this.lengths = lengths;
		this.times = times;
	}
	
	private void validate(List<StationInfo> stationInfos, List<Integer> lengths, List<Integer> times) {
		if (stationInfos.size() != lengths.size() + 1 || stationInfos.size() != times.size() + 1) {
			throw CustomExceptions.LINE_INFO_INIT_FAIL.get();
		}
	}
	
	public static List<Line> createLines(List<Station> stations) {
		Map<String, Station> stationMap = new HashMap<>();
		for (Station station : stations) {
			stationMap.put(station.getName(), station);
		}
		
		List<Line> lines = new ArrayList<>();
		for (LineInfo lineInfo : LineInfo.values()) {
			List<SubLine> subLines = new ArrayList<>();
			for (int i = 0; i < lineInfo.stationInfos.size() - 1; i++) {
				SubLine subLine = new SubLine(
						stationMap.get(lineInfo.stationInfos.get(i).name()),
						stationMap.get(lineInfo.stationInfos.get(i + 1).name()),
						lineInfo.lengths.get(i),
						lineInfo.times.get(i)
				);
				subLines.add(subLine);
			}
			lines.add(new Line(lineInfo.lineName, subLines));
		}
		return lines;
	}
}

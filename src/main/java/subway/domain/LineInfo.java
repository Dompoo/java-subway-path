package subway.domain;

import subway.CustomExceptions;

import java.util.List;

import static subway.domain.StationInfo.*;

public enum LineInfo {
	
	LINE_2(
			List.of(교대, 강남, 역삼),
			List.of(2, 2),
			List.of(3, 3)
	),
	LINE_3(
			List.of(교대, 남부터미널, 양재, 매봉),
			List.of(3, 6, 1),
			List.of(2, 5, 1)
	),
	LINE_신분당(
			List.of(강남, 양재, 양재시민의숲),
			List.of(2, 10),
			List.of(8, 3)
	),
	;
	
	private final List<StationInfo> stationInfos;
	private final List<Integer> lengths;
	private final List<Integer> times;
	
	LineInfo(List<StationInfo> stationInfos, List<Integer> lengths, List<Integer> times) {
		validate(stationInfos, lengths, times);
		this.stationInfos = stationInfos;
		this.lengths = lengths;
		this.times = times;
	}
	
	private void validate(List<StationInfo> stationInfos, List<Integer> lengths, List<Integer> times) {
		if (stationInfos.size() != lengths.size() + 1 || stationInfos.size() != times.size() + 1) {
			throw CustomExceptions.LINE_INFO_INIT_FAIL.get();
		}
	}
}

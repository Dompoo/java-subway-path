package subway.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum StationInfo {

	교대,
	강남,
	역삼,
	남부터미널,
	양재,
	양재시민의숲,
	매봉,
	;
	
	public static List<Station> createStations() {
		return Arrays.stream(StationInfo.values())
				.map(info -> new Station(info.name()))
				.collect(Collectors.toList());
	}
}

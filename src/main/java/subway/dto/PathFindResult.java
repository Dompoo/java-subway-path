package subway.dto;

import java.util.List;

public record PathFindResult(
		int totalLenght,
		int totalTime,
		List<String> stationNames
) {
}

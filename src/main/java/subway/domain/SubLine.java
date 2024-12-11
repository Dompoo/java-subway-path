package subway.domain;

public class SubLine {
	
	private final Station from;
	private final Station to;
	private final int length;
	private final int time;
	
	public SubLine(Station from, Station to, int length, int time) {
		this.from = from;
		this.to = to;
		this.length = length;
		this.time = time;
	}
}

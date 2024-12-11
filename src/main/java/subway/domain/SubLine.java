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
	
	public Station getFrom() {
		return from;
	}
	
	public Station getTo() {
		return to;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getTime() {
		return time;
	}
}

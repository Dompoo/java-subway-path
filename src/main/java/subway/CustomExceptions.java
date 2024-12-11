package subway;

public enum CustomExceptions {
	
	LINE_INFO_INIT_FAIL(
			"노선 정보에 문제가 있습니다. 프로그램을 종료합니다.",
			IllegalStateException.class
	),
	STATION_NOT_FOUND(
			"존재하지 않는 역 이름입니다. 프로그램을 종료합니다.",
			IllegalStateException.class
	),
	;
	
	private final String message;
	private final Class<? extends RuntimeException> exceptionType;
	
	CustomExceptions(String message, Class<? extends RuntimeException> exceptionType) {
		this.message = message;
		this.exceptionType = exceptionType;
	}
	
	public RuntimeException get() {
		try {
			return exceptionType.getDeclaredConstructor(String.class).newInstance(message);
		} catch (Exception e) {
			return new RuntimeException(message);
		}
	}
}

package subway;

import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.dto.PathFindResult;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("""
                ## 메인 화면
                1. 경로 조회
                Q. 종료
                
                ## 원하는 기능을 선택하세요.
                """);
            String input = scanner.nextLine();
            if (input.equals("Q")) return;
            
            System.out.println("""
                ## 출발역을 입력하세요.
                """);
            String startStationName = scanner.nextLine();
            
            System.out.println("""
                ## 도착역을 입력하세요.
                """);
            String endStationName = scanner.nextLine();
            
            System.out.println("""
                ## 경로 기준
                1. 최단 거리
                2. 최소 시간
                B. 돌아가기
                """);
            String choice = scanner.nextLine();
            if (choice.equals("B")) continue;
            
            if (choice.equals("1")) {
                PathFindResult result = Station.findLengthShotestPath(
                        StationRepository.findByName(startStationName).orElseThrow(CustomExceptions.STATION_NOT_FOUND::get),
                        StationRepository.findByName(endStationName).orElseThrow(CustomExceptions.STATION_NOT_FOUND::get),
                        StationRepository.stations(),
                        LineRepository.subLines()
                );
                System.out.println(result);
                continue;
            }
            
            PathFindResult result = Station.findTimeShotestPath(
                    StationRepository.findByName(startStationName).orElseThrow(CustomExceptions.STATION_NOT_FOUND::get),
                    StationRepository.findByName(endStationName).orElseThrow(CustomExceptions.STATION_NOT_FOUND::get),
                    StationRepository.stations(),
                    LineRepository.subLines()
            );
            System.out.println(result);
        }
    }
}

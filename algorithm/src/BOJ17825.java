/**
 * @author nakhoonchoi
 * @date 2024/10/07
 * @see https://www.acmicpc.net/problem/17825
 * @mem 127,480kb
 * @time 600ms
 * @caution
 * [고려사항]
 * 역대급으로 오래 걸렸던 문제.
 * 윷놀이 판을 어떻게 구현할 지, 그리고 말의 이동을 어떻게 구현할 지 고민해야했다.
 * gameMap은 Map<Integer, Map<Integer, Point>>로 구성되어있는데,
 * 현재 좌표에 대한 다음 위치를 Map<Integer, Point> 형태로 저장했다.
 * 다음 위치에는 이전 좌표와 화살표의 색깔의 대한 정보를 저장했다.
 *
 * 말의 위치 중 16, 22, 24, 26, 28, 30은 두 곳이 있으므로 구별해주어야했다.
 * 그래서 10x+y로 y에는 화살표의 색깔, x에는 좌표의 값을 기준으로 좌표를 판별하였다.
 * 예를 들어, 좌표값이 30인데 파란 화살표와 관련 있는 경우 301,
 * 좌표값이 22인데 빨간 화살표와 관련 있는 경우는 220으로 표현했다.
 *
 * 말의 위치에 대한 visited 체크를 확실히 하고, dfs 시에 말의 정보를 정확히 롤백시켜야했다.
 *
 * 그리고 10, 20, 30에서 갈라지는 경우와, 25, 40에서 합쳐지는 경우를 잘 구현해야했다.
 * 또, 백트래킹을 위해 현재 turn에 대한 총합으로 중복을 가르고자 했는데, 중복이 나올 수 있는 여러 경우의 수가 있고,
 * 그 경우의 수가 최대값을 나타낼 수 있는 경우일 수도 있기 때문에 중복 체크 로직을 제거하였을 때 AC를 받을 수 있었다.
 *
 * 참고했던 테스트 케이스 : 5 4 5 2 2 2 5 3 1 4 -> 245
 *
 * [입력사항]
 * [출력사항]
 */

import java.io.*;
import java.util.*;
//백준 <삼성기출/구현> '주사위 윷놀이'

public class BOJ17825 {
    static int [] dice;
    static Map<Integer, Map<Integer, Point>> gameMap;
    static Map<Integer, Boolean> pieceVisitedMap;
    static int answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        gameMap = new HashMap<>();
        pieceVisitedMap = new HashMap<>();
        dice = new int[10];

        for(int i=0;i<10;i++){
            dice[i] = Integer.parseInt(st.nextToken());
        }

        init();

        Point [] pointPiece = new Point[4];
        for(int i=0;i<4;i++){
            pointPiece[i] = new Point(0, 2, false);
        }

        dfs(pointPiece, 0, 0);

        System.out.println(answer);
    }

    public static void dfs(Point [] pointPiece, int turn, int total){
        if(turn == 10){
            answer = Math.max(answer, total);
            return;
        }

        for(int i=0;i<4;i++){
            Point temp = new Point(pointPiece[i].cur, pointPiece[i].next, pointPiece[i].isBlue);
            Point point = pointPiece[i];

            if(point.cur == -1 && point.next == -1){
                continue;
            }

            for(int j=0;j<dice[turn];j++){
                point = move(point);
                if(point.cur == -1 && point.next == -1){
                    break; //말이 도착한 경우
                }
            }

            if(point.cur == 10 || point.cur == 20 || point.cur == 300 || point.cur == 301){
                Point bluePoint = gameMap.get(point.cur).get(point.cur);
                point.isBlue = bluePoint.isBlue;
                point.next = bluePoint.next;
            }

            //말이 도착한 경우
            if(point.cur == -1 && point.next == -1){
                pointPiece[i] = point;
                pieceVisitedMap.put(temp.cur, false);
                dfs(pointPiece, turn+1, total);
                pieceVisitedMap.put(temp.cur, true);
                pointPiece[i] = temp;
            }

            //이동할 곳에 말이 없는 경우 + turn 별 총합이 이미 지나간 적이 없는 경우
            if(pieceVisitedMap.containsKey(point.cur) && !pieceVisitedMap.get(point.cur)){
                pointPiece[i] = point;
                pieceVisitedMap.put(point.cur, true);
                pieceVisitedMap.put(temp.cur, false);
                dfs(pointPiece, turn+1, total + (point.cur > 100 ? point.cur / 10 : point.cur));
                pieceVisitedMap.put(point.cur, false);
                pieceVisitedMap.put(temp.cur, true);
                pointPiece[i] = temp;
            }
        }
    }

    public static Point move(Point point){
        int cur = point.cur;

        if(point.next == -1){ //말이 도착지에 도착한 경우
            return new Point(-1, -1, false);
        }

        Map<Integer, Point> map = gameMap.get(point.next);

        Point nextPoint = map.get(cur);

        return new Point(point.next, nextPoint.next, nextPoint.isBlue);
    }

    public static void init(){
        Map<Integer, Point> map;
        map = new HashMap<>();
        map.put(-2, new Point(2, false));
        gameMap.put(0, map);
        pieceVisitedMap.put(0, false);

        map = new HashMap<>();
        map.put(0, new Point(4, false));
        gameMap.put(2, map);
        pieceVisitedMap.put(2, false);

        map = new HashMap<>();
        map.put(2, new Point(6, false));
        gameMap.put(4, map);
        pieceVisitedMap.put(4, false);

        map = new HashMap<>();
        map.put(4, new Point(8, false));
        gameMap.put(6, map);
        pieceVisitedMap.put(6, false);

        map = new HashMap<>();
        map.put(6, new Point(10, false));
        gameMap.put(8, map);
        pieceVisitedMap.put(8, false);

        map = new HashMap<>();
        map.put(8, new Point(12, false));
        map.put(10, new Point(13, true));
        gameMap.put(10, map);
        pieceVisitedMap.put(10, false);

        map = new HashMap<>();
        map.put(10, new Point(14, false));
        gameMap.put(12, map);
        pieceVisitedMap.put(12, false);

        map = new HashMap<>();
        map.put(10, new Point(161, true));
        gameMap.put(13, map);
        pieceVisitedMap.put(13, false);

        map = new HashMap<>();
        map.put(12, new Point(160, false));
        gameMap.put(14, map);
        pieceVisitedMap.put(14, false);

        map = new HashMap<>();
        map.put(14, new Point(18, false));
        gameMap.put(160, map);
        pieceVisitedMap.put(160, false);

        map = new HashMap<>();
        map.put(13, new Point(19, true));
        gameMap.put(161, map);
        pieceVisitedMap.put(161, false);

        map = new HashMap<>();
        map.put(160, new Point(20, false));
        gameMap.put(18, map);
        pieceVisitedMap.put(18, false);

        map = new HashMap<>();
        map.put(161, new Point(25, true));
        gameMap.put(19, map);
        pieceVisitedMap.put(19, false);

        map = new HashMap<>();
        map.put(18, new Point(220, false));
        map.put(20, new Point(221, true));
        gameMap.put(20, map);
        pieceVisitedMap.put(20, false);

        map = new HashMap<>();
        map.put(20, new Point(240, false));
        gameMap.put(220, map);
        pieceVisitedMap.put(220, false);

        map = new HashMap<>();
        map.put(20, new Point(241, false));
        gameMap.put(221, map);
        pieceVisitedMap.put(221, false);

        map = new HashMap<>();
        map.put(220, new Point(260, false)); //특이 케이스라 flag를 0의 자리에 표시했다.
        gameMap.put(240, map);
        pieceVisitedMap.put(240, false);

        map = new HashMap<>();
        map.put(221, new Point(25, true)); //0의 경우에는 빨간 화살표, 1의 경우에는 파란 화살표
        gameMap.put(241, map);
        pieceVisitedMap.put(241, false);

        map = new HashMap<>();
        map.put(19, new Point(300, false));
        map.put(241, new Point(300, false));
        map.put(261, new Point(300, false));
        gameMap.put(25, map);
        pieceVisitedMap.put(25, false);

        map = new HashMap<>();
        map.put(240, new Point(280, false));
        gameMap.put(260, map);
        pieceVisitedMap.put(260, false);

        map = new HashMap<>();
        map.put(27, new Point(25, true));
        gameMap.put(261, map);
        pieceVisitedMap.put(261, false);

        map = new HashMap<>();
        map.put(260, new Point(301,  false));
        gameMap.put(280, map);
        pieceVisitedMap.put(280, false);

        map = new HashMap<>();
        map.put(301, new Point(27, true));
        gameMap.put(281, map);
        pieceVisitedMap.put(281, false);

        map = new HashMap<>();
        map.put(25, new Point(35, false));
        map.put(300, new Point(35, false));
        gameMap.put(300, map);
        pieceVisitedMap.put(300, false);

        map = new HashMap<>();
        map.put(280, new Point(32, false));
        map.put(301, new Point(281, true));
        gameMap.put(301, map);
        pieceVisitedMap.put(301, false);

        map = new HashMap<>();
        map.put(281, new Point(261, false));
        gameMap.put(27, map);
        pieceVisitedMap.put(27, false);

        map = new HashMap<>();
        map.put(300, new Point(40, false));
        gameMap.put(35, map);
        pieceVisitedMap.put(35, false);

        map = new HashMap<>();
        map.put(35, new Point(-1, false));
        map.put(38, new Point(-1, false));
        gameMap.put(40, map);
        pieceVisitedMap.put(40, false);

        map = new HashMap<>();
        map.put(301, new Point(34, false));
        gameMap.put(32, map);
        pieceVisitedMap.put(32, false);

        map = new HashMap<>();
        map.put(32, new Point(36, false));
        gameMap.put(34, map);
        pieceVisitedMap.put(34, false);

        map = new HashMap<>();
        map.put(34, new Point(38, false));
        gameMap.put(36, map);
        pieceVisitedMap.put(36, false);

        map = new HashMap<>();
        map.put(36, new Point(40, false));
        gameMap.put(38, map);
        pieceVisitedMap.put(38, false);
    }

    static class Point implements Comparable<Point>{
        int cur;
        int next;
        boolean isBlue;

        Point(int cur, int next, boolean isBlue){
            this.cur = cur;
            this.next = next;
            this.isBlue = isBlue;
        }

        Point(int next, boolean isBlue){
            this.next = next;
            this.isBlue = isBlue;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.next, o.next);
        }
    }
}
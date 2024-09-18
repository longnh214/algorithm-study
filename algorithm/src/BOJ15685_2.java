/**
 * @author nakhoonchoi
 * @date 2024/09/18
 * @see https://www.acmicpc.net/problem/15685
 * @mem 13,432kb
 * @time 100ms
 * @caution
 * [고려사항]
 * 방향을 저장할 때, List와 Set을 이용해서 저장을 해주었고,
 * 각 드래곤 커브 별로 좌표를 저장해준 뒤에
 * 정사각형의 네 점이 존재하는 경우의 수를 출력해주었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <삼성기출/구현> '드래곤 커브'
public class BOJ15685_2 {
    static int [] dx = {1, 0, -1, 0};
    static int [] dy = {0, -1, 0, 1};
    static List<Integer> dirList;
    static Set<Point> pointSet;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        pointSet = new HashSet<>();
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int gen = Integer.parseInt(st.nextToken());

            func(x, y, dir, gen);
        }

        int answer = 0;
        for(Point p : pointSet){
            if(!pointSet.contains(new Point(p.x, p.y + 1))) continue;
            if(!pointSet.contains(new Point(p.x + 1, p.y))) continue;
            if(!pointSet.contains(new Point(p.x + 1, p.y + 1))) continue;
            answer++;
        }

        System.out.println(answer);
    }

    public static void func(int x, int y, int dir, int gen) {
        dirList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        dirList.add(dir);
        for (int i = 1; i <= gen; i++) {
            for (int tempDir : dirList) {
                stack.push(tempDir);
            }
            while (!stack.isEmpty()) {
                int tempDir = stack.pop();
                dirList.add((tempDir + 1) % 4);
            }
        }
        int nx = x;
        int ny = y;
        pointSet.add(new Point(x, y));
        for (int cmd : dirList) {
            nx += dx[cmd];
            ny += dy[cmd];
            pointSet.add(new Point(nx, ny));
        }
    }

    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
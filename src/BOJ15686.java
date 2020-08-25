/**
 * @author choi
 * @date Aug 25, 2020
 * @see https://www.acmicpc.net/problem/15686
 * @mem 16596kb
 * @time 196ms
 * @caution
 * [고려사항] 재귀적 조합을 이용하면 풀 수 있는 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <브루트포스> - '치킨 배달'
public class BOJ15686 {
    static int N, M, chickenCount, houseCount, answer;
    static List<Point> chicken;
    static List<Point> house;
    static Point[] tempChicken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chickenCount = 0;
        houseCount = 0;
        answer = Integer.MAX_VALUE;
        chicken = new ArrayList<>();
        house = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 1) {
                    houseCount++;
                    house.add(new Point(i, j));
                }
                if (n == 2) {
                    chickenCount++;
                    chicken.add(new Point(i, j));
                }
            }
        }
        tempChicken = new Point[chickenCount];
        comb(0, 0);

        System.out.println(answer);
    }

    public static void comb(int cnt, int start) {
        if (cnt == M) {
            int total = 0;
            if (tempChicken.length == 0)
                return;
            for (Point housePoint : house) {
                int min = Integer.MAX_VALUE;
                for (Point temp : tempChicken) {
                    if (temp != null) {
                        int distance = Math.abs(housePoint.x - temp.x) + Math.abs(housePoint.y - temp.y);
                        min = Math.min(distance, min);
                    }
                }
                total += min;
            }
            answer = Math.min(answer, total);
            return;
        }
        for (int i = start; i < chickenCount; i++) {
            tempChicken[cnt] = chicken.get(i);
            comb(cnt + 1, i + 1);
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
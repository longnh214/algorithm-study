/**
 * @author nakhoon
 * @date 2022, 4월 29일
 * @see https://www.acmicpc.net/problem/11651
 * @mem 68,768kb
 * @time 672ms
 * @caution
 * [고려사항]
 * Point 객체에 Comparable 인터페이스를 구현해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 <정렬> '좌표 정렬하기 2'
public class BOJ11651 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Point [] points = new Point[N];


        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[i] = new Point(x, y);
        }

        Arrays.sort(points);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(points[i].x + " " + points[i].y).append("\n");
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if(this.y == o.y){
                return Integer.compare(this.x, o.x);
            }
            return Integer.compare(this.y, o.y);
        }
    }
}
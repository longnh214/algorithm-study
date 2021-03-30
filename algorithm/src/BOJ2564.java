/**
 * @author choi
 * @date Sep 22, 2020
 * @see https://www.acmicpc.net/problem/2564
 * @mem 13,028kb
 * @time 88ms
 * @caution
 * [고려사항]
 * 입력이 좌표가 아니여서 객체를 만들 때에 생성자에서 좌표를 계산하여 넣어주고,
 * 시계 방향과 반시계 방향의 거리 경우의 수 중에 최소값을 답에 더해주는 식으로 계산하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현> '경비원'
public class BOJ2564 {
    static int N, M, shopCount;
    static int total;
    static Point [] shops;
    static Point home;
    static int [] minLength;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        //배열의 총 둘레
        total = (N+M)*2;

        shopCount = Integer.parseInt(br.readLine());

        minLength = new int[shopCount];
        shops = new Point[shopCount];

        for(int i=0;i<shopCount;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            shops[i] = new Point(a,b);
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        home = new Point(a,b);

        //집과 평행인 곳을 temp에 저장한다.
        int temp = -1;
        switch(a) {
            case 1:
                temp = 2;
                break;
            case 2:
                temp = 1;
                break;
            case 3:
                temp = 4;
                break;
            case 4:
                temp = 3;
                break;
        }

        int sum = 0;
        for(int i=0;i<shopCount;i++) {
            if(shops[i].direction == temp) {
                //가로로 평행이라면.
                if (shops[i].direction == 1 || shops[i].direction == 2) {
                    sum += Math.min(home.y + shops[i].y + home.x + shops[i].x, home.y + shops[i].y + N - home.x + N - shops[i].x);
                }
                //세로로 평행이라면.
                else {
                    sum += Math.min(M - home.y + M - shops[i].y + home.x + shops[i].x, home.y + shops[i].y + home.x + shops[i].x);
                }
            }else {
                sum += Math.abs(home.y - shops[i].y) + Math.abs(home.x - shops[i].x);
            }
        }

        System.out.println(sum);
    }


    static class Point{
        int direction;
        int y;
        int x;

        Point(int direction, int distance){
            this.direction = direction;

            if (direction == 1) {
                this.y = 0;
                this.x = distance;
            } else if (direction == 2) {
                this.y = M;
                this.x = distance;
            } else if (direction == 3) {
                this.y = distance;
                this.x = 0;
            } else {
                this.y = distance;
                this.x = N;
            }
        }
    }
}
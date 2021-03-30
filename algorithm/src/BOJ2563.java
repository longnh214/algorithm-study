/**
 * @author choi
 * @date Sep 22, 2020
 * @see https://www.acmicpc.net/problem/2563
 * @mem 13,096kb
 * @time 88ms
 * @caution
 * [고려사항]
 * 도화지를 만들어놓고 색종이가 채워지는 곳은 1로 바꾸며,
 * 마지막에 1의 숫자를 전부 세주었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현> '색종이'
public class BOJ2563 {
    static int [][] map = new int[100][100];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0;i<count;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            colorPaper(a,b);
        }

        System.out.println(count());
    }

    public static void colorPaper(int x, int y) {
        for(int i=x;i<x+10;i++) {
            for(int j=y;j<y+10;j++) {
                map[i][j] = 1;
            }
        }
    }

    public static int count() {
        int result = 0;
        for(int i=0;i<100;i++) {
            for(int j=0;j<100;j++) {
                if(map[i][j] == 1)
                    result++;
            }
        }
        return result;
    }
}
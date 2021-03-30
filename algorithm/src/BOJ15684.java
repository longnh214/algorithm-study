/**
 * @author choi
 * @date Oct 13, 2020
 * @see https://www.acmicpc.net/problem/15684
 * @mem 15,240kb
 * @time 336ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

// 백준 <구현/삼성기출> '사다리 조작'
public class BOJ15684 {
    static int[][] arr;
    static int N, M, H, answer;
    static boolean finish;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        //[세로][가로]
        arr = new int[H + 1][N + 1];
        if (M > 0) {
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[a][b] = 1;
                arr[a][b + 1] = 2;
            }
        }
        for(int i=0;i<=3;i++) {
            answer = i;
            perm(1,0);
            if(finish) break;
        }
        System.out.println((finish) ? answer : -1);
    }

    public static void perm(int x, int count) {
        //가지치기
        if(finish) return;
        if (answer == count) {
            if(check()) {
                finish = true;
            }
            return;
        }

        for (int i = x; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (arr[i][j] == 0 && arr[i][j + 1] == 0) {
                    arr[i][j] = 1;
                    arr[i][j + 1] = 2;
                    perm(i, count + 1);
                    arr[i][j] = arr[i][j + 1] = 0;
                }
            }
        }
    }

    public static boolean check() {
        for (int i = 1; i <= N; i++) {
            int x = 1;
            int y = i;
            for (int j = 0; j < H; j++) {
                if (arr[x][y] == 1) {
                    y++;
                } else if (arr[x][y] == 2) {
                    y--;
                }
                x++;
            }
            if (y != i)
                return false;
        }
        return true;
    }
}
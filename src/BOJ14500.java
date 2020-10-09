/**
 * @author choi
 * @date Oct 9, 2020
 * @see https://www.acmicpc.net/problem/14500
 * @mem 32,960kb
 * @time 520ms
 * @caution
 * [고려사항]
 * 도형 배열을 각각 나올 수 있는 경우의 수 19가지를 만들어서 dfs를 이용해 최대값을 탐색하였습니다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <구현/삼성기출> '테트로미노'
public class BOJ14500 {
    static int N, M;
    static int[][] arr;

    static int[] dx1 = { 0, 0, 0, 0 };
    static int[] dy1 = { 0, 1, 2, 3 };

    static int[] dx2 = { 0, 1, 2, 3 };
    static int[] dy2 = { 0, 0, 0, 0 };

    static int[] dx3 = { 0, 0, 1, 1 };
    static int[] dy3 = { 0, 1, 0, 1 };

    static int[] dx4 = { 0, 1, 2, 2 };
    static int[] dy4 = { 0, 0, 0, 1 };

    static int[] dx5 = { 0, 0, 1, 2 };
    static int[] dy5 = { 0, 1, 0, 0 };

    static int[] dx6 = { 0, 0, -1, -2 };
    static int[] dy6 = { 0, 1, 1, 1 };

    static int[] dx7 = { 0, 0, 1, 2 };
    static int[] dy7 = { 0, 1, 1, 1 };

    static int[] dx8 = { 0, 1, 1, 1 };
    static int[] dy8 = { 0, 0, 1, 2 };

    static int[] dx9 = { 0, 0, 0, -1 };
    static int[] dy9 = { 0, 1, 2, 2 };

    static int[] dx10 = { 0, 1, 0, 0 };
    static int[] dy10 = { 0, 0, 1, 2 };

    static int[] dx11 = { 0, 0, 0, 1 };
    static int[] dy11 = { 0, 1, 2, 2 };

    static int[] dx12 = { 0, 1, 1, 2 };
    static int[] dy12 = { 0, 0, 1, 1 };

    static int[] dx13 = { 0, 1, 1, 2 };
    static int[] dy13 = { 0, 0, -1, -1 };

    static int[] dx14 = { 0, 0, -1, -1 };
    static int[] dy14 = { 0, 1, 1, 2 };

    static int[] dx15 = { 0, 0, 1, 1 };
    static int[] dy15 = { 0, 1, 1, 2 };

    static int[] dx16 = { 0, 0, 1, 0 };
    static int[] dy16 = { 0, 1, 1, 2 };

    static int[] dx17 = { 0, 0, -1, 0 };
    static int[] dy17 = { 0, 1, 1, 2 };

    static int[] dx18 = { 0, -1, 0, 1 };
    static int[] dy18 = { 0, 1, 1, 1 };

    static int[] dx19 = { 0, 1, 1, 2 };
    static int[] dy19 = { 0, 0, 1, 0 };



    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(dx1, dy1);
        dfs(dx2, dy2);
        dfs(dx3, dy3);
        dfs(dx4, dy4);
        dfs(dx5, dy5);
        dfs(dx6, dy6);
        dfs(dx7, dy7);
        dfs(dx8, dy8);
        dfs(dx9, dy9);
        dfs(dx10, dy10);
        dfs(dx11, dy11);
        dfs(dx12, dy12);
        dfs(dx13, dy13);
        dfs(dx14, dy14);
        dfs(dx15, dy15);
        dfs(dx16, dy16);
        dfs(dx17, dy17);
        dfs(dx18, dy18);
        dfs(dx19, dy19);

        System.out.println(answer);
    }

    public static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void dfs(int[] temp1, int[] temp2) {
        for (int a = 0; a < N; a++) {
            for (int b = 0; b < M; b++) {
                int x = a;
                int y = b;
                int cnt = 0;
                int sum = 0;
                for (int i = 0; i < 4; i++) {
                    x = a + temp1[i];
                    y = b + temp2[i];
                    if (isIn(x,y)) {
                        cnt++;
                        sum += arr[x][y];
                    }
                    if (cnt == 4) {
                        if (answer < sum) {
                            answer = sum;
                            sum = 0;
                        }
                    }
                }
            }
        }
    }
}
/**
 * @author choi
 * @date Sep 3, 2020
 * @see https://www.acmicpc.net/problem/17471
 * @mem 13,576kb
 * @time 84ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <브루트포스/삼성기출> '게리맨더링'
public class BOJ17471 {
    static int N, answer, count;
    static int[] people;
    static int[] team;
    static int[][] arr;
    static boolean[] visited;
    static boolean flag;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        people = new int[N + 1];
        team = new int[N + 1];
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        answer = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            for (int j = 0; j < temp; j++) {
                int linkNum = Integer.parseInt(st.nextToken());
                arr[i][linkNum] = 1;
                arr[linkNum][i] = 1;
            }
        }
        //check
//		for(int i=1;i<=N;i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}

        divide(1);
        if (!flag)
            answer = -1;

        System.out.println(answer);
    }

    public static void divide(int cnt) {
        if (cnt == N + 1) {
            //여기에서 최소값을 구해본다.
            Arrays.fill(visited, false);
            count = 0;
            for (int i = 1; i <= N; i++) {
                if (team[i] == 1) {
                    dfs(i, 1);
                    break;
                }
            }

            for (int i = 1; i <= N; i++) {
                if (team[i] == 2) {
                    dfs(i, 2);
                    break;
                }
            }
            if (count != N) return;

            flag = true;
            int sumA = 0;
            int sumB = 0;
            for (int i = 1; i <= N; i++) {
                if (team[i] == 1)
                    sumA += people[i];
                else
                    sumB += people[i];
            }
            answer = Math.min(answer, Math.abs(sumA - sumB));
            return;
        }

        team[cnt] = 1;
        divide(cnt + 1);
        team[cnt] = 2;
        divide(cnt + 1);
    }

    public static void dfs(int start, int teamNum) {
        visited[start] = true;
        count++;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && team[i] == teamNum && arr[start][i] == 1) {
                dfs(i, teamNum);
            }
        }
    }
}
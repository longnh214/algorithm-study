/**
 * @author choi
 * @date Dec 16, 2020
 * @see https://www.acmicpc.net/problem/10971
 * @mem 13,272kb
 * @time 360ms
 * @caution
 * [고려사항]
 * N이 10이므로 dp가 아닌 dfs로도 해결할 수 있었다.
 * arr[i][j]의 값이 0인 경우를 if문 안에 잘 넣어주어야 했던 문제.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <백트래킹> '외판원 순회 2'
public class BOJ10971 {
    static int [][] arr;
    static boolean [] visited;
    static int N,answer;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;
        arr = new int[N][N];
        visited = new boolean[N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++) {
            visited = new boolean[N];
            dfs(i,i,0);
        }

        System.out.println(answer);
    }

    public static void dfs(int start, int target, int cost) {
        if(isEnd()) {
            if(arr[target][start] != 0 && cost + arr[target][start] < answer) {
                answer = cost + arr[target][start];
            }
            return;
        }
        visited[target] = true;

        for(int i=0;i<N;i++) {
            if(!visited[i]) {
                if(arr[target][i] == 0) continue;
                visited[i] = true;
                dfs(start,i,cost + arr[target][i]);
                visited[i] = false;
            }
        }
    }

    public static boolean isEnd() {
        for(int i=0;i<N;i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
/**
 * @author choi
 * @date Aug 28, 2020
 * @see https://www.acmicpc.net/problem/14889
 * @mem 36,916kb
 * @time 252ms
 * @caution
 * [고려사항]
 * <각 시너지를 더해서 계산할 때>
 * j를 0부터 돌게 되면, 같은 시너지를 두번 더하게 되므로 j를	i+1부터 돌아야 한다. 
 * 한번에 시너지 차이를 구해 비교해서 min을 설정 가능
 * 0부터 돌게 되면 쓸데 없는 반복을 돌고 (마지막 절대값 차)/2를 해주어야 한다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <백트래킹> '스타트와 링크'
public class BOJ14889 {
    static int[][] taste;
    static int N, M, answer;
    static boolean[] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = N / 2;
        answer = Integer.MAX_VALUE;
        visited = new boolean[N];
        taste = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                taste[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        comb(0, 0);

        System.out.println(answer);

    }

    public static void comb(int cnt, int start) {
        if (cnt == M) {
            int[] aArr = new int[M];
            int[] bArr = new int[M];
            int aCount = 0;
            int bCount = 0;
            int A = 0;
            int B = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    aArr[aCount++] = i;
                } else {
                    bArr[bCount++] = i;
                }
            }

            for (int i = 0; i < M; i++) {
                //j를 0부터 돌게 되면, 같은 시너지를 두번 더하게 되므로 j를	i+1부터 돌아야 한다.
                //한번에 시너지 차이를 구해 비교해서 min을 설정 가능
                //0부터 돌게 되면 쓸데 없는 반복을 돌고 (마지막 절대값 차)/2를 해주어야 한다.
                for (int j = i + 1; j < M; j++) {
                    A += (taste[aArr[i]][aArr[j]] + taste[aArr[j]][aArr[i]]);
                    B += (taste[bArr[i]][bArr[j]] + taste[bArr[j]][bArr[i]]);
                }
            }
            answer = Math.min(answer, (Math.abs(A - B)));
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            comb(cnt + 1, i + 1);
            visited[i] = false;
        }
    }
}
/**
 * @author choi
 * @date 2020. 7. 29
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT&categoryId=AWT-lPB6dHUDFAVT&categoryType=CODE
 * @mem 21,072kb
 * @time 833ms
 * @caution
 * [고려사항] 조합 코드 배운 부분을 응용할 때 인덱스를 잘 고려해야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
// SW expert 5215번 <D3> - '햄버거 다이어트'
public class Solution5215 {
    static int[][] list;
    static boolean[] visited;
    static int[] arr;
    static int best, N, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            list = new int[N][2];
            visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                list[i][0] = Integer.parseInt(st.nextToken());
                list[i][1] = Integer.parseInt(st.nextToken());
            }

            best = 0;

            for (int i = 1; i < N + 1; i++) {
                arr = new int[i];
                combination(0, i, arr);
            }

            System.out.println("#" + t + " " + best);
        }
    }

    static void combination(int start, int r, int [] arr) {
        if (r == 0) {
            int scoreSum = 0;
            int calorieSum = 0;
            for(int i=0;i<arr.length;i++) {
                scoreSum += list[arr[i]][0];
                calorieSum += list[arr[i]][1];
            }

            if(calorieSum <= L && scoreSum > best)
                best = scoreSum;

            return;
        }
        for (int i = start; i < N; i++) {
            arr[r - 1] = i;
            combination(i+1, r-1, arr);
        }
    }
}
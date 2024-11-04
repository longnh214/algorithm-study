/**
 * @author nakhoonchoi
 * @date 2024/11/04
 * @see https://softeer.ai/practice/7369
 * @caution
 * [고려사항]
 * 맨처음에는 dfs로 문제를 풀었는데, 시간초과가 발생했다.
 * 하지만 이 문제는 (나무의 두 배를 이미 더했나 더하지 않았나)
 * 두 가지를 고려해서 풀어야하는 dp 문제였다.
 * dp 점화식을 세워서 문제를 풀어야 해서 어려웠던 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//소프티어 <연습문제> '나무 수확'

public class Softeer7369 {
    static int n;
    static int [][] map;
    static int [][] sum;
    static int [][] answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        answer = new int[n][n];
        sum = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sum[0][0] = map[0][0];
        answer[0][0] = map[0][0] * 2;

        for(int i=0;i<n;i++){
            for (int j = 0; j < n; j++) {
                if(i > 0){
                    sum[i][j] = Math.max(sum[i][j], sum[i-1][j] + map[i][j]);
                    answer[i][j] = Math.max(answer[i][j], answer[i-1][j] + map[i][j]);
                    answer[i][j] = Math.max(answer[i][j], sum[i-1][j] + map[i][j] * 2);
                }
                if(j > 0){
                    sum[i][j] = Math.max(sum[i][j], sum[i][j-1] + map[i][j]);
                    answer[i][j] = Math.max(answer[i][j], answer[i][j-1] + map[i][j]);
                    answer[i][j] = Math.max(answer[i][j], sum[i][j-1] + map[i][j] * 2);
                }
            }
        }

        System.out.println(answer[n-1][n-1]);
    }
}
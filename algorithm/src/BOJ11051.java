/**
 * @author nakhoon
 * @date 2022, 7월 12일
 * @see https://www.acmicpc.net/problem/11051
 * @mem 15,608kb
 * @time 100ms
 * @caution
 * [고려사항]
 * 파스칼의 삼각형을 DP로 구현해서 풀 수 있는 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DP> '이항 계수 2'
public class BOJ11051 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] Triangle = new int[N+1][N+1];

        for(int i = 0; i < Triangle.length; i++) {
            for(int j = 0; j <= i; j++) {
                if(i == j || j == 0)
                    Triangle[i][j] = 1;
                else
                    Triangle[i][j] = (Triangle[i-1][j-1] + Triangle[i-1][j]) % 10007;
            }
        }
        System.out.println(Triangle[N][K]);
    }
}
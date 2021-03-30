/**
 * @author choi
 * @date Aug 16, 2020
 * @see https://www.acmicpc.net/problem/11660
 * @mem 137,180kb
 * @time 1204ms
 * @caution
 * [고려사항] 2중 for문을 이용하면 쉽게 해결이 가능하지만 N의 최대 크기가 1024이고, M이 10만 이라 점화식과 메모이제이션
 * 		활용해서 풀어야하는 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <?> - '구간 합 구하기 5'
public class BOJ11660 {
    static int [][] arr;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        //배열에 입력 값을 바로 넣는게 아니라 (1,1)부터 (N,M) 까지의 합을 넣어준다.(점화식 이용)
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
            }
        }
        //dp와 같이 점화식을 찾아야 한다.
        for(int j=0;j<M;j++) {
            st = new StringTokenizer(br.readLine());

            int fromA = Integer.parseInt(st.nextToken());
            int fromB = Integer.parseInt(st.nextToken());
            int toA = Integer.parseInt(st.nextToken());
            int toB = Integer.parseInt(st.nextToken());

            System.out.println(arr[toA][toB] - arr[toA][fromB-1] - arr[fromA-1][toB] + arr[fromA-1][fromB-1]);
        }
    }
}
/**
 * @author nakhoonchoi
 * @date 2024/07/16
 * @see https://www.acmicpc.net/problem/14929
 * @mem 22,788kb
 * @time 184ms
 * @caution
 * [고려사항]
 * 점화식을 구해서 누적합을 이용해 계산하였다.
 * 결과가 int 형을 벗어날 수 있음을 주의해야했던 문제.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <누적합> '귀찮아 (SIB)'

public class BOJ14929 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];
        int [] sumArr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sumArr[i+1] = sumArr[i] + arr[i];
        }

        long answer = 0;
        for(int i=0;i<N;i++){
            answer += (arr[i]) * (sumArr[N] - sumArr[i+1]);
        }

        System.out.println(answer);
    }
}
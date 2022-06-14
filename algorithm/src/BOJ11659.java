/**
 * @author nakhoon
 * @date 2022, 6월 14일
 * @see https://www.acmicpc.net/problem/11659
 * @mem 56,592kb
 * @time 572ms
 * @caution
 * [고려사항]
 * 누적 합을 저장할 배열을 새로 선언하고 누적 합 배열에서 각 인덱스 값 끼리 빼주었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 <누적 합> '구간 합 구하기 4'
public class BOJ11659 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] arr = new int[N];
        int [] sumArr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sumArr[i+1] = sumArr[i] + arr[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(sumArr[end] - sumArr[start-1]).append("\n");
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}
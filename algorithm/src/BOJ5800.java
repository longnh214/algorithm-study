/**
 * @author nakhoon
 * @date 2022, 3월 6일
 * @see https://www.acmicpc.net/problem/5800
 * @mem 12,176kb
 * @time 100ms
 * @caution
 * [고려사항]
 * 정렬을 이용해서 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 <정렬> '성적 통계'
public class BOJ5800 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=1;i<=K;i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int [] score = new int[N];
            for(int j=0;j<N;j++){
                score[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(score);
            int max = -1;
            for(int j=0;j<N-1;j++){
                max = Math.max(Math.abs(score[j] - score[j+1]),max);
            }
            System.out.println("Class " + i);
            System.out.println("Max " + score[N-1] + ", Min " + score[0] + ", Largest gap " + max);
        }
    }
}
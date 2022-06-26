/**
 * @author nakhoon
 * @date 2022, 6월 26일
 * @see https://www.acmicpc.net/problem/3135
 * @mem 11,488kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 먼저 현재와 목표 채널까지의 차이를 구하고, 즐겨찾는 채널 숫자가 들어올 때마다 목표 채널까지의 차이를
 * 계산해서 그 값의 +1과 차이 중 가장 최소값을 출력하는 문제였다.(+1을 조심해야했던 문제이다.)
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 <그리디> '라디오'
public class BOJ3135 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());

        int answer = Math.abs(b - a);

        for(int i=0;i<N;i++){
            int target = Integer.parseInt(br.readLine());

            answer = Math.min(Math.abs(target - b) + 1, answer);
        }

        System.out.println(answer);
    }
}
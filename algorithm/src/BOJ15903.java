/**
 * @author choi
 * @date Sep 4, 2020
 * @see https://www.acmicpc.net/problem/15903
 * @mem 33,280kb
 * @time 532ms
 * @caution
 * [고려사항]
 * 정렬하고 앞의 두 수를 더해서 갱신해주는 것을 반복해서 마지막에 전부 합을 출력했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디 알고리즘> '카드 합체 놀이'
public class BOJ15903 {
    static int N,M;
    static long [] cards;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cards = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(Arrays.toString(cards));

        for(int i=0;i<M;i++) {
            Arrays.sort(cards);
            long mix = cards[0] + cards[1];
            cards[0] = cards[1] = mix;
        }

        long sum = 0;
        for(int i=0;i<N;i++) {
            sum += cards[i];
        }

        System.out.println(sum);
    }
}
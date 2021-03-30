/**
 * @author choi
 * @date 2020. 7. 29
 * @see https://www.acmicpc.net/problem/2798
 * @mem 13,424kb
 * @time 88ms
 * @caution
 * [고려사항] 조합 재귀함수에서 매개변수에 넣어야 할 인자를 잘못 넣었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 2798번 <조합> - '블랙잭'
public class BOJ2798 {
    static int max,sum,N,target;
    static int [] cards;
    static int [] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;
        sum = 0;
        cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        arr = new int[3];
        comb(0,0);

        System.out.println(max);
    }

    public static void comb(int start, int cnt) {
        if(cnt == 3) {
            sum = 0;
            for(int i=0;i<arr.length;i++) {
                sum += cards[arr[i]];
            }

            if(sum > max && sum <= target) max = sum;
            return;
        }
        for(int i=start;i<N;i++) {
            arr[cnt] = i;
            comb(i+1,cnt+1);
        }
    }
}
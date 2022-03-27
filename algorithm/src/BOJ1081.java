/**
 * @author nakhoon
 * @date 2022, 3월 27일
 * @see https://www.acmicpc.net/problem/1081
 * @mem 12,160kb
 * @time 100ms
 * @caution
 * [고려사항]
 * 1019번 책 페이지의 방법을 이용해서 마지막에 배열의 값만큼 더해서 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 <수학> '합'
public class BOJ1081 {
    static long [] arr = new long[10];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());

        int ten = 1;
        int first = L;
        int last = U;
        while(first <= last){
            while(last % (10 * ten) != 9 && first <= last){
                calc(last--, ten);
            }

            if(last < first) break;

            while(first % (10 * ten) != 0 && first <= last){
                calc(first++, ten);
            }

            first /= 10;
            last /= 10;

            for(int i=0;i<10;i++){
                arr[i] += ((last - first + 1) * ten);
            }

            ten *= 10;
        }

        long answer = 0L;
        for(int i=0;i<10;i++){
            answer += (arr[i] * i);
        }
        System.out.println(answer);
    }

    public static void calc(int num, long ten){
        while(num > 0){
            arr[num % 10] += ten;
            num /= 10;
        }
    }
}
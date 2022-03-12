/**
 * @author nakhoon
 * @date 2022, 3월 11일
 * @see https://www.acmicpc.net/problem/1019
 * @mem 12,120kb
 * @time 96ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <수학> '책 페이지'
public class BOJ1019 {
    static int [] arr = new int[10];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ten = 1;
        int first = 1;
        int last = N;
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

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<10;i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }

    public static void calc(int num, long ten){
        while(num > 0){
            arr[num % 10] += ten;
            num /= 10;
        }
    }
}
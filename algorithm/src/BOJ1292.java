/**
 * @author nakhoon
 * @date 2022, 3월 1일
 * @see https://www.acmicpc.net/problem/1292
 * @mem 11,476kb
 * @time 80ms
 * @caution
 * [고려사항]
 * A, B에 주어지는 숫자는 1000까지이므로 배열에 미리 값을 넣어놓고 A부터 B까지 수들을 합해주었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 <구현> '쉽게 푸는 문제'
public class BOJ1292 {
    public static void main(String[] args) throws IOException{
        int [] arr = new int[1000];
        int standard = 1;
        outer: for(int i=0;i<1000;i++){
            for(int j=0;j<standard;j++){
                if(i+j >= 1000) break outer;
                arr[i+j] = standard;
            }
            i += (standard-1);
            standard++;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int sum = 0;
        for(int i=A-1;i<B;i++){
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
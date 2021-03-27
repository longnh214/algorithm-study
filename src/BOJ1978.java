/**
 * @author nakhoon
 * @date Mar 27, 2021
 * @see https://www.acmicpc.net/problem/1978
 * @mem 11,584kb
 * @time 76ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <수학> '소수 찾기'
public class BOJ1978 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean [] isNotPrime = new boolean[1001];

        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for(int i=2;i<Math.sqrt(1000);i++) {
            for(int j=2;i*j<=1000;j++) {
                isNotPrime[i*j] = true;
            }
        }

        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            if(!isNotPrime[Integer.parseInt(st.nextToken())]) {
                answer++;
            }
        }

        System.out.println(answer);
    }

}
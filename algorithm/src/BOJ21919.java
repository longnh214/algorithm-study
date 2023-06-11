/**
 * @author nakhoon
 * @date 2022년 9월 24일
 * @see https://www.acmicpc.net/problem/21919
 * @mem 16,052kb
 * @time 160ms
 * @caution
 * [고려사항]
 * 중복된 수가 소수로 들어갈 수 있다는 것이 함정이었던 문제이다.
 * 소수가 한 번 곱해지면 그 수에 대한 소수 판정 배열 값(flag)을 수정해주어 중복으로 곱하는 일이 없도록 했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <소수 판정> '소수 최소 공배수'
public class BOJ21919 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean [] isNotPrime = new boolean[1000001];

        for(int i=2;i<Math.sqrt(1000001);i++){
            for(int j=2;j*i<1000001;j++){
                isNotPrime[j*i] = true;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        long result = 1;
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            if(!isNotPrime[num]) {
                result *= num;
                isNotPrime[num] = true;
            }
        }
        System.out.println(result == 1 ? -1 : result);
    }
}
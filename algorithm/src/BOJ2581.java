/**
 * @author nakhoon
 * @date 2022, 4월 17일
 * @see https://www.acmicpc.net/problem/2581
 * @mem 11,492kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 에라토스테네스의 체를 통해 소수를 판별하고, 구간 사이의 최솟값, 합을 구해서 출력해주었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <소수> '소수'
public class BOJ2581 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean [] isNotPrime = new boolean[10001];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for(int i=2;i<=Math.sqrt(10000);i++){
            if(isNotPrime[i]) continue;
            for(int j=2;j*i<=10000;j++){
                isNotPrime[j*i] = true;
            }
        }
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        boolean flag = false;
        int min = -1;
        int sum = 0;
        for(int i=M;i<=N;i++){
            if(!isNotPrime[i]){
                if(!flag){
                    flag = true;
                    min = i;
                    sum += i;
                }else{
                    sum += i;
                }
            }
        }
        if(sum == 0){
            System.out.println(-1);
        }else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
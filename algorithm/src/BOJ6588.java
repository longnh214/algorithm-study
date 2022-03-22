/**
 * @author nakhoon
 * @date 2022, 3월 22일
 * @see https://www.acmicpc.net/problem/6588
 * @mem 36,768kb
 * @time 288ms
 * @caution
 * [고려사항]
 * 에라토스테네스의 체를 이용해서 1부터 1000000까지 중 소수를 판별하고, 소수는 2부터 시작하므로 타겟 숫자와 2부터 수를 하나씩 줄여가고 늘려가며
 * 소수 끼리의 합이 해당되는 지 판별해서 가능하면 출력하는 방식으로 해결하였다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <소수 판정> '골드바흐의 추측'
public class BOJ6588 {
    public static boolean[] primeList;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        primeList = new boolean[1000001];
        primeCheck();

        int T = Integer.parseInt(br.readLine());
        while(T!=0){
            boolean check = false;
            for(int i=T-3; i>=3; i--){
                if(!primeList[i] && !primeList[T-i]){
                    sb.append(T+" = "+(T-i)+" + "+i+"\n");
                    check = true;
                    break;
                }
            }
            if(!check){
                sb.append("Goldbach's conjecture is wrong.");
            }
            T = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
    }

    static void primeCheck(){
        primeList[0] = primeList[1] = true;
        for(int i=2; i<Math.sqrt(primeList.length); i++){
            if(primeList[i]) continue;
            for(int j=i*i; j<primeList.length; j+=i){
                primeList[j] = true;
            }
        }
    }
}
/**
 * @author nakhoon
 * @date 2022, 4월 23일
 * @see https://www.acmicpc.net/problem/4948
 * @mem 12,212kb
 * @time 124ms
 * @caution
 * [고려사항]
 * 에라토스테네스의 체를 이용해서 문제를 풀었는데, 부등호를 잘못 생각해서 오랫동안 틀렸던 문제이다.
 * 그리고 0 하나만 입력 받았을 때, 아무 것도 출력하면 안된다는 함정도 있었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <소수> '베르트랑 공준'
public class BOJ4948 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean [] isNotPrime = new boolean[123456 * 2 + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for(int i=2;i<=Math.sqrt(123456*2);i++){
            if(isNotPrime[i]) continue;
            for(int j=i;i*j<=123456*2;j++){
                isNotPrime[i*j] = true;
            }
        }
        int num;
        StringBuilder sb = new StringBuilder();
        while((num = Integer.parseInt(br.readLine())) != 0){
            int count = 0;
            for(int i=num+1;i<=2*num;i++){
                if(!isNotPrime[i]) count++;
            }
            sb.append(count).append("\n");
        }
        if(sb.length() > 0){
            System.out.println(sb.substring(0, sb.length()-1));
        }
    }
}
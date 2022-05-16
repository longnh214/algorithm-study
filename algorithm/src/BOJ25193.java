/**
 * @author nakhoon
 * @date 2022, 5월 16일
 * @see https://www.acmicpc.net/problem/25193
 * @mem 13,988kb
 * @time 96ms
 * @caution
 * [고려사항]
 * C의 개수 / (C가 아닌 개수 + 1)을 소수 첫 째 자리에서 올리면 정답이였다. 하지만 나눗셈의 결과가 실수가 나와야하므로 1을 더할 때 1.0을 더해주어야 했다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <문자열> '곰곰이의 식단 관리'
public class BOJ25193 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int cCount = 0;
        int notCCount = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == 'C'){
                cCount++;
            }else{
                notCCount++;
            }
        }
        System.out.println((int)(Math.ceil(cCount / (notCCount + 1.0))));
    }
}
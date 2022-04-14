/**
 * @author nakhoon
 * @date 2022, 4월 14일
 * @see https://www.acmicpc.net/problem/20437
 * @mem 19,144kb
 * @time 412ms
 * @caution
 * [고려사항]
 * 문자열을 입력 받자마자 각 알파벳의 개수를 배열에 저장해주었다.
 * 문자열의 문자들을 돌면서 개수가 k 미만이면 스킵하고, k 이상인 경우만 체크해서
 * min과 max 값을 저장해주어 마지막에 출력해주었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <문자열> '문자열 게임 2'
public class BOJ20437 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());
            if(k == 1) { //k가 1일 때
                System.out.println("1 1");
                continue;
            }

            int[] alpha = new int[26];//알파벳 별 개수를 저장한다.
            for(int j = 0; j < str.length(); j++) {
                alpha[str.charAt(j) - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = -1;
            for(int j = 0; j < str.length(); j++) {
                //k 보다 작은 수의 알파벳은 스킵한다.
                if(alpha[str.charAt(j) - 'a'] < k) continue;

                int count = 1;
                for(int l = j + 1; l < str.length(); l++) {
                    if(str.charAt(j) == str.charAt(l)) count++;
                    if(count == k) {
                        min = Math.min(min, l - j + 1);
                        max = Math.max(max, l - j + 1);
                        break;
                    }
                }
            }
            if(min == Integer.MAX_VALUE || max == -1) System.out.println("-1");
            else System.out.println(min + " " + max);
        }
    }
}
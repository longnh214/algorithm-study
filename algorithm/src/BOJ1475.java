/**
 * @author nakhoon
 * @date 2022, 3월 16일
 * @see https://www.acmicpc.net/problem/1475
 * @mem 11,500kb
 * @time 72ms
 * @caution
 * [고려사항]
 * 카운트 배열을 두고, 9일 경우에는 6에 카운트를 더해주었고, count[6]의 반과 다른 배열들 값 중 최대값을 정답으로 출력했다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <구현> '방 번호'
public class BOJ1475 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int [] count = new int[9];
        for(int i=0;i<input.length();i++){
            int num = input.charAt(i) - '0';
            if(num == 9) count[6]++;
            else count[num]++;
        }
        int answer = 0;
        for(int i=0;i<9;i++){
            if(i == 6){
                answer = Math.max(answer, (count[6] % 2 == 0) ? count[6] / 2 : (count[6] / 2) + 1);
            }else{
                answer = Math.max(answer, count[i]);
            }
        }
        System.out.println(answer);
    }
}
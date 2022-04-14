/**
 * @author nakhoon
 * @date 2022, 4월 15일
 * @see https://www.acmicpc.net/problem/15927
 * @mem 17,612kb
 * @time 160ms
 * @caution
 * [고려사항]
 * 팰린드롬에 대해서 나타날 수 있는 경우의 수는 총 세 가지이다.
 * 팰린드롬 인 경우, 팰린드롬이 아닌 경우, 문자열이 모두 하나의 알파벳으로 구성되어있으면서 팰린드롬인 경우이다.
 * 이 중 세 번째 경우에 의해 시간초과가 발생했다.
 * 문자열을 입력 받자마자 세 번째 경우인 지 확인하고, 세 번째 경우라면 -1,
 * 아니라면 팰린드롬이 아닌 최장 길이의 값을 출력했다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <문자열> '회문은 회문아니야!!'
public class BOJ15927 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char c = str.charAt(0);
        boolean flag = true;
        int answer = -1;

        for(int i=1;i<str.length();i++){
            if(str.charAt(i) != c){
                flag = false;
                break;
            }
        }
        if(flag){
            System.out.println(answer);
            return;
        }

        for(int i=str.length();i>=1;i--){
            if(!isPalindrome(str.substring(0, i))){
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
    public static boolean isPalindrome(String str){
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i) != str.charAt(str.length() - i - 1)){
                return false;
            }
        }
        return true;
    }
}
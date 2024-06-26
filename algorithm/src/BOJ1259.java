/**
 * @author nakhoonchoi
 * @date 2024/06/26
 * @see https://www.acmicpc.net/problem/1259
 * @mem
 * @time
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <문자열> '팰린드롬수'

public class BOJ1259 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while(true){
            input = br.readLine();

            if(input.equals("0")){
                break;
            }

            System.out.println(isPalindrome(input) ? "yes" : "no");
        }
    }

    public static boolean isPalindrome(String input){
        for(int i=0;i<input.length() / 2;i++){
            if(input.charAt(i) != input.charAt(input.length() - i - 1)){
                return false;
            }
        }

        return true;
    }
}
/**
 * @author nakhoon
 * @date 2022, 6월 19일
 * @see https://www.acmicpc.net/problem/2941
 * @mem 11,680kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 크로아티아 알파벳에 해당하는 알파벳을 치환하고, 치환된 알파벳의 길이를 출력해주었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <문자열> '크로아티아 알파벳'
public class BOJ2941 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        input = input.replace("c=", "a");
        input = input.replace("c-", "a");
        input = input.replace("dz=", "a");
        input = input.replace("d-", "a");
        input = input.replace("lj", "a");
        input = input.replace("nj", "a");
        input = input.replace("s=", "a");
        input = input.replace("z=", "a");

        System.out.println(input.length());
    }
}
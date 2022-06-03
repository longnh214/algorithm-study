/**
 * @author nakhoon
 * @date 2022, 6월 3일
 * @see https://www.acmicpc.net/problem/9660
 * @mem 11,488kb
 * @time 72ms
 * @caution
 * [고려사항]
 * 입력 값이 1조로 엄청 크기 때문에 Long 형으로 입력을 받아야 했다. 돌 게임 4와 똑같은 규칙으로 이루어지는 게임이다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <게임 이론> '돌 게임 6'
public class BOJ9660 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        System.out.println(N % 7 == 0 || N % 7 == 2 ? "CY" : "SK");
    }
}
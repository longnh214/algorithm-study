/**
 * @author nakhoon
 * @date 2022, 6월 1일
 * @see https://www.acmicpc.net/problem/9658
 * @mem 11,532kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 상근이가 한 번이라도 이길 수 있는 상황이면 상근이가 이기고, 상근이가 절대 못 이기는 상황이라면 창영이가 이기는 것으로 판단해서 규칙을 찾았다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <DP> '돌 게임 4'
public class BOJ9658 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(N % 7 == 1 || N % 7 == 3 ? "CY" : "SK");
    }
}
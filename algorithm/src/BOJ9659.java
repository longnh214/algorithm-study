/**
 * @author nakhoon
 * @date 2022, 6월 2일
 * @see https://www.acmicpc.net/problem/9659
 * @mem 11,508kb
 * @time 76ms
 * @caution
 * [고려사항]
 * Long 형으로 입력 받아야 하는 문제이다. N을 2로 나누었을 때 나머지에 따라 이기는 사람이 달라지는 문제이다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <게임 이론> '돌 게임 5'
public class BOJ9659 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        System.out.println(N % 2 == 0 ? "CY" : "SK");
    }
}
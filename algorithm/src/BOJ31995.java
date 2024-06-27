/**
 * @author nakhoonchoi
 * @date 2024/06/27
 * @see https://www.acmicpc.net/problem/31995
 * @mem 11,492kb
 * @time 68ms
 * @caution
 * [고려사항]
 * 계산식을 만들어서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <수학> '게임말 올려놓기'

public class BOJ31995 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        if(N < 2 || M < 2){
            System.out.println(0);
        }else{
            System.out.println((N - 1) * (M - 1) * 2);
        }
    }
}
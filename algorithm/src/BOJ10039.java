/**
 * @author nakhoonchoi
 * @date 2024/08/09
 * @see https://www.acmicpc.net/problem/10039
 * @mem 11.520kb
 * @time 60ms
 * @caution
 * [고려사항]
 * 삼항 연산자를 이용해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
        import java.util.*;
//백준 <수학> '평균 점수'

public class BOJ10039 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        for(int i=0;i<5;i++){
            int score = Integer.parseInt(br.readLine());

            sum += (score >= 40 ? score : 40);
        }

        System.out.println(sum / 5);
    }
}
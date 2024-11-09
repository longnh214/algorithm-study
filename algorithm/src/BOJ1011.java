/**
 * @author nakhoonchoi
 * @date 2024/11/09
 * @see https://boj.ma/1101
 * @mem 12,628kb
 * @time 92ms
 * @caution
 * [고려사항]
 * 규칙을 깨달아야 풀 수 있는 문제였다...
 * k는 시작과 끝, 대칭이다.
 * 시작 좌표와 끝 좌표는 상관 없이 두 좌표의 차이와 대칭을 가지고 풀 수 있는 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <수학> 'Fly me to the Alpha Centauri'

public class BOJ1011 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int gap = end - start;
            int answer = 0;
            int k = 1;

            while(gap > 0){
                if(gap > 2 * k){
                    gap -= 2 * k;
                    answer += 2;
                }else{
                    gap -= k;
                    answer++;
                }
                k++;
            }
            System.out.println(answer);
        }
    }
}
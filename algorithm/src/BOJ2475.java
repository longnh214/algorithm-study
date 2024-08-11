/**
 * @author nakhoonchoi
 * @date 2024/08/11
 * @see https://www.acmicpc.net/problem/2475
 * @mem 11,500kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 한 자리의 수만 입력으로 5개 주어지므로 int 형으로 커버되었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <수학> '검증수'

public class BOJ2475 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i=0;i<5;i++){
            int num = Integer.parseInt(st.nextToken());

            sum += (num * num);
        }

        System.out.println(sum % 10);
    }
}
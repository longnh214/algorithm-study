/**
 * @author choi
 * @date 2020. 8. 7
 * @see https://www.acmicpc.net/problem/1629
 * @mem 12,952kb
 * @time 76ms
 * @caution
 * [고려사항] 들어온 A를 C로 나눈 것을 횟수만큼 곱해준 값을 C로 나눈 값과
 *         A를 B만큼 곱해준 값을 C로 나눈 값이 같다는 것을 몰라서
 *         계속 틀렸다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <수학> - '곱셈'
public class BOJ1629 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        long output = 1;
        long multiply = A % C;
        while(B>0) {
            if(B%2==1) {
                output *= multiply;
                output %= C;
            }
            multiply = ((multiply%C)*(multiply%C))%C;
            B/=2;
        }
        System.out.println(output);
    }
}
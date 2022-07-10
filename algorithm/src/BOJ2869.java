/**
 * @author nakhoon
 * @date 2022, 7월 10일
 * @see https://www.acmicpc.net/problem/2869
 * @mem 11,480kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 달팽이가 낮에 맨 꼭대기 지점에 도착하면 더 이상 미끄러지지 않는다. 라는 점을 주의하고,
 * 시간 제한이 빡빡하므로 BufferedReader를 이용해야 시간 안에 해결할 수 있는 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <수학> '달팽이는 올라가고 싶다'
public class BOJ2869 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        int day = (length - down) / (up - down);
        if ((length - down) % (up - down) != 0)
            day++;

        System.out.println(day);
    }
}
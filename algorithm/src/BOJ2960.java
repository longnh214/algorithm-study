/**
 * @author choi
 * @date Oct 4, 2020
 * @see https://www.acmicpc.net/problem/2960
 * @mem 12944kb
 * @time 84ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <수학> '에라토스테네스의 체'
public class BOJ2960 {
    static int [] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        check = new int[N+1];
        check[0] = 1;
        check[1] = 1;
        int count = 0;
        for(int i=2;i<=N;i++) {
            for(int j=1;j*i<=N;j++) {
                if(check[j*i] == 0) {
                    check[j*i] = 1;
                    count++;
                    if(count == K) {
                        System.out.println(j*i);
                        return;
                    }
                }
            }
        }
    }
}
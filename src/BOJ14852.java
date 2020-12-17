/**
 * @author choi
 * @date Dec 17, 2020
 * @see https://www.acmicpc.net/problem/14852
 * @mem 19,440kb
 * @time 108ms
 * @caution
 * [고려사항]
 * DP 문제인 만큼 점화식을 잘 세워야한다.
 * 그림을 그려서 두 경우에 따라 점화식을 세울 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <DP> '타일 채우기 3'
public class BOJ14852 {
    final static int MOD = 1_000_000_007;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] f = new int[N+1];
        int [] g = new int[N+1];

        //정상적인 직사각형
        f[0] = 1;
        f[1] = 2;
        //1x1 타일이 한개 채워져있는 직사각형의 나머지 부분
        g[0] = 0;
        g[1] = 1;

        //g(n) = f(n-1) + f(n-2) + g(n-1)
        //f(n) = 2*g(n) + f(n-2)
        for(int i=2;i<=N;i++) {
            g[i] = (((f[i-1] + f[i-2]) % MOD) + g[i-2]) % MOD;
            f[i] = ((2*g[i] % MOD) + f[i-2]) % MOD;
        }

        System.out.println(f[N]);
    }
}
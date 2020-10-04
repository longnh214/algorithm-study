/**
 * @author choi
 * @date Oct 4, 2020
 * @see https://www.acmicpc.net/problem/16134
 * @mem 20,888kb
 * @time 108ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <페르마의 소정리> '조합 (Combination)'
public class BOJ16134 {
    static long [] fac;
    static final long MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        fac = new long[1000001];
        fac[0] = 1;
        for(int i=1;i<=1000000;i++) {
            fac[i] = (fac[i-1] * i) % MOD;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        long answer = fac[N] % MOD;
        answer = answer * pow(fac[N-R],MOD-2) % MOD;
        answer = answer * pow(fac[R], MOD-2) % MOD;
        System.out.println(answer);
    }

    public static long pow(long a, long b) {
        if(b==0) return 1L;
        else {
            long temp = pow(a,b/2);
            if(b%2==0) return (temp*temp) % MOD;
            else return ((temp*temp) % MOD * a)%MOD;
        }
    }
}
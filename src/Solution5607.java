/**
 * @author choi
 * @date Sep 28, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXGKdbqczEDFAUo&categoryId=AWXGKdbqczEDFAUo&categoryType=CODE
 * @mem 27,440kb
 * @time 129ms
 * @caution
 * [고려사항]
 * 페르마의 소정리를 이용하여 풀 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//SW Expert <D3> - '[Professional] 조합'
public class Solution5607 {
    static long [] fac;
    static final int MOD = 1234567891;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        fac = new long[1000001];
        fac[0] = 1;
        for(int i=1;i<=1000000;i++) {
            fac[i] = (fac[i-1] * i) % MOD;
        }

        for(int t=1;t<=T;t++) {
            long answer = 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            answer = fac[N] % MOD;
            answer = answer * pow(fac[R], MOD-2) % MOD;
            answer = answer * pow(fac[N-R], MOD-2) % MOD;
            System.out.println("#" + t + " " + answer);
        }
    }

    public static long pow(long a, long b) {
        if(b==0) {
            return 1;
        }
        else {
            long temp = pow(a,b/2);
            if(b%2==0) return (temp*temp)%MOD;
            else return ((temp*temp)%MOD*a)%MOD;
        }
    }
}
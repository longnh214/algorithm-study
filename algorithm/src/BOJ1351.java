/**
 * @author nakhoon
 * @date 2022, 4월 3일
 * @see https://www.acmicpc.net/problem/1351
 * @mem 11,760kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 배열의 인덱스에는 long 형을 넣을 수 없기 때문에 배열 대신 맵을 이용해서 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//백준 <DP> '무한 수열'
public class BOJ1351 {
    static int p;
    static int q;
    static Map<Long, Long> map = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        System.out.println(dp(n));
    }

    static long dp(long num){
        if(num == 0) return 1;
        if(map.containsKey(num)) return map.get(num);

        long a = (long)Math.floor(num/p);
        long b = (long)Math.floor(num/q);

        map.put(num, dp(a) + dp(b));
        return map.get(num);
    }
}
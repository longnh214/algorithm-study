/**
 * @author choi
 * @date Jan 10, 2021
 * @see https://www.acmicpc.net/problem/2661
 * @mem 20,716kb
 * @time 112ms
 * @caution
 * [고려사항]
 * while문의 범위와 substring의 범위를 잘 지정해주어야하는 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <브루트포스> '좋은 수열'
public class BOJ2661 {
    static int N;
    static boolean flag;
    static String answer;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        solution("");
    }

    public static void solution(String str) {
        if(flag) return;
        if(str.length() == N) {
            System.out.println(str);
            flag = true;
            return;
        }

        for(int i=1;i<=3;i++) {
            if(isGood(str+Integer.toString(i)))
                solution(str+Integer.toString(i));
        }
    }

    public static boolean isGood(String str) {
        String cur = "";
        String next = "";

        for(int len = 1;len<str.length(); len++) {
            if(len * 2 > str.length()) break;
            int start = 0;
            int end = start + len;
            while(end + len - 1 < str.length()) {
                cur = str.substring(start, end);
                next = str.substring(end, end + len);
                if(cur.contains(next))
                    return false;

                start = start + 1;
                end = end + 1;
            }
        }
        return true;
    }
}
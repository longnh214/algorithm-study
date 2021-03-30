/**
 * @author choi
 * @date Oct 4, 2020
 * @see https://www.acmicpc.net/problem/17504
 * @mem 12,952kb
 * @time 84ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <수학> '제리와 톰 2'
public class BOJ17504 {
    static int P,Q;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(N-->0) {
            stack.push(Integer.parseInt(st.nextToken()));
        }
        long a = stack.pop();
        long b = stack.pop() * a + 1;

        while(!stack.isEmpty()) {
            long temp = stack.pop();
            a += (temp * b);
            temp = a;
            a = b;
            b = temp;
        }
        System.out.println(b-a + " " + b);
    }
}
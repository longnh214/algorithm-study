/**
 * @author choi
 * @date Sep 18, 2020
 * @see https://www.acmicpc.net/problem/2605
 * @mem 13,096kb
 * @time 88ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현> '줄 세우기'
public class BOJ2605 {
    static int [] command;
    static int N;
    static List<Integer> line = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        command = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<command.length;i++) {
            command[i] = Integer.parseInt(st.nextToken());
        }

        line.add(1);

        for(int i=1;i<command.length;i++) {
            int num = command[i];
            line.add(i-num, i+1);
        }

        for(int num : line) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
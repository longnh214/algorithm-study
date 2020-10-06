/**
 * @author choi
 * @date Oct 6, 2020
 * @see https://www.acmicpc.net/problem/18442
 * @mem 15,844kb
 * @time 224ms
 * @caution
 * [고려사항]
 * L의 범위를 long으로 하는 것을 고려해야 했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
// 백준 <완전탐색> '우체국 1'
public class BOJ18442 {
    static long[] vill;
    static long[] temp;
    static long[] answer;
    static long min;
    static int V, P;
    static long L;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        min = Long.MAX_VALUE;
        V = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        L = Long.parseLong(st.nextToken());

        vill = new long[V];
        temp = new long[P];
        answer = new long[P];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < V; i++) {
            vill[i] = Long.parseLong(st.nextToken());
        }

        comb(0, 0);
        System.out.println(min);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]);
            if (i != answer.length - 1)
                System.out.print(" ");
        }
    }

    public static void comb(int cnt, int start) {
        if (cnt == P) {
            long total = 0;
            for (int i = 0; i < V; i++) {
                long minLen = Long.MAX_VALUE;
                for (int j = 0; j < P; j++) {
                    minLen = Math.min(Math.min(Math.abs(vill[i] - temp[j]), L - Math.abs(vill[i] - temp[j])), minLen);
                    if (minLen == 0)
                        break;
                }
                total += minLen;
            }
            if (total < min) {
                for (int i = 0; i < P; i++) {
                    answer[i] = temp[i];
                }
                min = total;
            }
            return;
        }

        for (int i = start; i < V; i++) {
            temp[cnt] = vill[i];
            comb(cnt + 1, i + 1);
        }
    }
}
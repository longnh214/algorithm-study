/**
 * @author choi
 * @date 2020. 8. 5
 * @see https://www.acmicpc.net/problem/1168
 * @mem 31,440kb
 * @time 1108ms
 * @caution
 * [고려사항] 일반 배열을 선언하면 메모리 초과가 날 수 있으므로
 *       리스트를 이용해서 최대한 함수 호출을 줄여야 한다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <리스트> - '요세푸스 문제2'
public class BOJ1168 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }
        sb.append("<");
        int deadIdx = 0;
        while (list.size() > 0) {
            deadIdx = (deadIdx + K - 1) % list.size();
            sb.append(list.remove(deadIdx)).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()).append(">");
        System.out.println(sb);
    }
}
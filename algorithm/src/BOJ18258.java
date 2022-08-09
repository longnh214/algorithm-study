/**
 * @author nakhoon
 * @date 2022/08/09
 * @see https://www.acmicpc.net/problem/18258
 * @mem 323,632kb
 * @time 992ms
 * @caution
 * [고려사항]
 * 평소 StringBuilder를 출력할 때, sb.substring(0, sb.length()-1)을 출력하는 습관이 있는데, 아무 것도 없는 출력이 있는 경우
 * StringIndexOutOfBoundsException이 발생하는 문제가 있어서 수정했다.
 * 큐를 직접 구현하는 방식으로 문제를 해결했다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//백준 <큐> '큐 2'
public class BOJ18258 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int queue[] = new int[N];
        int front =0;
        int rear = 0;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();

            switch(input) {
                case "empty":
                    sb.append(front == rear ? 1 : 0).append("\n");
                    break;
                case "size":
                    sb.append(rear - front).append("\n");
                    break;
                case "front":
                    sb.append(front == rear ? -1 : queue[front]).append("\n");
                    break;
                case "back":
                    sb.append(front == rear ? -1 : queue[rear - 1]).append("\n");
                    break;
                case "pop":
                    sb.append(front == rear ? -1 : queue[front++]).append("\n");
                    break;
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    queue[rear++] = num;
            }
        }
        System.out.print(sb);
    }
}
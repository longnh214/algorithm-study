/**
 * @author choi
 * @date Aug 3, 2020
 * @see https://www.acmicpc.net/problem/1158
 * @mem 278,556kb
 * @time 784ms
 * @caution
 * [고려사항]
 * [입력사항]
 * 상당히 작은 범위 1 <= K <= N <= 5000
 * [출력사항]
 */
import java.util.*;
//백준 <큐> - '요세푸스 문제'
import java.io.*;
public class BOJ1158 {
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> answer = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=1;i<=N;i++) {
            q.add(i);
        }

        while(q.size() != 0) {
            for(int i=0;i<K-1;i++) {
                q.add(q.poll());
            }
            answer.add(q.poll());
        }
        System.out.printf("<");
        while(!answer.isEmpty()) {
            System.out.printf("%d",answer.poll());
            if(!answer.isEmpty()) System.out.printf(", ");
        }
        System.out.printf(">");
    }
}
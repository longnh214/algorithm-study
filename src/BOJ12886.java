/**
 * @author choi
 * @date Aug 26, 2020
 * @see https://www.acmicpc.net/problem/12886
 * @mem 13,788kb
 * @time 92ms
 * @caution
 * [고려사항]
 *	BFS를 이용해 풀 수 있었다. 그리고 꿀 팁이 있다면 입력 받은 A+B+C가 3으로 나누어 떨어지지 않는다면 무조건
 *	세 수가 같은 수가 될 수 없다. 이외에도 혹시 모를 경우의 수가 있으니 5000번 까지는 bfs를 돌려봤더니 정답!
 *	1000번까지는 틀린 답이 나왔었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <?> '돌 그룹'
public class BOJ12886 {
    static int A,B,C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        if((A+B+C)%3 != 0) {
            System.out.println(0);
            return;
        }

        bfs();
    }

    public static void bfs() {
        boolean flag = false;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(A,B,C));
        int count = 0;

        while(!q.isEmpty()) {
            count++;
            if(count > 5000) break;
            Node cur = q.poll();
            if(cur.a == cur.b && cur.b == cur.c && cur.c == cur.a) {
                flag = true;
            }
            int a;
            int b;
            int c;
            if(cur.a < cur.b) {
                a = cur.a * 2;
                b = cur.b - cur.a;
                c = cur.c;
                q.offer(new Node(a,b,c));
            }
            if(cur.a > cur.b) {
                a = cur.a - cur.b;
                b = cur.b * 2;
                c = cur.c;
                q.offer(new Node(a,b,c));
            }
            if(cur.b < cur.c) {
                a = cur.a;
                b = cur.b * 2;
                c = cur.c - cur.b;
                q.offer(new Node(a,b,c));
            }
            if(cur.b > cur.c) {
                a = cur.a;
                b = cur.b - cur.c;
                c = cur.c * 2;
                q.offer(new Node(a,b,c));
            }
            if(cur.c < cur.a) {
                a = cur.a - cur.c;
                b = cur.b;
                c = cur.c * 2;
                q.offer(new Node(a,b,c));
            }
            if(cur.c > cur.a) {
                a = cur.a * 2;
                b = cur.b;
                c = cur.c - cur.a;
                q.offer(new Node(a,b,c));
            }
        }

        if(flag) System.out.println(1);
        else System.out.println(0);
    }

    static class Node{
        int a;
        int b;
        int c;
        Node(int a,int b,int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
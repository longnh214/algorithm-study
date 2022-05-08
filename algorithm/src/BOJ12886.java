/**
 * @author choi
 * @date May 8, 2022
 * @see https://www.acmicpc.net/problem/12886
 * @mem 57,044kb
 * @time 224ms
 * @caution
 * [고려사항]
 *	BFS를 이용해 풀 수 있었다. 그리고 꿀 팁이 있다면 입력 받은 A+B+C가 3으로 나누어 떨어지지 않는다면 무조건
 *	세 수가 같은 수가 될 수 없다. 이외에도 혹시 모를 경우의 수가 있으니 5000번 까지는 bfs를 돌려봤더니 정답!
 *	1000번까지는 틀린 답이 나왔었다.
 *  ---
 *  bfs를 5000번까지 돌렸을 때 이후로 판별하면 문제를 visited 배열을 통해 방문했는 지 확인하는 방식으로
 *  문제를 수정하여 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS> '돌 그룹'
public class BOJ12886 {
    static int A,B,C;
    static boolean [][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[1501][1501];

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
        visited[A][B] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.a == cur.b && cur.b == cur.c) {
                flag = true;
            }
            int a;
            int b;
            int c;
            if(cur.a < cur.b) {
                a = cur.a * 2;
                b = cur.b - cur.a;
                c = cur.c;

                if(!visited[a][b]){
                    q.offer(new Node(a,b,c));
                    visited[a][b] = true;
                }
            }
            if(cur.a > cur.b) {
                a = cur.a - cur.b;
                b = cur.b * 2;
                c = cur.c;

                if(!visited[a][b]){
                    q.offer(new Node(a,b,c));
                    visited[a][b] = true;
                }
            }
            if(cur.b < cur.c) {
                a = cur.a;
                b = cur.b * 2;
                c = cur.c - cur.b;

                if(!visited[a][b]){
                    q.offer(new Node(a,b,c));
                    visited[a][b] = true;
                }
            }
            if(cur.b > cur.c) {
                a = cur.a;
                b = cur.b - cur.c;
                c = cur.c * 2;

                if(!visited[a][b]){
                    q.offer(new Node(a,b,c));
                    visited[a][b] = true;
                }
            }
            if(cur.c < cur.a) {
                a = cur.a - cur.c;
                b = cur.b;
                c = cur.c * 2;

                if(!visited[a][b]){
                    q.offer(new Node(a,b,c));
                    visited[a][b] = true;
                }
            }
            if(cur.c > cur.a) {
                a = cur.a * 2;
                b = cur.b;
                c = cur.c - cur.a;

                if(!visited[a][b]){
                    q.offer(new Node(a,b,c));
                    visited[a][b] = true;
                }
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
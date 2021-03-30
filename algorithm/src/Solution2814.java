/**
 * @author choi
 * @date Dec 3, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GOPPaAeMDFAXB
 * @mem 21,796kb
 * @time 146ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//SW Expert <D3> - '최장 경로'
public class Solution2814 {
    static int N,M,answer;
    static List<Integer> [] adjList;
    static boolean [] visited;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t=1;t<=T;t++) {
            answer = 0;

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N == 1) {
                answer = 1;
                System.out.println("#" + t + " " + answer);
                continue;
            }

            adjList = new ArrayList[N+1];

            for(int i=1;i<=N;i++) {
                adjList[i] = new ArrayList<Integer>();
            }

            for(int i=0;i<M;i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                adjList[a].add(b);
                adjList[b].add(a);
            }

            for(int i=1;i<=N;i++) {
                visited = new boolean[N+1];
                dfs(i,0);
            }

            System.out.println("#" + t + " " + answer);
        }

    }

    public static void dfs(int index, int count) {
        if(count > answer) {
            answer = count;
        }

        for(int next : adjList[index]) {
            if(!visited[next]) {
                visited[next] = true;
                dfs(next, count+1);
                visited[next] = false;
            }
        }
    }
}
import java.util.*;
import java.io.*;
//백준 2617번 <DFS> - '구슬 찾기'
public class BOJ2617 {
    static int N;
    static int M;
    static List<Integer> [] heavier;
    static List<Integer> [] lighter;
    static boolean [] visited;
    static int mid;
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        heavier = new ArrayList[N+1];
        lighter = new ArrayList[N+1];
        mid = (N+1)/2;

        for(int i=1;i<=N;i++){
            heavier[i] = new ArrayList<>();
            lighter[i] = new ArrayList<>();
        }
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            heavier[a].add(b);
            lighter[b].add(a);
        }

        for(int i=1;i<=N;i++){
            Arrays.fill(visited, false);
            //나보다 무겁거나 가벼운 것이 중간 값보다 많으면 그 구슬은 중간 값이 될 수 없다.
            if(dfs(i, heavier) > mid)
                answer++;

            Arrays.fill(visited, false);
            if(dfs(i, lighter) > mid)
                answer++;
        }

        System.out.println(answer);
        br.close();
    }

    public static int dfs(int a, List<Integer> [] adjList){
        visited[a] = true;
        int result = 1;
        for(int i=0;i<adjList[a].size();i++){
            if(!visited[adjList[a].get(i)])
                result += dfs(adjList[a].get(i), adjList);
        }
        return result;
    }
}
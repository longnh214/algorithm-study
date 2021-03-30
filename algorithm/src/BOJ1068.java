import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//백준 1068번 <트리> - '트리'
public class BOJ1068 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n+1];
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];

        for(int i=0;i<n;i++) {
            a[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            int v = Integer.parseInt(st.nextToken());

            // 부모 저장.
            parent[i] = v;
        }

        int root = 0;
        for(int i=0;i<n;i++) {
            int v = parent[i];

            if (v == -1) {
                root = i;
                continue;
            }

            // 부모 배열을 통한 인접리스트 생성

            a[v].add(i);
            a[i].add(v);

        }

        int remove = Integer.parseInt(br.readLine());

        // 한번 bfs를 통해 제거할 노드의 자식들 제거 (본인 포함)
        // 그 후 다시 bfs를 통해 리프노드 탐색

        bfs(a,parent,visited,remove);
        System.out.println(bfs(a,parent,visited,root));

    }

    public static int bfs(ArrayList<Integer>[] a, int[] parent, boolean[] visited, int remove) {
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;

        if (visited[remove]) {
            return 0;
        }

        q.add(remove);
        visited[remove] = true;

        while(!q.isEmpty()) {
            remove = q.poll();
            boolean flag = false;

            for(int v : a[remove]) {
                if (!visited[v] && parent[remove] != v) {
                    // 방문하지 않았고, 부모정점과 현재 정점이 같지 않다면 탐색
                    // 방문했거나, 부모정점과 같다면 탐색할 필요가 없다
                    flag = true;
                    q.add(v);
                    visited[v] = true;
                }

            }

            // 정점을 기준으로 탐색을 하지 못했을 경우 리프노드.
            if (!flag) {
                cnt++;
            }

        }

        return cnt;
    }
}
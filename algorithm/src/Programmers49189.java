/**
 * @author nakhoonchoi
 * @date 2025/09/01
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/49189
 * @caution
 * [고려사항]
 * BFS로 큐의 크기를 세어주면서 문제를 해결했다.
 *
 * 먼저 배열에서 인접리스트로 양방향의 간선을 담아주었고,
 * BFS 안의 큐에서 진행 거리 별로 size를 측정해서
 * 큐가 값이 담겨있는 가장 마지막 크기를 반환하면 간단하게 풀 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//프로그래머스 <그래프> '가장 먼 노드'

public class Programmers49189 {
    public int solution(int n, int[][] edge) {
        List<Integer> [] adjList = new ArrayList[n];

        for(int i=0;i<n;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i=0;i<edge.length;i++){
            int s = edge[i][0] - 1;
            int e = edge[i][1] - 1;

            adjList[s].add(e);
            adjList[e].add(s);
        }

        return bfs(adjList);
    }

    public int bfs(List<Integer> [] adjList){
        Queue<Integer> q = new ArrayDeque<>();
        boolean [] visited = new boolean[adjList.length];

        visited[0] = true;
        q.offer(0);


        int size = q.size();

        while(!q.isEmpty()){
            size = q.size();

            for(int i=0;i<size;i++){
                int cur = q.poll();

                for(int next : adjList[cur]){
                    if(!visited[next]){
                        q.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }

        return size;
    }
}
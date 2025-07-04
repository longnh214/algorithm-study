/**
 * @author nakhoonchoi
 * @date 2025/07/04
 * @see https://boj.ma/15681
 * @mem 103,336kb
 * @time 1,756ms
 * @caution
 * [고려사항]
 * 트리와 쿼리. 트리 + DP 문제에 익숙하지 않아서 어떤 유형인지 연습 겸 파악하기 위해 풀어본 문제이다.
 * 문제를 이해하는 데 어려웠다. 무방향 그래프임을 Map에 먼저 입력 받으면서 값을 넣었다.
 * 그리고 루트의 번호에 따라 중력/방향(?)에 맞게 부모/자식의 방향에 맞게 트리 형태로 만들어서 후위 순회를 진행했다.
 *
 * 후위 순회를 해서 리프 노드까지 탐색했다면, 부모의 dp 값에 자식의 dp 값을 누적시켜줌으로써 서브트리의 개수를 저장했다.
 * 다른 트리 DP 문제도 풀어봐야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <트리 DP> '트리와 쿼리'

public class BOJ15681 {
    static Map<Integer, List<Integer>> treeMap;
    static int [] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        dp = new int[N+1];

        treeMap = new HashMap<>();

        Arrays.fill(dp, 1);

        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            treeMap.putIfAbsent(a, new ArrayList<>());
            treeMap.putIfAbsent(b, new ArrayList<>());
            treeMap.get(a).add(b);
            treeMap.get(b).add(a);
        }

        postOrder(R, -1);

        for(int i=0;i<Q;i++){
            int node = Integer.parseInt(br.readLine());
            System.out.println(dp[node]);
        }
    }

    static void postOrder(int node, int parent){
        for(int nextNode : treeMap.get(node)){
            if(parent != nextNode){
                postOrder(nextNode, node);
            }
        }

        if(parent != -1){
            dp[parent] += dp[node];
        }
    }
}
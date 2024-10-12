/**
 * @author nakhoonchoi
 * @date 2024/10/12
 * @see https://www.acmicpc.net/problem/1516
 * @mem 22,072kb
 * @time 244ms
 * @caution
 * [고려사항]
 * st의 countTokens() 함수를 이용해 -1을 보지 않고 거르려고 했지만,
 * for 문에서 st.nextToken()으로 입력 받으면서 countTokens() 값이 갱신되어 마지막 값을 입력 받을 수 없는 이슈가 있었다.
 * StringTokenizer의 nextToken 횟수에 따라 countTokens()의 값이 갱신된다는 것을 알 수 있었고,
 * ACM Craft(백준 1005번) 문제와 다르게 map을 하나만 이용해서 dp를 적용했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <위상 정렬,DP> '게임 개발'

public class BOJ1516 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int [] indegree = new int[N];
        int [] buildTime = new int[N];
        int [] dp = new int[N];

        Map<Integer, Set<Integer>> nextBuildingMap = new HashMap<>();

        for(int i=0;i<N;i++){
            nextBuildingMap.put(i, new HashSet<>());
        }

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken());
            int count = st.countTokens() - 1;

            for(int j=0;j<count;j++){
                int prevBuilding = Integer.parseInt(st.nextToken()) - 1;

                indegree[i]++;

                Set<Integer> nextBuildingSet = nextBuildingMap.get(prevBuilding);
                nextBuildingSet.add(i);
                nextBuildingMap.put(prevBuilding, nextBuildingSet);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<N;i++){
            if(indegree[i] == 0){
                q.offer(i);
                dp[i] = buildTime[i];
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int nextBuilding : nextBuildingMap.get(cur)){
                indegree[nextBuilding]--;

                dp[nextBuilding] = Math.max(dp[nextBuilding], dp[cur] + buildTime[nextBuilding]);

                if(indegree[nextBuilding] == 0){
                    q.offer(nextBuilding);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(dp[i]).append('\n');
        }

        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
/**
 * @author nakhoonchoi
 * @date 2024/10/08
 * @see https://www.acmicpc.net/problem/1005
 * @mem 307,672kb
 * @time 1,700ms
 * @caution
 * [고려사항]
 * 위상 정렬과 DP를 이용해서 문제를 해결하였다.
 * 위상 정렬에 대해 처음 알았는데, 비순환 그래프에서 현재 노드의 작업이
 * 다음 몇 개의 노드에 영향을 미치는 지를 개수로 저장하고,
 * 해당 노드의 작업이 끝나면 다음 노드의 count를 줄이는 식으로
 * edgeCount가 0인 노드를 찾아 큐에 계속 넣어줌으로써 순서에 맞게 순환할 수 있다.
 *
 * 이전까지 소요된 시간을 dp 배열에 저장하여
 * 점화식으로 목표 건물 건설까지 소요되는 시간을 구하였다.
 *
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <위상정렬,DP> 'ACM Craft'

public class BOJ1005 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            Map<Integer, List<Integer>> buildSequenceMap = new HashMap<>();
            Map<Integer, List<Integer>> buildReverseSequenceMap = new HashMap<>();

            int [] buildTime = new int[N];
            int [] edgeCount = new int[N];
            int [] dp = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                buildTime[i] = Integer.parseInt(st.nextToken());
                buildSequenceMap.put(i, new ArrayList<>());
                buildReverseSequenceMap.put(i, new ArrayList<>());
            }
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()) - 1;
                int Y = Integer.parseInt(st.nextToken()) - 1;

                List<Integer> buildSequenceList = buildSequenceMap.get(X);
                buildSequenceList.add(Y);
                buildSequenceMap.put(X, buildSequenceList);

                List<Integer> buildReverseSequenceList = buildReverseSequenceMap.get(Y);
                buildReverseSequenceList.add(X);
                buildReverseSequenceMap.put(Y, buildReverseSequenceList);
                edgeCount[Y]++;
            }

            Queue<Integer> q = new LinkedList<>();
            for(int i=0;i<N;i++){
                if(edgeCount[i] == 0){
                    q.offer(i);
                }
            }

            while(!q.isEmpty()){
                int max = 0;
                int index = q.poll();

                for(int beforeBuildIndex : buildReverseSequenceMap.get(index)){
                    max = Math.max(max, dp[beforeBuildIndex]);
                }
                dp[index] = max + buildTime[index];

                List<Integer> buildSequenceList = buildSequenceMap.get(index);

                for(int nextIndex : buildSequenceList){
                    edgeCount[nextIndex]--;
                    if(edgeCount[nextIndex] == 0){
                        q.offer(nextIndex);
                    }
                }
            }

            int W = Integer.parseInt(br.readLine()) - 1;

            System.out.println(dp[W]);
        }
    }
}
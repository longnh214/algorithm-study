/**
 * @author nakhoonchoi
 * @date 2025/02/07
 * @see https://boj.ma/1766
 * @mem 61,240kb
 * @time 540ms
 * @caution
 * [고려사항]
 * 위상 정렬로 문제를 해결했다.
 * 다음 문제들을 저장할 Map<Integer, Set<Integer>>과
 * 선행 되어야할 문제를 저장할 배열 indegree를 선언했다.
 * 우선적으로 작은 숫자의 문제가 해결되어야하므로 우선순위 큐로 위상 정렬을 구현했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <위상 정렬> '문제집'

public class BOJ1766_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] indegree = new int[N+1];
        Map<Integer, Set<Integer>> nextQuestionMap = new HashMap<>();
        StringBuilder answer = new StringBuilder();

        for(int i=1;i<=N;i++){
            nextQuestionMap.put(i, new HashSet<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            Set<Integer> nextQuestionSet = nextQuestionMap.get(prev);

            if(!nextQuestionSet.contains(next)){
                indegree[next]++;
            }

            nextQuestionSet.add(next);
            nextQuestionMap.put(prev, nextQuestionSet);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1;i<=N;i++){
            if(indegree[i] == 0){
                pq.offer(i);
            }
        }

        while(!pq.isEmpty()){
            int cur = pq.poll();

            for(int next : nextQuestionMap.get(cur)){
                indegree[next]--;

                if(indegree[next] == 0){
                    pq.offer(next);
                }
            }

            answer.append(cur).append(' ');
        }

        System.out.println(answer.substring(0, answer.length() - 1));
    }
}
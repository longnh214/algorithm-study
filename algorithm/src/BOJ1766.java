/**
 * @author nakhoonchoi
 * @date 2024/10/11
 * @see https://www.acmicpc.net/problem/1766
 * @mem 60,616kb
 * @time 524ms
 * @caution
 * [고려사항]
 * indegree 배열의 개수와 가장 쉬운 문제를 먼저 푸는 게 좋다는 우선순위가 생겼기 때문에,
 * 기존의 위상 정렬에서 사용하던 큐 대신 우선순위 큐를 이용해서 쉬운 문제를 우선순위로 먼저 풀 수 있도록 구현하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <위상 정렬> '문제집'

public class BOJ1766 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] indegree = new int[N];

        Map<Integer, Set<Integer>> nextQuestionMap = new HashMap<>();

        for(int i=0;i<N;i++){
            nextQuestionMap.put(i, new HashSet<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int prev = Integer.parseInt(st.nextToken()) - 1;
            int next = Integer.parseInt(st.nextToken()) - 1;

            Set<Integer> nextQuestionSet = nextQuestionMap.get(prev);

            if(!nextQuestionSet.contains(next)){
                indegree[next]++;
            }

            nextQuestionSet.add(next);
            nextQuestionMap.put(prev, nextQuestionSet);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            if(indegree[i] == 0){
                pq.offer(i);
            }
        }

        while(!pq.isEmpty()){
            int curQuestion = pq.poll();

            sb.append(curQuestion + 1).append(' ');

            for(int nextQuestion : nextQuestionMap.get(curQuestion)){
                indegree[nextQuestion]--;

                if(indegree[nextQuestion] == 0){
                    pq.offer(nextQuestion);
                }
            }
        }

        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
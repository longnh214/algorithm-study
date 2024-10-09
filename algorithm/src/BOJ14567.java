/**
 * @author nakhoonchoi
 * @date 2024/10/09
 * @see https://www.acmicpc.net/problem/14567
 * @mem 142,604kb
 * @time 564ms
 * @caution
 * [고려사항]
 * 위상 정렬 연습 문제였다.
 * 큐를 이용해서 위상 정렬을 구현하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <위상 정렬> '선수과목(Prerequisite)'

public class BOJ14567 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] indegree = new int[N];
        int [] classSemester = new int[N];

        Map<Integer, List<Integer>> prevClassMap = new HashMap<>();

        for(int i=0;i<N;i++){
            prevClassMap.put(i, new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken()) - 1;
            int next = Integer.parseInt(st.nextToken()) - 1;

            List<Integer> nextClassList = prevClassMap.get(prev);
            nextClassList.add(next);
            prevClassMap.put(prev, nextClassList);

            indegree[next]++;
        }

        Queue<ClassInfo> q = new LinkedList<>();

        for(int i=0;i<N;i++){
            if(indegree[i] == 0){
                q.offer(new ClassInfo(i, 1));
            }
        }

        while(!q.isEmpty()){
            ClassInfo cur = q.poll();

            classSemester[cur.classNum] = cur.semester;

            for(int nextClass : prevClassMap.get(cur.classNum)){
                indegree[nextClass]--;

                if(indegree[nextClass] == 0){
                    q.offer(new ClassInfo(nextClass, cur.semester + 1));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(classSemester[i]).append(" ");
        }

        System.out.println(sb.substring(0, sb.length()-1));
    }

    static class ClassInfo{
        int classNum;
        int semester;

        ClassInfo(int classNum, int semester){
            this.classNum = classNum;
            this.semester = semester;
        }
    }
}
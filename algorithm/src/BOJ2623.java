/**
 * @author nakhoonchoi
 * @date 2024/10/10
 * @see https://www.acmicpc.net/problem/2623
 * @mem 12,736kb
 * @time 88ms
 * @caution
 * [고려사항]
 * 중복 간선이 들어올 수 있음을 고려해야했고,
 * 중복 간선에 따라 indegree 배열의 수를 올릴 지 말 지 고려해야했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <위상 정렬> '음악프로그램'

public class BOJ2623 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] indegree = new int[N];

        Map<Integer, Set<Integer>> nextMusicProgramMap = new HashMap<>();

        for(int i=0;i<N;i++){
            nextMusicProgramMap.put(i, new HashSet<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int prevMusicProgram = -1;

            for(int j=0;j<count;j++){
                int curMusicProgram = Integer.parseInt(st.nextToken()) - 1;

                if(prevMusicProgram != -1){
                    Set<Integer> nextMusicProgramSet = nextMusicProgramMap.get(prevMusicProgram);

                    if(!nextMusicProgramSet.contains(curMusicProgram)){
                        indegree[curMusicProgram]++;
                    }

                    nextMusicProgramSet.add(curMusicProgram);
                    nextMusicProgramMap.put(prevMusicProgram, nextMusicProgramSet);
                }
                prevMusicProgram = curMusicProgram;
            }

        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<N;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int totalCount = 0;

        while(!q.isEmpty()){
            int curMusicProgram = q.poll();

            sb.append(curMusicProgram + 1).append('\n');
            totalCount++;

            for(int nextMusicProgram : nextMusicProgramMap.get(curMusicProgram)){
                indegree[nextMusicProgram]--;

                if(indegree[nextMusicProgram] == 0){
                    q.offer(nextMusicProgram);
                }
            }
        }

        if(totalCount != N){
            sb = new StringBuilder();
            sb.append(0);
            System.out.println(sb);
            return;
        }

        System.out.println(sb.substring(0, sb.length()-1));
    }
}
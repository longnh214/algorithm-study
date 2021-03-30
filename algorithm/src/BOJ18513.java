/**
 * @author choi
 * @date Dec 15, 2020
 * @see https://www.acmicpc.net/problem/18513
 * @mem 60,076kb
 * @time 576ms
 * @caution
 * [고려사항]
 * answer도 long 형으로 선언했어서 이론 상 다 맞았다고 생각했는데, 역시 BFS는 Queue를 이용해야 시간이 절약되는 느낌이다.
 * 그리고 visited는 역시 List가 아닌 Set으로 처리 했어야 했다. List와 Set의 시간 차이를 보니 Set이 훨씬 빨랐다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS> '샘터'
public class BOJ18513{
    static int N,K,count;
    static long answer;
    static List<Integer> chicken;
    static Set<Integer> homeSet;
    static int [] dx = {-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = 0;
        chicken = new ArrayList<>();
        homeSet = new HashSet<>();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int address = Integer.parseInt(st.nextToken());
            chicken.add(address);
            homeSet.add(address);
        }

        count = K;
        bfs();
        System.out.println(answer);
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        for(int chic : chicken) {
            q.offer(chic);
        }

        int depth = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-->0) {
                int temp = q.poll();

                for(int i=0;i<2;i++) {
                    int nx = temp + dx[i];

                    if(!homeSet.contains(nx)) {
                        --count;
                        answer+=depth;
                        homeSet.add(nx);
                        q.offer(nx);
                    }

                    if(count == 0) {
                        q.clear();
                        return;
                    }
                }
            }
            depth++;
        }
    }
}
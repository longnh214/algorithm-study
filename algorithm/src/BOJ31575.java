/**
 * @author nakhoonchoi
 * @date 2025/04/17
 * @see https://boj.ma/31575
 * @mem 26,444kb
 * @time 240ms
 * @caution
 * [고려사항]
 * 일반적인 BFS 문제였다. visited 방문 처리를 안해주었을 때 메모리 초과가 발생했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <BFS> '도시와 비트코인'

public class BOJ31575 {
    static int N, M;
    static int [][] map;
    static boolean [][] visited;
    static int [] dx = {0, 1};
    static int [] dy = {1, 0};
    static boolean answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        System.out.println(answer ? "Yes" : "No");
    }

    public static void bfs(){
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int [] cur = q.poll();

            if(cur[0] == M-1 && cur[1] == N-1){
                answer = true;
                return;
            }

            for(int i=0;i<2;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    public static boolean isIn(int x, int y){
        return x>=0 && x<M && y>=0 && y<N;
    }
}
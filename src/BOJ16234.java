/**
 * @author choi
 * @date Oct 13, 2020
 * @see https://www.acmicpc.net/problem/16234
 * @mem 284,456kb
 * @time 972ms
 * @caution
 * [고려사항]
 * bfs에서 큐에 객체를 넣어주지 않은 초보적인 실수로 시간을 날린 문제이다..
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS/삼성기출> '인구 이동'
public class BOJ16234 {
    static int N,L,R;
    static int [][] arr;
    static int [][] visited;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,-1,0,1};
    static int count, tempNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        visited = new int[N][N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            init();

            tempNum = 1;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(visited[i][j] == 0) {
                        bfs(i,j);
                        tempNum++;
                    }
                }
            }
            
            if(tempNum == (N*N + 1))
                break;

            count++;

            HashMap<Integer, int []> map = new HashMap<>();
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(visited[i][j] != 0) {
                        if(map.get(visited[i][j]) == null) {
                            map.put(visited[i][j], new int[2]);
                        }
                        map.get(visited[i][j])[0]++;
                        map.get(visited[i][j])[1]+=arr[i][j];
                    }
                }
            }
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(visited[i][j] != 0) {
                        arr[i][j] = map.get(visited[i][j])[1] / map.get(visited[i][j])[0];
                    }
                }
            }
        }

        System.out.println(count);
    }

    public static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        visited[x][y] = tempNum;
        q.offer(new Point(x,y));

        while(!q.isEmpty()) {
            Point temp = q.poll();

            for(int i=0;i<4;i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(isIn(nx,ny) && visited[nx][ny] == 0) {
                    if(Math.abs(arr[nx][ny] - arr[temp.x][temp.y]) >= L && Math.abs(arr[nx][ny] - arr[temp.x][temp.y]) <= R) {
                        visited[nx][ny] = tempNum;
                        q.offer(new Point(nx,ny));
                    }
                }
            }
        }
    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void init() {
        for(int i=0;i<N;i++) {
            Arrays.fill(visited[i], 0);
        }
    }

    public static boolean isIn(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N;
    }
}
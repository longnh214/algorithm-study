import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2583 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int count = 0;
    static Queue<dot> q = new LinkedList<dot>();
    static int M,N,K;
    static int tmp_square = 0;

    static class dot {
        int x;
        int y;

        public dot(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void fill_square(int x1, int y1, int x2, int y2){//직사각형 채우기
        for(int i=x1;i<x2;i++){
            for(int j=y1;j<y2;j++){
                map[j][i] = 1;
            }
        }
    }

    static void bfs(int a,int b){
        dot d = new dot(a,b);
        visited[a][b] = true;
        q.add(d);

        while(!q.isEmpty()) {
            tmp_square++;
            dot tmp = q.remove();

            int x1 = tmp.x;
            int y1 = tmp.y;

            for(int i=0; i<4; i++) {
                int x2 = x1 + dx[i];
                int y2 = y1 + dy[i];

                if(x2 >= 0 && x2 < M && y2 >=0 && y2 < N &&
                        map[x2][y2] == 0 && !visited[x2][y2]) {
                    q.add(new dot(x2,y2));
                    visited[x2][y2] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[101][101];

        visited = new boolean[101][101];

        ArrayList<Integer> squares = new ArrayList<Integer>();

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            fill_square(x1,y1,x2,y2);
        }

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 0 && !visited[i][j]) {
                    bfs(i,j);
                    count++;
                    squares.add(tmp_square);
                    tmp_square = 0;
                }
            }
        }

        System.out.println(count);
        Collections.sort(squares);
        for(int i=0; i<squares.size(); i++) {
            if(squares.size() != 0) {
                System.out.print(squares.get(i) + " ");
            } else {
                System.out.println(0);
            }
        }
    }
}
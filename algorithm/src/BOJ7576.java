import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
    static int N;
    static int M;
    static int [][] box;
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};

    static class Dot{
        int x;
        int y;
        int day;

        public Dot(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void bfs(){
        Queue<Dot> q = new LinkedList<>();
        int day = 0;//날짜 계산 변수

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(box[i][j] == 1)
                    q.add(new Dot(i, j, 0));
            }
        }

        while(!q.isEmpty()){
            Dot dot = q.poll();
            day = dot.day;

            for(int i=0;i<4;i++){
                int nx = dot.x + dx[i];
                int ny = dot.y + dy[i];
                if(0 <= nx && 0 <= ny && nx < M && ny < N) {
                    if (box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        q.add(new Dot(nx, ny, day + 1));
                    }
                }
            }
        }

        if(checkTomato())
            System.out.println(day);
        else
            System.out.println(-1);
    }

    public static boolean checkTomato(){
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(box[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        box = new int[M][N];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
    }
}

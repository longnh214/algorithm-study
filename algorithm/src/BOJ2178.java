import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    static int N;
    static int M;
    static int [][] arr;
    static boolean [][] visited;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};

    static public void bfs(int n, int m){
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        qx.add(n);
        qy.add(m);

        while(!qx.isEmpty() && !qy.isEmpty()){
            n = qx.poll();
            m = qy.poll();
            visited[n][m] = true;
            for(int i=0;i<4;i++){
                //다음 좌표
                int nx = n + dx[i];
                int ny = m + dy[i];
                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    if(arr[nx][ny] == 1 && !visited[nx][ny]){
                        qx.add(nx);
                        qy.add(ny);
                        visited[nx][ny] = true;
                        arr[nx][ny] = arr[n][m] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j] = s.charAt(j)-'0'; //문자를 숫자로 인식하게한다.
            }
        }
        bfs(0,0);
        System.out.println(arr[N-1][M-1]);
    }
}

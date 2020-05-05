import java.io.*;
import java.util.*;
//백준 1068번 <DFS/BFS/완전탐색> - '연구소'
public class BOJ14502 {
    static int [][] map;
    static int [][] copyMap;
    static ArrayList<Point> virusList;
    static int max = 0;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copyMap = new int[N][M];
        virusList = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                //바이러스 좌표를 리스트에 저장
                if(value == 2)
                    virusList.add(new Point(i,j));
            }
        }

        //0부터 N*M 인덱스까지 벽을 세운다.
        setWall(0,0);

        System.out.println(max);
    }

    //Map을 복사한다.
    public static void copyMap(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                copyMap[i][j] = map[i][j];
            }
        }
    }

    //permutation을 통해 벽을 세개 정한다. depth는 벽을 몇 개 세웠는지 세기 위한 변수.
    public static void setWall(int start, int depth){
        if (depth == 3) {
            //맵을 복사한 후 copyMap으로 계산한다.
            copyMap();

            //바이러스 좌표 별로 지정해서 퍼뜨린다.
            for(Point p : virusList)
                bfs(p.x,p.y);

            //최대한 퍼뜨린 후 최대값 계산 후 return.
            max = Math.max(max,getSafetyCount());
            return;
        }

        for (int i = start; i < N * M; i++) {
            int x = i / M;
            int y = i % M;

            if (map[x][y] == 0) {
                map[x][y] = 1;
                setWall(i + 1, depth + 1);
                map[x][y] = 0;
            }
        }
    }

    //bfs를 이용해서 바이러스를 퍼뜨린다.
    public static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));

        while(!q.isEmpty()){
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (copyMap[nx][ny] == 0) {
                        copyMap[nx][ny] = 2;
                        q.add(new Point(nx,ny));
                    }
                }
            }
        }
    }

    //안전 구역을 계산한다.
    public static int getSafetyCount() {
        int count = 0;
        for(int i=0;i<N;i++)
            for(int j=0;j<M;j++)
                if(copyMap[i][j] == 0)
                    count++;

        return count;
    }

    //좌표 클래스
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
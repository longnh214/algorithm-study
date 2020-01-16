import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ3184 {
    static char [][] map;
    static boolean [][] visited;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {1,-1,0,0};
    static int tWolf;
    static int tSheep;
    static int a;
    static int b;
    static Queue<Point> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split(" ");
        a = Integer.parseInt(str[0]);
        b = Integer.parseInt(str[1]);
        map = new char[a+1][b+1];
        visited = new boolean[a+1][b+1];
        //2차원배열 입력
        for(int i=1;i<=a;i++){
            //공백 하나 추가
            String s = " " + br.readLine();
            map[i] = s.toCharArray();
        }
        for(int i=1;i<=a;i++){
            for(int j=1;j<=b;j++){
                if(map[i][j] != '#' && !visited[i][j])
                    bfs(i,j);
            }
        }
        System.out.println(tSheep + " " + tWolf);
    }
    public static void bfs(int x, int y){
        int wolf = 0;
        int sheep = 0;
        q.add(new Point(x,y));
        visited[x][y] = true;
        if(map[x][y] == 'v') wolf++;
        else if(map[x][y] == 'o') sheep++;

        while(!q.isEmpty()){
            Point temp = q.poll();
            for(int i=0;i<4;i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(nx < 1 || ny < 1 || nx > a || ny > b) continue;
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                if(map[nx][ny] == '#') continue;
                //해당 영역 내의 늑대와 양 마리 수 계산
                if(map[nx][ny] == 'v') wolf++;
                else if(map[nx][ny] == 'o') sheep++;
                q.add(new Point(nx,ny));
            }
        }
        //영역 내의 늑대, 양 마리 수에 대한 결과 처리
        if(wolf >= sheep) tWolf+=wolf;
        else tSheep+=sheep;
    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

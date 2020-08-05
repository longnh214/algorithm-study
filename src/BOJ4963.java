/**
 * @author choi
 * @date 2020. 8. 5
 * @see https://www.acmicpc.net/problem/4963
 * @mem 18,320kb
 * @time 152ms
 * @caution
 * [고려사항] 인접 행렬로 받아들여 8각으로 탐색해서 탐색한 곳은 0으로 바꿔주면서 visited 배열을 사용하지 않았다.
 *       bfs()를 실행할 때마다 count++ 해주었다.(bfs가 실행될 때마다 섬 한 개가 나오기 때문에.)
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <그래프> - '섬의 개수'
public class BOJ4963 {
    static int [] dx = {-1,-1,0,1,1,1,0,-1};
    static int [] dy = {0,-1,-1,-1,0,1,1,1};
    static int [][] map;
    static int w,h,count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0)
                break;
            count = 0;
            map = new int[h][w];

            for(int i=0;i<h;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            while(!isFinish()) {
                count++;
                outer : for(int i=0;i<h;i++) {
                    for(int j=0;j<w;j++) {
                        if(map[i][j] == 1) {
                            bfs(new Dot(i,j));
                            break outer;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void bfs(Dot dot) {
        Queue<Dot> q = new LinkedList<>();
        q.offer(dot);
        map[dot.x][dot.y] = 0;
        while(!q.isEmpty()) {
            Dot temp = q.poll();
            for(int i=0;i<8;i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(isIn(nx,ny) && map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    q.offer(new Dot(nx,ny));
                }
            }
        }
    }
    public static boolean isIn(int x, int y) {
        return x>=0 && x<h && y>=0 && y<w;
    }

    public static boolean isFinish() {
        for(int i=0;i<h;i++) {
            for(int j=0;j<w;j++) {
                if(map[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

    static class Dot{
        int x;
        int y;
        Dot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
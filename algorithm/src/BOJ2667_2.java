/**
 * @author choi
 * @date 2020. 8. 5
 * @see https://www.acmicpc.net/problem/2667
 * @mem 13,880kb
 * @time 104ms
 * @caution
 * [고려사항] 단지 개수를 오름차순으로 정렬해야함을 잘 못봐서 한번 틀렸다.
 *       문제를 제대로 읽어야 겠다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <DFS/BFS> - '단지번호붙이기'
public class BOJ2667_2 {
    static int [][] map;
    static int N, count, size;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,-1,0,1};
    static List<Integer> sizeList = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        count = 0;
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<N;j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        while(!isFinish()) {
            count++;
            outer : for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(map[i][j] == 1) {
                        size = 0;
                        bfs(new Dot(i,j));
                        sizeList.add(size);
                        break outer;
                    }
                }
            }
        }
        System.out.println(count);
        Collections.sort(sizeList);
        for(int i : sizeList) {
            System.out.println(i);
        }
    }

    public static void bfs(Dot dot) {
        Queue<Dot> q = new LinkedList<>();
        q.offer(dot);
        map[dot.x][dot.y] = 0;
        size++;
        while(!q.isEmpty()) {
            Dot temp = q.poll();

            for(int i=0;i<4;i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(isIn(nx,ny) && map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    size++;
                    q.offer(new Dot(nx,ny));
                }
            }
        }
    }

    public static boolean isIn(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N;
    }

    public static boolean isFinish() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
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
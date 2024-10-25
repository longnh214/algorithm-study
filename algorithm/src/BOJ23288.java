/**
 * @author nakhoonchoi
 * @date 2024/10/25
 * @see https://www.acmicpc.net/problem/23288
 * @mem 33,116kb
 * @time 152ms
 * @caution
 * [고려사항]
 * 최근에 풀었던 '주사위 굴리기' 문제와 비슷했다.
 * spin 메소드를 구현해서, (동,남,서,북) 방향에 따라 시계 방향으로 잘 맞게 굴려주고,
 * 현재 좌표에 따라 bfs로 탐색해서 최대한 같은 숫자인 곳을 탐색하여 점수 계산을 한다.
 * 마지막으로 조건에 따라 주사위의 방향을 바꿔주면 문제를 해결할 수 있다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <삼성기출/구현> '주사위 굴리기 2'

public class BOJ23288 {
    static int N, M, K;
    static int [][] map;
    //{0,1,2,3,4,5}
    //동,남,서,북
    static int [][] dice = {
            { 3, 1, 0, 5, 4, 2 },
            { 1, 5, 2, 3, 0, 4 },
            { 2, 1, 5, 0, 4, 3 },
            { 4, 0, 2, 3, 5, 1 },
    };
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static int [] diceValue;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        diceValue = new int[6];
        for(int i=0;i<6;i++){
            diceValue[i] = i+1;
        }

        map = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int dir = 0;
        int total = 0;
        int x = 0;
        int y = 0;
        for(int i=0;i<K;i++){
            //한 칸 구른다.(벗어났다면 반대로 한 칸)
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(!isIn(nx, ny)){
                dir = (dir + 2) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            spin(dir);

            //점수 획득 BFS
            total += bfs(nx, ny);

            //이동 방향 변경
            if(diceValue[5] > map[nx][ny]){
                dir = (dir + 1) % 4;
            }else if(diceValue[5] < map[nx][ny]){
                dir = (dir + 3) % 4;
            }

            x = nx;
            y = ny;
        }

        System.out.println(total);
    }

    public static void spin(int cmd){
        //윗 면 : 5번 인덱스
        //바닥 면 : 0번 인덱스

        int [] cpDice = new int[6];
        for (int i = 0; i < 6; i++){
            cpDice[i] = diceValue[dice[cmd][i]];
        }
        diceValue = Arrays.copyOf(cpDice, cpDice.length);
    }

    public static int bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        boolean [][] visited = new boolean[N][M];
        int sum = 0;
        int standard = map[x][y];
        visited[x][y] = true;
        q.offer(new Point(x, y));
        sum += standard;

        while(!q.isEmpty()){
            Point cur = q.poll();

            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] == standard){
                    visited[nx][ny] = true;
                    sum += standard;
                    q.offer(new Point(nx, ny));
                }
            }
        }

        return sum;
    }

    public static boolean isIn(int x, int y){
        return x>=0 && x<N && y>=0 && y<M;
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
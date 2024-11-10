/**
 * @author nakhoonchoi
 * @date 2024/11/10
 * @see https://softeer.ai/practice/7726
 * @caution
 * [고려사항]
 * 맞왜틀이 계속 발생했던 문제였다.
 * 먼저 유령을 기준으로 bfs를 돌았고, 그 뒤에 남우가 출구에 도착하는 시간이 유령보다 작으면 통과인 것으로 생각했는데,
 * 정답은 남우를 먼저 bfs를 순회해서 남우가 끝에 도달할 수 없다면, No를 출력해서 미리 거르고 시작해야하는 문제였다.
 * 유령의 개수가 정해져있지 않아 한 번에 유령이 bfs를 돌게 되면 시간초과가 발생하는 듯 하다...
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//소프티어 <연습문제> '나무 섭지'

public class Softeer7726{
    static int N, M;
    static char [][] map;
    static int [][] step;
    static List<Point> ghosts;
    static Point namwoo;
    static int exitX, exitY, playerStep;
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ghosts = new ArrayList<>();

        map = new char[N][M];
        step = new int[N][M];

        for(int i=0;i<N;i++){
            map[i] = br.readLine().toCharArray();
            for(int j=0;j<M;j++){
                step[i][j] = Integer.MAX_VALUE;
                if(map[i][j] == 'D') {
                    exitX = i;
                    exitY = j;
                }else if(map[i][j] == 'G'){
                    ghosts.add(new Point(i, j, 0));
                }else if(map[i][j] == 'N'){
                    namwoo = new Point(i, j, 0);
                }
            }
        }
        namwooBfs(namwoo);

        if(step[exitX][exitY] == Integer.MAX_VALUE){
            System.out.println("No");
        }else{
            playerStep = step[exitX][exitY];

            for(int i=0;i<N;i++){
                Arrays.fill(step[i], Integer.MAX_VALUE);
            }

            ghostBfs(ghosts);

            System.out.println(step[exitX][exitY] > playerStep ? "Yes" : "No");
        }
    }

    public static void namwooBfs(Point namwoo){
        Queue<Point> q = new LinkedList<>();
        q.offer(namwoo);

        while(!q.isEmpty()){
            Point cur = q.poll();

            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(isIn(nx, ny) && map[nx][ny] != '#' && step[nx][ny] > cur.distance + 1){
                    step[nx][ny] = cur.distance + 1;
                    q.offer(new Point(nx, ny, cur.distance + 1));
                }
            }
        }
    }

    public static void ghostBfs(List<Point> ghosts){
        Queue<Point> q = new LinkedList<>(ghosts);

        while(!q.isEmpty()){
            Point ghost = q.poll();

            for(int i=0;i<4;i++){
                int nx = ghost.x + dx[i];
                int ny = ghost.y + dy[i];

                if(isIn(nx, ny) && step[nx][ny] > ghost.distance + 1){
                    step[nx][ny] = ghost.distance + 1;
                    q.offer(new Point(nx, ny, ghost.distance + 1));
                }
            }
        }
    }

    public static boolean isIn(int x, int y){
        return x>=0 && x<N && y>=0 && y<M;
    }

    static class Point{
        int x;
        int y;
        int distance;
        Point(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
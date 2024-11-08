/**
 * @author nakhoonchoi
 * @date 2024/11/08
 * @see https://boj.ma/23289
 * @mem 32,736kb
 * @time 284ms
 * @caution
 * [고려사항]
 * 우선 아래 순서대로 구현하였다.
 * 1. 벽을 어떻게 표현하며 입력할 것인가.
 * 2. 온풍기 바람 처리
 * 3. 온도 조절 로직
 * 4. 온도가 1 이상인 바깥쪽 온도 감소
 * 5. 체크리스트의 온도가 전부 K 이상인지 체크
 *
 * 벽은 각 Point 클래스 안에 BitSet으로 문제의 방향과 같이 [0 : 오른, 1 : 왼, 2 : 위, 3 : 아래]로 체크하였다.
 * 그리고 입력에서는 한 좌표의 위와 오른쪽 방향 벽의 정보만 주어지지만,
 * 하나의 벽으로 두 좌표에 영향이 미치기 때문에 두 좌표에 전부 정보를 담아주었다.
 *
 * 온풍기의 바람 처리 메소드를 구현할 때에
 * 온풍기의 대각선 방향 바람이 벽에 막힐 때의 조건이 조금 까다로웠다.
 * 바람의 시작 지점의 벽과, 도착 지점의 벽의 여부를 확인해서 bfs를 진행했다.
 * 그리고 두 벽이 and 일 때 막히는 게 아니라 둘 중에 하나만 있는 or의 조건임이 중요했다.
 *
 * 온도 조절 로직은 모든 좌표가 동시에 동작하므로, 온도의 변화 크기를 임시 temp 배열에 저장했다.
 * 온도 조절도 벽에 의해서 진행되지 않을 수 있으므로 주의해야한다.
 *
 * 가장 바깥쪽의 온도를 1 씩 감소하는 로직에서도
 * for 문에 따라 중복으로 degree--; 로직을 실행하지 않도록 주의해야한다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <삼성기출/구현> '온풍기 안녕!'

public class BOJ23289 {
    static int R,C,K;
    static Point [][] map;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {1,-1,0,0};
    static boolean [][] visited;
    static List<Point> machines;
    static List<Point> checkPoints;
    static final int FIRST_DEGREE = 5;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        checkPoints = new ArrayList<>();
        machines = new ArrayList<>();

        map = new Point[R][C];
        visited = new boolean[R][C];

        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int command = Integer.parseInt(st.nextToken());
                map[i][j] = new Point(i, j);

                switch(command){
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        map[i][j].dir = command - 1;
                        machines.add(map[i][j]);
                        break;
                    case 5:
                        checkPoints.add(map[i][j]);
                        break;
                    case 0:
                    default:
                        break;
                }
            }
        }

        int wallCount = Integer.parseInt(br.readLine());
        for(int i=0;i<wallCount;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int wall = Integer.parseInt(st.nextToken());

            if(wall == 0){
                if(isIn(x-1, y)){
                    map[x-1][y].wall.set(3, true);
                }
                map[x][y].wall.set(2, true);
            }else{
                if(isIn(x, y+1)){
                    map[x][y+1].wall.set(1, true);
                }
                map[x][y].wall.set(0, true);
            }
        }

        int count = 1;

        while(true){
            if(count > 100){
                System.out.println(101);
                return;
            }

            for(Point machine : machines){
                machineRun(machine);
            }

            arrangeDegree();
            arrangeDegree2();

            if(degreeCheck()){
               break;
            }

            count++;
        }

        System.out.println(count);
    }

    public static boolean degreeCheck(){
        for(Point checkPoint : checkPoints){
            if(checkPoint.degree < K){
                return false;
            }
        }
        return true;
    }

    public static void arrangeDegree(){
        int [][] temp = new int[R][C];

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                for(int k=0;k<4;k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(isIn(nx, ny) && !map[i][j].wall.get(k) && map[i][j].degree > map[nx][ny].degree){
                        int transferDegree = (map[i][j].degree - map[nx][ny].degree) / 4;
                        temp[i][j] -= transferDegree;
                        temp[nx][ny] += transferDegree;
                    }
                }
            }
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                map[i][j].degree += temp[i][j];
            }
        }
    }

    public static void arrangeDegree2(){
        for(int i=0;i<R;i++){
            if(map[i][0].degree > 0){
                map[i][0].degree--;
            }

            if(map[i][C - 1].degree > 0) {
                map[i][C - 1].degree--;
            }
        }

        for(int i=1;i<C-1;i++){
            if(map[0][i].degree > 0){
                map[0][i].degree--;
            }

            if(map[R - 1][i].degree > 0) {
                map[R - 1][i].degree--;
            }
        }
    }

    public static void machineRun(Point machine){
        int dir = machine.dir;
        int nextX = machine.x + dx[dir];
        int nextY = machine.y + dy[dir];

        initVisited();

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(nextX, nextY, FIRST_DEGREE));
        map[nextX][nextY].degree += FIRST_DEGREE;
        visited[nextX][nextY] = true;

        while(!q.isEmpty()){
            Point cur = q.poll();

            if(cur.degree <= 1){
                continue;
            }

            int start = 0; // 0,1 (가로) 2,3 (세로)
            if(dir / 2 == 0){ //가로
                start+=2;
            }
            //온풍기 오른쪽
            // 오른쪽 + 위 = 대각선
            // 오른쪽 + 아래 = 아래대각선
            for(int i=start;i<start+2;i++) {
                int nx = cur.x + dx[dir] + dx[i];
                int ny = cur.y + dy[dir] + dy[i];

                if(!isIn(nx,ny) || visited[nx][ny] || map[cur.x][cur.y].wall.get(i) || map[nx][ny].wall.get(reverseDir(dir))){
                    continue;
                }

                visited[nx][ny] = true;
                map[nx][ny].degree += (cur.degree - 1);
                q.offer(new Point(nx, ny, cur.degree - 1));
            }

            int nx = cur.x + dx[dir];
            int ny = cur.y + dy[dir];

            if(map[cur.x][cur.y].wall.get(dir)){
                continue;
            }

            if(isIn(nx, ny) && !visited[nx][ny]){
                visited[nx][ny] = true;
                map[nx][ny].degree += (cur.degree - 1);
                q.offer(new Point(nx, ny, cur.degree - 1));
            }
        }
    }

    public static int reverseDir(int dir){
        if(dir % 2 == 0){
            dir++;
        }else{
            dir--;
        }

        return dir;
    }

    public static void initVisited(){
        for(int i=0;i<R;i++){
            Arrays.fill(visited[i], false);
        }
    }

    static class Point{
        int x;
        int y;
        BitSet wall; //0 : 오른, 1 : 왼, 2 : 위, 3 : 아래
        int degree;
        int dir; //해당 좌표가 온풍기일 경우

        Point(int x, int y){
            this.x = x;
            this.y = y;
            this.wall = new BitSet(4);
            this.wall.set(0, 4, false);
        }

        Point(int x, int y, int degree){
            this.x = x;
            this.y = y;
            this.degree = degree;
        }
    }

    public static boolean isIn(int x, int y){
        return x>=0 && x<R && y>=0 && y<C;
    }
}
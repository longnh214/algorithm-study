/**
 * @author choi
 * @date 2020. 8. 7
 * @see https://www.acmicpc.net/problem/17135
 * @mem 38,092kb
 * @time 280ms
 * @caution
 * [고려사항] 2차원 배열은 1차원 배열처럼 복사하면 안되는 것을 알았다.
 *        DFS로 생각했는데 범위 중 가장 가까운 적을 죽여야하므로 BFS를
 *        써야 한다는 것을 알았다.
 *        같은 적이 여러 궁수에게 공격 당할 수 있다는 것을 알았다.
 *        (공격 받은 적을 바로 죽이지 말고, 턴이 끝났을 때 죽여야 한다.)
 *        (중복이 발생할 수 있으므로.)
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <?> - '캐슬 디펜스'
public class BOJ17135 {
    static int N,M,D,answer,kill;
    //입력받는 게임 맵.
    static int [][] game;
    //카피해서 쓸 temp 맵.
    static int [][] copyMap;
    static int [] dx = {0,-1,0};
    static int [] dy = {-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        game = new int[N+1][M];
        copyMap = new int[N+1][M];
        answer = Integer.MIN_VALUE;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0,0);

        System.out.println(answer);
    }
    //궁수 3명을 놓는 경우의 수 조합
    public static void comb(int cnt, int start) {
        if(cnt == 3) {
            copyMap = deepcopy(game);
            doGame();
            return;
        }

        for(int i=start;i<M;i++) {
            game[N][i] = 2;
            comb(cnt+1,i+1);
            game[N][i] = 0;
        }
    }
    //매 조합마다 게임을 진행한다.
    public static void doGame() {
        kill = 0;
        while(!isFinish()) {
            for(int i=0;i<M;i++) {
                if(copyMap[N][i] == 2) {
                    bfs(N,i,0);
                }
            }
            //적이 있으면 내려온다.
            for(int i=N-1;i>=0;i--) {
                for(int j=0;j<M;j++) {
                    if(copyMap[i][j] == 1) {
                        //copyMap[i][j] = 0;
                        if(isIn(i+1,j)) {
                            copyMap[i+1][j] = 1;
                        }
                    }
                    copyMap[i][j] = 0;
                }
            }
        }
        answer = Math.max(kill, answer);
    }
    //궁수가 범위 안에 있는 우선순위가 가장 높은 적을 찾는 bfs(왼쪽 우선)
    //copyMap 값이 1이면 적, 2이면 궁수, 3이면 이미 공격당한 적을 나타낸다.
    public static void bfs(int x, int y, int d) {
        Queue<Zone> q = new LinkedList<Zone>();
        q.offer(new Zone(x,y,d));

        while(!q.isEmpty()) {
            Zone temp = q.poll();
            if(copyMap[temp.x][temp.y] == 3) {
                return;
            }
            else if(copyMap[temp.x][temp.y] == 1) {
                copyMap[temp.x][temp.y] = 3;
                //System.out.println(x + ", " + y + ", " + d);
                kill++;
                return;
            }
            if(temp.d == D) {
                continue;
            }
            for(int i=0;i<3;i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(isIn(nx,ny)) {
                    q.offer(new Zone(nx,ny,temp.d+1));
                }
            }
        }
    }
    //전부 0인 지 아닌 지(게임이 끝났는 지 아닌 지)
    public static boolean isFinish() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(copyMap[i][j] != 0)
                    return false;
            }
        }
        return true;
    }
    //구역이 게임 구역에 포함되는 지 안 되는 지
    public static boolean isIn(int x, int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }
    //2차원 배열을 복사하는 deepcopy 코드
    public static int [][] deepcopy(int [][] original){
        if(original == null) return null;
        int [][] result = new int[original.length][original[0].length];

        for(int i=0;i<original.length;i++) {
            System.arraycopy(original[i], 0, result[i], 0, original[0].length);
        }
        return result;
    }
    //구역에 대한 클래스
    static class Zone{
        int x;
        int y;
        int d;
        public Zone(int x, int y, int d) {
            super();
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
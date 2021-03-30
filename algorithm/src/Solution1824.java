/**
 * @author choi
 * @date Nov 2, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4yLUiKDUoDFAUx
 * @mem 22,336 kb
 * @time 140ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//SW Expert <D4> '혁진이의 프로그램 검증'
public class Solution1824 {
    static int N,M,mem,dir,startX,startY;
    static char [][] map;
    static boolean [][][][] visited;
    static String answer;
    //오른쪽, 아래, 왼쪽, 위 순서
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            answer = "NO";
            map = new char[N][M];
            visited = new boolean[N][M][4][16];
            boolean flag = false;
            for(int i=0;i<N;i++) {
                String str = br.readLine();
                for(int j=0;j<M;j++) {
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == '@') flag = true;
                }
            }
            if(!flag) {
                System.out.println("#" + t + " " + answer);
                continue;
            }
            if(bfs())
                answer = "YES";

            System.out.println("#" + t + " " + answer);
        }
    }
    public static boolean bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0,0,0));
        visited[0][0][0][0] = true;
        while(!q.isEmpty()) {
            Point temp = q.poll();

            int nx = temp.x;
            int ny = temp.y;
            int nDir = temp.dir;
            int nMem = temp.mem;

            if(map[nx][ny] == '@') {
                return true;
            }

            if(map[nx][ny] == '?') {
                for(int i=0;i<4;i++) {
                    nDir = i;
                    nx = temp.x + dx[nDir];
                    ny = temp.y + dy[nDir];
                    nx += N;
                    ny += M;
                    nx %= N;
                    ny %= M;
                    if(visited[nx][ny][nDir][nMem])
                        continue;
                    visited[nx][ny][nDir][nMem] = true;
                    q.offer(new Point(nx,ny,nDir,nMem));
                }
            }else {
                switch(map[nx][ny]) {
                    case '<':
                        nDir = 2;
                        break;
                    case '>':
                        nDir = 0;
                        break;
                    case '^':
                        nDir = 3;
                        break;
                    case 'v':
                        nDir = 1;
                        break;
                    case '_':
                        nDir = (nMem == 0) ? 0 : 2;
                        break;
                    case '|':
                        nDir = (nMem == 0) ? 1 : 3;
                        break;
                    case '.':
                        break;
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        nMem = map[temp.x][temp.y] - '0';
                        break;
                    case '+':
                        nMem = (nMem+1) % 16;
                        break;
                    case '-':
                        nMem = (nMem+15) % 16;
                        break;
                }
                nx = nx + dx[nDir];
                ny = ny + dy[nDir];
                nx += N;
                ny += M;
                nx %= N;
                ny %= M;

                if(visited[nx][ny][nDir][nMem])
                    continue;
                visited[nx][ny][nDir][nMem] = true;
                q.offer(new Point(nx,ny,nDir,nMem));
            }


        }
        return false;
    }

    static class Point{
        int x;
        int y;
        int dir;
        int mem;
        Point(int x, int y, int dir, int mem){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mem = mem;
        }
    }

    public static boolean isIn(int x, int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }
}
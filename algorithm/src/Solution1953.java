/**
 * @author choi
 * @date Nov 3, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpLlKAQ4DFAUq
 * @mem 25,108kb
 * @time 147ms
 * @caution
 * [고려사항]
 * bfs를 이용한 구현 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//SW Expert <SW역량테스트> '탈주범 검거'
public class Solution1953 {
    static int N,M,answer,R,C,L;
    static int [][] map;
    static boolean [][] visited;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int t=1;t<=T;t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs(R,C);
            //print();
            System.out.println("#" + t + " " + count());
        }
    }

    public static void print() {
        for(int i=0;i<N;i++) {
            System.out.println(Arrays.toString(visited[i]));
        }
    }

    public static int count() {
        int count = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(visited[i][j]) count++;
            }
        }
        return count;
    }

    public static boolean isMatch(int x, int y, int targetX, int targetY, int pipe) {
        int nx = -1;
        int ny = -1;

        switch(pipe) {
            case 1:
                return true;
            //break;
            case 2:
                nx = x + dx[0];
                ny = y + dy[0];

                if(isIn(nx,ny) && (targetX == nx && targetY == ny)) {
                    return true;
                }

                nx = x + dx[2];
                ny = y + dy[2];

                if(isIn(nx,ny) && (targetX == nx && targetY == ny)) {
                    return true;
                }
                break;
            case 3:
                nx = x + dx[1];
                ny = y + dy[1];

                if(isIn(nx,ny) && (targetX == nx && targetY == ny)) {
                    return true;
                }

                nx = x + dx[3];
                ny = y + dy[3];

                if(isIn(nx,ny) && (targetX == nx && targetY == ny)) {
                    return true;
                }
                break;
            case 4:
                nx = x + dx[0];
                ny = y + dy[0];

                if(isIn(nx,ny) && (targetX == nx && targetY == ny)) {
                    return true;
                }

                nx = x + dx[1];
                ny = y + dy[1];

                if(isIn(nx,ny) && (targetX == nx && targetY == ny)) {
                    return true;
                }
                break;
            case 5:
                nx = x + dx[1];
                ny = y + dy[1];

                if(isIn(nx,ny) && (targetX == nx && targetY == ny)) {
                    return true;
                }

                nx = x + dx[2];
                ny = y + dy[2];

                if(isIn(nx,ny) && (targetX == nx && targetY == ny)) {
                    return true;
                }
                break;
            case 6:
                nx = x + dx[2];
                ny = y + dy[2];

                if(isIn(nx,ny) && (targetX == nx && targetY == ny)) {
                    return true;
                }

                nx = x + dx[3];
                ny = y + dy[3];

                if(isIn(nx,ny) && (targetX == nx && targetY == ny)) {
                    return true;
                }
                break;
            case 7:
                nx = x + dx[3];
                ny = y + dy[3];

                if(isIn(nx,ny) && (targetX == nx && targetY == ny)) {
                    return true;
                }

                nx = x + dx[0];
                ny = y + dy[0];

                if(isIn(nx,ny) && (targetX == nx && targetY == ny)) {
                    return true;
                }
                break;
        }
        return false;
    }

    public static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new Point(x,y,map[x][y],1));

        while(!q.isEmpty()) {
            Point temp = q.poll();

            if(temp.time == L) {
                break;
                //continue; 도 해보기
            }

            int nx = -1;
            int ny = -1;
            switch(temp.pipe) {
                case 1:
                    for(int i=0;i<4;i++) {
                        nx = temp.x + dx[i];
                        ny = temp.y + dy[i];

                        if(isIn(nx,ny) && !visited[nx][ny]  && map[nx][ny] != 0 && isMatch(nx,ny,temp.x, temp.y, map[nx][ny])) {
                            visited[nx][ny] = true;
                            q.offer(new Point(nx,ny,map[nx][ny],temp.time+1));
                        }
                    }
                    break;
                case 2:
                    nx = temp.x + dx[0];
                    ny = temp.y + dy[0];

                    if(isIn(nx,ny) && !visited[nx][ny]  && map[nx][ny] != 0 && isMatch(nx,ny,temp.x, temp.y, map[nx][ny])) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx,ny,map[nx][ny],temp.time+1));
                    }

                    nx = temp.x + dx[2];
                    ny = temp.y + dy[2];

                    if(isIn(nx,ny) && !visited[nx][ny]  && map[nx][ny] != 0 && isMatch(nx,ny,temp.x, temp.y, map[nx][ny])) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx,ny,map[nx][ny],temp.time+1));
                    }
                    break;
                case 3:
                    nx = temp.x + dx[1];
                    ny = temp.y + dy[1];

                    if(isIn(nx,ny) && !visited[nx][ny]  && map[nx][ny] != 0 && isMatch(nx,ny,temp.x, temp.y, map[nx][ny])) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx,ny,map[nx][ny],temp.time+1));
                    }

                    nx = temp.x + dx[3];
                    ny = temp.y + dy[3];

                    if(isIn(nx,ny) && !visited[nx][ny] && map[nx][ny] != 0 && isMatch(nx,ny,temp.x, temp.y, map[nx][ny])) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx,ny,map[nx][ny],temp.time+1));
                    }
                    break;
                case 4:
                    nx = temp.x + dx[0];
                    ny = temp.y + dy[0];

                    if(isIn(nx,ny) && !visited[nx][ny]  && map[nx][ny] != 0 && isMatch(nx,ny,temp.x, temp.y, map[nx][ny])) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx,ny,map[nx][ny],temp.time+1));
                    }

                    nx = temp.x + dx[1];
                    ny = temp.y + dy[1];

                    if(isIn(nx,ny) && !visited[nx][ny]  && map[nx][ny] != 0 && isMatch(nx,ny,temp.x, temp.y, map[nx][ny])) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx,ny,map[nx][ny],temp.time+1));
                    }
                    break;
                case 5:
                    nx = temp.x + dx[1];
                    ny = temp.y + dy[1];

                    if(isIn(nx,ny) && !visited[nx][ny]  && map[nx][ny] != 0 && isMatch(nx,ny,temp.x, temp.y, map[nx][ny])) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx,ny,map[nx][ny],temp.time+1));
                    }

                    nx = temp.x + dx[2];
                    ny = temp.y + dy[2];

                    if(isIn(nx,ny) && !visited[nx][ny]  && map[nx][ny] != 0 && isMatch(nx,ny,temp.x, temp.y, map[nx][ny])) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx,ny,map[nx][ny],temp.time+1));
                    }
                    break;
                case 6:
                    nx = temp.x + dx[2];
                    ny = temp.y + dy[2];

                    if(isIn(nx,ny) && !visited[nx][ny]  && map[nx][ny] != 0 && isMatch(nx,ny,temp.x, temp.y, map[nx][ny])) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx,ny,map[nx][ny],temp.time+1));
                    }

                    nx = temp.x + dx[3];
                    ny = temp.y + dy[3];

                    if(isIn(nx,ny) && !visited[nx][ny]  && map[nx][ny] != 0 && isMatch(nx,ny,temp.x, temp.y, map[nx][ny])) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx,ny,map[nx][ny],temp.time+1));
                    }
                    break;
                case 7:
                    nx = temp.x + dx[3];
                    ny = temp.y + dy[3];

                    if(isIn(nx,ny) && !visited[nx][ny]  && map[nx][ny] != 0 && isMatch(nx,ny,temp.x, temp.y, map[nx][ny])) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx,ny,map[nx][ny],temp.time+1));
                    }

                    nx = temp.x + dx[0];
                    ny = temp.y + dy[0];

                    if(isIn(nx,ny) && !visited[nx][ny]  && map[nx][ny] != 0 && isMatch(nx,ny,temp.x, temp.y, map[nx][ny])) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx,ny,map[nx][ny],temp.time+1));
                    }
                    break;
            }
        }
    }

    public static boolean isIn(int x, int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }

    static class Point{
        int x;
        int y;
        int pipe;
        int time;
        Point(int x, int y, int pipe, int time){
            this.x = x;
            this.y = y;
            this.pipe = pipe;
            this.time = time;
        }
    }
}
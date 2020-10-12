/**
 * @author choi
 * @date Oct 13, 2020
 * @see https://www.acmicpc.net/problem/19238
 * @mem 28,800kb
 * @time 372ms
 * @caution
 * [고려사항]
 * 예외처리를 많이 해야하는 문제였다. 문제를 꼼꼼히 읽고 어떤 예외가 생길 지 잘 생각해야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS/삼성기출> '스타트 택시'
public class BOJ19238 {
    static int N,M,fuel,startX, startY;
    static int [] custX;
    static int [] custY;
    static int [] destX;
    static int [] destY;
    static int [] custLength;
    static int [][] map;
    static boolean [][] visited;
    static int [] dx = {0,-1,0,1};
    static int [] dy = {-1,0,1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];
        custX = new int[M];
        custY = new int[M];
        destX = new int[M];
        destY = new int[M];
        //각 손님까지 최단거리를 계산하여 저장하는 배열
        custLength = new int[M];

        Arrays.fill(custLength, Integer.MAX_VALUE);

        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dx = Integer.parseInt(st.nextToken());
            int dy = Integer.parseInt(st.nextToken());

            custX[i] = x;
            custY[i] = y;
            destX[i] = dx;
            destY[i] = dy;
        }

        for(int i=0;i<M;i++) {
            //visited 배열 초기화.
            init();
            //최단 거리를 구하여 가장 최단 거리의 승객을 리턴한다.
            int nextPerson = findShort(startX, startY);
            //승객이 벽에 막혀 갈 수 없는 곳에 있다면.(예외1)
            if(nextPerson == -1) {
                System.out.println(-1);
                return;
            }
            fuel -= custLength[nextPerson];
            //연료가 이동 도중에 다 떨어졌다면.(예외2)
            if(fuel < 0) {
                System.out.println(-1);
                return;
            }
            init();
            //승객을 태우고 이동하면서 발생하는 연료 소모.
            int useFuel = drive(nextPerson);
            //승객을 태우고 이동할 수 없다면.(예외3)
            if(useFuel == -1) {
                System.out.println(-1);
                return;
            }

            fuel -= useFuel;

            //승객을 태우고 이동하면서 연료 소모가 보유 연료보다 크다면.(예외4)
            if(fuel < 0) {
                System.out.println(-1);
                return;
            }

            fuel += (2 * useFuel);
            custLength[nextPerson] = -1;
            startX = destX[nextPerson];
            startY = destY[nextPerson];
            //매번 최단거리를 구하면서 custLength를 갱신해주어야한다.
            //custLength가 -1인 경우는 이미 택시를 태운 승객임을 표시.
            for(int j=0;j<M;j++) {
                if(custLength[j] != -1) {
                    custLength[j] = Integer.MAX_VALUE;
                }
            }
        }

        //혹시라도 택시를 못 태운 승객이 남아있다면.(예외5)
        for(int i=0;i<M;i++) {
            if(custLength[i] != -1) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(fuel);
    }

    //택시에 승객을 태우고 이동할 때 최단 거리를 구하는 BFS 함수.
    public static int drive(int index) {
        Queue<Point> q = new LinkedList<>();
        visited[custX[index]][custY[index]] = true;
        q.offer(new Point(custX[index], custY[index], 0));

        while(!q.isEmpty()) {
            Point temp = q.poll();

            if(temp.x == destX[index] && temp.y == destY[index]) {
                return temp.length;
            }

            for(int i=0;i<4;i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(isIn(nx,ny) && !visited[nx][ny]) {
                    if(map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx,ny,temp.length+1));
                    }
                }
            }
        }

        return -1;
    }

    //현재 택시 좌표를 기준으로 가장 가까운 승객을 찾는 BFS.
    public static int findShort(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new Point(x,y,0));

        while(!q.isEmpty()) {
            Point temp = q.poll();

            for(int i=0;i<M;i++) {
                if(temp.x == custX[i] && temp.y == custY[i] && custLength[i] != -1) {
                    custLength[i] = custLength[i] > temp.length ? temp.length : custLength[i];
                }
            }

            for(int i=0;i<4;i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(isIn(nx,ny) && !visited[nx][ny]) {
                    if(map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx,ny,temp.length+1));
                    }
                }
            }
        }

        int minLen = Integer.MAX_VALUE;
        int minIndex = -1;

        //최단 거리 승객 판별.
        for(int i=0;i<M;i++) {
            if(custLength[i] == -1) continue;
            if(minLen > custLength[i]) {
                minIndex = i;
                minLen = custLength[i];
            }else if(minLen != Integer.MAX_VALUE && minLen == custLength[i]) {
                if(custX[minIndex] < custX[i]) {
                    continue;
                }else if(custX[minIndex] > custX[i]) {
                    minIndex = i;
                    minLen = custLength[i];
                }else {
                    if(custY[minIndex] > custY[i]) {
                        minIndex = i;
                        minLen = custLength[i];
                    }
                }
            }
        }
        return minIndex;
    }

    //visited 배열 초기화 함수.
    public static void init() {
        for(int i=1;i<=N;i++) {
            Arrays.fill(visited[i], false);
        }
    }

    //좌표 class
    static class Point{
        int x;
        int y;
        int length;
        Point(int x, int y, int length){
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }

    //유효한 좌표인지 확인하는 함수.
    public static boolean isIn(int x, int y) {
        return x>=1 && x<=N && y>=1 && y<=N;
    }
}
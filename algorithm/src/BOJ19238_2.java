/**
 * @author nakhoonchoi
 * @date 2024/10/17
 * @see https://www.acmicpc.net/problem/19238
 * @mem 27,396kb
 * @time 288ms
 * @caution
 * [고려사항]
 * 예외 처리가 많이 필요했던 문제이다. 아래의 경우에는 전부 -1을 반환해야한다.
 * - 승객이 벽에 막혀 갈 수 없는 경우.
 * - 연료가 이동 도중에 다 떨어진 경우.
 * - 승객을 태우고 이동할 수 없는 경우.
 * - 승객을 태우고 이동하면서 연료 소모가 보유 연료보다 큰 경우.
 * - 로직을 전부 수행했을 때 택시를 못 태운 승객이 남아있는 경우.
 *
 * 현재 위치에서 최단 거리의 승객을 찾을 때,
 * 승객에서 최단 거리의 목적지를 찾을 때
 * 전체적으로 BFS를 이용해서 구현하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <삼성기출/구현> '스타트 택시'

public class BOJ19238_2 {
    static int N, M, fuel, startX, startY;
    static int [] customerX;
    static int [] customerY;
    static int [] destinationX;
    static int [] destinationY;
    static int [] customerMinLength;
    static int [][] map;
    static boolean [][] visited;
    static int [] dx = {0, -1, 0, 1};
    static int [] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];
        customerX = new int[M];
        customerY = new int[M];
        destinationX = new int[M];
        destinationY = new int[M];
        //각 손님까지 최단거리를 계산하여 저장하는 배열
        customerMinLength = new int[M];

        Arrays.fill(customerMinLength, Integer.MAX_VALUE);

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken()) - 1;
        startY = Integer.parseInt(st.nextToken()) - 1;

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            customerX[i] = Integer.parseInt(st.nextToken()) - 1;
            customerY[i] = Integer.parseInt(st.nextToken()) - 1;
            destinationX[i] = Integer.parseInt(st.nextToken()) - 1;
            destinationY[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        for(int i=0;i<M;i++){
            //visited 배열 초기화.
            visitedInit();
            //최단 거리를 구하여 가장 최단 거리의 승객을 리턴한다.
            int nextPerson = findNearCustomer(startX, startY);
            //승객이 벽에 막혀 갈 수 없는 곳에 있다면.(예외1)
            if(nextPerson == -1){
                System.out.println(-1);
                return;
            }
            fuel -= customerMinLength[nextPerson];
            //연료가 이동 도중에 다 떨어졌다면.(예외2)
            if(fuel < 0){
                System.out.println(-1);
                return;
            }
            visitedInit();
            //승객을 태우고 이동하면서 발생하는 연료 소모.
            int useFuel = drive(nextPerson);
            //승객을 태우고 이동할 수 없다면.(예외3)
            if(useFuel == -1){
                System.out.println(-1);
                return;
            }

            fuel -= useFuel;

            //승객을 태우고 이동하면서 연료 소모가 보유 연료보다 크다면.(예외4)
            if(fuel < 0){
                System.out.println(-1);
                return;
            }

            //승객을 도착시킨 경우 사용했던 기름의 두 배 추가.
            fuel += (2 * useFuel);

            //이미 태운 승객임을 flag 표시.
            customerMinLength[nextPerson] = -1;

            //시작 지점 갱신.
            startX = destinationX[nextPerson];
            startY = destinationY[nextPerson];

            //매번 최단거리를 구하면서 customerMinLength를 갱신해주어야한다.
            for(int j=0;j<M;j++){
                if(customerMinLength[j] != -1){
                    customerMinLength[j] = Integer.MAX_VALUE;
                }
            }
        }

        //혹시라도 택시를 못 태운 승객이 남아있다면.(예외5)
        for (int i=0;i<M;i++) {
            if(customerMinLength[i] != -1){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(fuel);
    }

    //택시에 승객을 태우고 이동할 때 최단 거리를 구하는 BFS 함수.
    public static int drive(int destinationIndex){
        Queue<Point> q = new LinkedList<>();
        visited[customerX[destinationIndex]][customerY[destinationIndex]] = true;
        q.offer(new Point(customerX[destinationIndex], customerY[destinationIndex], 0));

        while(!q.isEmpty()){
            Point temp = q.poll();

            if(temp.x == destinationX[destinationIndex] && temp.y == destinationY[destinationIndex]){
                return temp.length;
            }

            for(int i=0;i<4;i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(isIn(nx, ny) && !visited[nx][ny]){
                    if(map[nx][ny] == 0){
                        visited[nx][ny] = true;
                        q.offer(new Point(nx, ny, temp.length + 1));
                    }
                }
            }
        }

        //도착하지 못할 경우에 -1 반환.
        return -1;
    }

    //현재 택시 좌표를 기준으로 가장 가까운 승객을 찾는 BFS.
    public static int findNearCustomer(int x, int y){
        Queue<Point> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new Point(x, y, 0));

        while(!q.isEmpty()){
            Point temp = q.poll();

            for(int i=0;i<M;i++){
                if(temp.x == customerX[i] && temp.y == customerY[i] && customerMinLength[i] != -1){
                    customerMinLength[i] = Math.min(customerMinLength[i], temp.length);
                }
            }

            for (int i=0;i<4;i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(isIn(nx, ny) && !visited[nx][ny]){
                    if(map[nx][ny] == 0){
                        visited[nx][ny] = true;
                        q.offer(new Point(nx, ny, temp.length + 1));
                    }
                }
            }
        }

        int minLen = Integer.MAX_VALUE;
        int minIndex = -1;

        //최단 거리 승객 판별.
        //백준이 태울 승객을 고를 때는 현재 위치에서 최단거리가 가장 짧은 승객을 고른다.
        //그런 승객이 여러 명이면 그중 행 번호가 가장 작은 승객을, 그런 승객도 여러 명이면 그중 열 번호가 가장 작은 승객을 고른다.
        //택시와 승객이 같은 위치에 서 있으면 그 승객까지의 최단거리는 0이다.
        for (int i=0;i<M;i++) {
            if(customerMinLength[i] == -1) continue; //이미 태운 승객

            if(minLen > customerMinLength[i]){
                minIndex = i;
                minLen = customerMinLength[i];
            }else if(minLen != Integer.MAX_VALUE && minLen == customerMinLength[i]){
                if(customerX[minIndex] == customerX[i]) {
                    if(customerY[minIndex] > customerY[i]) {
                        minIndex = i;
                        minLen = customerMinLength[i];
                    }
                }else if(customerX[minIndex] > customerX[i]){
                    minIndex = i;
                    minLen = customerMinLength[i];
                }
            }
        }
        return minIndex;
    }

    //visited 배열 초기화 함수.
    public static void visitedInit(){
        for(int i=0;i<N;i++) {
            Arrays.fill(visited[i], false);
        }
    }

    //좌표 class
    static class Point {
        int x;
        int y;
        int length;

        Point(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }

    //유효한 좌표인지 확인하는 함수.
    public static boolean isIn(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N;
    }
}
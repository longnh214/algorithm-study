/**
 * @author nakhoonchoi
 * @date 2024/12/02
 * @see https://boj.ma/21609
 * @mem 15,648kb
 * @time 216ms
 * @caution
 * [고려사항]
 * 기준 블록을 정하는 기준에서 빠진 부분이 있어서 맞왜틀이 발생했다.
 * 기준 블록끼리 비교할 때
 * 크기, 포함된 무지개 블록의 개수, 시작 블록의 행, 시작 블록의 열 순으로 내림차순인 지 확인해야하고,
 * 시작 블록에는 무지개 블록에 대한 정보가 들어가면 안된다.
 *
 * 그리고, 무지개 블록은 공통적으로 사용할 수 있기 때문에 bfs 돌기 전에 visited를 (무지개 블록만) 초기화 해야한다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <삼성기출/구현> '상어 중학교'

public class BOJ21609 {
    static int [][] map;
    static boolean [][] visited;
    static int N, M;
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, -1, 0, 1};
    static final int INF = Integer.MIN_VALUE;
    static final int BLACK_BLOCK = -1;
    static final int RAINBOW_BLOCK = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];

        int score = 0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            for (int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //while(끝날 때 까지){
        while(true){
            //1. 가장 큰 블록 찾기
            Group findGroup = findBlockGroup();
            if(findGroup == null){
                break;
            }
            //2. 블록 제거하기, 점수 계산하기
            score += findGroup.size * findGroup.size;

            eraseBlockGroup(findGroup);

            //3. 중력이 작용한다.
            scrollDown();
            //4. 격자가 90도 반시계 방향으로 회전한다.
            rotate();
            //5. 중력 재작용
            scrollDown();
        }

        System.out.println(score);
    }

    public static void rotate(){
        int [][] temp = new int[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                temp[i][j] = map[j][N-i-1];
            }
        }

        map = temp;
    }

    public static void scrollDown(){
        //열마다 탐색
        for(int i=0;i<N;i++){
            for(int j=N-1;j>=1;j--){
                for(int k=N-1;k>=1;k--) {
                    if (map[k][i] == BLACK_BLOCK || map[k - 1][i] == BLACK_BLOCK) {
                        continue;
                    }
                    if (map[k][i] == INF) {
                        int temp = map[k - 1][i];
                        map[k - 1][i] = map[k][i];
                        map[k][i] = temp;
                    }
                }
            }
        }
    }

    public static void eraseBlockGroup(Group group){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(group.startX, group.startY));
        map[group.startX][group.startY] = INF;

        while(!q.isEmpty()){
            Point cur = q.poll();

            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(!isIn(nx, ny) || map[nx][ny] == INF) {
                    continue;
                }
                if(map[nx][ny] == RAINBOW_BLOCK || map[nx][ny] == group.color){
                    map[nx][ny] = INF;
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static Group findBlockGroup(){
        List<Group> blockGroupList = new ArrayList<>();

        for(int i=1;i<=M;i++){
            initVisited();
            Group findGroup = findTargetColorGroup(i);

            if(findGroup != null) {
                blockGroupList.add(findGroup);
            }
        }

        Collections.sort(blockGroupList);
        return !blockGroupList.isEmpty() ? blockGroupList.get(0) : null;
    }

    public static Group findTargetColorGroup(int color){
        List<Group> sameColorGroupList = new ArrayList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                initVisitedRainbow();
                if(!visited[i][j] && map[i][j] == color){
                    Group findGroup = bfs(color, i, j);
                    if(findGroup.size >= 2) {
                        sameColorGroupList.add(findGroup);
                    }
                }
            }
        }

        Collections.sort(sameColorGroupList);
        return !sameColorGroupList.isEmpty() ? sameColorGroupList.get(0) : null;
    }

    public static Group bfs(int color, int startX, int startY){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(startX, startY));
        visited[startX][startY] = true;
        int size = 1;
        int rainbowCount = 0;

        while(!q.isEmpty()){
            Point cur = q.poll();

            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(!isIn(nx, ny) || visited[nx][ny]) {
                    continue;
                }
                if(map[nx][ny] == RAINBOW_BLOCK){
                    visited[nx][ny] = true;
                    rainbowCount++;
                    size++;
                    q.offer(new Point(nx, ny));
                }
                if(map[nx][ny] == color){
                    visited[nx][ny] = true;
                    size++;
                    q.offer(new Point(nx, ny));
                }
            }
        }

        return new Group(color, startX, startY, size, rainbowCount);
    }

    public static void initVisited(){
        for(int i=0;i<N;i++){
            Arrays.fill(visited[i], false);
        }
    }

    public static void initVisitedRainbow(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] == RAINBOW_BLOCK){
                    visited[i][j] = false;
                }
            }
        }
    }

    public static boolean isIn(int x, int y){
        return x>=0 && x<N && y>=0 && y<N;
    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class Group implements Comparable<Group>{
        int color;
        int startX;
        int startY;
        int size;
        int rainbowCount;

        Group(int color, int startX, int startY, int size, int rainbowCount){
            this.color = color;
            this.startX = startX;
            this.startY = startY;
            this.size = size;
            this.rainbowCount = rainbowCount;
        }

        @Override
        public int compareTo(Group o) {
            if(this.size == o.size){
                if(this.rainbowCount == o.rainbowCount) {
                    if (this.startX == o.startX) {
                        return Integer.compare(this.startY, o.startY) * -1;
                    }
                    return Integer.compare(this.startX, o.startX) * -1;
                }
                return Integer.compare(this.rainbowCount, o.rainbowCount) * -1;
            }
            return Integer.compare(this.size, o.size) * -1;
        }
    }
}
/**
 * @author choi
 * @date Sep 4, 2020
 * @see https://www.acmicpc.net/problem/17472
 * @mem 13,188kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 섬으로 최소 신장트리를 만들어야하는 문제였다.
 * BFS를 이용해 섬마다 번호를 부여해주고, BFS를 이용해서 각 점마다 다리를 연결할 수 있는 지
 * 확인한 후 다리를 만들 수 있다면 PriorityQueue에 넣어주었다.
 * 서로소 집합과 Kruskal로 최소 신장 트리를 만들고, 가장 최소의 길이로 다리를 만들었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS/우선순위 큐> '다리 만들기 2'
public class BOJ17472 {
    static int N,M,number,answer;
    static int [][] map;
    static int [] parent, rank;
    static boolean [][] visited;
    static Queue<Point> q;
    static PriorityQueue<Point> pq;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        number = 1;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        map = new int[N][M];
        answer = 0;

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        q = new LinkedList<>();
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j] == 0) {
                    bfs(i,j);
                    number++;
                }
            }
        }
        number--;
        pq = new PriorityQueue<>();
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j] > 0) {
                    makeBridge(i, j);
                }
            }
        }


        parent = new int[number+1];
        rank = new int[number+1];

        init();
        int count = 0;
        while(!pq.isEmpty()) {
            Point temp = pq.poll();

            if(union(temp.x, temp.y)) {
                answer+=temp.distance;
                count++;
            }

            if(count == number - 1)
                break;
        }
        System.out.println(count != number - 1 ? -1 : answer);
    }

    static void makeBridge(int x, int y) {
        q.offer(new Point(x,y,0));
        int start = map[x][y];
        while(!q.isEmpty()) {
            Point temp = q.poll();

            for(int i=0;i<4;i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                int distance = 0;
                boolean flag = false;
                while(!flag) {
                    if(!isIn(nx,ny)) break;
                    if(map[nx][ny] == start) break;
                    if(map[nx][ny] != -1) {
                        flag = true;
                        break;
                    }
                    distance++;

                    nx += dx[i];
                    ny += dy[i];
                }

                if(flag) {
                    if(distance < 2) continue;
                    pq.offer(new Point(map[x][y],map[nx][ny],distance));
                }
            }
        }
        q.clear();
    }

    static void bfs(int x, int y) {
        visited[x][y] = true;
        map[x][y] = number;
        q.offer(new Point(x,y));

        while(!q.isEmpty()) {
            Point temp = q.poll();

            for(int i=0;i<4;i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(isIn(nx,ny) && !visited[nx][ny] && map[nx][ny] == 0) {
                    map[nx][ny] = number;
                    visited[nx][ny] = true;
                    q.offer(new Point(nx,ny));
                }
            }
        }
        q.clear();
    }

    static void init() {
        for(int i=1;i<number+1;i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    static int find(int x) {
        if(parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if(xRoot == yRoot) return false;
        else {
            if(rank[xRoot] == rank[yRoot]) {
                rank[xRoot]++;
            }
            if(rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = parent[yRoot];
            }else {
                parent[yRoot] = parent[xRoot];
            }
            return true;
        }
    }

    static boolean isIn(int x, int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distance;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        Point(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.distance, o.distance);
        }
    }
}
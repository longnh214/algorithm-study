/**
 * @author choi
 * @date Oct 13, 2020
 * @see https://www.acmicpc.net/problem/17142
 * @mem 42,136kb
 * @time 712ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS/삼성기출> '연구소 3'
public class BOJ17142 {
    static int [][] arr;
    static int [][] virus;
    static int N, M, virusCnt, answer;
    static int [] temp;
    static int [][] copyMap;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        copyMap = new int[N][N];
        virus = new int[10][2];
        answer = Integer.MAX_VALUE;
        temp = new int[M];

        virusCnt = 0;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                copyMap[i][j] = arr[i][j];
                if(arr[i][j] == 2) {
                    virus[virusCnt][0] = i;
                    virus[virusCnt][1] = j;
                    virusCnt++;
                }
            }
        }

        comb(0,0);

        System.out.println((answer != Integer.MAX_VALUE) ? answer : -1);
    }

    //활성화될 바이러스를 고르는 완전탐색
    public static void comb(int cnt, int start) {
        if(cnt == M) {
            copy();
            bfs();
            //여기에서 bfs
            return;
        }

        for(int i=start;i<virusCnt;i++) {
            temp[cnt] = i;
            comb(cnt+1, i+1);
        }
    }

    //입력받았던 연구소 현황을 copy. 대신 활성화될 바이러스는 3으로 바꿔준다.
    public static void copy() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                arr[i][j] = copyMap[i][j];
            }
        }

        for(int i=0;i<temp.length;i++) {
            arr[virus[temp[i]][0]][virus[temp[i]][1]] = 3;
        }
    }

    //바이러스를 퍼뜨리는 bfs
    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        for(int i=0;i<temp.length;i++) {
            q.offer(new Point(virus[temp[i]][0], virus[temp[i]][1]));
        }

        while(!q.isEmpty()) {
            Point cur = q.poll();

            if(isFinish() != -1) {
                //바이러스는 3부터 퍼지므로 arr에는 퍼진 시간 + 3의 값이 저장되어 있으므로
                //최대값은 arr 중 최대값 - 3이다.
                answer = Math.min(answer, isFinish() - 3);
            }

            for(int i=0;i<4;i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                //비활성화된 바이러스 위치에 안 퍼뜨려도 연구소가 전부 감염되는 지 확인하는 데에 지장이 없지만,
                //벽처럼 아예 막힌 것이 아니라면 비활성화된 바이러스 위치에도 바이러스를 퍼뜨린다.
                if(isIn(nx,ny) && (arr[nx][ny] == 0 || arr[nx][ny] == 2)) {
                    arr[nx][ny] = arr[cur.x][cur.y]+1;
                    q.offer(new Point(nx,ny));
                }
            }
        }

    }

    //연구소 모든 공간에 바이러스가 퍼졌으면 arr 값 중 최대값 리턴.
    public static int isFinish() {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                max = Math.max(max, arr[i][j]);
                if(arr[i][j] == 0) {
                    return -1;
                }
            }
        }
        return max;
    }

    //유효한 배열 인덱스인지 확인
    public static boolean isIn(int x, int y) {
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
}
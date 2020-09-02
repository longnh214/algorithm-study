/**
 * @author choi
 * @date Sep 2, 2020
 * @see https://www.acmicpc.net/problem/17144
 * @mem 136,548kb
 * @time 476ms
 * @caution
 * [고려사항]
 * 회전할 때 인덱스만 잘 생각하면 풀 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <시뮬레이션/삼성> '미세먼지 안녕!'
public class BOJ17144 {
    static int R,C,T,sum,arr[][];
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,-1,0,1};
    static List<Integer> ACList;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        ACList = new ArrayList<>();

        arr = new int[R][C];
        for(int i=0;i<R;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == -1) {
                    ACList.add(i);
                }
            }
        }

        for(int t=0;t<T;t++) {
            bfs();
            rotateDust();
        }

        //check
//		for(int i=0;i<R;i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}

        sum = 0;
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                if(arr[i][j] != -1) {
                    sum += arr[i][j];
                }
            }
        }
        sb.append(sum);
        System.out.println(sb);
    }

    static void bfs() {
        Queue<Dust> q = new LinkedList<>();

        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                if(arr[i][j] > 0) {
                    q.offer(new Dust(i,j,arr[i][j]));
                }
            }
        }

        while(!q.isEmpty()) {
            Dust temp = q.poll();

            for(int i=0;i<4;i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                int moveDust = temp.dust/5;

                if(isIn(nx,ny) && arr[nx][ny] != -1) {
                    arr[temp.x][temp.y] -= moveDust;
                    //여기에서 배열 값이 0이 되었을 때를 체크.
                    arr[nx][ny] += moveDust;
                }
            }
        }
    }

    static void rotateDust() {
        int up = ACList.get(0);
        int down = ACList.get(1);
        //위쪽 공기청정기 처리
        for(int i=up-1;i>0;i--) {
            arr[i][0] = arr[i-1][0];
        }
        for(int i=0;i<C-1;i++) {
            arr[0][i] = arr[0][i+1];
        }
        for(int i=0;i<up;i++) {
            arr[i][C-1] = arr[i+1][C-1];
        }
        for(int i=C-1;i>1;i--) {
            arr[up][i] = arr[up][i-1];
        }
        arr[up][1] = 0;

        //아래쪽 공기청정기 처리
        for(int i=down+1;i<R-1;i++) {
            arr[i][0] = arr[i+1][0];
        }
        for(int i=0;i<C-1;i++) {
            arr[R-1][i] = arr[R-1][i+1];
        }
        for(int i=R-1;i>down;i--) {
            arr[i][C-1] = arr[i-1][C-1];
        }
        for(int i=C-1;i>1;i--) {
            arr[down][i] = arr[down][i-1];
        }
        arr[down][1] = 0;
    }

    public static boolean isIn(int x, int y) {
        return x>=0 && x<R && y>=0 && y<C;
    }

    static class Dust{
        int x;
        int y;
        int dust;
        public Dust(int x, int y, int dust) {
            super();
            this.x = x;
            this.y = y;
            this.dust = dust;
        }
    }
}
/**
 * @author choi
 * @date Nov 2, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRQm6qfL0DFAUo
 * @mem 88,896kb
 * @time 1,144ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//SW Expert <SW역량테스트> '벽돌 깨기'
public class Solution5656 {
    static int H,W,answer,N;
    static int [] temp;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    static int [][] map, copyMap;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int t=1;t<=T;t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            copyMap = new int[H][W];
            temp = new int[N];

            for(int i=0;i<H;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<W;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            answer = Integer.MAX_VALUE;

            perm(0);

            System.out.println("#" + t + " " + answer);
        }

    }

    public static void perm(int cnt) {
        if(cnt == N) {
            copy();
            //N번 구슬을 떨어뜨린다. + 퍼짐 + 낙하.
            for(int i=0;i<N;i++) {
                func(temp[i]);
            }

            answer = Math.min(answer, count());
            return;
        }

        for(int i=0;i<W;i++) {
            temp[cnt] = i;
            perm(cnt+1);
        }
    }

    public static void func(int w) {
        boolean flag = false;
        int target = -1;
        for(int i=0;i<H;i++) {
            if(copyMap[i][w] > 0) {
                flag = true;
                target = i;
                break;
            }
        }
        //아무 것도 없는 곳이라면 함수 탈출.
        if(!flag) return;

        //퍼진다.
        bfs(target,w);

        //아래로 내린다.
        for(int i=0;i<W;i++) {
            for(int j=0;j<H;j++) {
                if(copyMap[j][i] == 0) {
                    for(int k=j;k>=1;k--) {
                        copyMap[k][i] = copyMap[k-1][i];
                    }
                    copyMap[0][i] = 0;
                }
            }
        }
    }

    public static void bfs(int x, int y) {
        Queue<Brick> q = new LinkedList<>();

        q.offer(new Brick(x,y,copyMap[x][y]));
        copyMap[x][y] = 0;

        while(!q.isEmpty()) {
            Brick temp = q.poll();

            for(int i=0;i<4;i++) {
                for(int j=1;j<temp.size;j++) {
                    if(isIn(temp.x + (dx[i] * j), temp.y + (dy[i] * j)) && copyMap[temp.x + (dx[i] * j)][temp.y + (dy[i] * j)] > 0) {
                        q.offer(new Brick(temp.x + (dx[i] * j), temp.y + (dy[i] * j), copyMap[temp.x + (dx[i] * j)][temp.y + (dy[i] * j)]));
                        copyMap[temp.x + (dx[i] * j)][temp.y + (dy[i] * j)] = 0;
                    }
                }
            }
        }
    }

    public static boolean isIn(int x, int y) {
        return x>=0 && x<H && y>=0 && y<W;
    }

    public static int count() {
        int count = 0;
        for(int i=0;i<H;i++) {
            for(int j=0;j<W;j++) {
                if(copyMap[i][j] > 0) count++;
            }
        }
        return count;
    }

    public static void copy() {
        for(int i=0;i<H;i++) {
            for(int j=0;j<W;j++) {
                copyMap[i][j] = map[i][j];
            }
        }
    }

    public static void print() {
        for(int i=0;i<H;i++) {
            System.out.println(Arrays.toString(copyMap[i]));
        }
    }

    static class Brick{
        int x;
        int y;
        int size;
        public Brick(int x, int y, int size) {
            super();
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }
}
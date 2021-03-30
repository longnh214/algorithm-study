/**
 * @author choi
 * @date Nov 8, 2020
 * @see https://www.acmicpc.net/problem/17143
 * @mem 22,144kb
 * @time 892ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현> '낚시왕'
public class BOJ17143 {
    static int R,C,M,answer;
    static int [][] map;
    static int [] dx = {0,-1,1,0,0};
    static int [] dy = {0,0,0,1,-1};
    static Shark [] shark;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(M == 0) {
            System.out.println(0);
            return;
        }

        map = new int[R+1][C+1];
        shark = new Shark[M+1];
        shark[0] = new Shark(-1,-1,-1,-1,-1);

        for(int i=1;i<=M;i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            shark[i] = new Shark(r, c, s, d, z);
        }

        Arrays.sort(shark);

        for(int i=1;i<=M;i++) {
            map[shark[i].r][shark[i].c] = i;
        }
        for(int i=1;i<=C;i++) {
            //잡고
            for(int j=1;j<=R;j++) {
                if(map[j][i] > 0) {
                    answer += shark[map[j][i]].z;

                    shark[map[j][i]].z = -1;

                    map[j][i] = 0;
                    break;
                }
            }
            //상어이동.
            for(int j=1;j<=R;j++) {
                Arrays.fill(map[j],0);
            }
            for(int j=1;j<=M;j++) {
                if(shark[j].z < 0)
                    continue;

                int nr = shark[j].r;
                int nc = shark[j].c;
                for(int k=0;k<(shark[j].d == 1 || shark[j].d == 2 ?  shark[j].s % (2*(R-1))  : shark[j].s % (2*(C-1)));k++) {
                    nr += dx[shark[j].d];
                    nc += dy[shark[j].d];

                    if(!isIn(nr,nc)) {
                        nr -= dx[shark[j].d];
                        nc -= dy[shark[j].d];
                        shark[j].d = reverseDir(shark[j].d);
                        nr += dx[shark[j].d];
                        nc += dy[shark[j].d];
                    }
                }

                if(map[nr][nc] != j && map[nr][nc] > 0) {
                    shark[map[nr][nc]].z = -1;
                }

                map[nr][nc] = j;
                shark[j].r = nr;
                shark[j].c = nc;
            }
        }

        System.out.println(answer);
    }

    public static void print() {
        for(int i=1;i<=R;i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }

    public static int reverseDir(int dir) {
        switch(dir) {
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 4;
            case 4:
                return 3;
            default:
                return -1;
        }
    }

    static class Shark implements Comparable<Shark>{
        int r;
        int c;
        int s;
        int d;
        int z;

        Shark(int r, int c, int s, int d, int z) {
            super();
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public String toString() {
            return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
        }

        @Override
        public int compareTo(Shark o) {
            // TODO Auto-generated method stub
            return Integer.compare(this.z, o.z);
        }
    }

    public static boolean isIn(int x, int y) {
        return x>=1 && x<=R && y>=1 && y<=C;
    }
}
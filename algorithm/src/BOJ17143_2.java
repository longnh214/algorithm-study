/**
 * @author nakhoonchoi
 * @date 2024/09/20
 * @see https://www.acmicpc.net/problem/17143
 * @mem 21,656kb
 * @time 848ms
 * @caution
 * [고려사항]
 * 상어의 크기 별로 정렬한 뒤에 이동을 해줌으로써,
 * 모든 이동이 마친 뒤에 상어가 크기가 작은 상어를 잡아먹는 로직을 효율적으로 실행할 수 있도록 했다.
 *
 * 그리고 시간 초과가 발생했던 문제였다.
 * 상어를 이동시키는 과정에서 speed는 1000까지 있을 수 있는데, 굳이 1000번 이동할 필요가 없고,
 * speed에서 방향과 자기 자리로 돌아올 수 있는 수만큼 나눈 나머지 만큼만 이동하면 되었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <삼성기출/구현> '낚시왕'

public class BOJ17143_2 {
    static int R, C, M, answer;
    static int [][] map;
    static int [] dx = {0, -1, 1, 0, 0};
    static int [] dy = {0, 0, 0, 1, -1};
    static Shark [] sharks;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(M == 0){
            System.out.println(0);
            return;
        }

        map = new int[R+1][C+1];
        sharks = new Shark[M+1];
        sharks[0] = new Shark(-1, -1, -1, -1, -1);

        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            sharks[i] = new Shark(r, c, speed, dir, size);
        }

        //크기 순으로 이동시킨다.
        Arrays.sort(sharks);

        for(int i=1;i<=M;i++) {
            map[sharks[i].r][sharks[i].c] = i;
        }

        for(int i=1;i<=C;i++){
            //낚시왕이 현재 열 중 가장 땅과 가까운 상어를 잡는다.
            for(int j=1;j<=R;j++){
                if(map[j][i] > 0){
                    answer += sharks[map[j][i]].size;
                    sharks[map[j][i]].size = -1;
                    map[j][i] = 0;
                    break;
                }
            }

            //상어가 이동한다.
            for(int j=1;j<=R;j++) {
                Arrays.fill(map[j],0);
            }
            for(int j=1;j<=M;j++){
                if(sharks[j].size < 0){
                    continue;
                }

                int nr = sharks[j].r;
                int nc = sharks[j].c;
                for(int k=0;k<(sharks[j].dir == 1 || sharks[j].dir == 2 ?  sharks[j].speed % (2*(R-1)) : sharks[j].speed % (2*(C-1)));k++){
                    nr += dx[sharks[j].dir];
                    nc += dy[sharks[j].dir];

                    if(!isIn(nr, nc)){
                        nr -= dx[sharks[j].dir];
                        nc -= dy[sharks[j].dir];
                        sharks[j].dir = reverseDir(sharks[j].dir);
                        nr += dx[sharks[j].dir];
                        nc += dy[sharks[j].dir];
                    }
                }

                //잡아먹힌다.
                if(map[nr][nc] != j && map[nr][nc] > 0){
                    sharks[map[nr][nc]].size = -1;
                }

                map[nr][nc] = j;
                sharks[j].r = nr;
                sharks[j].c = nc;
            }
        }

        System.out.println(answer);
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

    public static boolean isIn(int r, int c){
        return r>=1 && r<=R && c>=1 && c<=C;
    }

    static class Shark implements Comparable<Shark>{
        int r;
        int c;
        int speed;
        int dir;
        int size;

        Shark(int r, int c, int speed, int dir, int size) {
            this.r = r;
            this.c = c;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }

        @Override
        public int compareTo(Shark o) {
            return Integer.compare(this.size, o.size);
        }
    }
}
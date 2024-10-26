/**
 * @author nakhoonchoi
 * @date 2024/10/26
 * @see https://www.acmicpc.net/problem/19236
 * @mem 11,680kb
 * @time 64ms
 * @caution
 * [고려사항]
 * 재귀함수를 이용하여 완전탐색을 할 때에 갱신한 부분. visited처리를 하고, 원상복구하는 처리를 잘 할 수 있도록 생각해야겠다.
 * fishes는 물고기 정보를 담은 배열
 * map은 물고기의 크기를 나타낸 배열.
 * isAlive는 visited
 * map 2차원 배열 값이 -1이면 상어, 0이면 빈값, 나머지 값은 물고기의 크기이다.
 * 1. 상어가 0,0에 배치(물고기를 잡아먹음) ->
 * 2. 물고기 1~16번까지 swap & 이동 ->
 * 3. 상어가 다음 갈 곳 정하고 잡아먹으며 이동 ->
 * 4. 2,3 반복
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <삼성기출/구현> '청소년 상어'

public class BOJ19236_2 {
    //물고기의 정보를 입력받는다.
    static Fish [] fishes;
    //물고기의 현황을 2차원 배열에 표시한다.
    static int [][] map;
    //최대값을 갱신하기 위한 변수.
    static int answer;
    //8방향을 나타내기 위한 dx, dy 배열.
    static int [] dx = {-1,-1,0,1,1,1,0,-1};
    static int [] dy = {0,-1,-1,-1,0,1,1,1};
    //물고기가 살았는지 죽었는지 확인하기 위한 변수.
    static boolean [] isAlive = new boolean[17];
    public static void main(String[] args) throws IOException{
        //초기화.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[4][4];
        answer = Integer.MIN_VALUE;
        fishes = new Fish[17];

        //입력.
        for(int i=0;i<4;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<4;j++) {
                int size = Integer.parseInt(st.nextToken());
                //방향은 배열 인덱스에 맞게 -1로 입력받는다.
                int dir = Integer.parseInt(st.nextToken()) - 1;
                map[i][j] = size;
                fishes[size] = new Fish(i,j,dir);
            }
        }


        Arrays.fill(isAlive, true);

        //첫번째 상어 처리.
        int temp = map[0][0];
        isAlive[map[0][0]] = false;
        map[0][0] = -1;

        eatFish(0, 0, fishes[temp].dir, temp, 0);

        System.out.println(answer);
    }

    //상어가 다음 목적지를 찾으며 물고기를 먹는 작업
    public static void eatFish(int x, int y, int dir, int sum, int count) {
        //최대값이라면 갱신한다.
        answer = Math.max(answer, sum);

        int [][] copyMap = new int[4][4];
        Fish[] copyFishes = new Fish[17];

        //map과 Fishes 배열을 미리 copy 해놓는다.
        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        for(int i=1;i<17;i++) {
            copyFishes[i] = fishes[i];
        }

        //상어한테 먹힌 상태로 넘어왔으므로 이동.
        move();

        //상어는 1칸 ~ 3칸 사이로 갈 수 있다.
        for(int i=1;i<=3;i++) {
            int nx = x + (dx[dir] * i);
            int ny = y + (dy[dir] * i);

            if(isIn(nx,ny)) {
                //빈칸이라면 갈 수 없다.
                if(map[nx][ny] == 0) {
                    continue;
                }

                map[x][y] = 0;
                int size = map[nx][ny];
                //상어 칸.
                map[nx][ny] = -1;
                isAlive[size] = false;
                eatFish(nx, ny, fishes[size].dir, sum + size, count + 1);
                //재귀함수를 돈 후에 원상복구.
                isAlive[size] = true;
                map[nx][ny] = size;
                map[x][y] = -1;
            }
            //경계 밖을 넘어가면 더 이상 볼 필요가 없다.
            else {
                break;
            }
        }

        //상어가 이동할 곳이 없다면 최대한 물고기를 먹은 경우이므로 map과 fishes를 원상 복구 시킨다.
        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                map[i][j] = copyMap[i][j];
            }
        }

        for(int i=1;i<17;i++) {
            fishes[i] = copyFishes[i];
        }
    }

    //물고기의 이동 함수.
    public static void move() {
        for(int i=1;i<=16;i++) {
            //죽어있다면 continue.
            if(!isAlive[i])
                continue;

            Fish cur = fishes[i];

            int dir = cur.dir;
            int nx = cur.x;
            int ny = cur.y;
            //물고기가 이동할 곳이 있는 지 없는 지 판별.
            boolean flag = false;

            //최대 8번 방향 회전하여 이동시킬 수 있는지 확인
            for(int j=0;j<8;j++) {
                nx = cur.x + dx[dir];
                ny = cur.y + dy[dir];

                if(isIn(nx,ny)) {
                    //상어라면 45도 회전.
                    if(map[nx][ny] == -1) {
                        dir = (dir+1) % 8;
                        continue;
                    }
                    //빈칸이거나 상어가 아니라면(물고기라면)
                    if(map[nx][ny] == 0 || map[nx][ny] != -1) { //
                        flag = true;
                        break;
                    }
                }
                //배열 인덱스 밖이라면. 45도 회전.
                else {
                    dir = (dir+1)%8;
                }
            }

            //8방향을 다 돌아도 물고기가 없다면.
            if(!flag) continue;

            //고기의 자리를 바꾼다.
            int temp = map[nx][ny];
            map[nx][ny] = map[cur.x][cur.y];
            map[cur.x][cur.y] = temp;

            fishes[i] = new Fish(nx,ny,dir);

            //이동할 칸이 빈칸이 아니라면.
            if(temp != 0) {
                fishes[temp] = new Fish(cur.x, cur.y, fishes[temp].dir);
            }
        }
    }

    //물고기 객체.
    static class Fish{
        int x;
        int y;
        int dir;

        Fish(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    //배열 인덱스 안에 있는 지 판별하는 함수.
    public static boolean isIn(int x, int y) {
        return x>=0 && x<4 && y>=0 && y<4;
    }
}
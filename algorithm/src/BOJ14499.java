/**
 * @author choi
 * @date Oct 8, 2020
 * @see https://www.acmicpc.net/problem/14499
 * @mem 14,176kb
 * @time 140ms
 * @caution
 * [고려사항]
 * 회전할 때마다 주사위 배열의 값을 잘 조정하도록 인덱스를 잘 바꿔야 했던 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현> '주사위 굴리기'
public class BOJ14499 {
    //{0,1,2,3,4,5}
    static int [][] dice = {
            { 2, 1, 5, 0, 4, 3 },
            { 3, 1, 0, 5, 4, 2 },
            { 1, 5, 2, 3, 0, 4 },
            { 4, 0, 2, 3, 5, 1 },
    };
    static int [] diceValue = new int[6];
    static int [][] map;
    static int [] command;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {1,-1,0,0};
    static int N,M,X,Y,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //주사위 설정


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        command = new int[K];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++) {
            command[i] = Integer.parseInt(st.nextToken());
        }

        //주사위 첫 좌표는 0,1
//		int diceX = 0;
//		int diceY = 1;
        int curX = X;
        int curY = Y;
        for(int i=0;i<K;i++) {
            //여기서 주사위를 굴린다.
            int nx = curX + dx[command[i]-1];
            int ny = curY + dy[command[i]-1];

            if(isIn(nx,ny)) {
                curX = nx;
                curY = ny;

                //커맨드에 따라 주사위 면 좌표 이동.
                spin(command[i]-1);
                if (map[nx][ny] == 0){
                    map[nx][ny] = diceValue[0];
                }
                else{
                    diceValue[0] = map[nx][ny];
                    map[nx][ny] = 0;
                }
                System.out.println(diceValue[5]);

                //System.out.println(Arrays.toString(diceValue));
            }
        }
    }

    public static void spin(int cmd){
        //윗 면 : 5번 인덱스
        //바닥 면 : 0번 인덱스

        int [] cpDice = new int[6];
        for (int i = 0; i < 6; i++){
            cpDice[i] = diceValue[dice[cmd][i]];
        }
        diceValue = Arrays.copyOf(cpDice, cpDice.length);
    }

    public static boolean isIn(int x, int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }
}
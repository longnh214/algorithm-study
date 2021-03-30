/**
 * @author choi
 * @date Oct 19, 2020
 * @see https://www.acmicpc.net/problem/20057
 * @mem 38,160kb
 * @time 540ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현/삼성기출> '마법사 상어와 토네이도'
public class BOJ20057 {
    static int [][] arr;
    static int [][][][] dirArr;
    static int [] arrLen = {2,2,1,2,2};
    static int startX, startY;
    static int N;
    static int answer = 0;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {-1,0,1,0};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;

        //dirArr 전처리 [방향][퍼센트][퍼센트별 개수][x,y좌표]
        dirArr = new int[4][5][2][2];

        //왼쪽 1% 인덱스 설정
        dirArr[0][0][0][0] = -1;
        dirArr[0][0][0][1] = 1;
        dirArr[0][0][1][0] = 1;
        dirArr[0][0][1][1] = 1;

        //왼쪽 2% 인덱스 설정
        dirArr[0][1][0][0] = -2;
        dirArr[0][1][0][1] = 0;
        dirArr[0][1][1][0] = 2;
        dirArr[0][1][1][1] = 0;

        //왼쪽 5% 인덱스 설정
        dirArr[0][2][0][0] = 0;
        dirArr[0][2][0][1] = -2;

        //왼쪽 7% 인덱스 설정
        dirArr[0][3][0][0] = -1;
        dirArr[0][3][0][1] = 0;
        dirArr[0][3][1][0] = 1;
        dirArr[0][3][1][1] = 0;

        //왼쪽 10% 인덱스 설정
        dirArr[0][4][0][0] = -1;
        dirArr[0][4][0][1] = -1;
        dirArr[0][4][1][0] = 1;
        dirArr[0][4][1][1] = -1;

        //아래쪽 1% 인덱스 설정
        dirArr[1][0][0][0] = -1;
        dirArr[1][0][0][1] = -1;
        dirArr[1][0][1][0] = -1;
        dirArr[1][0][1][1] = 1;

        //아래쪽 2% 인덱스 설정
        dirArr[1][1][0][0] = 0;
        dirArr[1][1][0][1] = -2;
        dirArr[1][1][1][0] = 0;
        dirArr[1][1][1][1] = 2;

        //아래쪽 5% 인덱스 설정
        dirArr[1][2][0][0] = 2;
        dirArr[1][2][0][1] = 0;

        //아래쪽 7% 인덱스 설정
        dirArr[1][3][0][0] = 0;
        dirArr[1][3][0][1] = 1;
        dirArr[1][3][1][0] = 0;
        dirArr[1][3][1][1] = -1;

        //아래쪽 10% 인덱스 설정
        dirArr[1][4][0][0] = 1;
        dirArr[1][4][0][1] = -1;
        dirArr[1][4][1][0] = 1;
        dirArr[1][4][1][1] = 1;

        //오른쪽 1% 인덱스 설정
        dirArr[2][0][0][0] = -1;
        dirArr[2][0][0][1] = -1;
        dirArr[2][0][1][0] = 1;
        dirArr[2][0][1][1] = -1;

        //오른쪽 2% 인덱스 설정
        dirArr[2][1][0][0] = -2;
        dirArr[2][1][0][1] = 0;
        dirArr[2][1][1][0] = 2;
        dirArr[2][1][1][1] = 0;

        //오른쪽 5% 인덱스 설정
        dirArr[2][2][0][0] = 0;
        dirArr[2][2][0][1] = 2;

        //오른쪽 7% 인덱스 설정
        dirArr[2][3][0][0] = -1;
        dirArr[2][3][0][1] = 0;
        dirArr[2][3][1][0] = 1;
        dirArr[2][3][1][1] = 0;

        //오른쪽 10% 인덱스 설정
        dirArr[2][4][0][0] = -1;
        dirArr[2][4][0][1] = 1;
        dirArr[2][4][1][0] = 1;
        dirArr[2][4][1][1] = 1;

        //위쪽 1% 인덱스 설정
        dirArr[3][0][0][0] = 1;
        dirArr[3][0][0][1] = -1;
        dirArr[3][0][1][0] = 1;
        dirArr[3][0][1][1] = 1;

        //위쪽 2% 인덱스 설정
        dirArr[3][1][0][0] = 0;
        dirArr[3][1][0][1] = -2;
        dirArr[3][1][1][0] = 0;
        dirArr[3][1][1][1] = 2;

        //위쪽 5% 인덱스 설정
        dirArr[3][2][0][0] = -2;
        dirArr[3][2][0][1] = 0;

        //위쪽 7% 인덱스 설정
        dirArr[3][3][0][0] = 0;
        dirArr[3][3][0][1] = -1;
        dirArr[3][3][1][0] = 0;
        dirArr[3][3][1][1] = 1;

        //위쪽 10% 인덱스 설정
        dirArr[3][4][0][0] = -1;
        dirArr[3][4][0][1] = -1;
        dirArr[3][4][1][0] = -1;
        dirArr[3][4][1][1] = 1;

        arr = new int[N][N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        startX = N/2;
        startY = N/2;

        int rotate = 1;

        while(true) {
            for(int i=0;i<(2*rotate - 1);i++) {
                if(startY - i < 0) {
                    break;
                }
                func(startX, startY-i, 0);
            }

            startY -= (2*rotate - 1);

            if(startX == 0 && startY <= 0) {
                break;
            }

            for(int i=0;i<(2*rotate - 1);i++) {
                func(startX+i, startY, 1);
            }

            startX += (2*rotate - 1);

            for(int i=0;i<(2*rotate);i++) {
                func(startX, startY+i, 2);
            }

            startY += (2*rotate);

            for(int i=0;i<(2*rotate);i++) {
                func(startX-i, startY, 3);
            }

            startX -= (2*rotate);

            rotate++;
        }

        System.out.println(answer);
    }

    public static void func(int x, int y, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if(isIn(nx,ny)) {
            arr[nx][ny] += arr[x][y];
            arr[x][y] = 0;
        }else {
            answer += arr[x][y];
            arr[x][y] = 0;
            return;
        }

        int temp = arr[nx][ny];

        for(int i=0;i<5;i++) {
            for(int j=0;j<arrLen[i];j++) {
                int percent = -1;
                switch(i) {
                    case 0:
                        percent = 1;
                        break;
                    case 1:
                        percent = 2;
                        break;
                    case 2:
                        percent = 5;
                        break;
                    case 3:
                        percent = 7;
                        break;
                    case 4:
                        percent = 10;
                        break;
                }

                arr[nx][ny] -= ((temp * percent) / 100);

                if(isIn(nx+dirArr[dir][i][j][0], ny+dirArr[dir][i][j][1])){
                    arr[nx+dirArr[dir][i][j][0]][ny+dirArr[dir][i][j][1]] += ((temp * percent) / 100);
                }else {
                    answer += ((temp * percent) / 100);
                }
            }
        }
        if(isIn(nx+dx[dir], ny+dy[dir])){
            arr[nx+dx[dir]][ny+dy[dir]] += arr[nx][ny];
        }else {
            answer += arr[nx][ny];
        }
        arr[nx][ny] = 0;
    }

    public static boolean isIn(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N;
    }
}
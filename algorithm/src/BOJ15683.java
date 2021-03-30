/**
 * @author choi
 * @date Oct 10, 2020
 * @see https://www.acmicpc.net/problem/15683
 * @mem 22,336kb
 * @time 432ms
 * @caution
 * [고려사항]
 * nx와 ny를 초기화 시켜주지 않아 cctv 처리를 제대로 하지 못했다.
 * 코드를 꼼꼼히 읽고 초기화를 잘 시켜주어야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현/삼성기출> '감시'
public class BOJ15683 {
    static int N,M;
    static int [][] arr;
    static int [][] copyArr;
    static int answer = Integer.MAX_VALUE;
    static int cctvCnt = 0;
    static int [] temp;
    static int [] cctvInfo;
    static int [] cctvX;
    static int [] cctvY;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        copyArr = new int[N][M];


        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] >= 1 && arr[i][j] <= 5)
                    cctvCnt++;
            }
        }
        temp = new int[cctvCnt];
        cctvInfo = new int[cctvCnt];
        cctvX = new int[cctvCnt];
        cctvY = new int[cctvCnt];
        int index = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(arr[i][j] >= 1 && arr[i][j] <= 5) {
                    cctvInfo[index] = arr[i][j];
                    cctvX[index] = i;
                    cctvY[index] = j;
                    index++;
                }
            }
        }

        perm(0,0);

        System.out.println(answer);
    }

    public static void perm(int cnt, int index) {
        if(cnt == cctvCnt) {
            copy();
            for(int i=0;i<cctvCnt;i++) {
                func(cctvInfo[i], temp[i], cctvX[i], cctvY[i]);
            }

            int count = 0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(copyArr[i][j] == 0) {
                        count++;
                    }
                }
            }
            answer = answer > count ? count : answer;
            return;
        }

        for(int i=index;i<cctvInfo.length;i++) {
            if(cctvInfo[i] >= 1 && cctvInfo[i] <= 4) {
                for(int j=0;j<4;j++) {
                    temp[cnt] = j;
                    perm(cnt+1,i+1);
                }
            }else {
                temp[cnt] = 0;
                perm(cnt+1, i+1);
            }
        }
    }

    public static void func(int cctv, int dir, int x, int y) {
        int nx = x;
        int ny = y;
        switch(cctv) {
            case 1:
                while(true) {
                    nx += dx[dir];
                    ny += dy[dir];

                    if(isIn(nx,ny) && copyArr[nx][ny] != 6)
                        copyArr[nx][ny] = -1;
                    else if(!isIn(nx,ny) || copyArr[nx][ny] == 6)
                        break;
                }
                break;
            case 2:
                while(true) {
                    nx += dx[dir];
                    ny += dy[dir];

                    if(isIn(nx,ny) && copyArr[nx][ny] != 6)
                        copyArr[nx][ny] = -1;
                    else if(!isIn(nx,ny) || copyArr[nx][ny] == 6)
                        break;
                }
                nx = x;
                ny = y;
                while(true) {
                    nx += dx[(dir+2)%4];
                    ny += dy[(dir+2)%4];

                    if(isIn(nx,ny) && copyArr[nx][ny] != 6)
                        copyArr[nx][ny] = -1;
                    else if(!isIn(nx,ny) || copyArr[nx][ny] == 6)
                        break;
                }
                break;
            case 3:
                while(true) {
                    nx += dx[dir];
                    ny += dy[dir];

                    if(isIn(nx,ny) && copyArr[nx][ny] != 6)
                        copyArr[nx][ny] = -1;
                    else if(!isIn(nx,ny) || copyArr[nx][ny] == 6)
                        break;
                }
                nx = x;
                ny = y;
                while(true) {
                    nx += dx[(dir+1)%4];
                    ny += dy[(dir+1)%4];

                    if(isIn(nx,ny) && copyArr[nx][ny] != 6)
                        copyArr[nx][ny] = -1;
                    else if(!isIn(nx,ny) || copyArr[nx][ny] == 6)
                        break;
                }
                break;
            case 4:
                while(true) {
                    nx += dx[dir];
                    ny += dy[dir];

                    if(isIn(nx,ny) && copyArr[nx][ny] != 6)
                        copyArr[nx][ny] = -1;
                    else if(!isIn(nx,ny) || copyArr[nx][ny] == 6)
                        break;
                }
                nx = x;
                ny = y;
                while(true) {
                    nx += dx[(dir+1)%4];
                    ny += dy[(dir+1)%4];

                    if(isIn(nx,ny) && copyArr[nx][ny] != 6)
                        copyArr[nx][ny] = -1;
                    else if(!isIn(nx,ny) || copyArr[nx][ny] == 6)
                        break;
                }
                nx = x;
                ny = y;
                while(true) {
                    nx += dx[(dir+2)%4];
                    ny += dy[(dir+2)%4];

                    if(isIn(nx,ny) && copyArr[nx][ny] != 6)
                        copyArr[nx][ny] = -1;
                    else if(!isIn(nx,ny) || copyArr[nx][ny] == 6)
                        break;
                }
                break;
            case 5:
                for(int i=0;i<4;i++) {
                    nx = x;
                    ny = y;
                    while(true) {
                        nx += dx[dir+i];
                        ny += dy[dir+i];

                        if(isIn(nx,ny) && copyArr[nx][ny] != 6)
                            copyArr[nx][ny] = -1;
                        else if(!isIn(nx,ny) || copyArr[nx][ny] == 6)
                            break;
                    }
                }
                break;
        }
    }

    public static void copy() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                copyArr[i][j] = arr[i][j];
            }
        }
    }

    public static boolean isIn(int x, int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }
}
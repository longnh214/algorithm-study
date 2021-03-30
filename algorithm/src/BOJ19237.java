/**
 * @author choi
 * @date Oct 16, 2020
 * @see https://www.acmicpc.net/problem/19237
 * @mem 16.072kb
 * @time 152ms
 * @caution
 * [고려사항]
 * 입력이 어려웠고, 문제를 잘 읽고 우선순위를 판단해야겠다고 생각했다.
 * 종이로 주어지면, 밑줄을 긋고 정리를 해야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <삼성기출> '어른 상어'
public class BOJ19237 {
    static int [][] arr;
    static int [][] smellArr;
    static int [][] smellStat;
    static int [][][] dir;
    static int [][] sharkInfo;
    static int N,M,k,answer;
    static int [] dx = {0,-1,1,0,0};
    static int [] dy = {0,0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        smellArr = new int[N][N];
        smellStat = new int[N][N];
        sharkInfo = new int[M+1][3];
        dir = new int[M+1][5][5];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > 0) {
                    sharkInfo[arr[i][j]][0] = i;
                    sharkInfo[arr[i][j]][1] = j;
                    smellArr[i][j] = k;
                    smellStat[i][j] = arr[i][j];
                }

            }
        }
        //각 상어의 방향 입력.
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=M;i++) {
            sharkInfo[i][2] = Integer.parseInt(st.nextToken());
        }

        //상어의 때에 따른 방향 우선순위 입력.
        for(int i=1;i<=M;i++) {
            for(int j=1;j<=4;j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=1;k<=4;k++) {
                    dir[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        //입력이 제대로 잘 되었는가.
//		for(int i=1;i<=M;i++) {
//			for(int j=1;j<=4;j++) {
//				System.out.println(Arrays.toString(dir[i][j]));
//			}
//		}
        answer = 0;
        while(true) {
            for(int i=1;i<=M;i++) {
                if(sharkInfo[i][0] == -1 && sharkInfo[i][1] == -1)
                    continue;
                int nx = sharkInfo[i][0] + dx[sharkInfo[i][2]];
                int ny = sharkInfo[i][1] + dy[sharkInfo[i][2]];

                int direction = sharkInfo[i][2];
                boolean flag = false;

                for(int j=1;j<=4;j++) {
                    nx = sharkInfo[i][0] + dx[dir[i][direction][j]];
                    ny = sharkInfo[i][1] + dy[dir[i][direction][j]];

                    if(isIn(nx,ny) && (smellArr[nx][ny] == 0)) {
                        if(arr[nx][ny] > 0 && arr[nx][ny] < i) {
                            arr[sharkInfo[i][0]][sharkInfo[i][1]] = 0;
                            sharkInfo[i][0] = -1;
                            sharkInfo[i][1] = -1;
                            sharkInfo[i][2] = -1;
                            break;
                        }
                        arr[sharkInfo[i][0]][sharkInfo[i][1]] = 0;
                        arr[nx][ny] = i;
                        sharkInfo[i][0] = nx;
                        sharkInfo[i][1] = ny;
                        sharkInfo[i][2] = dir[i][direction][j];
                        flag = true;
                        break;
                    }
                }

                if(flag) continue;

                for(int j=1;j<=4;j++) {
                    nx = sharkInfo[i][0] + dx[dir[i][direction][j]];
                    ny = sharkInfo[i][1] + dy[dir[i][direction][j]];

                    if(isIn(nx,ny) && (smellStat[nx][ny] == i)) {
                        if(arr[nx][ny] > 0 && arr[nx][ny] < i) {
                            arr[sharkInfo[i][0]][sharkInfo[i][1]] = 0;
                            sharkInfo[i][0] = -1;
                            sharkInfo[i][1] = -1;
                            sharkInfo[i][2] = -1;
                            break;
                        }
                        arr[sharkInfo[i][0]][sharkInfo[i][1]] = 0;
                        arr[nx][ny] = i;
                        sharkInfo[i][0] = nx;
                        sharkInfo[i][1] = ny;
                        sharkInfo[i][2] = dir[i][direction][j];
                        break;
                    }
                }
            }
            smellControl();
            for(int i=1;i<=M;i++) {
                if(sharkInfo[i][0] == -1 && sharkInfo[i][1] == -1)
                    continue;
                smellArr[sharkInfo[i][0]][sharkInfo[i][1]] = k;
                smellStat[sharkInfo[i][0]][sharkInfo[i][1]] = i;
            }
            answer++;

            if(isFinish()) {
                break;
            }
            if(answer > 1000) {
                break;
            }
        }
        System.out.println((answer > 1000) ? -1 : answer);
    }

    public static boolean isFinish() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(arr[i][j] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void smellControl() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(smellArr[i][j] == 1) {
                    smellStat[i][j] = 0;
                }
                if(smellArr[i][j] > 0) {
                    smellArr[i][j]--;
                }
            }
        }
    }

    public static boolean isIn(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N;
    }
}
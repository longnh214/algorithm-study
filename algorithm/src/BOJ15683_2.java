/**
 * @author nakhoonchoi
 * @date 2024/08/28
 * @see https://www.acmicpc.net/problem/15683
 * @mem 41,424kb
 * @time 196ms
 * @caution
 * [고려사항]
 * 배열을 입력 받으면서 cctv의 정보를 좌표, 정보 배열에 담아주었고,
 * 각 cctv마다 재귀로 방향을 정해주어서 완전탐색을 하였다.
 * 1,3,4번 cctv는 4방향으로 탐색해야하고,
 * 2번 cctv는 가로 세로 2방향,
 * 5번 cctv는 방향이 의미가 없었다.
 *
 * 재귀로 모든 cctv의 방향을 정해준 뒤 사각지대를 구할 때,
 * 2차원 배열을 복사해서 각 방향 별로 시야를 갱신한 뒤에 사각지대의 개수를 구해주었다.
 * '벽은 못 건너뛰지만, cctv는 건너뛸 수 있다.'
 * cctv에 대한 정보를 외부에 저장했기 때문에 복사된 배열 위의 cctv 정보는 덮어도 된다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <구현/삼성기출> '감시'

public class BOJ15683_2 {
    static int N, M, answer;
    static int [] cctvX;
    static int [] cctvY;
    static int [] cctvNum;
    static int [][] arr;
    static int [][] copyArr;
    static int [] cctvDir;
    static int cctvCount;
    static int [] dx = {1, 0, -1, 0};
    static int [] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        copyArr = new int[N][M];

        cctvX = new int[8];
        cctvY = new int[8];
        cctvNum = new int[8];

        cctvCount = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] >= 1 && arr[i][j] <= 5){
                    cctvX[cctvCount] = i;
                    cctvY[cctvCount] = j;
                    cctvNum[cctvCount] = arr[i][j];
                    cctvCount++;
                }
            }
        }
        cctvDir = new int[cctvCount];
        answer = Integer.MAX_VALUE;

        perm(0);

        System.out.println(answer);
    }

    public static void perm(int count) {
        if (count == cctvCount) {
            int result = calc();
            answer = Math.min(answer, result);
            return;
        }
        switch (cctvNum[count]) {
            case 1:
            case 3:
            case 4:
                for (int j = 0; j < 4; j++) {
                    cctvDir[count] = j;
                    perm(count + 1);
                }
                break;
            case 2:
                for (int j = 0; j < 2; j++) {
                    cctvDir[count] = j;
                    perm(count + 1);
                }
                break;
            case 5:
                cctvDir[count] = 0;
                perm(count + 1);
                break;
        }
    }

    public static int calc(){
        copy();

        for(int i=0;i<cctvCount;i++){
            switch(cctvNum[i]){
                case 1:
                    checkCctvVision(cctvX[i], cctvY[i], cctvDir[i]);
                    break;
                case 2:
                    checkCctvVision(cctvX[i], cctvY[i], cctvDir[i]);
                    checkCctvVision(cctvX[i], cctvY[i], (cctvDir[i] + 2) % 4);
                    break;
                case 3:
                    checkCctvVision(cctvX[i], cctvY[i], cctvDir[i]);
                    checkCctvVision(cctvX[i], cctvY[i], (cctvDir[i] + 1) % 4);
                    break;
                case 4:
                    checkCctvVision(cctvX[i], cctvY[i], cctvDir[i]);
                    checkCctvVision(cctvX[i], cctvY[i], (cctvDir[i] + 1) % 4);
                    checkCctvVision(cctvX[i], cctvY[i], (cctvDir[i] + 2) % 4);
                    break;
                case 5:
                    checkCctvVision(cctvX[i], cctvY[i], cctvDir[i]);
                    checkCctvVision(cctvX[i], cctvY[i], (cctvDir[i] + 1) % 4);
                    checkCctvVision(cctvX[i], cctvY[i], (cctvDir[i] + 2) % 4);
                    checkCctvVision(cctvX[i], cctvY[i], (cctvDir[i] + 3) % 4);
                    break;
                default:
                    break;
            }
        }

        return getBlindCount(copyArr);
    }

    //사각 지대 count
    public static int getBlindCount(int [][] copyArr){
        int count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(copyArr[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }

    //2차원 배열 복사
    public static void copy(){
        for(int i=0;i<N;i++){
            copyArr[i] = arr[i].clone();
        }
    }

    //범위 내에 있는 지 판별
    public static boolean isIn(int x, int y){
        return x>=0 && x<N && y>=0 && y<M;
    }

    //CCTV로 각 방향마다 볼 수 있는 시야 flag 표시(-1)
    public static void checkCctvVision(int baseX, int baseY, int dir){
        int nx = baseX;
        int ny = baseY;
        while(true){
            nx += dx[dir];
            ny += dy[dir];

            if(isIn(nx, ny) && copyArr[nx][ny] != 6){
                copyArr[nx][ny] = -1;
            }else{
                break;
            }
        }
    }
}
/**
 * @author nakhoonchoi
 * @date 2024/10/13
 * @see https://www.acmicpc.net/problem/20061
 * @mem 23,348kb
 * @time 320ms
 * @caution
 * [고려사항]
 * 파란 블록의 경우 3번 t, 초록 블록의 경우 2번 t에서
 * 양 블록이 같은 행 또는 열에 위치해야함을 주의해야한다.
 *
 * 그리고 각 색 블록의 lineCheck 함수에서 행 또는 열을 체크할 때,
 * 밀고 당겨온 다음 다음 열이 아닌 현재 열을 한 번 더 체크해야 했다.
 *
 * lightColorCheck를 두 번씩 하는 이유는, 각 0, 1번 행열을 확인해야하는데
 * 하나의 행/열씩 확인하려고 1번 행열만 확인한 뒤에 밀면 1번을 두 번 확인하면 되었다.
 * (공통의 함수를 사용하기 위해서)
 *
 * 2차원 배열 count를 할 때 스트림을 이용하면 확실히 시간이 조금 더 소요된다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <삼성기출/구현> '모노미노도미노 2'

public class BOJ20061 {
    static int [][] blueArea = new int[4][6];
    static int [][] greenArea = new int[6][4];
    static int [][] transferPoint;
    static int score;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        score = 0;

        for(int i=0;i<N;i++){
            //빨간 곳의 정보를 입력받아서
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            transferPoint = new int[2][2];

            //막대기 정보에 따라 파란 초록 곳으로 옮기고,
            switch(t){
                case 1:
                    transferPoint[0][0] = x;
                    transferPoint[0][1] = y;

                    transferBlue(transferPoint, 1, t);
                    transferGreen(transferPoint, 1, t);
                    break;
                case 2:
                    transferPoint[0][0] = x;
                    transferPoint[0][1] = y;
                    transferPoint[1][0] = x;
                    transferPoint[1][1] = y + 1;

                    transferBlue(transferPoint, 2, t);
                    transferGreen(transferPoint, 2, t);
                    break;
                case 3:
                    transferPoint[0][0] = x;
                    transferPoint[0][1] = y;
                    transferPoint[1][0] = x + 1;
                    transferPoint[1][1] = y;

                    transferBlue(transferPoint, 2, t);
                    transferGreen(transferPoint, 2, t);
                    break;
                default:
                    break;
            }
            //각각 수직, 수평 없애고 밀고 점수 체크
            blueLineCheck();
            greenLineCheck();

            //연한 곳 체크해서 옮긴다. double check(점수는 상승 없음)
            blueLightColorCheck();
            blueLightColorCheck();
            greenLightColorCheck();
            greenLightColorCheck();
        }

        System.out.println(score);
        System.out.println(getCount(blueArea) + getCount(greenArea));
    }

    //빨간 블록의 정보로 파란 블록 위에 배치하는 함수
    public static void transferBlue(int [][] transferPoint, int pointCount, int shape){
        // right
        int minY = 5;
        int x;
        switch(shape){
            case 1:
                x = transferPoint[0][0];

                for(int j=0;j<6;j++){
                    if(j == 5 || blueArea[x][j+1] != 0 ){
                        blueArea[x][j] = 1;
                        break;
                    }
                }
                break;
            case 2:
                for(int i=pointCount - 1;i>=0;i--){
                    x = transferPoint[i][0];

                    for(int j=0;j<6;j++){
                        if(j == 5 || blueArea[x][j+1] != 0){
                            blueArea[x][j] = 1;
                            break;
                        }
                    }
                }
                break;
            case 3:
                for(int i=pointCount - 1;i>=0;i--){
                    x = transferPoint[i][0];

                    for(int j=0;j<6;j++){
                        if(j == 5 || blueArea[x][j+1] != 0){
                            minY = Math.min(minY, j);
                            break;
                        }
                    }
                }

                blueArea[transferPoint[0][0]][minY] = 1;
                blueArea[transferPoint[1][0]][minY] = 1;
                break;
            default:
                break;
        }
    }

    //빨간 블록의 정보로 초록 블록 위에 배치하는 함수
    public static void transferGreen(int [][] transferPoint, int pointCount, int shape){
        // down
        int minX = 5;
        int y;
        switch(shape){
            case 1:
                y = transferPoint[0][1];

                for(int j=0;j<6;j++){
                    if(j == 5 || greenArea[j+1][y] != 0){
                        greenArea[j][y] = 1;
                        break;
                    }
                }
                break;
            case 2:
                for(int i=pointCount - 1;i>=0;i--){
                    y = transferPoint[i][1];

                    for(int j=0;j<6;j++){
                        if(j == 5 || greenArea[j+1][y] != 0){
                            minX = Math.min(minX, j);
                            break;
                        }
                    }
                }

                greenArea[minX][transferPoint[0][1]] = 1;
                greenArea[minX][transferPoint[1][1]] = 1;
                break;
            case 3:
                for(int i=pointCount - 1;i>=0;i--){
                    y = transferPoint[i][1];

                    for(int j=0;j<6;j++){
                        if(j == 5 || greenArea[j+1][y] != 0){
                            greenArea[j][y] = 1;
                            break;
                        }
                    }
                }
                break;
            default:
                break;
        }
    }

    //파란 블록의 수직으로 제거할 열이 있는 지 확인 후 점수 계산
    public static void blueLineCheck(){
        for(int i=5;i>=0;i--){
            int flag = 1;
            for(int j=0;j<4;j++){
                flag *= blueArea[j][i];
            }
            if(flag == 1){
                score++;

                blueArrange(i);

                i++; //밀린 열을 재검사 하기 위한 ++
            }
        }
    }

    //초록 블록의 수평으로 제거할 행이 있는 지 확인 후 점수 계산
    public static void greenLineCheck(){
        for(int i=5;i>=0;i--){
            int flag = 1;
            for(int j=0;j<4;j++){
                flag *= greenArea[i][j];
            }
            if(flag == 1){
                score++;

                greenArrange(i);

                i++; //밀린 행을 재검사 하기 위한 ++
            }
        }
    }

    //파란 블록의 연한 부분 체크(1열만 체크)
    public static void blueLightColorCheck(){
        for(int i=0;i<4;i++){
            if(blueArea[i][1] != 0){
                blueArrange(5);
                break;
            }
        }
    }

    //초록 블록의 연한 부분만 체크(1행만 체크)
    public static void greenLightColorCheck(){
        for(int i=0;i<4;i++){
            if(greenArea[1][i] != 0){
                greenArrange(5);
                break;
            }
        }
    }

    //파란 블록의 열이 제거되었을 경우 한 칸씩 당겨오는 정리 작업
    public static void blueArrange(int y){
        for(int i=0;i<4;i++){
            blueArea[i][y] = 0;
        }

        for(int j=y;j>=1;j--){
            for(int k=0;k<4;k++){
                blueArea[k][j] = blueArea[k][j-1];
            }
        }

        for(int i=0;i<4;i++){
            blueArea[i][0] = 0;
        }
    }

    //초록 블록의 행이 제거되었을 경우 한 칸씩 당겨오는 정리 작업
    public static void greenArrange(int x) {
        for (int i = 0; i < 4; i++) {
            greenArea[x][i] = 0;
        }

        for (int j = x; j >= 1; j--) {
            for (int k = 0; k < 4; k++) {
                greenArea[j][k] = greenArea[j - 1][k];
            }
        }

        for (int i = 0; i < 4; i++) {
            greenArea[0][i] = 0;
        }
    }

    //2차원 배열의 0이 아닌 개수를 가져오는 함수
    public static long getCount(int [][] area){
        return Arrays.stream(area)
                .flatMapToInt(Arrays::stream)
                .filter(value -> value != 0)
                .count();
    }
}
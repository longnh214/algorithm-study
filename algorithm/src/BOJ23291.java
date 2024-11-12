/**
 * @author nakhoonchoi
 * @date 2024/11/13
 * @see https://boj.ma/23291
 * @mem 31,708kb
 * @time 216ms
 * @caution
 * [고려사항]
 * 삼성 기출 문제 치고 친절하지 않았다.
 *
 * 어항 1차원 배열의 최댓값, 최솟값의 차이가 K 이하가 될 때까지 로직을 몇 번 수행하면 되는지 생각해야하는 문제였다.
 * 필요한 로직은 총 5개였다.
 *
 * 1. 1차원 어항 배열 중 최솟값에 해당 하는 어항에 물고기의 수를 1씩 더해주는 로직
 * 2. 1차원 어항을 달팽이 모양으로 90도로 굴린다.(문제에서는 위로 쌓았지만, 본인은 배열의 방향대로 아래로 굴렸다.)
 * 3. 2차원 어항 배열 기준으로 4방향으로 어항 물고기 수 정리
 * 4. 2차원 어항 배열을 1차원 어항 배열로 변환
 * 5. 1차원 어항 배열을 N/2 만큼 반반 나눠서 접고, 포갠 다음, 또 반을 나눠서 180도로 굴리며 쌓는다. 2번 로직 변형
 *
 * 배열 돌리기의 상위 호환 문제로 배열의 인덱스를 중요하게 생각해야했던 문제이다.
 * 2차원 어항 배열을 굴릴 때 기존 배열 내에서 회전하거나 접은 게 아니라
 * temp 배열에 회전이나 접은 이후의 상태를 저장하고 aquariumMatrix에 반영해주는 식으로 구현했다.
 *
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <삼성기출/구현> '어항 정리'

public class BOJ23291 {
    static int N, K;
    static int [] aquarium; //어항 1차원 배열
    static int [][] aquariumMatrix; //어항을 회전 및 접기위한 2차원 어항 배열
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        aquarium = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            aquarium[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        while(true){
            int max = Arrays.stream(aquarium).max().getAsInt();
            int min = Arrays.stream(aquarium).min().getAsInt();
            if(max - min <= K) {
                break;
            }

            minFishPlus1();

            aquariumMatrix = new int[N][N];

            spinAquarium1();

            arrangeFish();

            setFlatAquarium();

            aquariumMatrix = new int[N][N];

            flipAndSpinAquarium();

            arrangeFish();

            setFlatAquarium();

            answer++;
        }

        System.out.println(answer);
    }

    public static void minFishPlus1(){
        int min = Arrays.stream(aquarium).min().getAsInt();

        for(int i=0;i<N;i++){
            if(aquarium[i] == min){
                aquarium[i]++;
            }
        }
    }

    public static void spinAquarium1(){
        for(int i=0;i<N;i++){
            aquariumMatrix[0][i] = aquarium[i];
        }

        //처음 눕힐 때,
        aquariumMatrix[1][0] = aquariumMatrix[0][0];
        for(int i=0;i<N-1;i++){
            aquariumMatrix[0][i] = aquariumMatrix[0][i+1];
        }
        aquariumMatrix[0][N-1] = 0;

        //반복문
        while(true) {
            int[][] temp = new int[N][N];
            int cols = 0; //회전 대상 열
            int rows = 0;
            for (int i = 0; i < N; i++) {
                int height = 0;
                for (int j = 0; j < N; j++) {
                    if (aquariumMatrix[j][i] <= 0) {
                        break;
                    }
                    height++;
                }
                if (height >= 2) {
                    cols++;
                    rows = height;
                } else {
                    break;
                }
            }

            for (int i=0;i<N-cols;i++) {
                temp[0][i] = aquariumMatrix[0][i + cols];
            }
            for (int row=0;row<rows;row++) {
                for (int col=0;col<cols;col++) {
                    temp[cols - col][row] = aquariumMatrix[row][col];
                }
            }

            if(calcColLen(temp,0) >= calcColLen(temp,1)) {
                aquariumMatrix = temp;
            }else{
                break;
            }
            //반복문 종료(종료 조건 체크해야할듯)
        }
    }
    
    public static void arrangeFish(){
        int [][] temp = new int[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(aquariumMatrix[i][j] == 0){
                    break;
                }else{
                    for(int k=0;k<4;k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(isIn(nx, ny) && aquariumMatrix[nx][ny] != 0 && aquariumMatrix[i][j] >= aquariumMatrix[nx][ny] + 5){
                            int d = Math.abs(aquariumMatrix[i][j] - aquariumMatrix[nx][ny]) / 5;
                            temp[i][j] -= d;
                            temp[nx][ny] += d;
                        }
                    }
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                aquariumMatrix[i][j] += temp[i][j];
            }
        }
    }

    public static void setFlatAquarium(){
        int index = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(aquariumMatrix[j][i] == 0) {
                    break;
                }
                aquarium[index++] = aquariumMatrix[j][i];
            }
        }
    }

    public static void flipAndSpinAquarium(){
        for(int i=0;i<N;i++){
            aquariumMatrix[0][i] = aquarium[i];
        }

        int [][] temp = new int[N][N];

        for (int i = 0; i < N/2; i++) {
            temp[0][i] = aquariumMatrix[0][i + N/2];
        }

        for(int i=0;i<N/2;i++){
            temp[1][i] = aquariumMatrix[0][N/2 - 1 - i];
        }

        aquariumMatrix = temp;

        temp = new int[N][N];

        for(int i=0;i<2;i++){ // 주의 해야할 점. 2로 고정된다.
            for(int j=0;j<N/4;j++){
                temp[i][j] = aquariumMatrix[i][j + N/4];
            }
        }

        for(int i=0;i<2;i++){ // 주의 해야할 점. 2로 고정된다.
            for(int j=0;j<N/4;j++){
                temp[3 - i][N/4 - j - 1] = aquariumMatrix[i][j];
            }
        }

        aquariumMatrix = temp;
    }

    public static boolean isIn(int x, int y){
        return x>=0 && x<N && y>=0 && y<N;
    }

    public static int calcColLen(int [][] temp, int row){
        int count = 0;
        for(int i=0;i<N;i++){
            if(temp[row][i] <= 0){
                break;
            }else{
                count++;
            }
        }
        return count;
    }
}
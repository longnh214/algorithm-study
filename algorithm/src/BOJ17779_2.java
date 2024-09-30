/**
 * @author nakhoonchoi
 * @date 2024/10/01
 * @see https://www.acmicpc.net/problem/17779
 * @mem 19,284kb
 * @time 388ms
 * @caution
 * [고려사항]
 * 마름모의 좌표를 x,y,d1,d2에 대해서 시계 방향대로(x, y), (x+d2, y+d2), (x+d1+d2, y-d1+d2), (x+d1, y-d1)
 * 로 생각했다.
 * 4중 for문을 순회하면서 마름모의 꼭지점이 모두 좌표 안에 들어오는 x,y,d1,d2에 대해서 인구 수 계산을 진행하였다.
 *
 * 이전에는 1,2,3,4번을 정하고 그 뒤에 남은 칸을 5번으로 하려고 했는데
 * 수정해서 각 배열 칸을 구역으로 나눌 때 먼저 5번 선거구의 위치를 정하고 1,2,3,4번 선거구의 위치를 덮었고, 이 방법이 확실했다.
 *
 * 2중 for문을 이용해서 1,2,3,4번 선거구의 위치를 판별했는데, 이미 5번 선거구로 칠해있으면 break 했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <삼성기출/구현> '게리맨더링 2'

public class BOJ17779_2 {
    static int [][] populations;
    static int N;
    static int answer;
    static int [][] area;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        populations = new int[N][N];
        area = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                populations[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MAX_VALUE;

        for(int x=0;x<N;x++){
            for(int y=0;y<N;y++){
                for(int d1=1;d1<N;d1++){
                    for(int d2=1;d2<N;d2++){
                        if(isIn(x+d1, y-d1) && isIn(x+d2, y+d2) && isIn(x+d1+d2, y+d2-d1)) {
                            func(x, y, d1, d2);
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static void func(int x, int y, int d1, int d2){
        int [] score = new int[5];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        init();

        //5번 선거구
        for(int i=0;i<=d1;i++) {
            area[x+i][y-i] = 5;
        }
        for(int i=0;i<=d2;i++) {
            area[x+i][y+i] = 5;
        }
        for(int i=0;i<=d2;i++) {
            area[x+d1+i][y-d1+i] = 5;
        }
        for(int i=0;i<=d1;i++) {
            area[x+d2+i][y+d2-i] = 5;
        }

        //1번 선거구
        for(int i=0;i<x+d1;i++){
            for(int j=0;j<=y;j++){
                if(area[i][j] == 5)
                    break;
                area[i][j] = 1;
            }
        }

        //2번 선거구
        for(int i=x+d2;i>=0;i--) {
            for(int j=N-1;j>y;j--) {
                if(area[i][j] == 5)
                    break;
                area[i][j] = 2;
            }
        }

        //3번 선거구
        for(int i=x+d1;i<N;i++) {
            for(int j=0;j<y-d1+d2;j++) {
                if(area[i][j] == 5)
                    break;
                area[i][j] = 3;
            }
        }

        //4번 선거구
        for(int i=N-1;i>x+d2;i--) {
            for(int j=N-1;j>=y-d1+d2;j--) {
                if(area[i][j] == 5)
                    break;
                area[i][j] = 4;
            }
        }

        //선거구 별 인구 계산
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(area[i][j] == 0)
                    area[i][j] = 5;
                score[area[i][j] - 1] += populations[i][j];
            }
        }

        for(int i=0;i<score.length;i++){
            min = Math.min(min, score[i]);
            max = Math.max(max, score[i]);
        }

        answer = Math.min(answer, max - min);
    }

    public static void init(){
        for(int i=0;i<N;i++){
            Arrays.fill(area[i], 0);
        }
    }

    public static boolean isIn(int x, int y){
        return x>=0 && x<N && y>=0 && y<N;
    }
}
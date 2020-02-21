import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14891 {
    static int [][] wheel = new int[4][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //톱니바퀴 상황 입력
        for(int i=0;i<4;i++){
            //String으로 받고 charAt()을 이용한 숫자 입력
            //숫자 2차원 배열
            String s = br.readLine();
            for(int j=0;j<8;j++){
                wheel[i][j] = s.charAt(j) - '0';
            }
        }
        //회전 정보 입력
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken()); //기준
            int dir = Integer.parseInt(st.nextToken()); //회전 방향
            solution(index-1,dir);
        }

        //점수 계산
        int score = 0;
        for(int i=0;i<4;i++){
            score += wheel[i][0] * (1 << i);
        }
        System.out.println(score);
    }

    static void solution(int index, int dir){
        left(index-1,-dir);
        right(index+1,-dir);
        rotate(index,dir);
    }

    //기준에서 왼쪽 톱니바퀴 회전
    static void left(int index, int dir){
        if(index < 0)
            return;

        if(wheel[index][2] != wheel[index+1][6]) {
            left(index-1, -dir);
            rotate(index, dir);
        }
    }

    //기준에서 오른쪽 톱니바퀴 회전
    static void right(int index, int dir){
        if(index > 3)
            return;
        if(wheel[index][6] != wheel[index-1][2]) {
            right(index+1, -dir);
            rotate(index, dir);
        }
    }

    static void rotate(int index, int dir){
        //시계방향
        if(dir == 1){
            int temp = wheel[index][7];

            for(int i=7;i>0;i--)
                wheel[index][i] = wheel[index][i-1];
            wheel[index][0] = temp;
        }
        //반시계방향
        else{
            int temp = wheel[index][0];

            for(int i=0;i<7;i++)
                wheel[index][i] = wheel[index][i+1];
            wheel[index][7] = temp;
        }
    }
}
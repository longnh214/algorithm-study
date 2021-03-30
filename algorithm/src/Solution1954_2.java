/**
 * @author choi
 * @date Jul 28, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq&categoryId=AV5PobmqAPoDFAUq&categoryType=CODE
 * @mem 20,276kb
 * @time 126ms
 * @caution
 * [고려사항] 배열의 인덱스를 조심해서 작성해야한다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//SW Expert 1954번 <D2> - '달팽이 숫자'
public class Solution1954_2 {
    static int [][] arr;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            int num = 1;
            int row = 0;
            int col = 0;
            int round = 0;
            if(N==1) {
                arr[row][col] = num;
            }
            //N이 홀수일 때.
            else if(N%2 == 1) {
                arr[row][col] = num++;
                for(int i=N;i>=1;i-=2) {
                    //오른쪽 방향
                    for(int j=col+1;j<N-round;j++) {
                        arr[row][j] = num++;
                        col = j;
                    }
                    //아랫 방향
                    for(int j=row+1;j<N-round;j++) {
                        arr[j][col] = num++;
                        row = j;
                    }
                    //왼쪽 방향
                    for(int j=col-1;j>=round;j--) {
                        arr[row][j] = num++;
                        col = j;
                    }
                    //윗쪽 방향
                    for(int j=row-1;j>round;j--) {
                        arr[j][col] = num++;
                        row = j;
                    }
                    //반복문 빠져나오는 조건문
                    if(N/2 == row) {

                        arr[row][col+1] = num++;
                        break;
                    }
                    //한바퀴 돌았음을 표시
                    round++;
                }
            }
            //N이 짝수일 때.
            else {
                arr[row][col] = num++;
                for(int i=N;i>=1;i-=2) {
                    //오른쪽 방향
                    for(int j=col+1;j<N-round;j++) {
                        arr[row][j] = num++;
                        col = j;
                    }
                    //아랫쪽 방향
                    for(int j=row+1;j<N-round;j++) {
                        arr[j][col] = num++;
                        row = j;
                    }
                    //반복문 빠져나오는 조건문
                    if(N/2 == col) {
                        arr[row][col-1] = num++;
                        break;
                    }
                    //왼쪽 방향
                    for(int j=col-1;j>=round;j--) {
                        arr[row][j] = num++;
                        col = j;
                    }
                    //윗쪽 방향
                    for(int j=row-1;j>round;j--) {
                        arr[j][col] = num++;
                        row = j;
                    }
                    //한바퀴 돌았음을 표시.
                    round++;
                }
            }
            //출력문
            System.out.println("#"+t);
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    System.out.printf("%d ",arr[i][j]);
                }
                System.out.println();
            }
        }
    }
}

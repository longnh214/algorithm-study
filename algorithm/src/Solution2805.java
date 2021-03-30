/**
 * @author choi
 * @date 2020. 7. 29
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB
 * @mem 21,408kb
 * @time 124 ms
 * @caution
 * [고려사항] 합해야하는 부분 열 인덱스에 주의해야한다. 13531, 1357531 등등
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//SW expert <D3> - '농작물 수확하기'
public class Solution2805 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int [][] map;
        int sum;
        for(int t=1;t<=T;t++) {
            sum = 0;
            int N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for(int i=0;i<N;i++) {
                String str = br.readLine();
                for(int j=0;j<N;j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }
            //만약 N이 1이면 바로 끝내버리기.
            if(N==1) {
                sum+=map[N-1][N-1];
                System.out.println("#" + t + " " + sum);
                continue;
            }
            //N이 1이 아니라면
            else {
                //여기에 규칙을 만들자.
                for(int i=0;i<N/2;i++) {
                    //점점 늘어나는 부분(중간 직전 열)까지의 합
                    for(int j=N/2-i;j<=i+N/2;j++) {
                        sum+=map[i][j];
                    }

                }
                //절반 부분 전부 합
                for(int i=0;i<N;i++) {
                    sum+=map[N/2][i];
                }
                for(int i=N/2+1;i<N;i++) {
                    //점점 줄어드는 부분(중간 이후 열) 합
                    for(int j=i-N/2;j<=(N-i-1) + N/2;j++) {
                        sum+=map[i][j];
                    }
                }
            }
            System.out.println("#"+t +" " +sum);
        }
    }
}
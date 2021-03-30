/**
 * @author choi
 * @date Jul 28, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh
 * @mem 31,156kb
 * @time 148ms
 * @caution
 * [고려사항] 배열의 범위, 진행 방향을 고려해야한다.
 * [입력사항]
 * [출력사항]
 */
//SW Expert 1210번 <D4> - 'ladder1'
import java.io.*;
import java.util.*;
public class Solution1210 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static int answer;
    public static void main(String[] args) throws IOException{
        for(int t=1;t<=10;t++) {
            int [][] map = new int[100][100];
            sb = new StringBuilder();
            //한 줄은 필요 없음.
            br.readLine();
            for(int i=0;i<100;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<100;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int endIndex = 100;

            for(int i=0;i<100;i++) {
                if(map[99][i] == 2) {
                    endIndex = i;
                    break;
                }
            }
            //System.out.println(endIndex);

            //현재 좌표를 설정.
            int j = 99;
            int i = endIndex;

            //System.out.println(map[99][i]);

            //맨처음 기본은 무조건 위로 올라가는 거로.
            int direction = 0;
            while(j>0) {
                if(j==0) break;
                    //위 방향이였다면.
                else if(direction == 0) {
                    //왼쪽에 길이 있다면.
                    if(i>0 && map[j][i-1] > 0) {
                        direction = 1;
                        i--;
                    }
                    //오른쪽에 길이 있다면.
                    else if(i<99 && map[j][i+1] > 0) {
                        direction = 2;
                        i++;
                        //continue;
                    }
                    //길이 없다면 j--
                    else {
                        j--;
                    }
                }
                //왼쪽 방향이였다면.
                else if(direction == 1){

                    if(j>0 && map[j-1][i] > 0) {
                        direction = 0;
                        j--;
                    }
                    //진행 방향에 변화가 없다.
                    else {
                        i--;
                    }
                }
                //오른쪽 방향이였다면.
                else if(direction == 2){
                    if(j>0 && map[j-1][i] > 0) {
                        direction = 0;
                        j--;
                    }
                    //진행 방향에 변화가 없다.
                    else {
                        i++;
                    }
                }
            }
            answer = i;
            sb.append("#").append(t).append(" ").append(answer);
            System.out.println(sb.toString());
        }
    }

}

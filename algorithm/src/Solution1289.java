/**
 * @author choi
 * @date 2020. 7. 29
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV19AcoKI9sCFAZN&categoryId=AV19AcoKI9sCFAZN&categoryType=CODE
 * @mem 18,464 kb
 * @time 112 ms
 * @caution
 * [고려사항] 일정 기준 point를 두고 그 값과 다른 값이 나올 때마다 cnt를 올리면서 point를 갱신하면 되는 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//SW expert 1289번 <D2> - '원재의 메모리 복구하기'
public class Solution1289 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        char point;
        int cnt;
        for(int t=1;t<=T;t++) {
            String str = br.readLine();
            point = '0';
            cnt = 0;
            //point와 문자가 다르면 cnt++
            for (int i = 0; i < str.length(); i++) {
                if(point != str.charAt(i)) {
                    cnt++;
                    point = str.charAt(i);
                }
            }
            System.out.println("#"+ t + " " + cnt);
        }
    }
}
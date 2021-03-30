/**
 * @author choi
 * @date 2020. 7. 29
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXMCXV_qVgkDFAWv&categoryId=AXMCXV_qVgkDFAWv&categoryType=CODE
 * @mem 20,376kb
 * @time 144ms
 * @caution
 * [고려사항] 삼항 연산자를 이용하면 간단하게 풀 수 있다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//SW expert 10200번 <D3> - '구독자 전쟁'
public class Solution10200 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int max = (A<B) ? A : B;
            int min = (A+B)>N ? A+B-N : 0;

            System.out.println("#"+ t + " " + max + " " + min);
        }
    }
}
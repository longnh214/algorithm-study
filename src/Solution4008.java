/**
 * @author choi
 * @date Dec 3, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeRZV6kBUDFAVH
 * @mem 21,128kb
 * @time 151ms
 * @caution
 * [고려사항]
 * 연산자 배열을 만들어서 순열을 하는 것이 아니라 연산자 개수 배열에서 빼고 더하면서 순열(dfs)을 했더니 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//SW Expert <SW 역량테스트> '숫자 만들기'
public class Solution4008 {
    static int N,max,min;
    static int [] num;
    static int [] oper;
    static int [] temp;
    static char [] standard = {'+','-','*','/'};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t=1;t<=T;t++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            N = Integer.parseInt(br.readLine());

            num = new int[N];
            oper = new int[4];
            temp = new int[N-1];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<4;i++) {
                oper[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            perm(0);

            System.out.println("#"+ t +" " + (max - min));
        }

    }


    public static void perm(int cnt) {
        if(cnt == N-1) {
            //여기서 계산
            int output = num[0];
            for(int i=0;i<N-1;i++) {
                switch(temp[i]) {
                    case 0 :
                        output += num[i+1];
                        break;
                    case 1 :
                        output -= num[i+1];
                        break;
                    case 2 :
                        output *= num[i+1];
                        break;
                    case 3 :
                        output /= num[i+1];
                        break;
                }
            }

            max = Math.max(max, output);
            min = Math.min(min, output);
            return;
        }

        for(int i=0;i<4;i++) {
            if(oper[i] > 0) {
                temp[cnt] = i;
                oper[i]--;
                perm(cnt+1);
                oper[i]++;
                temp[cnt] = -1;
            }
        }
    }
}
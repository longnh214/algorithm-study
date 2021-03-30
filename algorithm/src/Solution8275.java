/**
 * @author choi
 * @date Dec 3, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWxQ310aOlQDFAWL
 * @mem 20,888kb
 * @time 584ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//SW Expert <D4> '햄스터'
public class Solution8275 {
    static int N,X,M,sum,answerSum;
    static int [] num,answer;
    static int [][] oper;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t=1;t<=T;t++) {
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            num = new int[N];
            answer = new int[N];
            oper = new int[M][3];
            answerSum = Integer.MIN_VALUE;
            answer[0] = -1;

            for(int i=0;i<M;i++) {
                st = new StringTokenizer(br.readLine());
                oper[i][0] = Integer.parseInt(st.nextToken())-1;
                oper[i][1] = Integer.parseInt(st.nextToken())-1;
                oper[i][2] = Integer.parseInt(st.nextToken());
            }

            dfs(0);

            sb.append("#").append(t).append(" ");
            if(answer[0] == -1) {
                sb.append(-1).append(" ");
            }else {
                for(int temp : answer) {
                    sb.append(temp).append(" ");
                }
            }
            System.out.println(sb.substring(0, sb.length()-1));
        }
    }

    public static boolean isOk(int index) {
        int sum = 0;
        for(int i=oper[index][0];i<=oper[index][1];i++) {
            sum += num[i];
        }

        if(sum == oper[index][2])
            return true;
        else
            return false;
    }

    public static void dfs(int cnt) {
        if(cnt==N) {
            for (int i = 0; i < M; i++) {
                if(!isOk(i)) {
                    return;
                }
            }

//          햄스터 갯수 만족할 때,
            sum=0;
            for (int i = 0; i < N; i++) {
                sum+=num[i];
            }
            if(answerSum < sum) {
                answerSum = sum;
                answer = Arrays.copyOf(num, N);
            }
            return;
        }

        for (int i = 0; i <= X; i++) {
            num[cnt]=i;
            dfs(cnt+1);
        }
    }
}
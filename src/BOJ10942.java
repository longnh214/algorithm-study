import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;;
import java.util.StringTokenizer;

//팰린드롬 연습문제(시간 초과) !?!?!?
public class BOJ10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());//문제 배열의 크기
        int [] question = new int[n+1];
        int [][] palindrome = new int[n+1][n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            question[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=n;i++){//혼자 있는 수는 무조건 팰린드롬 성립
            palindrome[i][i] = 1;
        }

        for(int i=1;i<n;i++){//연속 된 두자리 수는 팰린드롬 성립
            if(question[i] == question[i+1])
                palindrome[i][i+1] = palindrome[i+1][i] = 1;
        }

        for(int i=2;i<n;i++){//두자리 수 이상 팰린드롬 판별할 때
            for(int j=1;j<=n-i;j++){
                if(question[j] == question[j+i] && palindrome[j+1][j+i-1] == 1)
                    palindrome[j][j+i] = 1;
            }
        }

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            System.out.println(palindrome[s][t]);
        }
    }
}

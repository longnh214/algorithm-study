import java.util.Scanner;

//팰린드롬 연습문제
public class BOJ10942 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();//문제 배열의 크기
        int [] question = new int[n+1];
        int [][] palindrome = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            question[i] = scan.nextInt();
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

        int T = scan.nextInt();
        while(T-->0){
            //앞 scan(s), 뒷 scan(t)
            System.out.println(palindrome[scan.nextInt()][scan.nextInt()]);
        }
        scan.close();
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2602 {
    static char [] rings;
    static char [] devil;
    static char [] angel;
    static int [][][] dp = new int[100][20][2];//[지금 밟은 곳], [다음 밟을 곳], [악마의 돌다리인지, 천사의 돌다리인지]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        rings = new char[21];
        devil = new char[101];
        angel = new char[101];
        rings = br.readLine().toCharArray();
        devil = br.readLine().toCharArray();
        angel = br.readLine().toCharArray();

        //Arrays.fill(dp,-1); 이 방법은 1차원 배열 전용
        //3중 포문으로 초기화 시키는 방법
//        for (int i = 0; i < 100; i++) {
//            for (int j = 0; j < 20; j++) {
//                for (int k = 0; k < 2; k++) {
//                    dp[i][j][k] = -1;
//                }
//            }
//        }

        for(int [][] dp1 : dp){
            for(int [] dp2 : dp1)
                Arrays.fill(dp2, -1); //값을 -1로 초기화
        }


        int a = move(0,0,0);
        int b = move(0,0,1);

        System.out.println(a+b);
    }

    public static int move(int cur, int next, int dif){
        if(next == rings.length)//다음 밟을 곳이 없으면
            return 1;
        if(dp[cur][next][dif] > -1)
            return dp[cur][next][dif];

        int ans = 0;//가능한 갯수 저장하는 변수
        if(dif == 0){//전에 밟은 곳이 악마의 돌다리인 경우
            for(int i=cur;i<devil.length;i++){
                if(rings[next] == devil[i])
                    ans += move(i+1,next+1,1);//다음은 천사의 돌다리여야한다.
            }
        }else{//전에 밟은 곳이 천사의 돌다리인 경우
            for(int i=cur;i<angel.length;i++){
                if(rings[next] == angel[i])
                    ans += move(i+1,next+1,0);
            }
        }
        return dp[cur][next][dif] = ans;//dp에 경우의 수를 저장해서 return
    }
}

import java.util.Scanner;

public class BOJ14501 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int [] t = new int[size];//상담일수
        int [] p = new int[size+10];//상담비용(상담 일수에 따라 배열 인덱스 초과날 수 있으므로 여유있게)
        int [] dp = new int[size+10];//최대 상담 비용을 저장하는 dp 배열
        for(int i=0;i<size;i++){
            t[i] = scan.nextInt();
            p[i] = scan.nextInt();
            //dp 값에 기존의 dp 값, 새로 계산된 최대 상담 비용 중 최대 값을 저장한다.(갱신)
            dp[t[i]+i] = Math.max(p[i]+dp[i],dp[t[i]+i]);
        }
        System.out.println(dp[size-1]);
        scan.close();
    }
}

import java.util.Scanner;

public class BOJ14501 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int [] t = new int[size];//상담일수
        int [] p = new int[size+10];//상담비용(상담 일수에 따라 배열 인덱스 초과날 수 있으므로 여유있게)
        int [] dp = new int[size+10];//최대 상담 비용을 저장하는 dp 배열
        int max = 0;
        for(int i=0;i<size;i++){
            t[i] = scan.nextInt();
            p[i] = scan.nextInt();
        }
        for(int i=0;i<=size;i++){
            //이전까지의 최대 수입을 비교해서 최대 수입을 현재에도 저장해준다.
            //이전에 최대 수입이 나왔을 수 있으므로
            //ex) 3,7 (5 예상) 이라고 하면 5의 값은 7로 바꿔주는게 최대 수입을 얻는 데에 맞는 방법이다.
            dp[i] = Math.max(dp[i],max);
            //dp 값에 기존의 dp 값, 새로 계산된 최대 상담 비용 중 최대 값을 저장한다.(갱신)
            dp[t[i]+i] = Math.max(p[i]+dp[i],dp[t[i]+i]);
            //출력될 최대 수입
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
        scan.close();
    }
}
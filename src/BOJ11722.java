import java.util.Scanner;

public class BOJ11722 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size;
        int [] arr;//문제 배열
        int [] dp;//수열의 길이를 세기 위한 배열
        int max = 0; //수열의 길이 최대값
        size = scan.nextInt();
        arr = new int[size];
        dp = new int[size];
        dp[0] = 1;
        for(int i=0;i<size;i++){
            arr[i] = scan.nextInt();
        }
        for(int i=1;i<size;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++) {
                if (arr[i] < arr[j] && dp[i] <= dp[j])//배열 전 칸보다 다음 칸이 작고, dp 값이 보다 같거나 크면
                    dp[i] = dp[j] + 1;//수열의 count를 올린다.
                else if(arr[i]==arr[j])//위 조건에 안 맞고, 배열 값이 서로 같으면
                    dp[i] = dp[j];//수열의 count를 그 전값에 복사한다.(가장 긴 수열의 값에 변화가 없다.)
            }
        }
        for(int i=0;i<size;i++){
            max = Math.max(dp[i],max);//Math.max(배열값,최대값);
        }
        System.out.format("%d\n",max);
        scan.close();
    }
}

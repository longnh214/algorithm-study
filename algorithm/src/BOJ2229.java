import java.util.Scanner;

public class BOJ2229 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();//배열의 크기
        int [] arr = new int[size+1];//성적 입력 받는 배열
        int [] dp = new int[size+1];//입력 받을 때마다 최대값을 저장하는 배열

        for(int i=1;i<=size;i++){//입력 받을 때마다 최대값 계산
            int max = 0, min = 999999;//max, min 값 초기화
            arr[i] = scan.nextInt();
            for(int j=i;j>0;j--){
                max = Math.max(arr[j],max);
                min = Math.min(arr[j],min);
                dp[i] = Math.max(max - min + dp[j-1],dp[i]);
            }
        }
        System.out.println(dp[size]);
        scan.close();
    }
}
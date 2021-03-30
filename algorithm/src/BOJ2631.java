import java.util.Scanner;

public class BOJ2631 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int [] arr = new int[size];
        int [] dp = new int[size];
        int max = 0;
        for(int i=0;i<size;i++){
            arr[i] = scan.nextInt();
        }

        //LIS 알고리즘을 통해 부분, 연속적으로 증가하는 수의 모임을 찾는다.
        //그 모임에 포함 되지 않는 수들이 자리를 옮겨야 하는 수
        dp[0] = 1;
        for(int i=1;i<size;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++) {
                if (arr[j] < arr[i] && dp[i] <= dp[j])//배열 전 칸보다 다음 칸이 크고, dp 값이 보다 같거나 크면(모임에 포함이 되면)
                    dp[i] = dp[j] + 1;//수열의 count를 올린다.(자리를 바꿔도 되지 않는 수임을 표시)
                else if(arr[i]==arr[j])//위 조건에 안 맞고, 배열 값이 서로 같으면
                    dp[i] = dp[j];//수열의 count를 그 전값에 복사한다.(자리를 바꿔야 하는 수이므로 count하지 않는다.)
            }
        }

        //제자리에 있어도 되는 수 계산
        for(int i=1;i<size;i++){
            max = Math.max(dp[i],max);//Math.max(배열값,최대값); dp[i]의 최대값 구하기
        }

        //배열 전체 크기 - 제자리에 있어도 되는 수 = 자리를 옮겨야 하는 수
        System.out.format("%d\n",size-max);
    }
}

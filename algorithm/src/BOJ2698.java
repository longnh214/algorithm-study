import java.util.Scanner;

public class BOJ2698 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T, n, k; //테스트케이스, n, k
        int [][][]arr = new int[105][105][2]; //[길이][인접한 비트 수][끝자리 수]
        arr[1][0][0] = 1; // 비트 수 : 1, 끝자리 수 0
        arr[1][0][1] = 1; // 비트 수 : 1, 끝자리 수 1

        for(int i=2;i<105;i++){
            for(int j=0;j<i;j++){
                arr[i][j][0] = arr[i-1][j][0] + arr[i-1][j][1];
                arr[i][j][1] = arr[i-1][j][0] + ((j>0) ? arr[i-1][j-1][1] : 0);
            }
        }

        T = scan.nextInt();
        for(int t=0;t<T;t++){
            System.out.format("%d ",t);
            n = scan.nextInt();
            k = scan.nextInt();
            System.out.println(arr[n][k][0] + arr[n][k][1]);
        }
        scan.close();
    }
}

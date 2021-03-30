import java.util.Arrays;
import java.util.Scanner;

public class Solution1966 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int [] num;

        for (int t = 1; t <= T; t++) {
            num = new int[scan.nextInt()];
            for(int i=0;i<num.length;i++){
                num[i] = scan.nextInt();
            }

            Arrays.sort(num);


            System.out.format("#%d ", t);
            for(int i=0;i<num.length;i++)
                System.out.printf("%d ",num[i]);
            System.out.println();
        }
        scan.close();
    }
}

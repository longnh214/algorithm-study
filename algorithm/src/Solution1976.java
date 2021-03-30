import java.util.Scanner;

public class Solution1976 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int hour1, hour2, hourSum;
        int min1, min2, minSum;
        for (int t = 1; t <= T; t++) {
            hour1 = scan.nextInt();
            min1 = scan.nextInt();
            hour2 = scan.nextInt();
            min2 = scan.nextInt();
            hourSum = hour1 + hour2;
            minSum = min1 + min2;
            if (hourSum > 12) {
                hourSum -= 12;
            }
            if (minSum > 60) {
                minSum -= 60;
                hourSum++;
            }
            System.out.format("#%d %d %d\n",t, hourSum, minSum);
        }
    }
}

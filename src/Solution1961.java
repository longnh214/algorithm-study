import java.util.Scanner;


public class Solution1961 {

    static int[][] rotate(int num[][]) {
        int i, j, n = num.length;
        int[][] output = new int[n][n];

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                output[j][n - i - 1] = num[i][j];
            }
        }

        return output;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int[][] num;

        int[][] once;
        int[][] twice;
        int[][] triple;

        for (int t = 1; t <= T; t++) {
            int n = scan.nextInt();
            num = new int[n][n];
            once = new int[n][n];
            twice = new int[n][n];
            triple = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    num[i][j] = scan.nextInt();
                }
            }

            once = rotate(num);
            twice = rotate(once);
            triple = rotate(twice);

            System.out.format("#%d\n", t);
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++)
                    System.out.print(once[j][i]);
                System.out.print(" ");
                for (int i = 0; i < n; i++)
                    System.out.print(twice[j][i]);
                System.out.print(" ");
                for (int i = 0; i < n; i++)
                    System.out.print(triple[j][i]);
                System.out.println();
            }
        }
        scan.close();
    }
}

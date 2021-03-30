import java.util.Scanner;

public class Solution1974 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int[][] sudoku;
        int check;
        int sum;
        for (int t = 1; t <= T; t++) {
            check = 1;
            sudoku = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = scan.nextInt();
                }
            }
            outerloop:
            for (int i = 0; i < 9; i++) {
                sum = 0;
                for (int j = 0; j < 9; j++) {
                    sum += sudoku[i][j];
                }
                if (sum == 45) continue;
                else {
                    check = 0;
                    break outerloop;
                }
            }
            outerloop:
            for (int i = 0; i < 9; i++) {
                sum = 0;
                for (int j = 0; j < 9; j++) {
                    sum += sudoku[j][i];
                }
                if (sum == 45) continue;
                else {
                    check = 0;
                    break outerloop;
                }
            }
            outerloop:
            for (int i = 2; i < 9; i += 3) {
                sum = 0;
                for (int j = 2; j < 9; j += 3) {
                    sum = sudoku[i - 2][j - 2] + sudoku[i - 1][j - 2] + sudoku[i][j - 2] + sudoku[i - 2][j - 1] + sudoku[i - 1][j - 1] + sudoku[i][j - 1] + sudoku[i - 2][j] + sudoku[i - 1][j] + sudoku[i][j];
                    if(sum != 45){
                        check = 0;
                        break outerloop;
                    }else continue;
                }

            }
            System.out.format("#%d %d\n", t, check);
        }
        scan.close();
    }
}

/**
 * @author choi
 * @date Sep 23, 2020
 * @see https://www.acmicpc.net/problem/2578
 * @mem 13,008kb
 * @time 96ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현> '빙고'
public class BOJ2578 {
    static int [][] bingo = new int[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0;i<5;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int index = 0;
        for(int i=0;i<5;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++) {
                index++;
                int qNum = Integer.parseInt(st.nextToken());
                check(qNum);
                if(bingoCount() >= 3) {
                    //System.out.println(bingoCount());
                    System.out.println(index);
                    return;
                }
            }
        }
    }

    public static void check(int num) {
        loop : for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++) {
                if(bingo[i][j] == num) {
                    bingo[i][j] = 0;
                    break loop;
                }
            }
        }
    }

    public static int bingoCount() {
        int count = 0;
        for(int i=0;i<5;i++) {
            if(horizonCheck(i))
                count++;
        }
        for(int i=0;i<5;i++) {
            if(verticalCheck(i))
                count++;
        }
        if(leftDiagonalCheck()) {
            count++;
        }
        if(rightDiagonalCheck()) {
            count++;
        }
        return count;
    }

    public static boolean horizonCheck(int row) {
        for(int i=0;i<5;i++) {
            if(bingo[row][i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean verticalCheck(int col) {
        for(int i=0;i<5;i++) {
            if(bingo[i][col] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean leftDiagonalCheck() {
        for(int i=0;i<5;i++) {
            if(bingo[i][i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean rightDiagonalCheck() {
        for(int i=0;i<5;i++) {
            if(bingo[i][4-i] != 0) {
                return false;
            }
        }
        return true;
    }
}
/**
 * @author choi
 * @date Aug 16, 2020
 * @see https://www.acmicpc.net/problem/7682
 * @mem 12,940kb
 * @time 80ms
 * @caution
 * [고려사항] DFS/BFS로 문제를 접근하다가, 틱택토는 3*3 배열로 정해져 있는 것을 깨닫고
 * 		코드를 싹 다 갈아엎어 구현 문제로 접근했다.(절대 BFS/DFS 아님 주의)
 * [입력사항]
 * [출력사항]
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 백준 <구현> - '틱택토'
public class BOJ7682 {
    static char[][] game;
    static int countX, countO, countDot;
    static int answerX, answerO;
    static boolean isPossible;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while (true){
            game = new char[3][3];
            isPossible = true;
            countX = 0;
            countO = 0;
            countDot = 0;
            answerX = 0;
            answerO = 0;
            str = br.readLine();
            if(str.equals("end")) return;
            for (int k = 0; k < 9; k++) {
                int i = k / 3;
                int j = k % 3;
                char c = str.charAt(k);
                if(c == 'X') countX++;
                else if(c == 'O') countO++;
                else countDot++;
                game[i][j] = c;
            }
            //O의 개수는 X의 개수보다 많으면 안된다.
            if(countO > countX) isPossible = false;
            //O의 개수는 5개를 넘을 수 없다.
            if(countO >= 5) isPossible = false;
            //빈 곳은 4개 이상일 수 없다. 최대가 4개.(왜냐하면 X가 3으로 이기고, O이 2번 뒀을 때의 경우)
            if(countDot > 4) isPossible = false;
            //X와 O의 개수는 1개만 차이나거나, 두 개수가 같아야 한다.
            if(countX - countO > 1 || countX - countO < 0) isPossible = false;

            //위의 경우라면 전부 invalid이다.
            if(!isPossible) {
                System.out.println("invalid");
                continue;
            }

            answerX += checkRow(0, 'X');
            answerX += checkRow(1, 'X');
            answerX += checkRow(2, 'X');

            answerX += checkCol(0, 'X');
            answerX += checkCol(1, 'X');
            answerX += checkCol(2, 'X');

            answerX += checkLeftCross(0, 0, 'X');
            answerX += checkRightCross(0, 2, 'X');

            answerO += checkRow(0, 'O');
            answerO += checkRow(1, 'O');
            answerO += checkRow(2, 'O');

            answerO += checkCol(0, 'O');
            answerO += checkCol(1, 'O');
            answerO += checkCol(2, 'O');

            answerO += checkLeftCross(0, 0, 'O');
            answerO += checkRightCross(0, 2, 'O');

            //X의 개수가 많다면 X가 이겨야 한다.
            if(countX > countO) {
                if(answerO > 0) {
                    System.out.println("invalid");
                    continue;
                }
            }
            //X의 개수와 O의 개수가 같다면 O가 이겨야 한다.
            else if(countX == countO) {
                if(answerX > 0) {
                    System.out.println("invalid");
                    continue;
                }
            }
            //빙고가 전혀 생기지 않았다면
            if(answerX == 0 && answerO == 0) {
                //꽉 찬 경우이며, X가 5개, O가 4개여야 만 valid.
                if(countX != 5 || countO != 4) {
                    System.out.println("invalid");
                    continue;
                }
            }

            System.out.println("valid");
        }
    }
    //가로 방향이 정답일 경우.
    public static int checkRow(int i, char c) {
        if(game[i][0] == c && game[i][1] == c && game[i][2] == c) {
            return 1;
        }else return 0;
    }
    //세로 방향이 정답일 경우.
    public static int checkCol(int j, char c) {
        if(game[0][j] == c && game[1][j] == c && game[2][j] == c) {
            return 1;
        }else return 0;
    }
    //왼쪽에서 오른쪽 아래로 내려가는 대각선 방향.
    public static int checkLeftCross(int i, int j, char c) {
        if(game[i][j] == c && game[i+1][j+1] == c && game[i+2][j+2] == c) {
            return 1;
        }else return 0;
    }
    //오른쪽 위에서 왼쪽 아래로 내려가는 대각선 방향.
    public static int checkRightCross(int i, int j, char c) {
        if(game[i][j] == c && game[i+1][j-1] == c && game[i+2][j-2] == c) {
            return 1;
        }else return 0;
    }
}
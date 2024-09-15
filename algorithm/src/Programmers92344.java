/**
 * @author nakhoonchoi
 * @date 2024/09/15
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/92344
 * @caution
 * [고려사항]
 * 문제를 봤을 때, 사실 이리저리 계속 봐도 감이 잡히지 않는 문제였다.
 * 고민을 하다가 해답을 봤는데, 누적 합 문제였다는 것을 알았고, 누적 합에 대해 처음 알았다.
 * {n, 0, 0, -n}의 행렬을 우방향으로 누적합 하면 {n, n, n, 0}이 되는 신기한 일이 벌어지고,
 * 2차원으로 생각하면
 * {n, 0, 0, -n}
 * {0, 0, 0, 0}
 * {0, 0, 0, 0}
 * {-n, 0, 0, n}
 * 을 가로 방향으로 한 번, 세로 방향으로 한 번 누적합하면
 * {n, n, n, 0}
 * {n, n, n, 0}
 * {n, n, n, 0}
 * {0, 0, 0, 0}이 된다.
 *
 * 이를 통해 문제를 예상보다 단순하게(?) 해결할 수 있다.
 * 누적 합에 대한 문제를 더 찾아봐야겠다.
 * [입력사항]
 * [출력사항]
 */
//프로그래머스 <카카오 공채 2022> '파괴되지 않은 건물'

public class Programmers92344 {
    public static void main(String[] args) {
        int [][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int [][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};

        System.out.println(solution(board, skill));
    }

    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int [][] arr = new int[board.length][board[0].length];
        int N = board.length;
        int M = board[0].length;
        for(int i=0;i<skill.length;i++){
            int type = skill[i][0] == 1 ? -1 : 1;
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];


            arr[r1][c1] += type * degree;
            if(r2+1 < N && c2+1 < M) {
                arr[r2 + 1][c2 + 1] += type * degree;
            }
            if(c2+1 < M){
                arr[r1][c2+1] += (-1 * type * degree);
            }
            if(r2+1 < N) {
                arr[r2 + 1][c1] += (-1 * type * degree);
            }
        }

        for(int i=0;i<arr.length;i++){
            for(int j=1;j<arr[0].length;j++){
                arr[i][j] += arr[i][j-1];
            }
        }

        for(int i=0;i<arr[0].length;i++){
            for(int j=1;j<arr.length;j++){
                arr[j][i] += arr[j-1][i];
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j] += arr[i][j];
                if(board[i][j] > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
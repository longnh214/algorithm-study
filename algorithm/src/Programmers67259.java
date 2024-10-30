/**
 * @author nakhoonchoi
 * @date 2024/10/30
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/67259
 * @caution
 * [고려사항]
 * 정답률이 높은 문제라고 하는데... 나에게는 어려웠던 문제이다.
 * 먼저 방문 처리를 했어야하는데 visited 처리가 아닌 비용을
 * dp를 이용해 메모이제이션했다.
 * 계속 맞왜틀이 발생했는데, 이유는 (0,0)부터 시작한 것이 아니라
 * (0,1)이 비어있다면 100의 비용을 먼저 넣고 dfs((0,1), 100)을 하고,
 * 따로 (1,0)도 비어있다면 100의 비용을 먼저 넣고 dfs((1,0), 100)을 해줬다.
 * 하지만 조건식에 if(isIn(0,1) && board[0][1] == INF)에서 dfs를 진행한 뒤에,
 * if(isIn(1,0) && board[1][0] == INF)의 조건에서 board[1][0]이 INF에서
 * 값이 갱신되었을 수도 있다는 것을 간과했었다.
 *
 * 그리고 dp를 통해 가지치기를 하면서 기존 (dp값 + 500) < cost
 * 조건을 넣어주어, 꺾었을 때 더 효율적인 값이 나올 수 있음을 고려해야했다.
 *
 * dfs로 해결하였다. 다른 파일에서 bfs로도 해결해볼 것이다.
 * [입력사항]
 * [출력사항]
 */
//프로그래머스 <2020 카카오 인턴십> '경주로 건설'

public class Programmers67259 {
    static int N;
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, -1, 0, 1};
    static final int INF = Integer.MAX_VALUE - 10000;
    public static void main(String[] args) {
//        int [][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
//        int [][] board = {{0,0,0},{0,0,0},{0,0,0}};
        int [][] board = {{0,0,1,0},{0,0,0,0},{0,1,0,1}, {1,0,0,0}};

        System.out.println(solution(board));
    }

    public static int solution(int [][] board) {
        N = board.length;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(board[i][j] == 0){
                    board[i][j] = INF;
                }
            }
        }
        board[0][0] = 0;

        if(isIn(0, 1) && board[0][1] != 1){
            dfs(board, 3, 100, 0, 1);
        }
        if(isIn(1, 0) && board[0][1] != 1){
            dfs(board, 2, 100, 1, 0);
        }
        
        return board[N-1][N-1];
    }

    public static void dfs(int [][] board, int dir, int cost, int x, int y){
        if(!isIn(x, y) || board[x][y] == 1 || board[x][y] + 500 < cost){
            return;
        }

        board[x][y] = Math.min(board[x][y], cost);

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            dfs(board, i, (cost + ((dir != i) ? 600 : 100)), nx, ny);
        }
    }

    public static boolean isIn(int x, int y){
        return x>=0 && x<N && y>=0 && y<N;
    }
}
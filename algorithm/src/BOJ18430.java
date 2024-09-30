/**
 * @author nakhoonchoi
 * @date 2024/09/30
 * @see https://www.acmicpc.net/problem/18430
 * @mem 12,920kb
 * @time 124ms
 * @caution
 * [고려사항]
 * 2차원 배열을 2중 for문으로 순회하면서 부메랑을 체크해주는 방식으로 DFS를 진행했다.
 *
 * 재귀를 돌 때 base case와 recursive case를 세세하게 고려해주어야했다.
 * recursive case에 대해서는 분기처리를 한 번 해줘야했다.
 * 현재 좌표를 부메랑에 포함 시킬 건지, 안 시키고 다음 좌표를 탐색할 것인지
 * 그리고 마지막 좌표를 부메랑의 중심에 넣었는 지 안 넣었는 지
 *
 * 2중 for문으로 순회하면서 탐색했기 때문에
 * base case는 if(curX == N-1 && curY == M-1)(2차원 배열의 가장 오른쪽, 아래 마지막 좌표)일 때
 * 최대값을 비교하고 끝! 이라고 생각했지만
 * 이 좌표가 부메랑에 이미 포함되어있는 지, 아닌 지에 따라 경우의 수가 한 번 더 생길 수가 있었다.
 * 이 부분이 엣지 케이스였고, 예시에 없어서 한참 헤맸다.
 *
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <백트래킹> '무기 공학'

public class BOJ18430 {
    static int [][] map;
    static boolean [][] visited;
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, -1, 0, 1};
    static int N, M;
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        max = Integer.MIN_VALUE;

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        System.out.println(max);
    }

    public static void dfs(int curX, int curY, int curScore){
        //base case
        //마지막 좌표가 이미 부메랑에 포함되어있을 때에는 max 계산하고 return
        if(curX == N-1 && curY == M-1 && visited[curX][curY]){
            max = Math.max(max, curScore);
            return;
        }

        //마지막 좌표가 부메랑에 포함되지 않은 상태일 때 오는 base case
        if(curX > N-1 && curY == 0){
            max = Math.max(max, curScore);
            return;
        }
        //base case end

        if(!visited[curX][curY]){
            for(int i=0;i<4;i++){
                int nx1 = curX + dx[i];
                int ny1 = curY + dy[i];
                int nx2 = curX + dx[(i+1)%4];
                int ny2 = curY + dy[(i+1)%4];
                if(isIn(nx1, ny1) && isIn(nx2, ny2) && !visited[nx1][ny1] && !visited[nx2][ny2]){
                    visited[curX][curY] = true;
                    visited[nx1][ny1] = true;
                    visited[nx2][ny2] = true;

                    int plusScore = map[curX][curY] + map[nx1][ny1] + map[curX][curY] + map[nx2][ny2];

                    if(curX == N-1 && curY == M-1){
                        dfs(curX+1, 0, curScore + plusScore);
                    }else if(curY < M-1){
                        dfs(curX, curY+1, curScore + plusScore);
                    }else{
                        dfs(curX+1, 0, curScore + plusScore);
                    }
                    visited[nx1][ny1] = false;
                    visited[nx2][ny2] = false;
                    visited[curX][curY] = false;
                }
            }
        }

        if(curY < M-1){
            dfs(curX, curY+1, curScore);
        }else{
            dfs(curX+1, 0, curScore);
        }
    }

    public static boolean isIn(int x, int y){
        return x>=0 && x<N && y>=0 && y<M;
    }
}
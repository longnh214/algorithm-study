/**
 * @author nakhoonchoi
 * @date 2024/10/03
 * @see https://www.acmicpc.net/problem/17780
 * @mem 15,124kb
 * @time 104ms
 * @caution
 * [고려사항]
 * 새로운 게임 2와 비슷하지만, 살짝 다르다.
 * 
 * 1. 각 체스판 중 가장 아래에 있는 번호의 체스말(q.peek()의 값)만 이동 가능하다.
 * 2. 체스말 묶음이 분리되는 경우가 없고, 같이 간다.
 * 3. 각 턴의 끝에서 각 큐의 size를 체크해도 된다.
 *
 * 아마 새로운 게임 1을 풀고 2를 풀었다면 파란색의 분기 처리를 잘 할 수 있었을 것 같다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <구현> '새로운 게임'

public class BOJ17780 {
    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {1, -1, 0, 0};
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [][] map = new int[N][N];
        ChessPiece[] chessPieces = new ChessPiece[K];
        Queue<Integer> [][] mapStatus = new LinkedList[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                mapStatus[i][j] = new LinkedList<>();
            }
        }

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) - 1;

            chessPieces[i] = new ChessPiece(x, y, dir);
            mapStatus[x][y].offer(i);
        }

        int count = 1;
        while(count < 1000){
            //각 체스 별 이동
            for(int i=0;i<K;i++){
                ChessPiece chessPiece = chessPieces[i];

                if(mapStatus[chessPiece.x][chessPiece.y].peek() != i){
                    continue;
                }

                int nx = chessPiece.x + dx[chessPiece.dir];
                int ny = chessPiece.y + dy[chessPiece.dir];

                //범위 밖, 다음 좌표가 파란색일 경우 처리
                if(!isIn(nx, ny) || (isIn(nx, ny) && map[nx][ny] == 2)) {
                    chessPiece.dir = reverseDir(chessPiece.dir);
                    nx = chessPiece.x + dx[chessPiece.dir];
                    ny = chessPiece.y + dy[chessPiece.dir];
                    if (isIn(nx, ny) && map[nx][ny] != 2) {
                        List<Integer> moveList = new ArrayList<>();
                        while(!mapStatus[chessPiece.x][chessPiece.y].isEmpty()) {
                            int chessNum = mapStatus[chessPiece.x][chessPiece.y].poll();
                            moveList.add(chessNum);
                        }

                        if(map[nx][ny] == 1){
                            Collections.reverse(moveList);
                        }

                        for(int moveIndex : moveList){
                            chessPieces[moveIndex].x = nx;
                            chessPieces[moveIndex].y = ny;
                            mapStatus[nx][ny].offer(moveIndex);
                        }
                    }
                }
                //빨간색일 경우
                else if(isIn(nx, ny) && map[nx][ny] == 1){
                    List<Integer> moveList = new ArrayList<>();
                    while(!mapStatus[chessPiece.x][chessPiece.y].isEmpty()) {
                        int chessNum = mapStatus[chessPiece.x][chessPiece.y].poll();
                        moveList.add(chessNum);
                    }

                    Collections.reverse(moveList);

                    for(int moveIndex : moveList){
                        chessPieces[moveIndex].x = nx;
                        chessPieces[moveIndex].y = ny;
                        mapStatus[nx][ny].offer(moveIndex);
                    }
                }else{ //흰색일 경우
                    List<Integer> moveList = new ArrayList<>();
                    while(!mapStatus[chessPiece.x][chessPiece.y].isEmpty()) {
                        int chessNum = mapStatus[chessPiece.x][chessPiece.y].poll();
                        moveList.add(chessNum);
                    }

                    for(int moveIndex : moveList){
                        chessPieces[moveIndex].x = nx;
                        chessPieces[moveIndex].y = ny;
                        mapStatus[nx][ny].offer(moveIndex);
                    }
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(mapStatus[i][j].size() >= 4){
                        System.out.println(count);
                        return;
                    }
                }
            }
            count++;
        }

        System.out.println(-1);
    }

    public static int reverseDir(int dir){
        switch(dir){
            case 0:
                return 1;
            case 1:
                return 0;
            case 2:
                return 3;
            case 3:
                return 2;
            default:
                return -1;
        }
    }

    static class ChessPiece{
        int x;
        int y;
        int dir;

        ChessPiece(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public static boolean isIn(int x, int y){
        return x>=0 && x<N && y>=0 && y<N;
    }
}
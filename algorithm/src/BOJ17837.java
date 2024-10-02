/**
 * @author nakhoonchoi
 * @date 2024/10/02
 * @see https://www.acmicpc.net/problem/17837
 * @mem 13,784kb
 * @time 92ms
 * @caution
 * [고려사항]
 * 고려해야할 점이 많았던 구현 문제다...
 *
 * 체스판은 체스판 위에 여러 개의 말이 올 수 있으므로 큐의 2차원 배열로 구현했다.
 *
 * 주의할 점을 요약해본다면,
 * 1. 체스 말의 묶음은 분리될 수 있다.(기존 좌표에 남아있는 말과 이동할 말이 분리된다.)
 * 2. 다음이 파란색일 때나 범위 밖일 때, 반대 방향으로 돌아서
 *    다음 좌표가 흰색인 지 빨간색인지 고려해야했다.(이 부분 때문에 30분 날림...)
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <삼성기출/구현> '새로운 게임 2'

public class BOJ17837 {
    static int [] dx = {0, 0, -1, 1};
    static int [] dy = {1, -1, 0, 0};
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [][] map = new int[N][N];
        ChessPiece [] chessPieces = new ChessPiece[K];
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

                int nx = chessPiece.x + dx[chessPiece.dir];
                int ny = chessPiece.y + dy[chessPiece.dir];

                //범위 밖, 다음 좌표가 파란색일 경우 처리
                if(!isIn(nx, ny) || (isIn(nx, ny) && map[nx][ny] == 2)) {
                    chessPiece.dir = reverseDir(chessPiece.dir);
                    nx = chessPiece.x + dx[chessPiece.dir];
                    ny = chessPiece.y + dy[chessPiece.dir];
                    if (isIn(nx, ny) && map[nx][ny] != 2) {
                        List<Integer> remainList = new ArrayList<>();
                        List<Integer> moveList = new ArrayList<>();
                        boolean flag = false;
                        while (!mapStatus[chessPiece.x][chessPiece.y].isEmpty()) {
                            int chessNum = mapStatus[chessPiece.x][chessPiece.y].poll();

                            if(chessNum == i){
                                flag = true;
                            }

                            if(flag){
                                moveList.add(chessNum);
                            }else{
                                remainList.add(chessNum);
                            }
                        }

                        if(map[nx][ny] == 1){
                            Collections.reverse(moveList);
                        }

                        for(int remainIndex : remainList){
                            mapStatus[chessPiece.x][chessPiece.y].offer(remainIndex);
                        }

                        if (mapStatus[chessPiece.x][chessPiece.y].size() >= 4) {
                            System.out.println(count);
                            return;
                        }

                        for(int moveIndex : moveList){
                            chessPieces[moveIndex].x = nx;
                            chessPieces[moveIndex].y = ny;
                            mapStatus[nx][ny].offer(moveIndex);
                        }

                        if (mapStatus[nx][ny].size() >= 4) {
                            System.out.println(count);
                            return;
                        }
                    }
                }
                //빨간색일 경우
                else if(isIn(nx, ny) && map[nx][ny] == 1){
                    List<Integer> remainList = new ArrayList<>();
                    List<Integer> moveList = new ArrayList<>();
                    boolean flag = false;
                    while (!mapStatus[chessPiece.x][chessPiece.y].isEmpty()) {
                        int chessNum = mapStatus[chessPiece.x][chessPiece.y].poll();

                        if(chessNum == i){
                            flag = true;
                        }

                        if(flag){
                            moveList.add(chessNum);
                        }else{
                            remainList.add(chessNum);
                        }
                    }

                    for(int remainIndex : remainList){
                        mapStatus[chessPiece.x][chessPiece.y].offer(remainIndex);
                    }

                    if (mapStatus[chessPiece.x][chessPiece.y].size() >= 4) {
                        System.out.println(count);
                        return;
                    }

                    Collections.reverse(moveList);
                    for(int moveIndex : moveList){
                        chessPieces[moveIndex].x = nx;
                        chessPieces[moveIndex].y = ny;
                        mapStatus[nx][ny].offer(moveIndex);
                    }

                    if (mapStatus[nx][ny].size() >= 4) {
                        System.out.println(count);
                        return;
                    }
                }else{ //흰색일 경우
                    List<Integer> remainList = new ArrayList<>();
                    List<Integer> moveList = new ArrayList<>();
                    boolean flag = false;
                    while (!mapStatus[chessPiece.x][chessPiece.y].isEmpty()) {
                        int chessNum = mapStatus[chessPiece.x][chessPiece.y].poll();

                        if(chessNum == i){
                            flag = true;
                        }

                        if(flag){
                            moveList.add(chessNum);
                        }else{
                            remainList.add(chessNum);
                        }
                    }

                    for(int remainIndex : remainList){
                        mapStatus[chessPiece.x][chessPiece.y].offer(remainIndex);
                    }

                    if (mapStatus[chessPiece.x][chessPiece.y].size() >= 4) {
                        System.out.println(count);
                        return;
                    }

                    for(int moveIndex : moveList){
                        chessPieces[moveIndex].x = nx;
                        chessPieces[moveIndex].y = ny;
                        mapStatus[nx][ny].offer(moveIndex);
                    }

                    if (mapStatus[nx][ny].size() >= 4) {
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
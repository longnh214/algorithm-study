/**
 * @author choi
 * @date Sep 2, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4suNtaXFEDFAUf&categoryId=AV4suNtaXFEDFAUf&categoryType=CODE
 * @mem 24,712kb
 * @time 212ms
 * @caution
 * [고려사항]
 * BFS로 풀면 배열 복사를 계속 해줘야할 것 같아 DFS로 풀려고 했다.
 * 그리고 백트래킹을 하려면 BFS보다는 DFS가 더 좋을 것 같았다.
 * 코어를 선택하고 선택하지 않을 경우의 수를 생각해줘야하기 때문에
 * 선택된 최대 코어 개수일 때만 answer를 갱신하도록 했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//SW Expert <?> '프로세서 연결하기'
public class Solution1767 {
    //count : 각 코어에 연결된 줄마다 전선의 길이를 저장하기 위한 temp 변수
    static int N,answer,count,core;
    static int [][] map;
    static List<Point> coreList;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,-1,0,1};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            answer = Integer.MAX_VALUE;
            coreList = new ArrayList<>();
            N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            map = new int[N][N];

            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());

                for(int j=0;j<N;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(i != 0 && i != N-1 && j != 0 && j != N-1 && map[i][j] == 1) {
                        coreList.add(new Point(i,j));
                    }
                }
            }

            //core : 코어의 개수 저장하는 변수
            core = 0;

//			for(int i=0;i<N;i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}

            dfs(0,0,0);
            System.out.println("#"+t+" " +answer);
        }
    }

    //index = 현재 인덱스 / chooseCore = 지금까지 고른 코어의 개수. / length = 지금까지의 거리.
    public static void dfs(int index, int chooseCore, int length) {
        if(index == coreList.size()) {
            System.out.println(index + " " + chooseCore + " " + length);
            if(core < chooseCore) {
                core = chooseCore;
                answer = length;
            }else if(core == chooseCore) {
                answer = Math.min(answer, length);
            }
            return;
        }

        //연결 할 수 있는 지 4방향 전부 탐색하고 visited 처리한 후 다음 인덱스 dfs
        //dfs 한 후에 방문 전처럼 돌려놓는다.
        for(int i=0;i<4;i++) {
            if(isConnect(coreList.get(index), i)) {
                visited(coreList.get(index),i,2);//visited true 처리.
                dfs(index+1, chooseCore+1, length+count);
                visited(coreList.get(index),i,0);//visited false 처리.
            }
        }
        //이번 코어를 선택하지 않을 경우.
        dfs(index+1, chooseCore, length);
    }

    //범위에 있는 지.
    public static boolean isIn(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N;
    }

    //방문한 곳을 채우면서 길이를 구한다.
    public static void visited(Point point, int direction, int value) {
        int x = point.x + dx[direction];
        int y = point.y + dy[direction];
        //매 visited 마다 길이가 다르므로 0으로 초기화.
        count = 0;
        while(isIn(x,y)) {
            map[x][y] = value;
            count++;
            x += dx[direction];
            y += dy[direction];
        }

    }
    //연결할 수 있는 지 없는 지.
    public static boolean isConnect(Point point, int direction) {
        int x = point.x + dx[direction];
        int y = point.y + dy[direction];

        while(isIn(x,y)) {
            if(map[x][y] != 0)
                return false;

            x += dx[direction];
            y += dy[direction];
        }
        return true;
    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
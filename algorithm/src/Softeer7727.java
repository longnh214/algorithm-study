/**
 * @author nakhoonchoi
 * @date 2024/11/2
 * @see https://softeer.ai/practice/7727
 * @caution
 * [고려사항]
 * 문제를 봤을 때에는 엄청 쉬워보였는데... 막상 풀었을 때 감이 잡히지 않는 문제였다.
 * 먼저 m이 1이상 3이하로 크기가 작으므로, 중복 순열로 3*m 길이 만큼 방향을 미리 정해주었다.
 * (각 친구 별로 3초까지 진행 방향을 미리 다 정해놓음)
 * (4^3 * m 만큼 경우의 수가 나올 것이므로 생각보다 크지 않다.)
 * 그 이후 방향대로 좌표를 이동시키며 수확량을 더해주었고, 모든 경우의 수 중 가장 최댓값을 출력하였다.
 *
 * 여기에서 주의했던 점은, 범위가 벗어나거나 이미 수확한 곳을 방문한 친구가 있다면 그 친구는 더 이상 이동시키지 않도록 하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//소프티어 <연습문제> '함께하는 효도'

public class Softeer7727 {
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, -1, 0, 1};
    static int answer;
    static int [][] map;
    static boolean [][] visited;
    static int n, m, initSum;
    static int [][] friends;
    static int [] temp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        friends = new int[m][2];
        temp = new int[m*3];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            friends[i][0] = Integer.parseInt(st.nextToken()) - 1;
            friends[i][1] = Integer.parseInt(st.nextToken()) - 1;
            visited[friends[i][0]][friends[i][1]] = true;
            initSum += map[friends[i][0]][friends[i][1]];
        }
        comb(0);

        System.out.println(answer);
    }

    public static int func(int [] dirArr){
        int score = initSum;
        int nx, ny;

        boolean [] isOut = new boolean[m];

        for(int i=0;i<m;i++){
            if(isOut[i]) continue;

            nx = friends[i][0];
            ny = friends[i][1];
            for(int j=0;j<3;j++){
                int dir = dirArr[i * m + j];

                nx += dx[dir];
                ny += dy[dir];

                if(isIn(nx, ny) && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    score += map[nx][ny];
                }else{
                    isOut[i] = true;
                }
            }
        }

        return score;
    }

    public static void comb(int count) {
        if (count == 3 * m) {
            //여기에서 계산을 해야하나...?
            initVisited();
            answer = Math.max(answer, func(temp));
            return;
        }

        for (int i = 0; i < 4; i++) {
            temp[count] = i;
            comb(count + 1);
        }
    }

    public static void initVisited(){
        visited = new boolean[n][n];
        for(int i=0;i<m;i++){
            visited[friends[i][0]][friends[i][1]] = true;
        }
    }

    public static boolean isIn(int x, int y){
        return x>=0 && x<n && y>=0 && y<n;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ11559 {
    static char [][] map = new char[12][6];
    static int [] dx = {0,0,-1,1};
    static int [] dy = {1,-1,0,0};
    static int result;
    static boolean flag; //콤보가 이루어졌는지 판별하는 변수
    static Queue<Point> q = new LinkedList<>();
    static boolean[][] visited;
    static ArrayList<Point> al = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<12;i++)
            map[i] = br.readLine().toCharArray();

        result = 0;
        while(true){
            flag = true;
            range();
            bfs();
            if(flag) break;
            result++;
        }
        System.out.println(result);
    }

    //중력 정렬하는 함수
    static void range(){
        for(int i=11;i>=0;i--){
            for(int j=0;j<6;j++){
                if(map[i][j] == '.')
                    continue;
                //범위 체크
                int nx = i;
                char check = map[i][j];
                map[i][j] = '.';
                while(true){
                    //어디까지 내려야할 지 확인
                    if(!(nx+1>=0 && nx+1<12)|| map[nx+1][j] != '.')
                        break;
                    nx++;
                }
                map[nx][j] = check;
            }
        }
    }

    static void bfs(){
        for(int i=0;i<12;i++){
            for(int j=0;j<6;j++){
                if(map[i][j] == '.') continue;
                visited = new boolean[12][6];
                visited[i][j] = true;
                int count = 0; //주변의 같은 색 벽돌 count
                q.add(new Point(i,j));

                while(!q.isEmpty()){
                    Point cur = q.poll();
                    count++;
                    //이 반복문에 들어온 것만으로 같은 벽돌에 해당되므로 arrayList에 추가
                    al.add(cur);
                    for(int k=0;k<4;k++){
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if(!(nx>=0 && ny>=0 && nx<12 && ny<6) ||
                                map[nx][ny] != map[cur.x][cur.y] || visited[nx][ny]) continue;
                        visited[nx][ny] = true;
                        q.add(new Point(nx,ny));
                    }
                }
                //벽돌이 네 개 이상이 모이면
                if(count >= 4){
                    for(Point point : al){
                        map[point.x][point.y] = '.';
                    }
                    flag = false;
                }
                //한번 콤보를 이뤘으므로 arrayList 초기화
                al.clear();
            }
        }
    }

    static class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}

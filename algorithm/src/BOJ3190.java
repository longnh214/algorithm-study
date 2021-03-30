import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ3190 {
    //오른쪽, 아래, 왼쪽, 위 순서
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    static int [][] map;
    static int n;
    static int k;
    static int l;
    //시간에 대한 회전정보 저장
    //HashMap과 Map의 차이
    static Map<Integer, String> hashMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n+2][n+2];
        //벽을 1로 지정
        for(int i=0; i<n+2; i++)
            for(int j=0; j<n+2; j++)
                if(i==0 || j==0 || i==n+1 || j==n+1)
                    map[j][i] = 1;
        k = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 2;//사과는 2
        }

        l = Integer.parseInt(br.readLine());
        for(int i=0;i<l;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            hashMap.put(a,str);
        }

        int dir = 0;
        int time = 0;
        Deque<Point> snake = new ArrayDeque<>();
        snake.add(new Point(1,1));
        while(true){
            time++; //초 증가
            Point head = snake.peekLast();//맨 처음 들어온 값이 머리
            int nx = head.x + dx[dir];
            int ny = head.y + dy[dir];
            if(map[ny][nx] == 1)//새 좌표가 벽이거나 뱀의 몸통이라면(둘 다 1로 지정)
                break;
            if(map[ny][nx] != 2) {//다음 좌표가 사과가 아니라면
                Point tail = snake.poll();
                map[tail.y][tail.x] = 0;
            }
            map[ny][nx] = 1;
            snake.addLast(new Point(ny,nx));
            if(hashMap.containsKey(time)) {//해당 시간에 대한 값이 D면 오른쪽, 아니면 왼쪽으로 회전
                dir = (hashMap.get(time).equals("D")) ? (dir + 1) % 4 : (dir + 3) % 4;
            }
        }
        System.out.println(time);
    }

    static class Point{
        int x;
        int y;
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
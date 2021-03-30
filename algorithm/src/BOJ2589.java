import java.util.*;
public class BOJ2589 {
    static int m;
    static int n;
    static char [][] map;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,-1,0,1};
    static int ans = 0;

    public static class Point {
        int x;
        int y;

        Point(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        m = scan.nextInt();
        n = scan.nextInt();
        map = new char[m][n];
        scan.nextLine();
        for(int i=0;i<m;i++){
           char [] arr = scan.nextLine().toCharArray();
           for(int j=0;j<arr.length;j++){
               map[i][j] = arr[j];
           }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Queue<Point> q = new LinkedList<Point>();
                boolean [][] visited = new boolean[m][n];
                int [][] dist = new int[m][n];
                char ch = map[i][j];
                visited[i][j] = true;
                q.add(new Point(i,j));
                int temp = 0;

                while(!q.isEmpty()){
                    Point p = q.poll();
                    int x = p.x;
                    int y = p.y;

                    for(int k=0;k<4;k++){
                        int nx = dx[k] + x;
                        int ny = dy[k] + y;

                        if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                            if (!visited[ny][nx] && map[ny][nx] == ch) {
                                q.add(new Point(ny, nx));
                                dist[ny][nx] = dist[y][x] + 1;
                                visited[ny][nx] = true;
                                //최대값 갱신
                                if (temp < dist[ny][nx]) {
                                    temp = dist[ny][nx];
                                }
                            }
                        }
                    }
                }
                if(ans < temp)
                    ans = temp;
            }
        }
        System.out.println(ans);
    }
}
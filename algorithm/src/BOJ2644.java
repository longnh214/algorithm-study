import java.util.*;
public class BOJ2644 {
    static int n, m, start, end;
    static int[][] a = new int[101][101];
    static int[] dp = new int[101];
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        start = scan.nextInt();
        end = scan.nextInt();
        m = scan.nextInt();

        for (int i = 0; i < m; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            a[x][y] = a[y][x] = 1;
        }
        //bfs 부분
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int now = q.remove();
            for(int i=1; i<=n; i++){
                if(a[now][i]==0 || dp[i]!=0) continue;
                dp[i] = dp[now]+1;
                q.add(i);
            }
        }
        System.out.println(dp[end]==0?-1:dp[end]);
        scan.close();
    }
}
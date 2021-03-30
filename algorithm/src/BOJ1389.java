import java.util.*;
public class BOJ1389 {
    static int N,M;
    static int [][] dp;
    static int [][] map;
    static Queue<Integer> q = new LinkedList<>();
    static int minCnt = Integer.MAX_VALUE;
    static int min;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();

        dp = new int[N+1][N+1];
        map = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            Arrays.fill(dp[i],-1);
        }

        //친구 설정 (배열 map)
        for(int i=0;i<M;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            map[x][y] = map[y][x] = 1;
        }

        //최소값을 도출해내기 위해 역순으로 for문
        for(int i=N;i>=1;i--)
            bfs(i);
        System.out.println(min);
    }

    public static void bfs(int start){
        dp[start][start] = 0;
        q.add(start);

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i=1;i<=N;i++){
                if(map[cur][i] == 0 || dp[start][i] != -1) continue;

                dp[start][i] = dp[start][cur] + 1;
                q.add(i);
            }
        }
        int sum = 0;
        for(int i=1;i<=N;i++)
            sum += dp[start][i];

        if(minCnt >= sum){
            minCnt = sum;
            min = start;
        }
    }
}

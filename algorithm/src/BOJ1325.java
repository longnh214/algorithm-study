import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1325 {
    static int n;
    static int m;
    static ArrayList<Integer>[] a;
    static boolean [] visited;
    static int [] dp;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        a = new ArrayList[n+1];
        dp = new int[n+1];

        for(int i=1;i<=n;i++){
            a[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<m;i++){
            str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            a[x].add(y);
        }

        for(int i=1;i<=n;i++){
            visited = new boolean[n+1];
            dfs(i);
        }

        for(int i=1;i<=n;i++){
            max = Math.max(max,dp[i]);
        }

        for(int i=1;i<=n;i++){
            if(max == dp[i])
                System.out.format("%d ",i);
        }
        System.out.println();
    }

    static void dfs(int cur){
        visited[cur] = true;
        //각 정점을 기준으로 탐색되어지는 정점은 현재 기준 정점을 해킹할 수 있다는 것을 의미
        //next의 dp 값을 올려준 뒤에 dfs 함수를 재귀 호출한다.
        for(int next : a[cur]){
           if(!visited[next]){
               dp[next]++;
               dfs(next);
           }
        }
    }
}
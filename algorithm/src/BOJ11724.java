import java.util.Scanner;

public class BOJ11724 {
    static int N;
    static int M;
    static int [][] graph;//무방향 그래프
    static int [] visited;//방문 체크

    static void dfs(int a, int cnt){
        visited[a]=cnt;
        for(int i=1; i<N+1; i++) {
            if(graph[a][i]==1 && visited[i]==0) {
                dfs(i,cnt);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();//정점 갯수
        M = scan.nextInt();//간선 갯수

        graph = new int[N+1][N+1];
        visited = new int[N+1];

        for(int i=0;i<M;i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph[a][b] = graph[b][a] = 1;
        }

        int cnt=1;
        for(int i=1; i<=N; i++) {//dfs 수행 코드
            if(visited[i]==0) {
                dfs(i, cnt);
                cnt++;
            }
        }
        System.out.println(cnt-1);//1부터 시작했기 때문에 끝에 -1을 해줍니다.
    }
}
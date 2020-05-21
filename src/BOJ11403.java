import java.util.*;
import java.io.*;
//백준 11403번 <DFS/BFS> - '경로 찾기'
public class BOJ11403 {
    static int [] visited;
    static int [][] map;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new int[N];
        int [][] path = new int[N][N];

        //가중치 없는 방향 그래프 이므로 map[j][i]과는 값이 전혀 다를 수 있다.
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            dfs(i);
            for(int j=0;j<N;j++)
                path[i][j] = visited[j];
            //한번 dfs를 끝냈으므로 배열 초기화
            Arrays.fill(visited, 0);
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++)
                System.out.print(path[i][j] + " ");
            System.out.println();
        }
    }

    public static void dfs(int n){
        for(int i=0;i<N;i++){
            if(map[n][i] == 1 && visited[i] == 0){
                visited[i] = 1;
                dfs(i);
            }
        }
    }
}
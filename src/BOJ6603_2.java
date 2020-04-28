import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//백준 6603번 <DFS> - '로또'
public class BOJ6603_2 {
    static int [] arr;
    static boolean [] visited;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        do{
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            arr = new int[K];
            visited = new boolean[K];

            for(int i=0;i<K;i++)
                arr[i] = Integer.parseInt(st.nextToken());

            for(int i=0;i<=K-6;i++){
                visited[i] = true;
                dfs(i,1);
                visited[i] = false;
            }
            System.out.println();
        }while(K != 0);
    }

    public static void dfs(int curIndex, int depth){
        if(depth == 6){
            for(int i=0;i<K;i++){
                if(visited[i] == true)
                    System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i=curIndex;i<K;i++){
            if(visited[i] == true) continue;
            visited[i] = true;
            dfs(i,depth+1);
            visited[i] = false;
        }
    }
}
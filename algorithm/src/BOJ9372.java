import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ9372 {
    static int [][] map;
    static boolean [] visited;
    static Queue<Integer> q = new LinkedList<>();
    static int count;
    static int country; //나라
    static int plane; //비행기
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(T-->0){
            country = scan.nextInt();
            plane = scan.nextInt();
            map = new int[country+1][country+1];
            visited = new boolean[country+1];
            count = 0;
            for(int i=0;i<plane;i++){
                int a = scan.nextInt();
                int b = scan.nextInt();
                map[a][b] = map[b][a] = 1;
            }
            bfs(1);
            System.out.println(count);
            q.clear();
        }
    }

    public static void bfs(int v){
        q.add(v);
        visited[v] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int i=1;i<=country;i++){
                if(!visited[i] && map[temp][i]==1) {
                    count++;
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
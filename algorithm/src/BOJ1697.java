import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1697 {
    static int N, M;
    static int [] visited = new int[100003];

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();

        bfs();

        scan.close();
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = 1;//0은 방문하지 않음을 표시, 나머지는 해당 지점까지 소요된 최소 second를 표시

        while(!q.isEmpty()){
            N = q.poll();
            if(N == M)
                break;
            //if(visited[N+1] == 0 && N+1 <= 100000)
            if(N+1 <= 100000 && visited[N+1] == 0) {
                visited[N+1] = visited[N] + 1;
                q.add(N+1);
            }
            if (N-1 >= 0 && visited[N-1] == 0) {
                visited[N-1] = visited[N] + 1;
                q.add(N-1);
            }
            if(N*2 <= 100000 && visited[N*2] == 0) {
                visited[N*2] = visited[N] + 1;
                q.add(N*2);
            }
        }
        System.out.println(visited[M] - 1); // 1부터 시작했으므로 1을 빼준 값을 출력
    }
}
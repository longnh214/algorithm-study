import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://jaejin89.tistory.com/36 참고
public class BOJ6603 {
    static int [] list;
    static int [] visited;
    static int K;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            K = Integer.parseInt(st.nextToken());

            if(K==0){
                break;
            }

            list = new int[K];
            visited = new int[K];

            for(int i=0;i<K;i++){
                list[i] = Integer.parseInt(st.nextToken());
            }

            //로또는 6개의 수 이므로 로또에 나오지 않을 수 만큼만 반복문
            for(int i=0;i<=K-6;i++){
                visited[i] = 1;
                dfs(i,1);
                visited[i] = 0;
            }
            System.out.println();
        }
    }
    static void dfs(int cur, int cnt){//재귀함수 dfs
        if(cnt == 6){//로또 6자리가 다 채워지면
            for(int i=0;i<K;i++){
                if(visited[i] == 1)
                    System.out.print(list[i] + " ");
            }
            System.out.println();
            return;
        }
        //방문한 배열을 다시 탐색
        for(int i=cur;i<K;i++){
            if(visited[i] == 1) continue;
            visited[i] = 1;
            dfs(i,cnt+1);
            visited[i] = 0;
        }
    }
}
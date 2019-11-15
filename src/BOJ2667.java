import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Vector;

public class BOJ2667 {
    static int N;
    static int [][] arr;
    static int [] dx = {1,0,-1,0};//x축 방향
    static int [] dy = {0,1,0,-1};//y축 방향
    static int count;//단지 내의 세대 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        int total = 0;//단지수 초기화
        ArrayList<Integer> al = new ArrayList<>();//단지 내 세대 수를 넣기 위한 ArrayList
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j] == 1) {
                    count = 0;
                    total++;
                    dfs(i, j);
                    al.add(count);
                }
            }
        }
        System.out.println(total);//단지 수
        Collections.sort(al);//오름차순 정렬
        for(int i=0;i<al.size();i++){
           System.out.println(al.get(i));//정렬된 단지 내 세대 수 출력
        }
    }

    static void dfs(int n, int m){
        arr[n][m] = 0;
        count++;
        for(int i=0;i<4;i++){
            int nx = n + dx[i];
            int ny = m + dy[i];
            if(0 <= nx && 0 <= ny && nx < N && ny < N){
                if(arr[nx][ny] == 1)
                    dfs(nx, ny);
            }
        }
    }
}
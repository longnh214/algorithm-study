/**
 * @author choi
 * @date Sep 3, 2020
 * @see http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=954&sca=3030
 * @mem 13MB
 * @time 227ms
 * @caution
 * [고려사항]
 * arr[][]의 값이 0 이면 거리가 0인것이 아니라, 갈 수 있는 방법이 없다는 뜻인 것을 주의하면 문제를 풀 수 있다.
 * visited 처리를 제대로 해주지 않아 문제를 푸는 데에 오래 걸렸던 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//정올 <순열> - '해밀턴순환회로'
public class Jungol1681 {
    static int N,answer,sum;
    static int [][] arr;
    static int [] temp;
    static boolean [] visited;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        temp = new int[N];
        answer = Integer.MAX_VALUE;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<N;i++) {
            visited = new boolean[N];
            sum = 0;
            if(arr[0][i] != 0) {
                visited[i] = true;
                sum += arr[0][i];
                dfs(0,i,1);
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int start, int end, int cnt) {

        //가지치기
        if(sum > answer) {
            return;
        }

        if(cnt == N-1){
            if(arr[end][0] == 0) return;
            answer = Math.min(sum+arr[end][0], answer);
            return;
        }

        for(int i=1;i<N;i++) {
            if(!visited[i] && arr[end][i] != 0) {
                visited[i] = true;
                sum += arr[end][i];
                dfs(end, i, cnt+1);
                sum -= arr[end][i];
                visited[i] = false;
            }
        }
    }
}
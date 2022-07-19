/**
 * @author nakhoon
 * @date 2022, 7월 19일
 * @see https://www.acmicpc.net/problem/16922
 * @mem 11,448kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 처음에는 Set을 이용해서 중복된 숫자의 개수를 반환하려했다.
 * 하지만 이 방법으로는 시간 초과가 발생했고,
 * 값을 더해가면서 넘기는 dfs를 이용해서 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <브루트포스> '로마 숫자 만들기'
public class BOJ16922 {
    static int [] arr;
    static int N, answer;
    static boolean [] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[1001];
        arr = new int[]{1,5,10,50};
        perm(0,0,0);
        System.out.println(answer);
    }

    public static void perm(int count, int index, int cur){
        if(count == N){
            if(!visited[cur]){
                visited[cur] = true;
                answer++;
            }
            return;
        }

        for(int i=index;i<4;i++){
            perm(count+1, i, cur + arr[i]);
        }
    }
}
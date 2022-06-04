/**
 * @author nakhoon
 * @date 2022, 6월 4일
 * @see https://www.acmicpc.net/problem/10819
 * @mem 12,412kb
 * @time 104ms
 * @caution
 * [고려사항]
 * 순열을 이용해서 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <브루트포스> '차이를 최대로'
public class BOJ10819 {
    static int [] temp;
    static int N, answer;
    static boolean [] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];
        temp = new int[N];
        visited = new boolean[N];
        answer = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        perm(arr, 0);

        System.out.println(answer);
    }

    public static void perm(int [] arr, int count){
        if(count == N){
            //최대값 계산
            int sum = 0;
            for(int i=0;i<N-1;i++){
                sum += Math.abs(temp[i] - temp[i+1]);
            }
            answer = Math.max(answer, sum);
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                temp[count] = arr[i];
                perm(arr, count+1);
                visited[i] = false;
            }
        }
    }
}
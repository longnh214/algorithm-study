/**
 * @author nakhoonchoi
 * @date 2024/08/24
 * @see https://www.acmicpc.net/problem/2847
 * @mem 11,500kb
 * @time 68ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <그리디> '게임을 만든 동준이'

public class BOJ2847 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N == 1){
            System.out.println(0);
        }

        int [] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for(int i=N-2;i>=0;i--){
            if(arr[i+1] <= arr[i]){
                int gap = (arr[i] - arr[i+1] + 1);
                answer += gap;
                arr[i] -= gap;
            }
        }
        System.out.println(answer);
    }
}
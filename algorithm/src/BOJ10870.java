/**
 * @author nakhoonchoi
 * @date 2024/08/10
 * @see https://www.acmicpc.net/problem/10870
 * @mem 11,488kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 메모이제이션을 이용해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <수학> '피보나치 수 5'

public class BOJ10870 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[21];

        arr[0] = 0;
        arr[1] = 1;
        for(int i=2;i<arr.length;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }

        System.out.println(arr[N]);
    }
}
/**
 * @author nakhoonchoi
 * @date 2024/06/24
 * @see https://www.acmicpc.net/problem/20044
 * @mem 14,380kb
 * @time 120ms
 * @caution
 * [고려사항]
 * 정렬을 통해 점수를 정렬하고, 배열의 왼쪽 끝과 오른쪽 끝에서 한 칸씩 좁히면서 합 중 최솟값을 답으로 출력하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <정렬> 'Project Teams'
public class BOJ20044 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N*2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            int sum = arr[i] + arr[arr.length - i - 1];

            min = Math.min(sum, min);
        }

        System.out.println(min);
    }
}
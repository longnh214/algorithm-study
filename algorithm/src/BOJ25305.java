/**
 * @author nakhoonchoi
 * @date 2024/07/23
 * @see https://www.acmicpc.net/problem/25305
 * @mem 11,844kb
 * @time 88ms
 * @caution
 * [고려사항]
 * 정렬한 뒤에 N - M 인덱스의 값을 출력해주었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <정렬> '커트라인'

public class BOJ25305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(arr[N - M]);
    }
}
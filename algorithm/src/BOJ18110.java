/**
 * @author nakhoonchoi
 * @date 2024/06/25
 * @see https://www.acmicpc.net/problem/18110
 * @mem 37,344kb
 * @time 332ms
 * @caution
 * [고려사항]
 * 반올림을 할 때, Math.round 함수를 써야하는 것을 알았고,
 * Math.round((double) sum / (N - (sliceNum * 2))) 를 통해
 * sum을 int형에서 double형으로 형변환하고 나누어야 소수점을 반올림 할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <정렬> 'solved.ac'
public class BOJ18110 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sliceNum = (int) Math.round(N * 0.15);

        int [] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int sum = 0;
        for(int i=sliceNum;i<N - sliceNum;i++){
            sum += arr[i];
        }

        System.out.println(Math.round((double) sum / (N - (sliceNum * 2))));
    }
}
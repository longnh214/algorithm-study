/**
 * @author nakhoonchoi
 * @date 2024/07/27
 * @see https://www.acmicpc.net/problem/22970
 * @mem 12,468kb
 * @time 100ms
 * @caution
 * [고려사항]
 * 배열을 순회하고 역순하면서 얼마나 증가하는 수열인지
 * 메모이제이션 해주었고, 특정 인덱스 기준으로 가장 긴 산의 길이에서
 * 시작 인덱스 개수까지 +1 연산을 해서 출력하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <구현> '문제 재탕'

public class BOJ22970 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        int [] upArr = new int[N];
        int [] downArr = new int[N];
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N-1;i++){
            if(arr[i] < arr[i+1]){
                upArr[i+1] = upArr[i] + 1;
            }
        }

        for(int i=N-1;i>=1;i--){
            if(arr[i] < arr[i-1]){
                downArr[i-1] = downArr[i] + 1;
            }
        }

        for(int i=0;i<N;i++){
            answer = Math.max(answer, upArr[i] + downArr[i]);
        }
        System.out.println(answer + 1);
    }
}
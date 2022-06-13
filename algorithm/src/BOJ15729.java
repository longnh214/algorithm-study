/**
 * @author nakhoon
 * @date 2022, 6월 13일
 * @see https://www.acmicpc.net/problem/15729
 * @mem 78,064kb
 * @time 340ms
 * @caution
 * [고려사항]
 * 전구의 값이 1이면 그 다음 위치의 버튼을 눌러 오른쪽의 두 인덱스의 값을 바꿔준다.
 * N 까지 돌면 최소값을 구할 수 있다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '방탈출'
public class BOJ15729 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N+2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        for(int i=0;i<N;i++){
            if(arr[i] == 1){
                count++;
                arr[i+1] = arr[i+1] == 1 ? 0 : 1;
                arr[i+2] = arr[i+2] == 1 ? 0 : 1;
            }
        }
        System.out.println(count);
    }
}
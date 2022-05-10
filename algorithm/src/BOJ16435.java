/**
 * @author nakhoon
 * @date 2022, 5월 10일
 * @see https://www.acmicpc.net/problem/16435
 * @mem 11,828kb
 * @time 92ms
 * @caution
 * [고려사항]
 * 배열을 정렬하고, 현재 인덱스의 배열 값이 L보다 작거나 같다면 +1을 해주고, 아니라면 반복문을 break로 빠져나왔다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 <그리디> '스네이크버드'
public class BOJ16435 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int [] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0;i<N;i++){
            if(arr[i] <= L){
                L++;
            }else{
                break;
            }
        }

        System.out.println(L);
    }
}
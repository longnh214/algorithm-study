/**
 * @author nakhoon
 * @date 2022, 5월 6일
 * @see https://www.acmicpc.net/problem/3273
 * @mem 26,588kb
 * @time 308ms
 * @caution
 * [고려사항]
 * 투 포인터를 이용해서 문제를 해결할 수 있었다.
 * while 문의 조건문 내 부등호를 잘못 생각해서 한 번 틀렸던 문제이다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 <투 포인터> '두 수의 합'
public class BOJ3273 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int count = 0;
        int left = 0;
        int right = N-1;
        int sum;
        while(left < right){
            sum = arr[left] + arr[right];

            if(sum < target){
                left++;
            }else if(sum > target){
                right--;
            }else{
                count++;
                left++;
            }
        }
        System.out.println(count);
    }
}
/**
 * @author nakhoonchoi
 * @date 2024/08/29
 * @see https://www.acmicpc.net/problem/20366
 * @mem 12,152kb
 * @time 344ms
 * @caution
 * [고려사항]
 * 투 포인터를 이용해서 문제를 해결하였다.
 * 배열이 {a,b,c,d,e..} 로 이루어졌다는 가정 하에
 * 2중 for문을 이용해서 두 개의 숫자를 뽑은 뒤,
 * 하나의 눈사람(두 숫자)을 정해놓고, 범위 내에서 눈사람을 정해서 Math.min 작업을 진행해준다.
 * 절댓값이 0보다 크면 left 인덱스를 올리고, 절댓값이 0보다 작으면 right 인덱스를 하나 내려준다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <두 포인터> '같이 눈사람 만들래?'

public class BOJ20366_3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        int answer = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0;i<N-3;i++){
            for(int j=i+3;j<N;j++){
                int left = i+1;
                int right = j-1;

                int standard = arr[i] + arr[j];

                while(left < right){
                    int temp = standard - (arr[left] + arr[right]);

                    answer = Math.min(Math.abs(temp), answer);

                    if(temp > 0){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
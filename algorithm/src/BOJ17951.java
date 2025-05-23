/**
 * @author nakhoonchoi
 * @date 2025/05/23
 * @see https://boj.ma/17951
 * @mem 23,300kb
 * @time 256ms
 * @caution
 * [고려사항]
 * 오랜만에 이분탐색 문제였다.
 * 각 그룹의 총합 중 그룹 내에서 최소를 구해야하고, 그룹의 개수가 K를 만족하는 경우의 수들 중 최대의 점수가 되는 값을 구하면 되었다.
 * 0~총합점수 기준으로 이분탐색을 해서 최적의 점수 합을 찾으면 되었다.
 * mid 기준으로 현재 시험 점수 순서대로 그룹을 구해서 그룹의 개수가 K보다 적으면 mid가 최적의 값보다 크다는 의미이기 때문에
 * right = mid - 1;로 right 포인터를 바꿔주었고,
 * 그 이외의 경우 (그룹의 개수가 K와 같거나 보다 크면)
 * left 포인터를 left = mid + 1;로 수정해주었다.
 *
 * 이분탐색이 끝나면 반환될 값은 조건을 만족하는 기준값 중 최대값 → 'right'이다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <이분탐색> '흩날리는 시험지 속에서 내 평점이 느껴진거야'

public class BOJ17951 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] arr = new int[N];
        int total = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        int left = 0;
        int right = total;

        while(left <= right){
            int mid = left + (right - left) / 2;
            int groupCount = 0;
            int sum = 0;

            for(int i=0;i<N;i++){
                sum += arr[i];

                if(sum >= mid){
                    groupCount++;
                    sum = 0;
                }
            }

            if(K <= groupCount){ // 가능한 경우에는 기준을 더 높여보자.
                left = mid + 1;
            }else{ // 불가능한 경우에 기준을 낮추자.
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}
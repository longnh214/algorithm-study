/**
 * @author choi
 * @date Dec 20, 2020
 * @see https://www.acmicpc.net/problem/2473
 * @mem 14,136kb
 * @time 216ms
 * @caution
 * [고려사항]
 * 한 점을 고정해놓고, 최적의 해인 두 점을 찾으면 된다.(i는 0부터 N-2까지 반복)
 * O(N^2)
 * 두 용액처럼 양쪽을 고정하고 반복문으로 중간점을 찾으며 left와 right를 조정하고 싶었지만 어려웠다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
// 백준 <투포인터> '세 용액'
public class BOJ2473 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long [] arr = new long[N];
        long [] answer = new long[3];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        long sum = 0;

        //한 점을 고정해놓고, 최적의 해인 두 점을 찾으면 된다.(i는 0부터 N-2까지 반복)
        //O(N^2)
        for (int i = 0; i < N-2; i++) {
            int left = i+1;
            int right = N - 1;
            while (left < right) {
                sum = arr[left] + arr[i] + arr[right];
                if (Math.abs(min) > Math.abs(sum)) {
                    min = sum;
                    answer[0] = arr[left];
                    answer[1] = arr[right];
                    answer[2] = arr[i];
                }

                if (sum > 0)
                    right--;
                else
                    left++;
            }
        }

        Arrays.sort(answer);

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}
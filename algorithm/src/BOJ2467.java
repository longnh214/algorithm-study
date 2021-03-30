/**
 * @author choi
 * @date Dec 20, 2020
 * @see https://www.acmicpc.net/problem/2467
 * @mem 31,200kb
 * @time 284ms
 * @caution
 *[고려사항]
 *[입력사항]
 *[출력사항]
 */
import java.util.*;
import java.io.*;
// 백준 <투포인터> '용액'
public class BOJ2467 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;
        int answer_left = 0;
        int answer_right = N-1;
        int answer = arr[left] + arr[right];

        while (true) {
            if(left == right) break;
            int sum = arr[left] + arr[right];

            if (Math.abs(answer) > Math.abs(sum)) {
                answer = sum;
                answer_left = left;
                answer_right = right;
            }
            if(sum > 0) right--;
            else if(sum < 0) left++;
            else break;
        }
        System.out.println(arr[answer_left] + " " + arr[answer_right]);
    }
}
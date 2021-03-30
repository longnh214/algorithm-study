/**
 * @author choi
 * @date Dec 18, 2020
 * @see https://www.acmicpc.net/problem/14921
 * @mem 26,840kb
 * @time 268ms
 * @caution
 *[고려사항]
 * 투 포인터의 인덱스를 가장 왼쪽, 가장 오른쪽을 시작점으로 해야한다는 것을 생각하지 못해서 오래 걸렸던 문제이다.
 *[입력사항]
 *[출력사항]
 */
import java.util.*;
import java.io.*;
// 백준 <투포인터> '용액 합성하기'
public class BOJ14921 {
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
        int answer = arr[left] + arr[right];

        while (true) {
            if(left == right) break;
            int sum = arr[left] + arr[right];

            if (Math.abs(answer) > Math.abs(sum))
                answer = sum;
            if(sum > 0) right--;
            else if(sum < 0) left++;
            else break;
        }
        System.out.println(answer);
    }
}
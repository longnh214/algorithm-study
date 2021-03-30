/**
 * @author choi
 * @date Dec 30, 2020
 * @see https://www.acmicpc.net/problem/2170
 * @mem 333,872kb
 * @time 2,564ms
 * @caution
 * [고려사항]
 * 배열을 정렬하고, result를 갱신해주는 방식으로 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
// 백준 <정렬> '선 긋기'
public class BOJ2170 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[N][2];
        int result = 0;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int left = array[0][0];
        int right = array[0][1];

        for (int i = 1; i < N; i++) {
            if (array[i][0] <= right) {
                right = Math.max(array[i][1], right);
            } else {
                result += right - left;
                left = array[i][0];
                right = array[i][1];
            }
        }
        result += right - left;
        System.out.println(result);
    }
}
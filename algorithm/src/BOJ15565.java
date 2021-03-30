
/**
 * @author choi
 * @date Dec 16, 2020
 * @see https://www.acmicpc.net/problem/15565
 * @mem 76,616kb
 * @time 360ms
 * @caution
 * [고려사항]
 * 투 포인터의 경우 O(N)을 만족해서 반복문이 절대 두 번 들어가면 안될 것 같았다.
 * 하지만 1을 뺀 후 다음 1을 찾기 위한 과정에서 반복문이 불가피하게 필요하여 될까 반복문을 두번 사용하여 푼 문제.
 * 이중 반복문으로 풀어도 투 포인터가 되는 지 신기했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
// 백준 <투포인터> '귀여운 라이언'
public class BOJ15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = -1;
        int lionCount = 0;
        int tempLen = 0;
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (start >= 0)
                tempLen++;
            if (arr[i] == 1) {
                if (start == -1) {
                    start = i;
                    tempLen++;
                }
                lionCount++;
                if (lionCount == K) {
                    if (answer > tempLen)
                        answer = tempLen;
                    while (start < i) {
                        tempLen--;
                        start++;
                        if (arr[start] == 1)
                            break;
                    }
                    lionCount--;
                }
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}
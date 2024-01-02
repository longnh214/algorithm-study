/**
 * @author nakhoon
 * @date 1/3/24
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12924
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 등차수열 (1)을 배열로 지정하고, 값을 비교하며 계산해주었다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '숫자의 표현'
public class Programmers12924 {
    public static void main(String[] args) {
        int n = 10000;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int[] sum = new int[n + 1];
        sum[0] = 0;

        //등차수열 배열 값 지정.
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + i;
        }

        int count = 0;
        int startIdx = 0;

        for (int i = 1; i <= n; i++) {
            int temp = sum[i] - sum[startIdx];
            if (temp == n) {
                count++;
                startIdx++;
                i = startIdx;
            } else if (temp > n) {
                startIdx++;
                i = startIdx;
            }
        }

        return count;
    }
}
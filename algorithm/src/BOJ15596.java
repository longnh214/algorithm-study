/**
 * @author nakhoonchoi
 * @date 2024/05/02
 * @see https://www.acmicpc.net/problem/15596
 * @mem 423,048kb
 * @time 24ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */

//백준 <수학> '정수 N개의 합'
public class BOJ15596 {
    long sum(int[] a) {
        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
}
/**
 * @author choi
 * @date Dec 4, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWyNQrCahHcDFAVP
 * @mem 17,684kb
 * @time 103ms
 * @caution
 * [고려사항]
 * bfs로 풀려고 했으나 시간 초과로 인해 패턴을 찾아서 풀었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
// SW Expert <D4> '방향 전환'
public class Solution8382 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int t = 1; t <= T; t++) {

            st = new StringTokenizer(br.readLine());

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int xSum = Math.abs(startX - endX);
            int ySum = Math.abs(startY - endY);
            int big = Math.max(xSum, ySum);
            int small = Math.min(xSum, ySum);
            int differ = big - small;
            int result = 0;

            //둘 중 작은 곳만큼 대각선 이동(대각선은 2번 이동으로 간주)
            //차이의 값이 짝수라면 차이의 두배만큼 더 이동할 것이고, 홀수라면 차이의 두배에서 차이를 2로 나눈 나머지를 빼주어야 한다.
            result = 2 * small + 2 * differ - (differ % 2);

            System.out.println("#" + t + " " + result);
        }
    }
}
/**
 * @author choi
 * @date Sep 24, 2020
 * @see https://www.acmicpc.net/problem/2477
 * @mem 12,964kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 파인 부분의 변을 찾는 방법이 잘 생각나지 않아 어려웠던 문제이다.
 * 한 변을 기준으로 앞 뒤의 변의 합이 완전한 변의 크기와 같다면, 그 한 변은 파인 부분에 속하는 변이다. 
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현> '참외밭'
public class BOJ2477 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] num = new int[6];
        int width = 0;
        int height = 0;
        int notWidth = 0;
        int notHeight = 0;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            num[i] = Integer.parseInt(st.nextToken());
        }

        // Get, max width and height
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                if (width < num[i]) {
                    width = num[i];
                }
            } else {
                if (height < num[i]) {
                    height = num[i];
                }
            }
        }

        // 한 변을 기준으로 앞 뒤 변의 길이의 합이 길이와 같다면 파인 지점
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                if (height == num[(i + 5) % 6] + num[(i + 1) % 6]) {
                    notWidth = num[i];
                }
            } else {
                if (width == num[(i + 5) % 6] + num[(i + 1) % 6]) {
                    notHeight = num[i];
                }
            }
        }

        System.out.println((width * height - notWidth * notHeight) * N);
    }
}
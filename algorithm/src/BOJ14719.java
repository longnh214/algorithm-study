/**
 * @author choi
 * @date Oct 24, 2020
 * @see https://www.acmicpc.net/problem/14719
 * @mem 13,220kb
 * @time 96ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현> '빗물'
public class BOJ14719 {
    static int [] height;
    static int W,answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        st.nextToken();
        W = Integer.parseInt(st.nextToken());

        height = new int[W];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<W;i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<W-1;i++) {
            int leftHeight = Integer.MIN_VALUE;
            int rightHeight = Integer.MIN_VALUE;

            for(int j=0;j<i;j++) {
                leftHeight = Math.max(leftHeight, height[j]);
            }

            for(int j=i+1;j<W;j++) {
                rightHeight = Math.max(rightHeight, height[j]);
            }

            int temp = Math.min(leftHeight, rightHeight);

            if(temp - height[i] < 0) continue;

            answer += (temp - height[i]);
        }

        System.out.println(answer);
    }

}

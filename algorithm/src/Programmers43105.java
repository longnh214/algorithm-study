/**
 * @author nakhoonchoi
 * @date 2024/08/13
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/43105
 * [고려사항]
 * 삼각형 층수마다 합 중 최대를 메모이제이션 해놓고,
 * 마지막 층의 끝 dp 값들 중 최대를 반환해주었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//프로그래머스 <DP> '정수 삼각형'

public class Programmers43105 {
    public static void main(String[] args) {
        int [][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        System.out.println(solution(triangle));
    }

    public static int solution(int[][] triangle) {
        int [][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        for(int i=1;i<triangle.length;i++){
            for(int j=0;j<triangle[i].length;j++){
                if(j == 0) {
                    dp[i][j] = triangle[i][j] + dp[i-1][j];
                }else if(j == triangle[i].length - 1) {
                    dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                }else{
                    dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }
        int max = 0;
        for(int i=0;i<triangle.length;i++){
            max = Math.max(max, dp[triangle.length-1][i]);
        }

        return max;
    }
}
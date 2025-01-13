/**
 * @author nakhoonchoi
 * @date 2025/01/13
 * @see https://leetcode.com/problems/unique-paths/description/
 * @mem 40.57MB
 * @time 0ms
 * @caution
 * [고려사항]
 * dp를 이용해서 문제를 해결하였다.
 * 중학생 시절 거리 구하는 수학 공식을 점화식에 대입해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//LeetCode <LeetCode 75> 'Unique Path'

public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];

        Arrays.fill(dp[0], 1);

        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
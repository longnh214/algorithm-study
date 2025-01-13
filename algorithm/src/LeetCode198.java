/**
 * @author nakhoonchoi
 * @date 2025/01/13
 * @see https://leetcode.com/problems/house-robber/description/
 * @mem 40.98MB
 * @time 0ms
 * @caution
 * [고려사항]
 * dp를 이용해서 문제를 해결하였다.
 * dp[1]의 값을 넣을 때에 nums[0]과 nums[1] 중 큰 값을 넣어야하는 점이 중요한 점이었다.
 * [입력사항]
 * [출력사항]
 */
//LeetCode <LeetCode 75> 'House Robber'

public class LeetCode198 {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[nums.length - 1];
    }
}
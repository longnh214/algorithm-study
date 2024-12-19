/**
 * @author nakhoonchoi
 * @date 2024/12/19
 * @see https://leetcode.com/problems/increasing-triplet-subsequence/description/
 * @mem 134.02MB
 * @time 2ms
 * @caution
 * [고려사항]
 * DP로 풀려고 했으나, DP를 사용하게 되면 O(N^2)의 해답밖에 생각나지 않았다.
 * O(N)으로 문제를 해결하려면, i < j < k에서,
 * i와 j를 최적의 값으로 메모이제이션 해놓고 j < k인 k 값을 찾았을 때
 * true를 반환하는 식으로 문제를 해결하면 되겠다 싶었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//LeetCode <LeetCode 75> 'Increasing Triplet Subsequence'

public class LeetCode334 {
    public static void main(String[] args) {
        int [] nums = {1,1,-2,6};
        System.out.println(increasingTriplet(nums));
    }
    public static boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i] > b){
                return true;
            }else if(nums[i] <= a){
                a = nums[i];
            }else if(nums[i] < b){
                b = nums[i];
            }
        }

        return false;
    }
}

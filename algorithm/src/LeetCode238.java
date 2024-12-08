/**
 * @author nakhoonchoi
 * @date 2024/12/09
 * @see https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=leetcode-75
 * @mem 55.36MB
 * @time 3ms
 * @caution
 * [고려사항]
 * O(N)으로 해결하기. 공간 복잡도를 O(1)로 해결하기. 나누기 연산을 사용하지 않고 문제를 풀어야했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//LeetCode <LeetCode 75> 'Product of Array Except Self'

public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        int [] answer = new int[nums.length];

        Arrays.fill(answer, 1);

        for(int i=1;i<nums.length;i++){
            answer[i] = answer[i-1] * nums[i-1];
        }

        for(int i=nums.length-2;i>=0;i--){
            nums[i] *= nums[i+1];
            answer[i] *= (nums[i+1]);
        }

        return answer;
    }
}
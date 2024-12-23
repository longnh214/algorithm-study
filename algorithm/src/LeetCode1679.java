/**
 * @author nakhoonchoi
 * @date 2024/12/23
 * @see https://leetcode.com/problems/max-number-of-k-sum-pairs/description/
 * @mem 56.91MB
 * @time 18ms
 * @caution
 * [고려사항]
 * 이전에 릿코드에서 해결한 문제 중에 입력한 배열을 수정하지 않고 풀어야하는 문제가 있어서
 * 이 문제도 똑같이 수정하는 것이 불가하다면 엄청 어려웠을 것같다.
 *
 * 먼저 배열을 오름차순으로 정렬해준 다음에
 * 투 포인터 알고리즘을 이용해서 합이 k인 개수를 세어주었다.
 * [입력사항]
 * [출력사항]
 */

//LeetCode <LeetCode 75> 'Max Number of K-Sum Pairs'

public class LeetCode1679 {
    public int maxOperations(int[] nums, int k) {
        int left = 0;
        int right = nums.length-1;
        int count = 0;

        Arrays.sort(nums);

        while(left < right){
            if(nums[left] + nums[right] == k){
                count++;
                left++;
                right--;
            }else if(nums[left] + nums[right] < k){
                left++;
            }else{
                right--;
            }
        }

        return count;
    }
}
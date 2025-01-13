/**
 * @author nakhoonchoi
 * @date 2025/01/13
 * @see https://leetcode.com/problems/find-peak-element/description/
 * @mem 42.16MB
 * @time 0ms
 * @caution
 * [고려사항]
 * 재귀를 이용해서 반씩 나누어서 탐색하려고 했다.
 * 하지만 이분탐색 lower_bound로 구현할 수도 있는 문제였다.
 * [입력사항]
 * [출력사항]
 */
//LeetCode <LeetCode 75> 'Find Peak Element'

public class LeetCode162 {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        //{2,1} 대응
        int result = findPeakRecursion(nums, 0, nums.length - 1);
        if(result != -1){
            return result;
        }

        return findPeakRecursion(nums, 0, nums.length);
    }

    public int findPeakRecursion(int [] nums, int left, int right){
        while(left < right){
            int mid = (left + right) / 2;
            if(mid == 0 && nums[mid] > nums[mid + 1]){
                return mid;
            }else if(mid == nums.length - 1 && nums[mid] > nums[mid - 1]){
                return mid;
            }else if(nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]){
                return mid;
            }

            int leftResult = findPeakRecursion(nums, left, mid);
            int rightResult = findPeakRecursion(nums, mid+1, right);

            if(leftResult != -1){
                return leftResult;
            }else{
                return rightResult;
            }
        }
        return -1;
    }

    public int findPeakElement2(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            // mid와 mid+1을 비교하여 탐색 방향 결정
            if (nums[mid] > nums[mid + 1]) {
                // 피크는 mid 또는 그 왼쪽에 존재
                right = mid;
            } else {
                // 피크는 mid+1 또는 그 오른쪽에 존재
                left = mid + 1;
            }
        }
        // 최종적으로 left == right가 피크 인덱스를 가리킴
        return left;
    }
}
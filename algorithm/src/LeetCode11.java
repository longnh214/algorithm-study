/**
 * @author nakhoonchoi
 * @date 2024/12/22
 * @see https://leetcode.com/problems/container-with-most-water/description/
 * @mem 58.42MB
 * @time 4ms
 * @caution
 * [고려사항]
 * 기본적인 투 포인터 문제였다.
 * left++, right-- 방식으로 범위를 좁혀가면서 문제를 해결했다.
 * [입력사항]
 * [출력사항]
 */
//LeetCode <LeetCode 75> 'Container With Most Water'

public class LeetCode11 {
    public int maxArea(int[] height) {
        int answer = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;

        while(leftIndex < rightIndex){
            answer = Math.max(answer, Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex));

            if(height[leftIndex] < height[rightIndex]){
                leftIndex++;
            }else{
                rightIndex--;
            }

        }

        return answer;
    }
}
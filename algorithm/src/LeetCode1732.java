/**
 * @author nakhoonchoi
 * @date 2024/12/29
 * @see https://leetcode.com/problems/find-the-highest-altitude/description/
 * @mem 41.37MB
 * @time 0ms
 * @caution
 * [고려사항]
 * 누적합 문제인가? 싶었다.
 * gain 배열을 순회하면서 누적합을 하고, 그 누적합 중 최대값을 반환하면 되는 문제였다.
 * [입력사항]
 * [출력사항]
 */
//LeetCode <LeetCode 75> 'Find the Highest Altitude'

public class LeetCode1732 {
    public int largestAltitude(int[] gain) {
        int answer = 0;
        int sum = 0;
        for(int i=0;i<gain.length;i++){
            sum += gain[i];
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
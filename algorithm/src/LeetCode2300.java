/**
 * @author nakhoonchoi
 * @date 2025/01/13
 * @see https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/
 * @mem 67.16MB
 * @time 40ms
 * @caution
 * [고려사항]
 * 자바로 lower_bound를 구현해야하는 문제였다.
 * 먼저 정렬을 해준 뒤에 이분탐색을 통해 spell * potions의 값이
 * success보다 크거나 같은 가장 작은 인덱스를 left에서 반환하기 때문에
 * potions.length - left를 answer에 담아주면 되었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//LeetCode <LeetCode 75> 'Successful Pairs Of Spells and Potions'

public class LeetCode2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int [] answer = new int[spells.length];

        Arrays.sort(potions);

        for(int i=0;i<spells.length;i++){
            int left = 0;
            int right = potions.length;

            while(left < right){
                int mid = (left + right) / 2;
                if((long) spells[i] * potions[mid] >= success){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }
            answer[i] = potions.length - left;
        }
        return answer;
    }
}
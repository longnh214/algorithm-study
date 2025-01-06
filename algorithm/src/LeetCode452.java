/**
 * @author nakhoonchoi
 * @date 2025/01/06
 * @see https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
 * @mem 69.27MB
 * @time 55ms
 * @caution
 * [고려사항]
 * 2차원 배열 points를 0번 인덱스와 1번 인덱스를 기반으로 오름차순 정렬하고
 * left와 right로 화살의 유효한 범위를 주어서
 * 다음 point가 화살의 유효한 범위에 포함된다면 화살을 추가하지 않고,
 * 포함되지 않는 다면 화살을 추가하고 left와 right를 갱신하는 방식으로 풀었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//LeetCode <LeetCode 75> 'Minimum Number of Arrows to Burst Balloons'

public class LeetCode452 {
    public int findMinArrowShots(int[][] points) {
        int answer = 1;

        Arrays.sort(points, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        int left = points[0][0];
        int right = points[0][1];

        for(int i=1;i<points.length;i++){
            if(points[i][0] >= left && points[i][0] <= right){
                left = points[i][0];

                if(points[i][1] < right){
                    right = points[i][1];
                }
            }else{
                answer++;
                left = points[i][0];
                right = points[i][1];
            }
        }
        return answer;
    }
}
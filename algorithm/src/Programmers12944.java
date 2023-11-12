/**
 * @author nakhoonchoi
 * @date 2023/11/12
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12944
 * @mem
 * @time
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '평균 구하기'
public class Programmers12944 {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4};
        System.out.println(solution(arr));
    }

    public static double solution(int[] arr) {
        double answer = 0;
        for(int i=0;i<arr.length;i++){
            answer += arr[i];
        }
        return answer / arr.length;
    }
}

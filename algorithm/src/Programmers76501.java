/**
 * @author nakhoon
 * @date 11/6/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/76501
 * @mem
 * @time
 * @caution
 * [고려사항] absolutes 배열을 순회하면서 현재 수의 음수/양수를 곱해서 더한 값을 answer로 반환하면 되는 문제이다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '음양 더하기'
public class Programmers76501 {
    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i=0;i< absolutes.length;i++){
            answer += (signs[i] ? absolutes[i] : -1 * absolutes[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] absolutes = {4,7,12};
        boolean [] signs = {true, false, true};

        System.out.println(solution(absolutes, signs));
    }
}
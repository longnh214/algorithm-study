/**
 * @author nakhoonchoi
 * @date 2023/11/05
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/142086
 * @mem
 * @time
 * @caution
 * [고려사항] 각 문자열의 문자를 순회하면서 좌표를 alpha 배열에 저장하고, 그 배열 값이 -1이라면 그대로 정답 리스트에 넣고, 아니라면 좌표의 차이만큼을 정답 리스트에 넣는다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

//프로그래머스 <연습문제> '가장 가까운 같은 글자'
public class Programmers142086 {
    public static void main(String[] args) {
        String s = "banana";
        System.out.println(Arrays.toString(solution(s)));
    }

    public static int[] solution(String s) {
        int [] alpha = new int[26];

        Arrays.fill(alpha, -1);

        List<Integer> answerList = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            answerList.add(alpha[s.charAt(i) - 'a'] == -1 ? alpha[s.charAt(i) - 'a'] : i - alpha[s.charAt(i) - 'a']);

            alpha[s.charAt(i) - 'a'] = i;
        }

        return answerList.stream().mapToInt(i -> i).toArray();
    }
}
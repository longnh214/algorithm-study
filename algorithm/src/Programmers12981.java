/**
 * @author nakhoon
 * @date 1/7/24
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12981
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 중복 제거를 위해서 HashSet을 이용하였고, 실패의 경우(중복이거나 글자를 틀린 경우)에 answer 배열 값을 지정하는 로직으로
 * 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

//프로그래머스 <연습문제> '영어 끝말잇기'
public class Programmers12981 {
    public static void main(String[] args) {
        int n = 5;
        String [] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        System.out.println(Arrays.toString(solution(n, words)));
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        answer[0] = 0;
        answer[1] = 0;

        Set<String> alreadySpeakSet = new HashSet<>();

        for(int i=0;i<words.length;i++){
            if(alreadySpeakSet.contains(words[i]) || (i > 0 && words[i-1].charAt(words[i-1].length() - 1) != words[i].charAt(0))){
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;

                break;
            }

            alreadySpeakSet.add(words[i]);
        }
        return answer;
    }
}

/**
 * @author nakhoon
 * @date 12/7/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12930
 * @mem
 * @time
 * @caution
 * [고려사항]
 * String s 안에 공백이 두 개씩 있을 경우에 대해서는 처리가 안되었기 때문에 실패가 났었다.
 * String.split 함수에 인자가 2개인 메소드도 있는데, 첫 번째 인자는 배열이고, 두 번째 인자는 음수일 경우에는 구분값의 연속 개수,
 * 양수인 경우에는 split할 배열의 크기 제한을 의미한다는 것을 처음 알았다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '이상한 문자 만들기'
public class Programmers12930 {
    public static void main(String[] args) {
        String s = "try hello world";

        System.out.println(solution(s));
    }

    public static String solution(String s) {
        String [] words = s.split(" ", -1);
        for(int i=0;i<words.length;i++){
            words[i] = makeStrangeWord(words[i]);
        }
        return String.join(" ", words);
    }

    public static String makeStrangeWord(String word){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<word.length();i++){
            sb.append(i % 2 == 0 ? Character.toUpperCase(word.charAt(i)) : Character.toLowerCase(word.charAt(i)));
        }
        return sb.toString();
    }
}

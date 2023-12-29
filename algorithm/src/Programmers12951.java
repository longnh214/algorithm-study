/**
 * @author nakhoon
 * @date 12/29/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12951
 * @mem
 * @time
 * @caution
 * [고려사항]
 * Java 기준 공백 split으로 풀면 안되고, 각 char형을 조건에 따라 분기처리해서 StringBuilder에 추가해야하는
 * 문제였다. testcase 8번에 대한 반례가 main 함수 s 문자열에 기록되어있다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> 'JadenCase 문자열 만들기'
public class Programmers12951 {
    public static void main(String[] args) {
        String s = "  for the what 1what  ";
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                sb.append(' ');
            }else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                sb.append(s.charAt(i));
            }else if(i == 0 || s.charAt(i - 1) == ' '){
                sb.append(Character.toUpperCase(s.charAt(i)));
            }else{
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        return sb.toString();
    }
}
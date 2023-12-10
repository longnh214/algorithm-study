/**
 * @author nakhoonchoi
 * @date 2023/12/10
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12926
 * @mem
 * @time
 * @caution
 * [고려사항]
 * Character.isLowerCase()와 isUpperCase()를 통해 대소문자를 나누고, z에 1을 더하면 a로 이동할 수 있도록 mod 연산을 해주었다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '시저 암호'
public class Programmers12926 {
    public static void main(String[] args) {
        String s = "a B z";
        int n = 4;
        System.out.println(solution(s, n));
    }

    public static String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isLowerCase(c)){
                int count = c - 'a';
                sb.append((char)('a' + ((count + n) % 26)));
            }else if(Character.isUpperCase(c)){
                int count = c - 'A';
                sb.append((char)('A' + ((count + n) % 26)));
            }else{
                sb.append(c);
            }
        }

        return sb.toString();
    }
}

/**
 * @author nakhoon
 * @date 11/13/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12916
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 문자열 문자를 순회하면서 Character.toLowerCase를 통해 소문자로 변환 후 p와 y의 개수를 판별해서 비교했다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '문자열 내 p와 y의 개수
public class Programmers12916 {
    public static boolean solution(String s) {
        int pCount = 0;
        int yCount = 0;
        for(int i=0;i<s.length();i++){
            if(Character.toLowerCase(s.charAt(i)) == 'p'){
                pCount++;
            }else if(Character.toLowerCase(s.charAt(i)) == 'y'){
                yCount++;
            }
        }
        return pCount == yCount;
    }

    public static void main(String[] args) {
        String s = "pPoooyY";
        System.out.println(solution(s));
    }

}
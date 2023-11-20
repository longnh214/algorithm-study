/**
 * @author nakhoon
 * @date 11/20/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12919
 * @mem
 * @time
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '서울에서 김서방 찾기'
public class Programmers12919 {
    public static void main(String[] args) {
        String [] seoul = {"Jane", "Kim"};
    }

    public static String solution(String[] seoul) {
        for(int i=0;i<seoul.length;i++){
            if(seoul[i].equals("Kim")){
                return "김서방은 " + i + "에 있다";
            }
        }
        return null;
    }
}

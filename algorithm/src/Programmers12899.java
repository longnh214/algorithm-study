/**
 * @author nakhoon
 * @date Dec 13, 2021
 * @see https://programmers.co.kr/learn/courses/30/lessons/12899
 */
//프로그래머스 <코딩테스트 연습> '124 나라의 숫자'
public class Programmers12899 {

	public static void main(String[] args) {
		int n = 1;
		System.out.println(solution(n));
	}
	public static String solution(int n) {
        String [] remains = {"4","1","2"};
        String answer = "";
        int num = n;
        while(num > 0) {
        	int remain = num % 3;
        	num /= 3;
        	
        	if(remain == 0) num--;
        	
        	answer = remains[remain] + answer;
        }
        return answer;
    }
}
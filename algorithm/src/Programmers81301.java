/**
 * @author nakhoon
 * @date Sep 19, 2021
 */
//프로그래머스 <카카오 2021 채용연계형 인턴> '숫자 문자열과 영단어'
public class Programmers81301 {
	public static void main(String[] args) {
		String s = new String("oneoneone");
		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
        String answerStr = s.replace("one", "1").replace("two", "2").replace("three", "3").replace("four", "4").replace("five", "5").replace("six", "6").replace("seven", "7").replace("eight", "8").replace("nine", "9").replace("zero", "0");
        return Integer.parseInt(answerStr);
    }
}
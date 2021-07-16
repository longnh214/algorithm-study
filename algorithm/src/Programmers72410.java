/**
 * @author nakhoon
 * @date Jul 17, 2021
 * @see https://programmers.co.kr/learn/courses/30/lessons/72410?language=java
 * @mem
 * @time
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
//프로그래머스 <카카오 2021 블라인드> '신규 아이디 추천'
public class Programmers72410 {
	public static void main(String[] args) {
		System.out.println(solution("...!@BaT#*~..y.abcdefghijklm"));
		System.out.println(solution("z-+.^."));
		System.out.println(solution("=.="));
		System.out.println(solution("123_.def"));
		System.out.println(solution("abcdefghijklmn.p"));
		System.out.println(solution("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL"));
		System.out.println(solution("aabbaccc"));
		System.out.println(solution("ㅏ"));
	}

	public static String solution(String new_id) {
		//1단계
		new_id = new_id.toLowerCase();
		
		//2단계
		new_id = new_id.replace("~", "");
		new_id = new_id.replace("!", "");
		new_id = new_id.replace("@", "");
		new_id = new_id.replace("#", "");
		new_id = new_id.replace("$", "");
		new_id = new_id.replace("%", "");
		new_id = new_id.replace("^", "");
		new_id = new_id.replace("&", "");
		new_id = new_id.replace("*", "");
		new_id = new_id.replace("(", "");
		new_id = new_id.replace(")", "");
		new_id = new_id.replace("=", "");
		new_id = new_id.replace("+", "");
		new_id = new_id.replace("[", "");
		new_id = new_id.replace("{", "");
		new_id = new_id.replace("]", "");
		new_id = new_id.replace("}", "");
		new_id = new_id.replace(":", "");
		new_id = new_id.replace("?", "");
		new_id = new_id.replace(",", "");
		new_id = new_id.replace("<", "");
		new_id = new_id.replace(">", "");
		new_id = new_id.replace("/", "");
		
		//3단계
		while(new_id.contains("..")) {
			new_id = new_id.replace("..", ".");
		}
		
		//4단계
		if(new_id.length() > 0 && new_id.charAt(0) == '.') {
			new_id = new_id.substring(1, new_id.length());
		}
		if(new_id.length() > 0 && new_id.charAt(new_id.length()-1) == '.') {
			new_id = new_id.substring(0, new_id.length()-1);
		}
		
		//5단계
		if(new_id.length() == 0) {
			new_id = new String("a");
		}
		
		//6단계
		if(new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
			if(new_id.length() > 0 && new_id.charAt(new_id.length()-1) == '.') {
				new_id = new_id.substring(0, new_id.length()-1);
			}
		}
		
		//7단계
		if(new_id.length() <= 2) {
			StringBuilder sb = new StringBuilder(new_id);
			char last = new_id.charAt(new_id.length()-1);
			while(sb.length() < 3) {
				sb.append(last);
			}
			new_id = sb.toString();
		}
		
		//System.out.println(new_id);
		return new_id;
	}

}
/**
 * @author nakhoon
 * @date Dec 11, 2021
 * @see https://programmers.co.kr/learn/courses/30/lessons/60058
 */
//프로그래머스 <2020 카카오 공채 블라인드> '괄호 변환'
public class Programmers60058 {

	public static void main(String[] args) {
			String p = "(()())()";
			String p1 = ")(";
			String p2 = "()))((()";
			
			System.out.println(solution(p));
			System.out.println(solution(p1));
			System.out.println(solution(p2));
	}
	
	 public static String solution(String p) {
	        StringBuilder sb = new StringBuilder();
	        //1단계
	        if(p.length() == 0) return "";
	        //2단계
	        String u = null;
	        String v = null;
	        int left = 0;
	        int right = 0;
	        for(int i=0;i<p.length();i++) {
	        	if(p.charAt(i) == '(') left++;
	        	else if(p.charAt(i) == ')') right++;
	        	if(left != 0 && left == right) {
	        		u = p.substring(0,i+1);
	        		v = p.substring(i+1,p.length());
	        		break;
	        	}
	        }
	        if(check(u)) {
	        	sb.append(u);
	        	sb.append(solution(v));
	        }else {
	        	sb.append("(");
	        	sb.append(solution(v));
	        	sb.append(")");
	        	for(int i=1;i<u.length()-1;i++) {
	        		if(u.charAt(i) == '(') sb.append(")");
	        		else if(u.charAt(i) == ')') sb.append("(");
	        	}
	        }
	        return sb.toString();
	 }
	 
	 public static boolean check(String p) {
		 int left = 0;
		 int right = 0;
		 for(int i=0;i<p.length();i++) {
			 if(p.charAt(i) == '(') left++;
			 else if(p.charAt(i) == ')') right++;
			 if(left < right) return false;
		 }
		 return true;
	 }
}
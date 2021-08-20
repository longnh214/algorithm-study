/**
 * @author nakhoon
 * @date Aug 20, 2021
 * @see https://www.acmicpc.net/problem/4828
 * @mem 60,360kb
 * @time 504ms
 * @caution
 * [고려사항]
 * 7시간 동안 풀었던 문제...이다. <a><<a/>/a>와 같은 테스트케이스가 있다는 것을 몰랐다면 풀 수 없었던 문제...
 * 태그 검증을 할 때 <br/>과 같이 open과 close가 한꺼번에 되는 태그도 태그 검증이 끝나면 같이 제거를 해주어야 한다.
 * xml 파싱은 어렵다... 예외 처리가 너무 어려웠던 문제. 
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
import java.util.regex.*;
//백준 <정규 표현식> 'XML'
public class BOJ4828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		
		outer : while((input = br.readLine()) != null) {
			//escape 문자 제거
			input = input.replaceAll("&(amp|lt|gt);","");
			
			//16진수 짝수 자리 검증
			Matcher m = Pattern.compile("&x[a-fA-F0-9]+;").matcher(input);
			
			while(m.find()) {
				String hex = m.group().replaceAll("[&x;]","");
				if(hex.length() % 2 != 0) {
					System.out.println("invalid");
					continue outer;
				}
			}
			
			input = input.replaceAll("&x[a-fA-F0-9]+;", "");
			
			//태그 검증
			Stack<String> stack = new Stack<>();
			
			m = Pattern.compile("</?[a-z0-9]+>").matcher(input);
			
			while(m.find()) {
				String tag = m.group();
				if(tag.startsWith("</")) {
					//스택이 비어있는 경우
					if(stack.isEmpty()) {
						System.out.println("invalid");
						continue outer;
					}
					String openTag = stack.pop().replaceAll("[<>/]","");
					String closeTag = tag.replaceAll("[<>/]","");
					
					if(!openTag.equals(closeTag)) {
						System.out.println("invalid");
						continue outer;
					}
				}else {
					if(!tag.contains("/"))
						stack.push(tag);
				}
			}
			
			if(!stack.isEmpty()) {
				System.out.println("invalid");
				continue outer;
			}
			
			//여기에서 <br/>과 같은 태그를 제거해주어야 한다.
			//위에서 태그 검증은 다 끝난 상태이므로 전부 제거해주어야 한다.
			input = input.replaceAll("</?[a-z0-9]+/?>", "");
			
			
			//<,>,&은 포함하면 안된다.
			if(input.contains("<") || input.contains(">") || input.contains("&")) {
				System.out.println("invalid");
				continue outer;
			}
			
			//32~127의 값만 포함해야한다.
			for(char ch : input.toCharArray()) {
				if(ch < 32 || ch > 127) {
					System.out.println("invalid");
					continue outer;
				}
			}
			
			//위의 결과에 안 거친다면 valid한 태그
			System.out.println("valid");
		}
	}
}
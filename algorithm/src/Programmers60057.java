/**
 * @author nakhoon
 * @date Dec 7, 2021
 * @see https://programmers.co.kr/learn/courses/30/lessons/60057
 * @caution
 * 	[고려사항]
 * StringBuilder를 통해 문자열을 직접 만들어주지 않아도 자릿수만 더해주는 방법으로도 풀 수 있다.
 * [입력사항]
 * [출력사항]
 */
// 프로그래머스 <카카오 2020 블라인드 공채> '문자열 압축'
public class Programmers60057 {
	
	public static void main(String[] args) {
		String s = "aabbaccc";
		String s1 = "ababcdcdababcdcd";
		String s2 = "abcabcdede";
		String s3 = "abcabcabcabcdededededede";
		String s4 = "xababcdcdababcdcd";
		System.out.println(solution(s));
		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
		System.out.println(solution(s4));
	}
	
	public static int solution(String s) {
		int answer = s.length();
		for (int i = 1; i < s.length() / 2+1; i++) {
			int count = 0;
			StringBuilder sb = new StringBuilder();
			String standard = s.substring(0, i);
			for (int j = i; j < s.length(); j += i) {
				String next = j + i < s.length() ? s.substring(j, j + i) : s.substring(j, s.length());
				if (standard.equals(next)) {
					count++;
					standard = next;
				} else {
					if (count != 0) {
						sb.append(count + 1);
					}
					sb.append(standard);
					standard = next;
					count = 0;
				}
			}

			if (count != 0) {
				sb.append(count + 1);
			}
			sb.append(standard);

			answer = Math.min(sb.length(), answer);
		}
		return answer;
	}
}
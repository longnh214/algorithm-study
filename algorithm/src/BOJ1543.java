/**
 * @author nakhoon
 * @date Feb 21, 2022
 * @see https://www.acmicpc.net/problem/1543
 * @mem 12,440kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 자바에서 replace 함수는 한번에 해당되는 모든 문자열을 바꿔버리기 때문에, replaceFirst 함수를 이용해서
 * 해당되는 문자 하나만 바꿔줄 때마다 count를 더하는 방식으로 문제를 해결했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <그리디> '문서 검색'
public class BOJ1543 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String standard = br.readLine();
		int count = 0;
		while(str.contains(standard)) {
			str = str.replaceFirst(standard,"_");
			count++;
		}
		System.out.println(count);
	}
}
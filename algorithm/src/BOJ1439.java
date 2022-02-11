/**
 * @author nakhoon
 * @date Feb 11, 2022
 * @see https://www.acmicpc.net/problem/1439
 * @mem 11,496kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 숫자가 몇번 바뀌는 지를 체크해서 최소 몇 번 바꾸면 되는 지 계산을 해주었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <그리디> '뒤집기'
public class BOJ1439 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int count = 0;
		for(int i=1;i<input.length();i++) {
			if(input.charAt(i) != input.charAt(i-1))
				count++;
		}
		System.out.println((count+1)/2);
	}
}
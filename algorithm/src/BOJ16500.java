
/**
 * @author nakhoon
 * @date Dec 9, 2021
 * @see https://www.acmicpc.net/problem/16500
 * @mem 11,832kb
 * @time 76ms
 * @caution
 *[고려사항]
 * 맨 뒤부터 단어를 하나하나씩 체크해서 만들 수 있으면 dp 값을 바꾸고 dp[0]의 값이 1이 되었을 때 반복문을 탈출하고
 * dp[0]을 출력하면 됐다.
 *[입력사항]
 *[출력사항]
 */
import java.io.*;
// 백준 <문자열,DP> '문자열 판별'
public class BOJ16500 {
	static int [] dp;
	static String [] strArr;
	static String target;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		target = br.readLine();
		
		int size = Integer.parseInt(br.readLine());
		strArr = new String[size];
		dp = new int[target.length() + 1];
		
		for (int i = 0; i < size; i++) {
			strArr[i] = br.readLine();
		}
		
		dp[target.length()] = 1;
		
		outer: for(int i=target.length();i>=0;i--) {
			if(dp[i] != 1) continue;
			for(String current : strArr) {
				if(i - current.length() >= 0) {
					String tempStr = target.substring(i-current.length(),i);
					if(tempStr.equals(current)) {
						if(dp[i] == 1) {
							dp[i-current.length()] = 1;
							if(i- current.length() == 0) break outer;
						}
					}
				}
			}
		}
		System.out.println(dp[0]);
	}
}
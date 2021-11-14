/**
 * @author nakhoon
 * @date Nov 14, 2021
 * @see https://www.acmicpc.net/problem/11723
 * @mem 326,676kb
 * @time 1,232ms
 * @caution
 * [고려사항]
 * check가 접근이 전혀 안되는 문제가 있어서(정답이 공백)
 * System.out.println(sb.substring(0,sb.length()-1));에서 sb.length()가 음수로 되어 오류가 발생할 수 있는 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <비트마스킹> '집합'
public class BOJ11723 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int set = 0;
		StringBuilder sb = new StringBuilder();
		
		while(T-->0) {
			String [] cmd = br.readLine().split(" ");
			int x;
			switch(cmd[0]) {
			case "add":
				x = Integer.parseInt(cmd[1]);
				set = set | 1 << (x-1);
				break;
			case "remove":
				x = Integer.parseInt(cmd[1]);
				set = set & ~(1 << (x-1));
				break;
			case "check":
				x = Integer.parseInt(cmd[1]);
				sb.append((set & (1<< (x-1))) == 0 ? "0\n" : "1\n");
				break;
			case "toggle":
				x = Integer.parseInt(cmd[1]);
				set = set ^ 1 << (x-1);
				break;
			case "all":
				set = (1 << 20) - 1;
				break;
			case "empty":
				set = 0;
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
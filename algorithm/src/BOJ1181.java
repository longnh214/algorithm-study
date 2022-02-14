/**
 * @author nakhoon
 * @date Feb 14, 2022
 * @see https://www.acmicpc.net/problem/1181
 * @mem 29,724kb
 * @time 308ms
 * @caution
 * [고려사항]
 * 문자열을 입력 받을 때 중복을 제거해주어야 했다. Set과 List를 이용해서 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <문자열> '단어 정렬'
public class BOJ1181 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		for(int i=0;i<N;i++) {
			set.add(br.readLine());
		}
		
		List<String> list = new ArrayList<>(set); 
		
		Collections.sort(list, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return Integer.compare(o1.length(),o2.length());
			}
		});
		StringBuilder sb = new StringBuilder();
		for(String str : list) {
			sb.append(str).append("\n");
		}
		System.out.println(sb.toString());
	}
}
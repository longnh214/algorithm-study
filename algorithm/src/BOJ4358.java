/**
 * @author nakhoon
 * @date Jun 30, 2021
 * @see https://www.acmicpc.net/problem/4358
 * @mem 89,684kb
 * @time 564ms
 * @caution
 * [고려사항]
 * 입력 방식이 평소와 달라서 어려웠던 문제이다. 외에는 트리맵을 쓸 수도 있었지만 해시맵을 이용해서 풀었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <트리맵> '생태학'
public class BOJ4358 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String,Integer> map = new HashMap<>();
		int count = 0;
		String key = br.readLine();
		while(true) {
			count++;
			map.put(key, map.getOrDefault(key, 0) + 1);
			key = br.readLine();
			if(key == null || key.length() == 0) {
				break;
			}
		}
		
		Object [] keys = map.keySet().toArray();
		
		Arrays.sort(keys);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<keys.length;i++) {
			String keyStr = (String)keys[i];
			double per = (double)(map.get(keyStr) * 100) / count;
			
			sb.append(keyStr + " " + String.format("%.4f", per) + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
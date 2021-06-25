/**
 * @author nakhoon
 * @date Jun 25, 2021
 * @see https://www.acmicpc.net/problem/7662
 * @mem 303,252kb
 * @time 2,088ms
 * @caution
 * [고려사항]
 * 키 값을 정렬해주는 트리맵을 이용하면 쉽게 풀 수 있었다.
 * 맨 처음에는 우선순위 큐를 두개 사용하려했었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <우선순위큐> '이중 우선순위 큐'
public class BOJ7662 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			
			TreeMap<Integer,Integer> tMap = new TreeMap<>();
			
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				if(command.equals("I")) {
					tMap.put(num, tMap.getOrDefault(num, 0)+1);
				}else {
					if(tMap.size() == 0)
						continue;
					
					int key = num == 1 ? tMap.lastKey() : tMap.firstKey();
					tMap.put(key, tMap.get(key) - 1);
					
					if(tMap.get(key) == 0) {
						tMap.remove(key);
					}
				}
			}
			
			System.out.println(tMap.size() == 0 ? "EMPTY" : tMap.lastKey() + " " + tMap.firstKey());
		}
	}
}
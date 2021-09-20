/**
 * @author nakhoon
 * @date Sep 20, 2021
 * @see https://www.acmicpc.net/problem/23059
 * @mem 215,404kb
 * @time 2,396ms
 * @caution
 * [고려사항]
 * 해시맵과 위상 정렬을 이용하여 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <위상 정렬> '리그 오브 레게노'
public class BOJ23059 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> indegreeMap = new HashMap<>();
		Map<String, List<String>> nextItemMap = new HashMap<>();
		Set<String> itemSet = new HashSet<>();
 		
		PriorityQueue<String> pq = new PriorityQueue<>();
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			String firstItem = st.nextToken();
			String secondItem = st.nextToken();
			
			List<String> curList = nextItemMap.getOrDefault(firstItem, new ArrayList<>());
			
			curList.add(secondItem);
			
			itemSet.add(firstItem);
			itemSet.add(secondItem);
			
			nextItemMap.put(firstItem, curList);
			indegreeMap.put(firstItem, indegreeMap.getOrDefault(firstItem, 0));
			indegreeMap.put(secondItem, indegreeMap.getOrDefault(secondItem, 0) + 1);
		}
		
		for(String item : indegreeMap.keySet()) {
			if(indegreeMap.get(item) == 0) {
				pq.offer(item);
			}
		}
		int count = 0;
		StringBuilder sb = new StringBuilder();
		
		Queue<String> q = new LinkedList<>();
		while(!pq.isEmpty()) {
			int size = pq.size();
			for(int i=0;i<size;i++) {
				String curItem = pq.poll();
				sb.append(curItem + "\n");
				count++;
				
				if(nextItemMap.get(curItem) == null) continue; 
				for(String nextItem : nextItemMap.get(curItem)) {
					indegreeMap.put(nextItem, indegreeMap.get(nextItem)-1);
					if(indegreeMap.get(nextItem) == 0) {
						q.offer(nextItem);
					}
				}
			}
			while(!q.isEmpty()) {
				pq.offer(q.poll());
			}
		}
		System.out.print(count == itemSet.size() ? sb.substring(0, sb.length()-1) : -1);
	}
}
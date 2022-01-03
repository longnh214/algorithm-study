/**
 * @author nakhoon
 * @date Jan 3, 2022
 * @see https://www.acmicpc.net/problem/2262
 * @mem 11,656kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 그리디 문제를 어려워해서 생각보다 오래 걸렸던 문제이다. int 리스트에서 최대값의 위치를 찾아서 양쪽의 수를 비교한 뒤,(양쪽이 없다면 한쪽으로 고정)
 * 두 수 중 큰 수와 최대 등 수의 값의 차를 answer에 더해주면서 최대값을 리스트에서 삭제 해주었다.
 * 위와 같은 것을 list의 크기가 1이 될 때 까지(1등만 남을 때까지) 반복해서 풀 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '토너먼트 만들기'
public class BOJ2262 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int answer = 0;
		
		while(list.size() > 1) {
			int max = Integer.MIN_VALUE;
			for(int i=0;i<list.size();i++) {
				max = Math.max(max, list.get(i));
			}
			int maxIndex = list.indexOf(max);
			int targetIndex = -1;
			if(maxIndex == 0) {
				targetIndex = 1;
			}else if(maxIndex == list.size() - 1) {
				targetIndex = maxIndex - 1;
			}else {
				targetIndex = list.get(maxIndex - 1) < list.get(maxIndex + 1) ? maxIndex + 1 : maxIndex - 1;
			}
			answer += (list.get(maxIndex) - list.get(targetIndex));
			list.remove(maxIndex);
		}	
		System.out.println(answer);
	}
}
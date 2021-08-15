/**
 * @author nakhoon
 * @date Aug 16, 2021
 * @see https://www.acmicpc.net/problem/8111
 * @mem 14,508kb
 * @time 120ms
 * @caution
 * [고려사항]
 * 100 % 7 과, (10 % 7) + '0'을 붙인 30 % 7의 값은 같다.
 * 즉 0이나 1을 붙인 값의 나머지와 나머지에 0이나 1을 붙이고 나머지한 값은 같다는 점이 중요하다.
 * map에는 (현재 나머지, 다음에 올 숫자) 형식으로 저장하고, 
 * parent의 인덱스는 현재 나머지를 의미하고, 값은 현재 부모값을 의미한다. 나머지가 나오게 한 값
 * parent[나머지] = 나머지가 나오게 한 값
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS> '0과 1'
public class BOJ8111 {
	static int N;
	static Queue<Integer> q;
	static Map<Integer,Character> map;
	static int [] parent;
	static boolean []  visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			
			if(N == 1 ) {
				System.out.println(1);
				continue;
			}
			
			map = new HashMap<>();
			visited = new boolean[N];
			parent = new int[20000];
			
			bfs();
			
			System.out.println(answer(0));
		}
	}
	
	public static void bfs() {
		q = new LinkedList<>();
		
		q.offer(1);
		parent[1] = -1; //끝임을 알려주는 -1을 대입
		map.put(1,'1'); //맨 처음 값은 1로 확정
		visited[1] = true;//나머지가 1일 때는 이미 방문했다.(1은 1 이외의 값으로 나누면 무조건 나머지 1.)
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			int [] nextNum = {(cur * 10) % N, (cur * 10 + 1) % N}; //다음 숫자를 배열로 선언 1 -> (10,11), 10 -> (100, 101)
			
			for(int i=0;i<nextNum.length;i++ ) {
				if(visited[nextNum[i]]) continue;
				
				// 새로운 나머지가 나왔을 때 어떤 수를 뒤에 붙였는 지 기록한다.
				// 숫자를 char형으로 바꿔서 map에 추가
				map.put(nextNum[i], (char)(i +'0'));
				// 출력을 위한 순서를 기록하기 위해 부모를 기억
				parent[nextNum[i]] = cur;
				if(nextNum[i] == 0) return; // 나누어 떨어진다면 함수 끝.
				
				visited[nextNum[i]] = true; // 나머지 방문 처리
				q.offer(nextNum[i]);
			}
		}
	}
	
	public static String answer(int index) {
		if(index == -1) {
			return "";
		}
		return answer(parent[index]) + map.get(index);
	}
}
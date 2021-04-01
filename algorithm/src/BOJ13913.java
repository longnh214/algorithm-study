/**
 * @author nakhoon
 * @date Apr 2, 2021
 * @see https://www.acmicpc.net/problem/13913
 * @mem 30,220kb
 * @time 260ms
 * @caution
 * [고려사항]
 * +1, -1, *2 순으로 큐에 넣어야만 정답을 받을 수 있었다. 왜... *2로 시작하면 틀릴까...
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS> '숨바꼭질 4'
public class BOJ13913 {
	static int N,K;
	static int [] time = new int[100001];
	static int [] parent = new int[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs();
		int pushItem = K;
		
		Stack<Integer> stack = new Stack<>();
		stack.push(pushItem);
		
		while(pushItem != N) {
			stack.push(parent[pushItem]);
			pushItem = parent[pushItem];
		}
			
		StringBuilder sb = new StringBuilder();
		sb.append(time[K] + "\n");
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb.toString());
	}
	
	public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(cur==K) {
            	break;
            }
            if(cur+1 <= 100000 && time[cur+1] == 0) {
                q.offer(cur+1);
                time[cur+1] = time[cur] + 1;
                parent[cur+1] = cur;
            }
            if(cur-1 >= 0 && time[cur-1] == 0) {
                q.offer(cur-1);
                time[cur-1] = time[cur] + 1;
                parent[cur-1] = cur;
            }
            if(cur*2 <= 100000 && time[cur*2] == 0) {
                q.offer(cur*2);
                time[cur*2] = time[cur] + 1;
                parent[cur*2] = cur;
            }
        }
    }
}
import java.util.*;
import java.io.*;
//백준 11403번 <DFS/BFS> - '경로 찾기'
public class BOJ11403_bfs {
	static int [][] answer;
	static int N;
	static boolean [] visited;
	static int [][] map;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		answer = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			//매 for문 마다 visited 초기화.
			visited = new boolean[N];
			for(int j=0;j<N;j++) {
				if(map[i][j] == 1) {
					q.add(j);
				}
			}
			while(!q.isEmpty()) {
				int temp = q.poll();
				bfs(i,temp);
			}
		}

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.printf("%d ",answer[i][j]);
			}
			System.out.println();
		}
	}

	public static void bfs(int i, int temp) {
		answer[i][temp] = 1;
		visited[temp] = true;
		for(int k=0;k<N;k++) {
			if(map[temp][k] == 1 && !visited[k])
				q.add(k);
		}
	}

}
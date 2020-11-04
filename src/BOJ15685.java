/**
 * @author choi
 * @date Nov 4, 2020
 * @see https://www.acmicpc.net/problem/15686
 * @mem 15,324kb
 * @time 176ms
 * @caution
 * [고려사항]
 * 리스트와 스택을 이용하여 풀 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <구현> '드래곤 커브'
public class BOJ15685 {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static Set<Point> set;
	static List<Integer> commandList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		set = new HashSet<>();

		StringTokenizer st = null;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int gen = Integer.parseInt(st.nextToken());

			func(x, y, dir, gen);
		}

		int answer = 0;
		for(Point temp : set) {
			if(!set.contains(new Point(temp.x+1, temp.y))) continue;
			if(!set.contains(new Point(temp.x+1, temp.y+1))) continue;
			if(!set.contains(new Point(temp.x, temp.y+1))) continue;
			answer++;
		}
		System.out.println(answer);
	}

	public static void func(int x, int y, int dir, int gen) {
		commandList = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		commandList.add(dir);
		for (int i = 1; i <= gen; i++) {
			for (int tempDir : commandList) {
				stack.push(tempDir);
			}
			while (!stack.isEmpty()) {
				int tempDir = stack.pop();
				commandList.add((tempDir + 1) % 4);
			}
		}
		int nx = x;
		int ny = y;
		set.add(new Point(x, y));
		for (int cmd : commandList) {
			nx += dx[cmd];
			ny += dy[cmd];
			//System.out.println(cmd);
			set.add(new Point(nx, ny));
		}
	}

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
	    public boolean equals(Object a) {
	        Point obj = (Point) a;
	        return (obj.x == this.x && obj.y == this.y);
	    }

	    @Override
	    public int hashCode() {
	    	return Integer.toString(x).hashCode()+Integer.toString(y).hashCode();
	    }
	}
}
/**
 * @author nakhoon
 * @date Dec 18, 2021
 * @see https://programmers.co.kr/learn/courses/30/lessons/72415
 * @caution
 * [고려사항]
 * bfs를 통해 최단거리를 찾고, 조합을 통해 어느 카드부터 맞출 지 생각을 하면 풀 수 있었던 문제이다.
 * 실제 공채에서 0.95%의 정답률이 나올만큼 구현력이 요구되는 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//프로그래머스 <2021 카카오 공채> '카드 짝 맞추기'
public class Programmers72415 {
	static int n;
	static boolean [] visited;
	static int [] temp;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,-1,0,1};
	static int startX,startY;
	static int [][] tBoard = new int[4][4];
	static int [][] cBoard;
	static int answer;
	static Point curPoint;
	public static void main(String[] args) {
		int[][] board = {
                {1,0,0,3},
                {2,0,0,0},
                {0,0,0,2},
                {3,0,1,0}
        };
        int r = 1;
        int c = 0;
        System.out.println(solution(board, r, c));
	}
	
	public static int solution(int[][] board, int r, int c) {
		startX = r;
		startY = c;
        answer = Integer.MAX_VALUE;
        cBoard = board;
        n = 0;
        for(int [] row: board) {
        	for(int data: row) {
        		if(data != 0) n++;
        	}
        }
        n /= 2; //전체 짝 개수
        temp = new int[n];
        visited = new boolean[n+1];
        perm(0);
        return answer;
    }
	
	public static void copy() {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				tBoard[i][j] = cBoard[i][j];
			}
		}
	}
	
	public static Point bfs(int target) {
		Queue<Point> q = new LinkedList<>();
		boolean [][] visited = new boolean[4][4];
		
		q.offer(new Point(curPoint.x,curPoint.y,0));
		visited[curPoint.x][curPoint.y] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			if(tBoard[cur.x][cur.y] == target) {
				return new Point(cur.x,cur.y,cur.move);
			}
			
			for(int i=0;i<4;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(isIn(nx,ny) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new Point(nx,ny,cur.move + 1));
				}
			}
			
			for(int i=0;i<4;i++) {
				Point result = findCard(cur.x,cur.y,i);
				
				if((result.x != cur.x || result.y != cur.y) && !visited[result.x][result.y]) {
					visited[result.x][result.y] = true;
					q.offer(new Point(result.x,result.y,cur.move + 1));
				}
			}
		}
		return null;
	}
	
	public static Point findCard(int x, int y, int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		while(isIn(nx,ny)) {
			if(tBoard[nx][ny] != 0) {
				return new Point(nx,ny);
			}
			nx += dx[d];
			ny += dy[d];
		}
		return new Point(nx - dx[d], ny - dy[d]);
	}
	
	public static boolean isIn(int x, int y) {
		return x>=0 && x<4 && y>=0 && y<4;
	}
	
	public static void perm(int cnt) {
		if(cnt == n) {
			copy();
			//여기서 계산
			curPoint = new Point(startX, startY);
			int total = 0;
			for(int target : temp) {
				int count = 0;
				Point result = bfs(target);
				count += result.move + 1;
				curPoint = new Point(result.x, result.y);
				tBoard[result.x][result.y] = 0;
				
				result = bfs(target);
				count += result.move + 1;
				curPoint = new Point(result.x, result.y);
				tBoard[result.x][result.y] = 0;
				total += count;
			}
			
			answer = Math.min(answer,  total);
			return;
		}
		
		for(int i=1;i<=n;i++) {
			if(!visited[i]) {
				visited[i] = true;
				temp[cnt] = i;
				perm(cnt+1);
				visited[i] = false;
			}
		}
	}
	
	static class Point{
		int x,y,move;
		Point(int x, int y, int move){
			this.x = x;
			this.y = y;
			this.move = move;
		}
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
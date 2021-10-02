/**
 * @author nakhoon
 * @date Oct 2, 2021
 * @see https://programmers.co.kr/learn/courses/30/lessons/81302
 */
import java.util.*;
//프로그래머스 <2021 카카오 채용 인턴십> '거리두기 확인하기'
public class Programmers81302 {
	static int [] dx = {0,1,0,-1};
	static int [] dy = {1,0,-1,0};
	public static void main(String[] args) {
		String [][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		System.out.println(Arrays.toString(solution(places)));
	}
	
	 public static int[] solution(String[][] places) {
	        int[] answer = new int[5];
	        
	        for(int i=0;i<places.length;i++) {
	        	char [][] place = new char[5][5];
	        	
	        	for(int j=0;j<places[i].length;j++) {
	        		for(int k=0;k<places[i][j].length();k++) {
	        			place[j][k] = places[i][j].charAt(k);
	        		}
	        	}
	        	answer[i] = isOk(place);
	        }
	        return answer;
	 }
	 
	 public static int isOk(char [][] place) {
		 Queue<Point> q = new LinkedList<>();
		 
		 for(int i=0;i<place.length;i++) {
			 for(int j=0;j<place[i].length;j++) {
				 if(place[i][j] == 'P') {
					 boolean [][] visited = new boolean[5][5];
					 q.offer(new Point(i,j,0));
					 visited[i][j] = true;
					 while(!q.isEmpty()) {
						 Point cur = q.poll();
						 
						 if(cur.length > 2)
							 continue;
						 
						 if(cur.length != 0 && place[cur.x][cur.y] == 'P') {
							 return 0;
						 }
						 
						 for(int k=0;k<4;k++) {
							 int nx = cur.x + dx[k];
							 int ny = cur.y + dy[k];
							 
							 if(isIn(nx,ny) && !visited[nx][ny] && place[nx][ny] != 'X') {
								 visited[nx][ny] = true;
								 q.offer(new Point(nx,ny,cur.length+1));
							 }
						 }
					 }
				 }
			 }
		 }
		 
		 
		 return 1;
		 
	 }
	 
	 public static boolean isIn(int x, int y) {
		 return x>=0 && x<5 && y>=0 && y<5;
	 }
	 
	 static class Point{
		 int x; 
		 int y;
		 int length;
		 Point(int x, int y, int length){
			 this.x = x;
			 this.y = y;
			 this.length = length;
		 }
	 }
}

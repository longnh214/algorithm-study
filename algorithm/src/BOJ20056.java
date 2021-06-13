/**
 * @author nakhoon
 * @date Jun 13, 2021
 * @see https://www.acmicpc.net/problem/20056
 * @mem 50,688kb
 * @time 2856ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현> '마법사 상어와 파이어볼'
public class BOJ20056 {
	static int N,M,K;
	static int [][] map;
	static List<Fireball> fireballList;
	static int [] dx = {-1,-1,0,1,1,1,0,-1};
	static int [] dy = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		fireballList = new ArrayList<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			map[r-1][c-1]++;
			Fireball fireball = new Fireball(r-1, c-1, m, s, d);
			fireballList.add(fireball);
		}
		
		for(int i=0;i<K;i++) {
			List<Fireball> nextfireballList = new ArrayList<>();
			for(Fireball fireball : fireballList) {
				map[fireball.r][fireball.c]--;
				int nr = fireball.r + dx[fireball.d] * fireball.s;
				int nc = fireball.c + dy[fireball.d] * fireball.s;
				
				if(nr < 0) {
					while(nr < 0) {
						nr += N;
					}
				}else {
					nr %= N;
				}
				if(nc < 0) {
					while(nc < 0) {
						nc += N;
					}
				}else {
					nc %= N;
				}
				
				map[nr][nc]++;
				
				nextfireballList.add(new Fireball(nr,nc,fireball.m,fireball.s,fireball.d));
			}
			
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(map[j][k] >= 2) {
						int mSum = 0;
						int sSum = 0;
						
						Iterator<Fireball> iter = nextfireballList.iterator();
						
						int [] temp = new int[map[j][k]];
						int index = 0;
						while(iter.hasNext()) {
							Fireball fireball = iter.next();
							if(fireball.r == j && fireball.c == k) {
								mSum += fireball.m;
								sSum += fireball.s;
								
								temp[index++] = fireball.d % 2;
								
								iter.remove();
							}
						}
						
						if(mSum < 5) {
							map[j][k] = 0;
							continue;
						}
						
						if(isAllEqual(temp)) {
							nextfireballList.add(new Fireball(j,k,mSum/5,sSum/map[j][k],0));
							nextfireballList.add(new Fireball(j,k,mSum/5,sSum/map[j][k],2));
							nextfireballList.add(new Fireball(j,k,mSum/5,sSum/map[j][k],4));
							nextfireballList.add(new Fireball(j,k,mSum/5,sSum/map[j][k],6));
							map[j][k] = 4;
						}else {
							nextfireballList.add(new Fireball(j,k,mSum/5,sSum/map[j][k],1));
							nextfireballList.add(new Fireball(j,k,mSum/5,sSum/map[j][k],3));
							nextfireballList.add(new Fireball(j,k,mSum/5,sSum/map[j][k],5));
							nextfireballList.add(new Fireball(j,k,mSum/5,sSum/map[j][k],7));
							map[j][k] = 4;
						}
						
					}
				}
			}
			fireballList = new ArrayList<>(nextfireballList);
		}
		
		int answer = 0;
		for(Fireball fireball : fireballList) {
			answer += fireball.m;
		}
		
		System.out.println(answer);
		
	}
	
	public static boolean isAllEqual(int [] temp) {
		int standard = temp[0];
		for(int i=1;i<temp.length;i++) {
			if(temp[i] != standard) {
				return false;
			}
		}
		return true;
	}
	
	static class Fireball{
		int r;
		int c;
		int m;
		int s;
		int d;
		public Fireball(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.d = d;
			this.s = s;
		}
	}
}
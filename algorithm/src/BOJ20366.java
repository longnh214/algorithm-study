/**
 * @author nakhoon
 * @date Dec 29, 2021
 * @see https://www.acmicpc.net/problem/20366
 * @mem 24,256kb
 * @time 448ms
 * @caution
 * [고려사항]
 * 투 포인터로 분류되어있던 문제이지만 모든 경우의 수를 계산한 조합을 가지고 문제를 해결할 수 있을 것 같아서(N의 최대가 600이므로) 풀었는데 맞았다.
 * 투 포인터로도 한번 풀어봐야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <조합> '같이 눈사람 만들래?'
public class BOJ20366 {
	static int N;
	static int [] temp;
	static int [] size;
	static List<SnowMan> smList;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		temp = new int[2];
		size = new int[N];
		smList = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0,0);
		
		Collections.sort(smList);
		
		int answer = Integer.MAX_VALUE;
		
		for(int i=0;i<smList.size()-1;i++) {
			for(int j=i+1;j<smList.size();j++) {
				if(Math.abs(smList.get(i).sum - smList.get(j).sum) >= answer) break;
				if(smList.get(i).index1 == smList.get(j).index1 || smList.get(i).index1 == smList.get(j).index2 || smList.get(i).index2 == smList.get(j).index1 || smList.get(i).index2 == smList.get(j).index2) continue;
				
				 answer = Math.abs(smList.get(i).sum - smList.get(j).sum);
				 break;
			}
		}
		
		System.out.println(answer);
	}
	
	public static void comb(int start, int cnt) {
		if(cnt == 2) {
			smList.add(new SnowMan(temp[0],temp[1]));
			return;
		}
		
		for(int i=start;i<N;i++) {
			temp[cnt] = i;
			comb(i+1,cnt+1);
		}
	}

	static class SnowMan implements Comparable<SnowMan>{
		int index1;
		int index2;
		int sum;
		
		SnowMan(int index1, int index2){
			this.index1 = index1;
			this.index2 = index2;
			this.sum = size[index1] + size[index2];
		}

		@Override
		public int compareTo(SnowMan o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.sum, o.sum);
		}
	}
}
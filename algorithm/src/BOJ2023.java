/**
 * @author nakhoon
 * @date Mar 31, 2021
 * @see https://www.acmicpc.net/problem/2023
 * @mem 11,812kb
 * @time 80ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS> '신기한 소수'
public class BOJ2023 {
	static List<Integer> [] primeList;
	static int [] prime1 = {1,2,3,5,7,9};
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		primeList = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			primeList[i] = new ArrayList<>();
		}
		
		primeList[1].add(2);
		primeList[1].add(3);
		primeList[1].add(5);
		primeList[1].add(7);
		
		for(int i=2;i<=N;i++) {
			for(int temp : primeList[i-1]) {
				String tempStr = Integer.toString(temp);
				for(int j=0;j<prime1.length;j++) {
					String numStr = tempStr+prime1[j];
					if(isPrime(Integer.parseInt(numStr))) {
						primeList[i].add(Integer.parseInt(numStr));
					}
				}
			}
		}
		
		Collections.sort(primeList[N]);
		
		for(int temp : primeList[N]) {
			System.out.println(temp);
		}
	}
	public static boolean isPrime(int N) {
		for(int i=2;i<=Math.sqrt(N);i++) {
			if(N%i == 0) return false;
		}
		return true;
	}
}

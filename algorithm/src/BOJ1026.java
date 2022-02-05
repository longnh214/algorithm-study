/**
 * @author nakhoon
 * @date Feb 5, 2022
 * @see https://www.acmicpc.net/problem/1026
 * @mem 11,680kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 문제에서 b 배열은 재배열하면 안된다고 했지만, 이것은 fake였다. a는 오름차순으로, b는 내림차순으로 정렬해서
 * 인덱스 끼리의 곱을 더해주면 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '보물'
public class BOJ1026 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] a = new int[N];
		Integer [] b = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		Arrays.sort(b, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2) * -1;
			}
		});
		int answer = 0;
		for(int i=0;i<N;i++) {
			answer += (a[i] * b[i]);
		}
		System.out.println(answer);
	}
}
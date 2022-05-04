/**
 * @author nakhoon
 * @date May 5, 2022
 * @see https://www.acmicpc.net/problem/21941
 * @mem 302,864kb
 * @time 644ms
 * @caution
 * [고려사항]
 * 분류에는 DP로 되어있었지만, 그리디(?)하게 문제를 해결했다. 점수가 높고, 문자열의 길이가 짧은 것부터 점수화하려고 했었지만
 * 이 부분을 하나의 변수로 만들어서 점수/문자열의 길이의 변수를 double 형으로 만들어주었다.
 * 이 과정에서 우선순위 큐에 각 문자열, 점수 값을 넣을 때 고려해야할 점이 있었다. 문자열의 길이보다 점수가 낮으면 큐에 넣으면 안된다는 점 이였다.
 * 하지만 double 형으로 나누기만 하면 int 형의 나눗셈이 되어 소수점이 버려지게 되어 형 변환을 해주어야 했다.
 * -------
 * 그리디하게 문제를 해결하려 했지만 엣지 케이스가 있었다.
 * https://www.acmicpc.net/board/view/89027
 * 재귀를 이용한 DP로 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//백준 <DP> '문자열 제거'
public class BOJ21941 {
	static String input;
	static int N;
	static int [] cache;
	static Map<String, Integer> map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cache = new int[1001];
		Arrays.fill(cache, -1);
		input = br.readLine();
		N = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int score = Integer.parseInt(st.nextToken());
			map.put(str, score);
		}
		System.out.println(dp(input.length()));
	}

	public static int dp(int i){
		if(i <= 0) return 0;
		if(cache[i] != -1) return cache[i];
		cache[i] = dp(i - 1) + 1;
		for(int j=0;j<=i;j++){
			String key = input.substring(j, i);
			if(map.get(key) != null) {
				cache[i] = Math.max(cache[i], dp(j) + map.get(key));
			}
		}
		return cache[i];
	}
}
/**
 * @author nakhoon
 * @date Aug 21, 2021
 * @see https://www.acmicpc.net/problem/9081
 * @mem 11,456kb
 * @time 80ms
 * @caution
 * [고려사항]
 * C++에는 있지만 Java에서는 구현을 해줘야하는 next_permutation을 이용해서 풀 수 있는 문제이다.
 * next_permutation은 현재 순열의 다음 사전 순 순열을 나타낼 수 있는 함수이다.
 * 다음 단계를 거쳐서 작성할 수 있었다.
 * 1. 맨 뒤에서부터 탐색해서 i 인덱스의 값보다 작은 i-1 인덱스를 발견했을 때 첫번째 교환할 위치 i-1을 찾게 된다.
 * 2. i-1 인덱스의 배열 값과 교환할 i-1보다 큰 값을 가진 인덱스 j를 찾는다.
 * 3. i-1 인덱스의 값과 j 인덱스의 값을 교환한다.
 * 4. i부터 맨 마지막 인덱스까지 오름차순으로 정렬을 해준다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.Arrays;
//백준 <조합> '단어 맞추기'
public class BOJ9081 {
	static char [] str;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			str = br.readLine().toCharArray();
			N = str.length;
			next_permutation();
			for(int i=0;i<N;i++) {
				sb.append(str[i]);
			}
			System.out.println(sb.toString());
			sb.setLength(0); //Stringbuilder 초기화
		}
	}
	
	//C++의 next_permutation 구현
	public static void next_permutation() {
		int i = N-1;
		
		//뒤에서부터 탐색해서, 오름차순을 만족하지 않는 인덱스를 찾는다.
		while(i > 0 && str[i-1] >= str[i]) {
			i--;
		}
		
		//제일 앞까지 오름차순이면, 마지막 단어이므로 return
		if(i == 0) {
			return;
		}
		
		i--;
		int j = N-1;
		//다시 뒤에서부터 탐색해서 자신보다 큰, 바꿀 문자를 찾는다.
		while(str[i] >= str[j]) {
			j--;
		}
		
		//문자 위치를 교환한다.
		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;
		
		//i 뒤부터 N까지 정렬을 해준다.
		Arrays.sort(str,i+1,N);
	}
}
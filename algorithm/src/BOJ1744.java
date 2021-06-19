/**
 * @author nakhoon
 * @date Jun 19, 2021
 * @see https://www.acmicpc.net/problem/1744
 * @mem 11,512kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 정렬을 하고 합과 곱 중에 곱이 더 크다면 곱을 하는 방식으로 했지만 틀렸다. 반례도 다 맞았는데 사실 왜 틀렸는 지는 알 수 없었다.
 * 음수와 양수를 따로 나눠 최대한 곱을 하고 더하는 방식이 정답이였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <정렬> '수 묶기'
public class BOJ1744 {
	static int N;
	static int [] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		//양수 끼리 먼저 계산(정렬한 후 양수끼리만 계산)
		int result = 0;
		for(int i=N-1;i>=0;i--) {
			if(arr[i] > 0) {
				if(i == 0) {
					result += arr[i];
				}else if(arr[i - 1] > 1){
					result += (arr[i] * arr[i-1]);
					i--;
				}else {
					result += arr[i];
				}
			}else {
				break;
			}
		}
		
		//음수 끼리 먼저 계산(정렬한 후 음수끼리만 계산)
		for(int i=0;i<N;i++) {
			if(arr[i] <= 0) {
				if(i == N-1) {
					result += arr[i];
				}else if(arr[i + 1] <= 0){
					result += (arr[i] * arr[i+1]);
					i++;
				}else {
					result += arr[i];
				}
			}else {
				break;
			}
		}
		System.out.println(result);
	}
}
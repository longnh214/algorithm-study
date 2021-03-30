import java.util.*;
//백준 15988번 <?> - '1,2,3 더하기 3'
public class BOJ15988 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		while(T-->0) {
			int N = scan.nextInt();
			long [] arr = new long[N+3];
			arr[1] = 1;
			arr[2] = 2;
			arr[3] = 4;
			for(int i=4;i<=N;i++) {
				arr[i] = (arr[i-1] + arr[i-2] + arr[i-3])%1000000009;
			}
			System.out.println(arr[N]);
		}
		scan.close();
	}
}
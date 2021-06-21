/**
 * @author nakhoon
 * @date Jun 21, 2021
 * @see https://www.acmicpc.net/problem/5430
 * @mem 132,348kb
 * @time 1140ms
 * @caution
 * [고려사항]
 * 덱 자료구조를 이용해서 풀어야하는 문제. 출력부분 띄어쓰기 때문에 문제를 해결하지 못했었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <덱> 'AC'
public class BOJ5430 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		outer : for(int t=0;t<T;t++) {
			String command = br.readLine();
			int size = Integer.parseInt(br.readLine());
			String [] numArr = br.readLine().replace("[","").replace("]","").split(",");
			Deque<Integer> deque = new ArrayDeque<>();
			if(size != 0) {
				for(int i=0;i<numArr.length;i++) {
					deque.push(Integer.parseInt(numArr[i]));
				}
			}
			//true = 정방향, false = 역방향
			boolean flag = true;
			for(int i=0;i<command.length();i++) {
				if(command.charAt(i) == 'R') {
					flag = !flag;
				}else {
					if(deque.size() == 0) {
						System.out.println("error");
						continue outer;
					}
					if(flag) {
						deque.pollLast();
					}else {
						deque.pollFirst();
					}
				}
			}
			int [] answer = new int[deque.size()];
			for(int i=0;i<answer.length;i++) {
				if(flag) {
					answer[i] = deque.pollLast();
				}else {
					answer[i] = deque.pollFirst();
				}
			}
			System.out.println(Arrays.toString(answer).replace(" ", ""));
		}
	}
}
/**
 * @author nakhoon
 * @date Jul 12, 2021
 * @see https://www.acmicpc.net/problem/1092
 * @mem 15,164kb
 * @time 304ms
 * @caution
 * [고려사항]
 * 내림차순으로 정렬한 후 최대한 넣을 수 있는 값을 넣으며 time을 count했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '배'
public class BOJ1092 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> crane = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			crane.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		List<Integer> box = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<M;i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(box, Collections.reverseOrder());
		Collections.sort(crane, Collections.reverseOrder());
		
		if(box.get(0) > crane.get(0)) {
			System.out.println(-1);
		}else {
			int time = 0;
			while(!box.isEmpty()) {
				int index = 0;
				for(int i=0;i<crane.size();) {
					if(index == box.size()) {
						break;
					}else if(crane.get(i) >= box.get(index)) {
						box.remove(index);
						i++;
					}else {
						index++;
					}
				}
				time++;
			}
			System.out.println(time);
		}
	}
}
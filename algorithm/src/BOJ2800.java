/**
 * @author nakhoon
 * @date Feb 17, 2022
 * @see https://www.acmicpc.net/problem/2800
 * @mem 22,468kb
 * @time 252ms
 * @caution
 * 	[고려사항]
 * 문자열을 정렬하고 중복을 제거해야 하므로 TreeSet을 사용했고, 
 * 괄호의 짝 정보를 저장하고 부분집합을 통해 답을 도출해냈다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <스택> '괄호 제거'
public class BOJ2800 {
	static char[] input;
	static List<Pair> pairList;
	static Set<String> answerSet;
	static boolean[] isSelect;
	static boolean isFirst;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().toCharArray();
		Stack<Integer> stack = new Stack<>();
		pairList = new ArrayList<>();
		answerSet = new TreeSet<>();
		for (int i = 0; i < input.length; i++) {
			if (input[i] == '(') {
				stack.push(i);
			} else if (input[i] == ')') {
				pairList.add(new Pair(stack.pop(), i));
			}
		}
		isSelect = new boolean[pairList.size()];
		powerSet(0);
		for (String str : answerSet) {
			System.out.println(str);
		}
	}

	public static void powerSet(int count) {
		if (count == pairList.size()) {
			if(!isFirst) {
				isFirst = !isFirst;
			}else {
				Set<Integer> set = new HashSet<>();
				for (int i = 0; i < isSelect.length; i++) {
					if (isSelect[i]) {
						set.add(pairList.get(i).first);
						set.add(pairList.get(i).second);
					}
				}
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < input.length; i++) {
					if (!set.contains(i)) {
						sb.append(input[i]);
					}
				}
				answerSet.add(sb.toString());
			}
			return;
		}

		isSelect[count] = false;
		powerSet(count + 1);
		isSelect[count] = true;
		powerSet(count + 1);
	}

	static class Pair {
		int first;
		int second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
}
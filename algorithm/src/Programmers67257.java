/**
 * @author nakhoon
 * @date Dec 15, 2021
 * @see https://programmers.co.kr/learn/courses/30/lessons/67257
 * @caution
 * [고려사항]
 * 순열을 이용해서 풀 수 있었던 문제이다. 리스트에 값을 넣고 삭제하는 과정에서 인덱스를 이용한 요소 삭제는 편했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//프로그래머스 <2020 카카오 인턴십> '수식 최대화'
public class Programmers67257 {
	static char [] temp = new char[3];
	static boolean [] visited = new boolean[3];
	static char [] oper = {'*', '+', '-'};
	static List<Long> numList;
	static List<Character> operList;
	static List<Long> numTemp;
    static List<Character> operTemp;
    static long max;
	public static void main(String[] args) {
		String str= "50*6-3*2";
		System.out.println(solution(str));
	}

	public static long solution(String expression) {
        String [] numArr = expression.split("[^0-9]");
        String [] operArr = expression.split("[0-9]+");
        numList = new ArrayList<>();
        operList = new ArrayList<>(); 
        for(int i=0;i<numArr.length;i++) {
        	numList.add(Long.parseLong(numArr[i]));
        }
        for(int i=1;i<operArr.length;i++) {
        	operList.add(operArr[i].charAt(0));
        }
        perm(0);
        return max;
    }
	
	public static void perm(int cnt) {
		if(cnt == oper.length) {
			numTemp = new ArrayList<>(numList);
			operTemp = new ArrayList<>(operList);
			System.out.println(Arrays.toString(temp));
			calc(temp[0]);
			calc(temp[1]);
			calc(temp[2]);
			max = Math.max(max, Math.abs(numTemp.get(0)));
			return;
		}
		
		for(int i=0;i<oper.length;i++) {
			if(!visited[i]) {
				visited[i] = true;
				temp[cnt] = oper[i];
				perm(cnt+1);
				visited[i] = false;
			}
		}
	}
	
	public static void calc(char op) {
		int i=0;
		int size = operTemp.size();
		while(i < size) {
			if(op == operTemp.get(i)) {
				switch(op) {
				case '+':
					numTemp.set(i, numTemp.get(i) + numTemp.get(i+1));
					break;
				case '-':
					numTemp.set(i, numTemp.get(i) - numTemp.get(i+1));
					break;
				case '*':
					numTemp.set(i, numTemp.get(i) * numTemp.get(i+1));
					break;
				}
				numTemp.remove(i+1);
				operTemp.remove(i);
				i--;
				size--;
			}
			i++;
		}
	}
}
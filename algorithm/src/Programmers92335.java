/**
 * @author nakhoon
 * @date Jan 27, 2022
 * @see https://programmers.co.kr/learn/courses/30/lessons/92335
 */
import java.util.*;
//프로그래머스 <2022 카카오 공채> 'k진수에서 소수 개수 구하기'
public class Programmers92335 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 437674;
		int k = 3;
		//211020101011
		//345342, 7
		System.out.println(solution(n, k));
	}

	public static int solution(int n, int k) {

		int temp = n;
        Stack<Integer> stack = new Stack<>();
        while (temp != 0) {
            stack.push(temp % k);
            temp /= k;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        int answer = 0, i, j;
        for(i = 0; i < sb.length(); i = j) {
            for(j = i + 1; j < sb.length() && sb.charAt(j) != '0'; j++);
            if(isPrime(sb.toString().substring(i,j)))
                answer++;
        }
        return answer;
	}
	
	public static boolean isPrime(String primeStr) {
		long num = Long.parseLong(primeStr);
		
		if(num < 2) return false;
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num % i == 0) return false;
		}
		
		return true;
	}
}
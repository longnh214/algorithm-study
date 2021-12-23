/**
 * @author nakhoon
 * @date Dec 23, 2021
 * @see https://programmers.co.kr/learn/courses/30/lessons/12953
 */
//프로그래머스 <연습문제> N개의 최소공배수
public class Programmers12953 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {2,6,8,14};
		System.out.println(solution(arr));
	}
	
	public static int solution(int[] arr) {
        int num = arr[0];
        for(int i=1;i<arr.length;i++) {
        	num = num * arr[i] / gcd(num, arr[i]);
        }
        return num;
    }

	public static int gcd(int a, int b) {
		if(a%b == 0) {
			return b;
		}
		return gcd(b, a%b);
	}
}

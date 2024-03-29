/**
 * @author nakhoon
 * @date Dec 22, 2021
 * @see https://programmers.co.kr/learn/courses/30/lessons/12943
 */
//프로그래머스 <연습문제> '콜라츠 추측'
public class Programmers12943 {
	
	public static void main(String[] args) {
		int n = 6;
		System.out.println(solution(n));
	}
	
	 public static int solution(int num) {
	        for(int i=0;i<500;i++){
	            if(num == 1){
	                return i;
	            }else if(num % 2 == 0){
	                num /= 2;
	            }else if(num % 2 == 1){
	                num = num * 3 + 1;
	            }
	        }
	        return -1;
	    }
}
/**
 * @author nakhoon
 * @date Dec 10, 2021
 * @see https://programmers.co.kr/learn/courses/30/lessons/67256
 */
import java.util.*;
//프로그래머스 <2020 카카오 인턴십> '키패드 누르기'
public class Programmers67256 {

	public static void main(String[] args) {
		int [] numbers = {1,3,4,5,8,2,1,4,5,9,5};
		int [] numbers1 = {7,0,8,2,8,3,1,5,7,6,2};
		int [] numbers2 = {1,2,3,4,5,6,7,8,9,0};
		String left = "left";
		String right = "right";
		
		System.out.println(solution(numbers, right));
		System.out.println(solution(numbers1, left));
		System.out.println(solution(numbers2, right));
	}
	
	public static String solution(int[] numbers, String hand) {
        Map<Integer, Point> phoneMap = new HashMap<>();
        phoneMap.put(1, new Point(0,0));
        phoneMap.put(2, new Point(0,1));
        phoneMap.put(3, new Point(0,2));
        phoneMap.put(4, new Point(1,0));
        phoneMap.put(5, new Point(1,1));
        phoneMap.put(6, new Point(1,2));
        phoneMap.put(7, new Point(2,0));
        phoneMap.put(8, new Point(2,1));
        phoneMap.put(9, new Point(2,2));
        phoneMap.put(0, new Point(3,1));
        
        int leftX = 3;
        int leftY = 0;
        int rightX = 3;
        int rightY = 2;
        
        StringBuilder sb = new StringBuilder();
        Point point;
        for(int i=0;i<numbers.length;i++) {
        	switch(numbers[i]) {
        	case 1:
        	case 4:
        	case 7:
        		point = phoneMap.get(numbers[i]);
        		leftX = point.x;
        		leftY = point.y;
        		sb.append("L");
        		break;
        	case 3:
        	case 6:
        	case 9:
        		point = phoneMap.get(numbers[i]);
        		rightX = point.x;
        		rightY = point.y;
        		sb.append("R");
        		break;
        	default:
        		point = phoneMap.get(numbers[i]);
        		int leftValue = Math.abs(point.x - leftX) + Math.abs(point.y - leftY);
        		int rightValue = Math.abs(point.x - rightX) + Math.abs(point.y - rightY);
        		if(leftValue < rightValue) {
        			sb.append("L");
        			leftX = point.x;
        			leftY = point.y;
        		}else if(leftValue > rightValue) {
        			sb.append("R");
        			rightX = point.x;
        			rightY = point.y;
        		}else {
        			if(hand.equals("right")) {
        				sb.append("R");
            			rightX = point.x;
            			rightY = point.y;
        			}else {
        				sb.append("L");
            			leftX = point.x;
            			leftY = point.y;
        			}
        		}
        		break;
        	}
        }
        return sb.toString();
    }
	
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
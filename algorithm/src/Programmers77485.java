/**
 * @author nakhoon
 * @date Dec 14, 2021
 * @see https://programmers.co.kr/learn/courses/30/lessons/77485
 * @caution
 * [고려사항]
 * 배열을 회전하면서 값을 덮어 쓸 때를 고려했던 문제입니다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//프로그래머스 <2021 백엔드 데브매칭> '행렬 테두리 회전하기'
public class Programmers77485 {
	static int [][] arr;
	static int r,c;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rows = 6;
		int columns = 6;
		int [][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		
		System.out.println(Arrays.toString(solution(rows, columns, queries)));
	}
	
	public static int[] solution(int rows, int columns, int[][] queries) {
		List<Integer> answerList = new ArrayList<>();
        r = rows;
        c = columns;
        arr = new int[r][c];
        int start = 1;
        for(int i=0;i<r;i++) {
        	for(int j=0;j<c;j++) {
        		arr[i][j] = start++;
        	}
        }
        for(int i=0;i<queries.length;i++) {
        	answerList.add(rotate(queries[i][0]-1,queries[i][1]-1,queries[i][2]-1,queries[i][3]-1));
        }
        
        int [] answer = new int[answerList.size()];
        for(int i=0;i<answer.length;i++) {
        	answer[i] = answerList.get(i);
        }
        return answer;
        
    }
	
	public static int rotate(int leftX, int leftY, int rightX, int rightY) {
		int min = Integer.MAX_VALUE;
		int curX = leftX;
		int curY = leftY;
		int temp = arr[curX][curY];
		for(int i=0;i<rightX - leftX;i++) {
			arr[curX][curY] = arr[curX+1][curY];
			min = Math.min(min, arr[curX][curY]);
			curX++;
		}
		for(int i=0;i<rightY - leftY;i++) {
			arr[curX][curY] = arr[curX][curY+1];
			min = Math.min(min, arr[curX][curY]);
			curY++;
		}
		for(int i=0;i<rightX - leftX;i++) {
			arr[curX][curY] = arr[curX-1][curY];
			min = Math.min(min, arr[curX][curY]);
			curX--;
		}
		for(int i=0;i<rightY - leftY;i++) {
			if(curX == leftX && curY-1 == leftY) {
				arr[curX][curY] = temp;
			}else{
				arr[curX][curY] = arr[curX][curY-1];
			}
			min = Math.min(min, arr[curX][curY]);
			curY--;
		}
		return min;
	}
}
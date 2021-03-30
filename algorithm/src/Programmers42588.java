import java.util.*;
//프로그래머스 코딩테스트 연습 <스택/> - '탑' 문제
public class Programmers42588 {
    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        Stack<Tower> stack = new Stack<>();

        for(int i=0;i<heights.length;i++){
            //내 탑보다 큰 값이 있을 때까지 stack에서 값을 뺀다.
            while(!stack.isEmpty()) {
                if(stack.peek().height <= heights[i])
                    stack.pop();
                else
                    break;
            }
            //스택에서 값을 다 뺀 후에 스택이 비어있으면 수신받는 탑이 없으므로 0, 스택에 값이 있으면 그 탑이 수신받는 탑이므로 인덱스를 저장
            if(!stack.isEmpty())
                answer[i] = stack.peek().index;
            else
                answer[i] = 0;
            //해당 탑이 다음 탑의 신호를 수신받을 수 있기 때문에 스택에 저장
            stack.push(new Tower(i+1,heights[i]));
        }
        return answer;
    }
    //탑 클래스
    static class Tower{
        int index;
        int height;
        Tower(int index, int height){
            this.index = index;
            this.height = height;
        }
    }
    //테스트 케이스
    public static void main(String[] args) {
        int [] heights = {1,5,3,6,7,6,5};
        for(int n : solution(heights)){
            System.out.println(n);
        }
    }
}

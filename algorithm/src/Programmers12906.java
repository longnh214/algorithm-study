/**
 * @author nakhoon
 * @date 12/4/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12906
 * @mem
 * @time
 * @caution
 * [고려사항]
 * java util의 stack을 통해 top에 있는 원소를 확인한 후, 같은 숫자이면 push 하지 않는 로직으로 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

//프로그래머스 <연습문제> '같은 숫자는 싫어'
public class Programmers12906 {
    public static void main(String[] args) {
        int [] arr = {1,1,3,3,0,1,1};

        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int [] arr) {
        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }
}

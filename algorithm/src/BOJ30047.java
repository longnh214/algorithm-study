/**
 * @author nakhoonchoi
 * @date 2025/07/19
 * @see https://boj.ma/30047
 * @mem 36,136kb
 * @time 232ms
 * @caution
 * [고려사항]
 * 스택을 이용해서 풀 수 있는 간단한 문제였지만 일반적으로 Java에서 직관적으로 볼 수 있는 Stack 클래스가 아닌
 * Deque 인터페이스로 Stack을 구현하느라 실수를 했다.
 *
 * 먼저 예외 처리를 잘해야하는 문제였고, 입력받은 문자열이 함수인지 판별하기 위해서 역순으로 문자를 조회했다.
 * 그리고 각 문자에 대해서 조건과 로직을 설명하겠다.
 * x - x는 조건없이 0을 스택에 넣어주면 된다.
 * g - g는 스택에 값이 없는 경우에는 잘못된 함수 문자열이라고 판단했고,
 *     스택에 값이 있다면 최상단 값을 pop해서 +1을 해준 뒤에 다시 스택에 넣어주었다.
 * f - f는 현재 스택에 값이 2개 미만으로 있다면 잘못된 함수 문자열이라고 판단했다.
 *     그리고 값이 2개 이상으로 있다면 두번 값을 pop해서 그 중 최솟값을 스택에 넣어준다.
 *
 * 그리고 모든 로직을 실행한 뒤에 스택의 크기가 1개가 아니라면 전체적으로 잘못된 함수 문자열이라고 생각했다.
 *
 * 💡 Deque로 스택을 구현할 때 pop할 방향을 잘 정해줘야한다는 점을 알 수 있었다.
 * 예를 들어 offer 메소드로 값을 넣어준다면 pollLast로 값을 pop 해야하고,
 * offerFirst 메소드로 값을 넣어준다면 통일되게 pollFirst로 값을 pop 해야한다.
 *
 * 이 점을 파악하지 못하고 진행해서 어려움이 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <스택> '함수 문자열'

public class BOJ30047 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=str.length()-1;i>=0;i--){
            char c = str.charAt(i);

            if (c == 'x') {
                stack.offer(0);
            }else if(c == 'g'){
                if(stack.isEmpty()){
                    System.out.println(-1);
                    return;
                }

                int value = stack.pollLast();
                stack.offer(value + 1);
            }else{
                if(stack.size() < 2){
                    System.out.println(-1);
                    return;
                }

                int firstValue = stack.pollLast();
                int secondValue = stack.pollLast();
                stack.offer(Math.min(firstValue, secondValue));
            }
        }

        if(stack.size() != 1){
            System.out.println(-1);
            return;
        }

        System.out.println(stack.poll());
    }
}
/**
 * @author nakhoonchoi
 * @date 2024/08/07
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12923?language=java
 * @mem 52.8MB
 * @time 220ms
 * @caution
 * [고려사항]
 * 앞으로 효율성 문제를 풀어보기 위해 프로그래머스를 이용할 예정이다.
 * 배열의 값에는 자기 자신을 제외한 가장 큰 약수가 들어갈 것이고,
 * 가장 큰 약수를 구하기 위해서는 수를 가장 첫 번째에 나오는 약수로 나눈다면
 * 몫이 가장 큰 약수일 것이므로 값을 넣어주었고, 수가 1일 경우와 소수일 경우를 처리해주었다.g
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//프로그래머스 <레벨2> '숫자 블록'

public class Solution12923 {
    public static void main(String[] args) {
        long begin = 1;
        long end = 10;

        System.out.println(Arrays.toString(solution(begin, end)));
    }

    public static int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin) + 1];

        for(int i=0;i<answer.length;i++){
            long num = begin + i;
            for(long div=2;div<=Math.sqrt(num);div++){
                if(num % div == 0) {
                    if (num / div > 10000000) {
                        answer[i] = (int) div;
                        continue;
                    } else {
                        answer[i] = (int) (num / div);
                    }
                    break;
                }
            }
            if(answer[i] == 0){
                answer[i] = 1;
            }
        }
        if(begin == 1){
            answer[0] = 0;
        }

        return answer;
    }
}
/**
 * @author nakhoon
 * @date 12/8/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/131705
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 오랜만에 부트캠프 시절 재귀로 구현하는 조합이 생각나는 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

//프로그래머스 <연습문제> '삼총사'
public class Programmers131705 {
    static int [] arr;
    static int [] temp;
    static boolean [] visited;
    static int answer;

    public static void main(String[] args) {
        int [] number = {-3, -2, -1, 0, 1, 2, 3};
        System.out.println(solution(number));
    }

    public static int solution(int[] number) {
        arr = number;
        temp = new int[3];
        visited = new boolean[number.length];
        comb(0, 0);
        return answer;
    }

    public static void comb(int cur, int count){
        if(count == temp.length) {
            int sum = Arrays.stream(temp).sum();
            if(sum == 0){
                answer++;
            }
            return;
        }
        for(int i=cur;i<arr.length;i++){
            temp[count] = arr[i];
            comb(i+1, count+1);
        }
    }
}

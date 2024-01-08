/**
 * @author nakhoon
 * @date 1/8/24
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12980
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 순간이동 횟수도 건전지 사용량에 포함되는 줄 알았는데 K칸 점프만 건전지 사용량이 드는 것이었고,
 * 점프는 1씩 하는 것이 제일 최선이었다.
 * n이 홀수일 때만 건전지 사용량을 1 올리고, 그 뒤에 n이 0이 될 때 까지 2로 나눠주었다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '점프와 순간이동'
public class Programmers12980 {
    public static void main(String[] args) {
        int n = 5000;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int ans = 0;

        while(n > 0){
            if(n % 2 == 1){
                ans++;
            }
            n /= 2;
        }

        return ans;
    }
}

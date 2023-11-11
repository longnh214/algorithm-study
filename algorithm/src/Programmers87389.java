/**
 * @author nakhoonchoi
 * @date 2023/11/11
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/87389
 * @mem
 * @time
 * @caution
 * [고려사항] 가장 작은 수(2)부터 n까지 수 중에 나머지가 1이 되는 숫자를 찾으면 바로 return 하도록 구현했다.
 * n이 3이상이므로 나머지가 1인 숫자는 무조건 나올 수 밖에 없다고 판단되었고, 문제 설명에도 나와있었다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '나머지가 1이 되는 수 찾기'
public class Programmers87389 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        for(int i=2;i<n;i++){
            if(n % i ==1)
                return i;
        }
        return 0;
    }
}

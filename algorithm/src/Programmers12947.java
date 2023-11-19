/**
 * @author nakhoonchoi
 * @date 2023/11/19
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12947
 * @mem
 * @time
 * @caution
 * [고려사항]
 * split("")를 이용해서 각 자리 수에 대해 문자열을 자르고, 각 자리 수의 합으로 나눠서 나머지가 0인지를 return 하는 solution
 * 함수를 만들었다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '하샤드 수'
public class Programmers12947 {
    public static void main(String[] args) {
        int x = 11;
        System.out.println(solution(x));
    }

    public static boolean solution(int x) {
        int mod = 0;

        for(String s : String.valueOf(x).split("")){
            mod += Integer.parseInt(s);
        }

        return x % mod == 0;
    }
}

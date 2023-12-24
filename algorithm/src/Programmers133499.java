/**
 * @author nakhoonchoi
 * @date 2023/12/24
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/133499
 * @mem
 * @time
 * @caution
 * [고려사항]
 * aya, ye, woo, ma가 연속으로 나온다면 발음할 수 없으므로 pass하고,
 * 문자열 중 발음할 수 있는 문자가 포함 됐다면 ""이 아닌 " "으로 치환해서, 최대한 치환했을 때 "    "와 같이
 * 공백만 남아있다면 ""로 replace를 해서 문제를 해결할 수 있었다.
 * "mawooma"도 발음할 수 있는 문자열을 ""로 치환시켜버리면 발음할 수 있지만, 연속으로 된 문자가 나올 수 있기 때문에
 * " "으로 치환하는 것이 좋다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '옹알이 (2)'
public class Programmers133499 {
    public static void main(String[] args) {
        String [] babbling = {"mawooma"};
        System.out.println(solution(babbling));
    }

    public static int solution(String[] babblings) {
        int answer = 0;
        for(int i = 0; i < babblings.length; i++) {
            if(babblings[i].contains("ayaaya") || babblings[i].contains("yeye") || babblings[i].contains("woowoo") || babblings[i].contains("mama")) {
                continue;
            }

            babblings[i] = babblings[i].replace("aya", " ");
            babblings[i] = babblings[i].replace("ye", " ");
            babblings[i] = babblings[i].replace("woo", " ");
            babblings[i] = babblings[i].replace("ma", " ");
            babblings[i] = babblings[i].replace(" ", "");

            if(babblings[i].length()  == 0) answer++;

        }
        return answer;
    }
}

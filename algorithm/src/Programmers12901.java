/**
 * @author nakhoonchoi
 * @date 2023/12/17
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12901
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 단순한 구현 문제였다. 월마다 최대 요일을 배열로 설정하고, 요일을 문자열 배열로 만들어놓은 뒤에
 * mod 연산을 통해 요일 배열의 문자열을 뽑아냈다.
 * [입력사항]
 * [출력사항]
 */

public class Programmers12901 {
    static final int [] DAYS_BY_MONTH = {31,29,31,30,31,30,31,31,30,31,30,31};
    static final String [] WEEKDAYS = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        System.out.println(solution(a, b));
    }

    public static String solution(int a, int b) {
        int totalDays = 0;

        for(int i=0;i<a-1;i++){
            totalDays += DAYS_BY_MONTH[i];
        }

        totalDays += (b - 1);

        return WEEKDAYS[totalDays % 7];
    }
}

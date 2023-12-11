/**
 * @author nakhoon
 * @date 12/12/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/134240
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 지난 문제에서 익혔던 StringBuilder.reverse()를 통해 문제를 해결하였다.
 * 하지만, reverse는 현재 StringBuilder 객체의 문자열 값 자체를 뒤집기 때문에
 * return sb + "0" + sb.reverse();는 올바른 정답이 나오지 않았고
 * return sb.toString() + "0" + sb.reverse();를 반환하였다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '푸드 파이트 대회'
public class Programmers134240 {
    public static void main(String[] args) {
        int [] food = {1,3,4,6};
        System.out.println(solution(food));
    }

    public static String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<food.length;i++){
            for(int j=0;j<food[i]/2;j++){
                sb.append(i);
            }
        }
        return sb.toString() + "0" + sb.reverse();
    }
}

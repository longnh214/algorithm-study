/**
 * @author nakhoon
 * @date 11/23/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12948
 * @mem
 * @time
 * @caution
 * [고려사항]
 * Stream을 이용해서 문제를 해결했다. IntStream으로 숫자에 대한 스트림을 만드는 방법을 처음 사용해봤다.
 * [입력사항]
 * [출력사항]
 */
import java.util.stream.IntStream;

//프로그래머스 <연습문제> '핸드폰 번호 가리기'
public class Programmers12948 {
    public static void main(String[] args) {
        String phone_number = "01033334444";
        System.out.println(solution(phone_number));
    }

    public static String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, phone_number.length()).forEach(i -> {
            if(i < phone_number.length() - 4){
                sb.append('*');
            }else{
                sb.append(phone_number.toCharArray()[i]);
            }
        });
        return sb.toString();
    }
}

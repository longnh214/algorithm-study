/**
 * @author nakhoon
 * @date 12/26/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/77484
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 0의 개수와 맞춘 개수를 둘 다 세어준다음에 최고 등수, 최저 등수를 도출해내었다.
 * 삼항 연산자의 조건을 잘 맞췄어야했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.util.stream.Collectors;

//프로그래머스 <연습문제> '로또의 최고 순위와 최저 순위'
public class Programmers77484 {
    public static void main(String[] args) {
        int [] lottos = {1,2,3,4,5,6};
        int [] win_nums = {7,8,9,10,11,12};

        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        List<Integer> winNumsList = Arrays.stream(win_nums).boxed().collect(Collectors.toList());

        int matchCount = 0;
        int zeroCount = 0;
        for(int i=0;i<lottos.length;i++){
            if(lottos[i] == 0){
                zeroCount++;
            }
            if(winNumsList.contains(lottos[i])){
                matchCount++;
            }
        }
        answer[0] = zeroCount == 0 && matchCount == 0 ? 6 : 7 - matchCount - zeroCount;
        answer[1] = matchCount == 0 ? 6 : 7 - matchCount;

        return answer;
    }
}
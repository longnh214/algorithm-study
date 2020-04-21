import java.util.*;
//프로그래머스 코딩테스트 연습 <정렬> - 'H-index' 문제
public class Programmers42747 {
    public static void main(String[] args) {
        int [] citations = {3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        //h번 이상 인용된 논문이 h편 이상인 h의 최댓값을 구하면 된다.
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;//논문의 개수는 1부터 시작한다.(0부터 시작하지 않는다.)
            //i번 인덱스 값이 h보다 크면 그 이후는 전부 크므로 확인 할 필요가 없다.
            if(citations[i] >= h){
                answer = h;
                break;
            }
        }
        return answer;
    }
}
import java.util.*;
//프로그래머스 코딩테스트 연습 <완전탐색> - '모의고사' 문제
public class Programmers42840 {
    public static int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<>();
        //수포자 1부터 3까지 규칙들을 int형 배열로 정리
        int [] choice_1 = {1,2,3,4,5};
        int [] choice_2 = {2,1,2,3,2,4,2,5};
        int [] choice_3 = {3,3,1,1,2,2,4,4,5,5};
        int [] answer_count = new int[3]; //각 수포자의 정답 개수를 저장하는 배열
        //정답 개수 확인
        for(int i=0;i<answers.length;i++){
            if(answers[i] == choice_1[i%5])
                answer_count[0]++;
            if(answers[i] == choice_2[i%8])
                answer_count[1]++;
            if(answers[i] == choice_3[i%10])
                answer_count[2]++;
        }
        //정답 개수 중 최대값 뽑기42
        int max = Integer.MIN_VALUE;
        for(int i=0;i<answer_count.length;i++)
            max = Math.max(max,answer_count[i]);
        //최대값의 index 뽑기
        for(int i=0;i<answer_count.length;i++)
           if(max == answer_count[i])
               list.add(i+1);
        int [] answer = new int[list.size()];
        for(int i=0;i<list.size();i++)
           answer[i] = list.get(i);
        return answer;
    }
    public static void main(String[] args) {
        int [] answers = {1,3,2,4,2};
        int [] answer = solution(answers);
        for(int i : answer)
            System.out.println(i);
    }
}
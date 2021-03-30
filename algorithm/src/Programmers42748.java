import java.util.*;
//프로그래머스 코딩테스트 연습 <정렬> - 'K번째 수' 문제
public class Programmers42748 {
    //배열 인덱스를 헷갈려서 IndexBoundsException이 많이 발생했었다.
    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int [] answer = new int[commands.length];
            int [] temp;
            for(int i=0;i<commands.length;i++){
                temp  = new int[commands[i][1] - commands[i][0] + 1];
                for(int j=commands[i][0]-1;j<commands[i][1];j++)
                    temp[j-commands[i][0]+1] = array[j];
                Arrays.sort(temp);
                answer[i] = temp[commands[i][2]-1];
            }
            return answer;
        }

        //Arrays.copyOfRange() 함수 공부!
        public int[] solution2(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];

            for(int i=0; i<commands.length; i++){
                int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
                Arrays.sort(temp);
                answer[i] = temp[commands[i][2]-1];
            }

            return answer;
        }
    }
}

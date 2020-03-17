import java.util.*;
//프로그래머스 코딩테스트 연습 <스택/큐> - '기능개발' 문제
public class Programmers42586 {
    public static int[] solution(int[] progresses, int[] speeds) {
        int [] answer;
        int count = 0; //하루에 몇개의 Progress가 완료되는지 count
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>(); //list에 Queue에서 빠져나온(하루에 Progress가 몇개나 완료되었는 지) 횟수를 저장

        //큐에 배열의 순서(업무의 우선순위)대로 값을 넣어야 하므로 배열의 index를 순서대로 삽입.
        for(int i=0;i<progresses.length;i++){
            q.add(i);
        }

        while(!q.isEmpty()){
            for(int i=0;i<progresses.length;i++){
                progresses[i]+=speeds[i];
                if(progresses[i] >= 100)
                    progresses[i] = 100;
                //System.out.println(progresses[i]);
            }
            while(progresses[q.peek()] == 100){
                q.poll();
                count++;
                //Queue에서 값을 빼내고 그 뒤에 큐에 아무 값이 없으면 break
                if(q.isEmpty())
                   break;
            }
            //Queue에서 값이 나온 경우가 있을 때에만 count를 list에 저장
            if(count!=0)
                list.add(count);
            count = 0;
        }
        answer = new int[list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    //테스트 케이스와 같이 변수 설정
    public static void main(String[] args) {
        int [] progresses = {93,30,55};
        int [] speeds = {1,30,5};
        int [] solved = solution(progresses,speeds);
        for(int i=0;i<solved.length;i++)
            System.out.println(solved[i]);
    }
}

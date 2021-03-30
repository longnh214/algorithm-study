import java.util.*;
//프로그래머스 코딩테스트 연습 <힙(Heap)> - '이중우선순위큐' 문제
public class Programmers42628 {
    public static void main(String[] args) {
        String [] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        for(int i : solution(operations)){
            System.out.println(i);
        }
    }

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        //최대 우선순위 큐와 최소 우선순위 큐를 따로 만들어준다.
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        //각 operation에 따라 삽입 삭제 연산 조건문에 따라 다르게 처리한다.
        for(int i=0;i<operations.length;i++){
            String [] commandList = operations[i].split(" ");

            //삽입일 때에는 두 우선순위 큐에 삽입.
            if(commandList[0].equals("I")){
                maxPQ.offer(Integer.parseInt(commandList[1]));
                minPQ.offer(Integer.parseInt(commandList[1]));
            }
            //삭제일 때는 큐의 크기가 0이면 삭제 연산을 skip하고, 각 우선순위 큐에서 poll한 값을 다른 큐에서도 빼준다.
            else{
                if(commandList[1].equals("1")){
                    if(maxPQ.size() == 0) continue;
                    int value = maxPQ.poll();
                    minPQ.remove(value);
                }else{
                    if(minPQ.size() == 0) continue;
                    int value = minPQ.poll();
                    maxPQ.remove(value);
                }
            }
        }

        //두 우선순위 큐의 크기가 0이라면 answer 배열을 전부 0으로 채운다.
        if(maxPQ.size() == 0 && minPQ.size() == 0){
            Arrays.fill(answer, 0);
        }
        //배열의 0번째 인덱스는 최대값, 1번째 인덱스에는 최소값 입력.
        else{
            answer[0] = maxPQ.poll();
            answer[1] = minPQ.poll();
        }

        return answer;
    }
}
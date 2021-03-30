import java.util.*;
//프로그래머스 코딩테스트 연습 <스택/큐> - '프린터' 문제
//백준의 프린터 큐와 문제가 똑같았다.
public class Programmers42587 {
    static Queue<Printer> q = new LinkedList<>();
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        for(int i=0;i<priorities.length;i++){
            q.add(new Printer(priorities[i],i));
        }

        while(!q.isEmpty()){
            //우선순위가 가장 높으면 Queue에서 빼고
            if(isPriority()){
                Printer printer = q.poll();
                answer++;
                if(printer.index == location){
                    break;
                }
            }
            //우선순위가 가장 높은게 아니라면 Queue에서 값을 빼서 맨 뒤로 보낸다.
            else{
                q.add(q.poll());
            }
        }
        return answer;
    }
    //지금 현재 Queue에서 빼는 값의 우선순위가 가장 높은가 아닌가를 판별하는 함수
    public static boolean isPriority(){
        Printer printer = q.peek();
        int max = printer.priority;
        for(int i=0;i<q.size();i++){
            Printer temp = q.poll();
            max = Math.max(max,temp.priority);
            q.add(temp);
        }
        if(max == printer.priority) return true;
        else return false;
    }

    //Printer 클래스
    static class Printer{
        int index;
        int priority;
        Printer(int priority, int index){
            this.priority = priority;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        int [] priorities = {2,1,3,2};
        System.out.println(solution(priorities,2));
    }
}
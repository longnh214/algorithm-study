import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1966 {
    static Queue<Printer> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(T-->0){
            int count = 0;
            int num = scan.nextInt(); //index 개수
            int problem = scan.nextInt(); //구해야 할 index
            int [] rank = new int[num];
            for(int i=0;i<num;i++){
                int priority = scan.nextInt();
                q.add(new Printer(i,priority));
            }
            //priority 함수를 이용해 카운트 출력
            while(!q.isEmpty()){
                if(isPriority()){
                    Printer temp = q.poll();
                    count++;
                    if(temp.num == problem) break;
                    else continue;
                }
                else
                    q.add(q.poll());
            }
            q.clear();
            System.out.println(count);
        }
    }
    //우선순위가 가장 높아서 출력해야하는지 큐에 새로 삽입해야하는 지 판별
    static boolean isPriority(){
        Printer temp = q.peek();
        int max = temp.priority;
        for(Printer p : q){
            max = Math.max(max,p.priority);
        }
        System.out.println("max = " + max);
        if(max == temp.priority)
            return true;
        else
            return false;
    }
    //프린터 클래스 한개 생성
    static class Printer{
        int num;
        int priority;
        Printer(int num, int priority){
            this.num = num;
            this.priority = priority;
        }
    }
}
import java.util.*;
//프로그래머스 코딩테스트 연습 <스택/큐> - '주식가격' 문제
public class Programmers42584 {
    //2중 for문으로 해결(문제에서 원하는 정답 X)
    public static int [] solution(int [] prices){
        int [] answer = new int[prices.length];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<prices.length;i++){
            int count = 0;
            for(int j=i+1;j<prices.length;j++){
                count++;
                if(prices[i] > prices[j])
                    break;
            }
            list.add(count);
        }
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    //스택/큐 문제인데 2중 for문으로 푼 문제여서 다시 생각을 해봐야겠다.

    public static void main(String[] args) {
        int [] prices = {1,2,3,2,3};
        int [] solution = solution(prices);
        for(int i=0;i<solution.length;i++){
            System.out.println(solution[i]);
        }
    }

    //정답은 맞았지만 시간초과된 코드(큐 이용)
    /*static Queue<Integer> q = new LinkedList<>();
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<prices.length;i++)
            q.add(prices[i]);
        while(!q.isEmpty()){
            list.add(solution());
        }
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static int solution(){
        int size = q.size();
        int num = q.poll();
        int count = 0;
        for(int i=0;i<size-1;i++){
            int temp = q.poll();
            q.add(temp);
        }
        return count;
    }
     */

}
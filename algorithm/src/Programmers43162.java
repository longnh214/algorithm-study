import java.util.*;
//프로그래머스 코딩테스트 연습 <dfs/bfs> - '네트워크' 문제
public class Programmers43162 {
    public static void main(String[] args) {
        int [][] computers = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int n = 3;
        System.out.println(solution(n,computers));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        while(!isDone(computers)){
            bfs(n,computers);
            answer++;
        }
        return answer;
    }
    //네트워크 체크된 자리는 전부 0으로 치환해서 visited 배열을 사용하지 않고 bfs.
    public static void bfs(int n,int [][] computers){
        Queue<Integer> q = new LinkedList<>();
        int x = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                if(computers[i][j] == 1) {
                    x = i;
                    computers[i][j] = 0;
                    computers[j][i] = 0;
                    q.add(j);
                }
            }
            if(i == x)
                break;
        }

        while(!q.isEmpty()){
            int target = q.poll();
            for(int i=0;i<computers[target].length;i++){
                if(computers[target][i] == 1){
                    computers[i][target] = 0;
                    computers[target][i] = 0;
                    q.add(i);
                }
            }
        }
    }
    //computers 2차원 배열을 전부 탐색했는 지 확인하는 함수(1이 남아있는 지 체크)
    public static boolean isDone(int [][] computers){
        for(int i=0;i<computers.length;i++){
            for(int j=0;j<computers[i].length;j++){
                if(computers[i][j] == 1) return false;
            }
        }
        return true;
    }
}
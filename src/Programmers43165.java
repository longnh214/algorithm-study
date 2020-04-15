//프로그래머스 코딩테스트 연습 <dfs/bfs> - '타겟 넘버' 문제
public class Programmers43165 {
    public static void main(String[] args) {
        int [] numbers = {1,1,1,1,1};
        int target = 3;
        System.out.println(solution(numbers,target));
    }

    public static int solution(int[] numbers, int target) {
        return dfs(numbers,0,0,target);
    }

    public static int dfs(int [] numbers, int index, int sum, int target){
        //전부 계산한 값이 target이면 answer에 1을 추가
        if(index == numbers.length){
            if(sum == target) return 1;
            else return 0;
        }
        return dfs(numbers, index+1, sum + numbers[index], target)
                +dfs(numbers, index+1, sum - numbers[index], target);
    }
}
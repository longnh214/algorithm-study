//프로그래머스 코딩테스트 연습 <완전탐색> - '카펫' 문제
public class Programmers42842 {
    public static void main(String[] args) {
        int brown = 10;
        int red = 2;
        int [] answer = solution(brown,red);
        for(int i : answer)
            System.out.println(i);
    }

    public static int[] solution(int brown, int red) {
        int[] answer = new int[2];

        boolean [] visited = new boolean[red+1];
        int i;
        int j = 0;
        for(i=red;i>=1;i--){
            if(red%i==0 && visited[i] == false){
                j = red / i;
                visited[i] = true;
                visited[j] = true;
                if(2*(i+1) + 2*(j+1) == brown)
                    break;
            }
        }
        answer[0] = (i+2);
        answer[1] = (j+2);

        return answer;
    }
}
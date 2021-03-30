import java.util.*;
//프로그래머스 코딩테스트 연습 <2019 카카오 개발자 겨울 인턴십> - '크레인 인형뽑기 게임' 문제
public class Programmers64061 {
    public static void main(String[] args) {
        int [][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int [] moves = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int doll;
        Stack<Integer> basket = new Stack<>();

        for(int i=0;i<moves.length;i++){
            doll = 0;
            for(int j=0;j<board.length;j++){
                if(board[j][moves[i]-1] != 0){
                    doll = board[j][moves[i]-1];
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
            if(doll == 0)
                continue;
            else if(!basket.isEmpty()){
                if(basket.peek() == doll){
                    basket.pop();
                    answer+=2;
                }else
                    basket.push(doll);
            }else
                basket.push(doll);
        }
        return answer;
    }
    //매 상황 체크용 함수
    public static void print(int [][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.printf("%d ",board[i][j]);
            }
            System.out.println();
        }
    }
}
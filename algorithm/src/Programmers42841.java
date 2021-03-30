import java.util.*;
//프로그래머스 코딩테스트 연습 <완전탐색> - '숫자 야구' 문제
public class Programmers42841 {
    static Set<Integer> answerSet = new HashSet<>();

    public static void main(String[] args) {
       int [][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
       System.out.println(solution(baseball));
    }

    public static int solution(int[][] baseball) {
        int [] arr = {1,2,3,4,5,6,7,8,9};
        permutation(baseball,arr,0,3);
        return answerSet.size();
    }
    //순열(permutation), 매개변수(baseball 2차원 배열, 1~9 숫자카드, index, 순열로 뽑아야하는 자리수)
    public static void permutation(int [][] baseball, int [] arr, int index, int digit){
        if(index == digit){
            arrangeNum(baseball, arr, digit);
            return;
        }else{
           for(int i=0;i+index<arr.length;i++){
               swap(arr,index,index+i);
               permutation(baseball,arr, index+1, digit);
               swap(arr,index,index+i);
           }
        }
    }
    //arr 배열 내 swap 함수
    public static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //순열로 뽑아낸 숫자들을 int 형으로 계산해서 check
    public static void arrangeNum(int [][] baseball, int [] arr, int digit){
        int num = 0;
        for(int i=0;i<digit;i++){
            num += arr[i] * Math.pow(10, digit-i-1);
        }
        check(num,baseball);
    }
    //순열로 뽑아낸 숫자가 문제에 맞는지 아닌지 확인하는 함수
    public static void check(int num, int [][] baseball){
        String strNum = Integer.toString(num);
        int strike = 0;
        int ball = 0;
        boolean isRight = true;

        for(int i=0;i<baseball.length;i++){
            String questionNum = Integer.toString(baseball[i][0]);
            for(int j=0;j<3;j++){
                if(strNum.charAt(j) == questionNum.charAt(j))
                    strike++;
                else if(strNum.contains(Character.toString(questionNum.charAt(j))))
                    ball++;
                else
                    continue;
            }
            if(strike != baseball[i][1] || ball != baseball[i][2]){
                isRight = false;
                break;
            }
            strike = 0;
            ball = 0;
        }
        if(isRight){
            answerSet.add(num);
        }
    }
}
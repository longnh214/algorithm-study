import java.util.*;
//프로그래머스 코딩테스트 연습 <Dynamic Programming> - 'N으로 표현' 문제
public class Programmers42895 {
    public static void main(String[] args) {
        int N = 4;
        int number = 13;
        System.out.println(solution(N,number));
    }

    public static int solution(int N, int number) {
        int answer = -1;
        //중복 저장이 안되는 Set을 8개 만든다.
        Set<Integer> [] numList = new HashSet[8];
        for(int i=0;i<8;i++){
            numList[i] = new HashSet<>();
            numList[i].add(getOriginNum(N, i+1));
        }
        //숫자 두개로 만들 수 있는 수는 한개로 만들 수 있는 수와 한개로 만들 수 있는 수의 사칙연산.
        //숫자 n개로 만들 수 있는 수는 (한개로 만들 수 있는 수와 n-1개로 만들 수 있는 수의 사칙연산 계산 값)
        // + (두개로 만들 수 있는 수와 n-2개로 만들 수 있는 수의 사칙연산 계산 값)
        // + ....
        // + (n-1개로 만들 수 있는 수와 한개로 만들 수 있는 수의 사칙연산 계산 값)
        for(int i=1;i<8;i++){
            for(int j=0;j<i;j++){
                for(int k : numList[j]){
                    for(int m : numList[i-j-1]){
                        numList[i].add(k+m);
                        numList[i].add(k-m);
                        numList[i].add(k*m);
                        if(m != 0)
                            numList[i].add(k/m);
                    }
                }
            }
            //Set에 정답이 포함되어있으면 index를 반환하고 break
            if(numList[i].contains(number)) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }
    //연속된 숫자의 수 만들기 (ex >> '5' 3개로 '555')
    public static int getOriginNum(int N, int cnt){
        int value = 0;
        for(int i=0;i<cnt;i++){
            value += N * Math.pow(10,i);
        }
        return value;
    }
}
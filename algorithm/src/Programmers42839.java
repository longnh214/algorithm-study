import java.util.*;
//프로그래머스 코딩테스트 연습 <완전탐색> - '소수 찾기' 문제
public class Programmers42839 {

    public static int solution(String numbers) {
        boolean [] primes = new boolean[10000000];
        //numbers 배열을 한 자리 씩 자른다.
        int [] arr = new int[numbers.length()];
        for(int i=0;i<numbers.length();i++){
            arr[i] = numbers.charAt(i) - '0';
        }

        //primes의 배열 인덱스가 소수라면 배열값에 false, 소수가 아니라면 true
        primes[0] = true;
        primes[1] = true;
        for(int i=2;i<primes.length;i++){
            if(!primes[i]){
                for(int j=2;j*i<primes.length;j++)
                    primes[j*i] = true;
            }
        }

        //중복을 없애주는 Set(순서 상관 없음)에 순열을 이용해서 만들 수 있는 숫자들을 저장
        Set<Integer> primeSet = new HashSet<>();
        for(int i=1;i<=arr.length;i++){
            permutation(primeSet,arr,0,i);
        }

        //숫자들이 소수라면 answer + 1
        int answer = 0;
        for(int i : primeSet){
            answer = primes[i] ? answer : answer+1;
        }
        return answer;
    }
    //(Set,숫자카드배열,첫번째인덱스,총자리수)
    public static void permutation(Set<Integer> primeSet, int [] arr, int index, int digit){
        if(index == digit) {
            primeSet.add(mixInteger(arr, digit));
        }else{
            for(int i=0; i + index <arr.length;i++){
                //배열 값을 바꿔서 Set에 add하고 다시 원래대로 배열 값을 바꿔준다.
                swap(arr,index,index + i);
                permutation(primeSet, arr, index+1, digit);
                swap(arr,index,index + i);
            }
        }
    }
    //배열값을 서로 바꿔주는 함수
    public static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //StringBuilder를 통해 숫자를 문자열 처럼 합쳐주는 함수
    public static int mixInteger(int [] arr, int k){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<k;i++){
            sb.append(arr[i]);
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(solution("12345"));
    }
}
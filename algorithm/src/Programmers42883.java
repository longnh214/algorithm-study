//프로그래머스 코딩테스트 연습 <탐욕(Greedy)> - '큰 수 만들기' 문제
//자리수가 100만이여서 완전탐색으로 풀 수 없는 문제.
public class Programmers42883 {
    public static void main(String[] args) {
        String number = "19546";
        int k = 2;
        System.out.println(solution(number, k));
    }

    public static String solution(String number, int k) {
        int idx = 0; //인덱스 저장용 변수
        char max;
        StringBuilder answer = new StringBuilder();

        //인덱스가 0부터 시작할 때, k개의 숫자를 뺏을 때 최대 숫자는 적어도 0번째부터 k번째 숫자 중에 나와야 한다.
        //i는 완성될 숫자의 총 자리수까지만 (예제에서 4자리 숫자 중에서 두 자리를 뺀 최대값은 두 자리수이므로 두번 loop)
        for(int i = 0; i < number.length() - k; i++) {
            max = '0';
            //인덱스가 0부터 시작할 때, k개의 숫자를 뺏을 때 최대 숫자는 적어도 0번째부터 k번째 숫자 중에 나와야 한다.
            //인덱스부터 k(총 빼야하는 수) + i(현재 지정해야하는 자리)까지 중 최대값을 뽑아 인덱스를 저장하고 StringBuilder에 append
            for(int j = idx; j <= k + i; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j);
                    idx = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}

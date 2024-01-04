/**
 * @author nakhoon
 * @date 1/4/24
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12911
 * @mem
 * @time
 * @caution
 * [고려사항]
 * Integer.toString(n, radix)를 이용해서 반복문을 돌며 값을 +1씩 하면서 2진법 중 1의 개수를 비교해주었다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '다음 큰 숫자'
public class Programmers12911 {
    public static void main(String[] args) {
        int n = 78;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = n+1;
        String numToStr = Integer.toString(n, 2);
        int oneCount = getOneCount(numToStr);
        while(true){
            if(getOneCount(Integer.toString(answer, 2)) == oneCount){
                return answer;
            }
            answer++;
        }
    }

    public static int getOneCount(String s){
        int oneCount = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1'){
                oneCount++;
            }
        }

        return oneCount;
    }
}

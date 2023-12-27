/**
 * @author nakhoon
 * @date 12/27/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/131128
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 최대 숫자 자리수가 300만이 될 수 있으므로 Integer로 파싱하게 되면 런타임 에러가 발생한다.
 * 그리고 contains로 문자열 포함을 판별하기에는 300만의 자리수를 계속 순회해야하기 때문에 시간 초과가 발생하므로
 * 숫자의 count를 세고, 그 뒤에 min을 이용해서 겹치는 최대 자리 수만큼 9부터 0 순으로 StringBuilder에 채워주었다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '숫자 짝꿍'
public class Programmers131128 {
    public static void main(String[] args) {
        String X = "100";
        String Y = "100";
        System.out.println(solution(X, Y));
    }

    public static String solution(String X, String Y) {
        String [] xSplit = X.split("");
        String [] ySplit = Y.split("");
        int [] xNumCount = new int[10];
        int [] yNumCount = new int[10];

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<xSplit.length;i++){
            xNumCount[Integer.parseInt(xSplit[i])]++;
        }

        for(int i=0;i<ySplit.length;i++){
            yNumCount[Integer.parseInt(ySplit[i])]++;
        }

        for(int i=9;i>=0;i--){
            for(int j=0;j<Math.min(xNumCount[i], yNumCount[i]);j++){
                sb.append(i);
            }
        }

        String answer = sb.toString();
        answer = answer.replaceAll("^0.*$", "0");

        return answer.equals("") ? "-1" : answer;
    }
}

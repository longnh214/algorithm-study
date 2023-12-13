/**
 * @author nakhoon
 * @date 12/13/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/17681
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 10진수 숫자를 2진수로 변환하기 위해 Integer.toString과 parseInt를 사용하였고, OR 연산( | )를 이용했다.
 * 출력하기 전에 0과 1을 각각 공백과 #으로 replace 해주었고, n이 6인데 문자열이 "###"만 나올 수 있으므로
 * 앞에 "   ###"와 같이 공백을 붙여주는 작업도 해주었다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '비밀지도'
public class Programmers17681 {
    public static void main(String[] args) {
        int n = 5;
        int [] arr1 = {9,20,28,18,11};
        int [] arr2 = {30,1,21,17,28};
        System.out.println(solution(n, arr1, arr2));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0;i<n;i++){
            String str1 = Integer.toString(arr1[i], 2);
            String str2 = Integer.toString(arr2[i], 2);

            answer[i] = Integer.toString(Integer.parseInt(str1, 2) | Integer.parseInt(str2, 2),2).replace("1", "#").replace("0", " ");
            if(answer[i].length() != n){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n - answer[i].length();j++){
                    sb.append(" ");
                }
                sb.append(answer[i]);

                answer[i] = sb.toString();
            }
        }

        return answer;
    }
}

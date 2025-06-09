/**
 * @author nakhoonchoi
 * @date 2025/06/09
 * @see https://boj.ma/1498
 * @mem 77,892kb
 * @time 524ms
 * @caution
 * [고려사항]
 * 문자열 문제가 기억이 나서 푼 KMP 문제이다.
 *
 * 입력 받은 문자열을 S라고 할 때
 * i를 1부터 S.length()-1까지 순회한다.
 * pi 배열에 S.substring(0, i) 기준 접두사와 접미사가 같은 최대 길이를 구하면서
 * if(len > 0 && (i+1) % (i+1 - pi[i]) == 0) 조건문으로 현재까지의 문자열이 특정 문자열의 반복으로 이루어져있는지 판별한다.
 * len > 0을 넣은 이유는 len이 0이라면 접두사와 접미사가 같은 문자열이 없기 때문에 주기가 1일 것이다.
 *
 * output StringBuilder에 현재까지의 문자열 길이 (i+1)와
 * 특정 문자열의 주기 횟수인 ((i+1) / (i+1 - pi[i]))를 담아서 출력하면 AC를 받을 수 있다.
 *
 * pi 배열을 이용해서 문자열이 특정 문자열의 주기로 이루어져있다는 것을 판별할 수 있다는게 매번 신기하다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <KMP> '주기문'

public class BOJ1498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder output = new StringBuilder();

        int[] pi = new int[s.length()];
        int len = 0;
        int n = s.length();
        for (int i = 1; i < s.length(); i++) {
            while (len > 0 && s.charAt(len) != s.charAt(i)) {
                len = pi[len - 1];
            }
            if (s.charAt(len) == s.charAt(i)) {
                len++;
                pi[i] = len;
            }

            if (pi[i] > 0 && (i + 1) % (i + 1 - pi[i]) == 0) {
                output.append(i + 1).append(' ').append((i + 1) / (i + 1 - pi[i])).append('\n');
            }
        }

        if (output.length() != 0) {
            System.out.println(output.substring(0, output.length() - 1));
        }
    }
}
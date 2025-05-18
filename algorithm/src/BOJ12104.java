/**
 * @author nakhoonchoi
 * @date 2025/05/18
 * @see https://boj.ma/12104
 * @mem 17,508kb
 * @time 164ms
 * @caution
 * [고려사항]
 * 입력의 첫번째를 str, 두번째를 pattern이라고 했을 때,
 * 처음에는 mod 연산을 이용해서 str의 인덱스 0부터 마지막까지 kmp를 하려고 했는데,
 * 그럴 필요 없이 str+str로 한 번 연장한 값과 pattern에 대해서 kmp 연산을 해서
 * 값이 있다면 count에 ++를 하는 방식으로 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <KMP> '순환 순열'

public class BOJ12104 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        sb.append(str).append(str);

        String concatStr = sb.toString();
        String pattern = br.readLine();

        int [] pi = getPi(pattern);

        int answer = 0;

        int index = 0;

        for(int i=0;i<concatStr.length();i++) {
            while (index > 0 && concatStr.charAt(i) != pattern.charAt(index)){
                index = pi[index - 1];
            }
            if (concatStr.charAt(i) == pattern.charAt(index)) {
                if (index == pattern.length() - 1) {
                    answer++;
                    index = pi[index];
                } else {
                    index++;
                }
            }
        }

        System.out.println(str.equals(pattern) ? answer - 1 : answer);
    }

    public static int [] getPi(String str) {
        int n = str.length();
        int len = 0;
        int [] pi = new int[n];

        for(int i=1;i<n;i++){
            while(len > 0 && str.charAt(i) != str.charAt(len)){
                len = pi[len - 1];
            }
            if(str.charAt(i) == str.charAt(len)){
                len++;
                pi[i] = len;
            }
        }

        return pi;
    }
}
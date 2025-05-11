/**
 * @author nakhoonchoi
 * @date 2025/05/12
 * @see https://boj.ma/1305
 * @mem 24,108kb
 * @time 260ms
 * @caution
 * [고려사항]
 * s에서 연속되는 가장 짧은 부분 문자열을 찾으면 되는 문제였다.
 * LPS 알고리즘을 이용해서 풀 수 있었다.
 * 4354번 문제에서 s 안에 반복되는 문자열은 s[0...n - pi[n-1]]을 이용해서
 * 문자열을 구할 수 있었고 이 길이를 출력하면 답이 되는 문제였기 때문에
 * n - pi[n-1]을 출력해주었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <KMP> '광고'

public class BOJ1305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int [] pi = new int[N];
        int len = 0;

        for(int i=1;i<N;i++){
            while(len > 0 && str.charAt(len) != str.charAt(i)){
                len = pi[len - 1];
            }
            if(str.charAt(len) == str.charAt(i)){
                len++;
                pi[i] = len;
            }
        }

        System.out.println(N - pi[N - 1]);
    }
}
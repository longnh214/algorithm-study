/**
 * @author nakhoonchoi
 * @date 2025/05/17
 * @see https://boj.ma/3356
 * @mem 24,984kb
 * @time 184ms
 * @caution
 * [고려사항]
 * 입력된 문자열 S는 S`의 반복된 문자열 중 일부임이 보장되어있기 때문에
 * LPS 배열을 구하고, N - pi[N-1]의 값을 출력하면
 * 문자열이 반복되는 가장 짧은 S`의 길이를 출력할 수 있다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <KMP> '라디오 전송'

public class BOJ3356 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int [] pi = new int[n];
        int len = 0;
        int max = 0;

        for(int i=1;i<n;i++){
            while(len > 0 && str.charAt(len) != str.charAt(i)){
                len = pi[len - 1];
            }
            if(str.charAt(len) == str.charAt(i)){
                len++;
                max = Math.max(max, len);
                pi[i] = len;
            }
        }

        System.out.println(n - pi[n-1]);
    }
}
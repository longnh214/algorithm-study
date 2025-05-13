/**
 * @author nakhoonchoi
 * @date 2025/05/13
 * @see https://boj.ma/16900
 * @mem 20,728kb
 * @time 176ms
 * @caution
 * [고려사항]
 * KMP의 LPS 알고리즘으로 효율적으로 부분 문자열이 N번 포함되는 문자열의 최소 길이를 알 수 있었다.
 *
 * str의 접두사와 접미사 공통 최장 문자열 길이를 구한 뒤에
 * str의 길이 * count - (공통 최장 문자열 길이 * (count - 1))를 출력하면 된다.
 *
 * "aba 3"의 경우에는 정답이 "abababa"로 7인데
 * 공통 최장 문자열의 길이가 count - 1만큼 세이브되는 것을 볼 수 있기에
 * 그대로 점화식으로 사용했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <KMP> '이름 정하기'

public class BOJ16900 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int count = Integer.parseInt(st.nextToken());
        int n = str.length();

        int [] pi = new int[n];
        int len = 0;

        for(int i=1;i<n;i++){
            while(len > 0 && str.charAt(i) != str.charAt(len)){
                len = pi[len - 1];
            }
            if(str.charAt(i) == str.charAt(len)){
                len++;
                pi[i] = len;
            }
        }

        long minLength = (long) n * count - ((long) pi[n - 1] * (count - 1));
        System.out.println(minLength);
    }
}
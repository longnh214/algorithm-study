/**
 * @author nakhoonchoi
 * @date 2025/05/11
 * @see https://boj.ma/4354
 * @mem 96,588kb
 * @time 404ms
 * @caution
 * [고려사항]
 * LPS(Longest proper Prefix which is also Suffix)
 * 알고리즘을 이용해서 문제를 해결할 수 있었다.
 *
 * 문제에서 문자열 s에 대해 s = a^n를 만족하는 n의 최대를 찾아야 한다는 건
 * 문자열 s에서 반복되는 부분 문자열이 존재하고 최대 몇 번 반복되는 지 알아봐야한다는 의미였다.
 *
 * 먼저 s 안에서 반복된 부분 문자열을 찾아야하는데
 * 부분 문자열은 KMP의 LPS 알고리즘을 이용해서 찾을 수 있었다.
 *
 * pi 배열의 (pi[i]) 의미는 s[0...i] 문자열에서 접두사와 접미사의 길이가 같은 최장 길이를 의미한다.
 * LPS 알고리즘을 이용해서 pi 배열에 값을 넣으면 pi[s.length()-1] 에는
 * 현재 s의 접두사/접미사의 가장 긴 문자열의 길이가 들어있을 것이다.
 *
 * 여기에서 문자열 s를 0부터 s.length() - pi[s.length()-1]까지
 * substring한 문자열이 반복된 부분 문자열이 될 수 있는 확률이 있다.(안될 수도 있다.)
 *
 * 우선 접두사와 접미사의 공통 최장 문자열이 있다는 것은 pi[s.length()-1]에서 알 수 있다.
 * s[0...k] == s[n-k...n-1]
 * "ababab"라는 s 문자열이 있을 때 문자열의 길이 n은 6이고 p = "ab"라고 가정하면
 * s = p + p + p이다. 접두사와 접미사가 같은 가장 긴 문자열은 무조건 p를 포함하고 있을 것이다. (p + p)
 * 여기에서 반복되는 문자열 p는 s에서 p + p(최장 수열)를 빼야 나오기 때문에
 * 반복되는 문자열 p는 s[0...(n - pi[n - 1])]이 보장된다.
 * 
 * 다만 s 문자열 길이 n % (n - pi[n - 1]) == 0 이어야 p가 반복된다는 의미이고
 * 나누어 떨어지지 않는다면 "abcdabc"와 같이 우연히 접두사와 접미사가 같은 경우이기 때문에
 * 1을 출력하면 되고 나누어 떨어진다면 n / (n - pi[n - 1]) 값을 출력하면 된다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <KMP> '문자열 제곱'

public class BOJ4354 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while(!(str = br.readLine()).equals(".")){
            int [] failTable = getPi(str);
            int n = str.length();
            int patternLength = n - failTable[n-1];

            if(n % patternLength == 0){
                System.out.println(n / patternLength);
            }else{
                System.out.println(1);
            }

        }
    }

    static int[] getPi(String pattern) {
        int[] pi = new int[pattern.length()];
        int len=0;
        for(int i=1;i<pattern.length();i++) {
            while(len > 0 && pattern.charAt(i) != pattern.charAt(len)) {
                len = pi[len-1];
            }
            if(pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                pi[i] = len;
            }
        }
        return pi;
    }
}
/**
 * @author nakhoonchoi
 * @date 2025/07/13
 * @see https://boj.ma/2011
 * @mem 14,440kb
 * @time 104ms
 * @caution
 * [고려사항]
 * 1000000 기준으로 MOD 연산을 해야했기에 DP 문제라고 예상했다.
 * 하지만 DP 문제 치고는 분기처리와 예외 처리 할 부분이 많았다.
 * 예외 처리할 부분과 함께 점화식을 설명하려고 한다.
 *
 * <예외 처리>
 * 1. 입력의 첫 자리 수가 0이라면 바로 0을 출력하고 끝내야한다. ex) "015"
 * 2. 현재 자리수가 0일 때 (현재 자리가 첫 자리수가 아닐 때)
 *   - 바로 앞 자리가 1이나 2가 아니라면 바로 0을 출력하고 끝내야 한다. ex) "30"이나 "50"은 유효하지 않다.
 * 3. 현재 자리수의 값이 0이 아니라면
 *   - 바로 앞 자리 수와 묶어서 10 ~ 26 사이의 수가 아니라면 현재 자리수에 대한 경우의 수만 더해준다.
 *
 *
 * <점화식, DP 로직>
 * dp 배열을 (입력 문자열의 길이 + 1)만큼 선언했다.
 * 현재 자릿수에 대한 경우의 수만 더할 때 dp[i+1] = (dp[i+1] + dp[i]) % MOD;
 * 두 자리 수가 알파벳 숫자에 유효해서 두 자리 앞 경우의 수도 더해야할 때 dp[i+1] = (dp[i+1] + dp[i-1]) % MOD;
 *
 * DP의 점화식 설계 뿐 아니라 예외 처리가 중요했던 재미있는 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <DP> '암호코드'

public class BOJ2011{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int MOD = 1000000;
        String input = br.readLine().strip();
        int N = input.length();
        int [] dp = new int[N+1];

        if(N > 0){
            if(input.charAt(0) == '0'){
                System.out.println(0);
                return;
            }
            dp[0] = 1;
            dp[1] = 1;
        }

        for(int i=1;i<N;i++){
            int twoDigitValue = Integer.parseInt(input.substring(i-1, i+1));
            if(input.charAt(i) == '0'){
                if(input.charAt(i-1) != '1' && input.charAt(i-1) != '2'){
                    System.out.println(0);
                    return;
                }else{
                    dp[i+1] = (dp[i+1] + dp[i-1]) % MOD;
                }
            }else{
                if(twoDigitValue / 10 != 0 && twoDigitValue <= 26){
                    dp[i+1] = (dp[i+1] + dp[i-1]) % MOD;
                }
                dp[i+1] = (dp[i+1] + dp[i]) % MOD;
            }
        }
        System.out.println(dp[N]);
    }
}
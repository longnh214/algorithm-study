/**
 * @author nakhoonchoi
 * @date 2025/04/16
 * @see https://boj.ma/1456
 * @mem 27,612kb
 * @time 376ms
 * @caution
 * [고려사항]
 * 에라토스테네의 체를 이용한 소수 판별 문제였다.
 * A와 B가 최대 10^14까지 갈 수 있으므로 int 형을 벗어날 수 있음에 주의해야했다.
 *
 * 거의 소수란 "소수의 N 제곱의 수"를 나타내는 의미였다.
 * 문제에서 구해야하는 것은 "1부터 B 까지의 거의 소수 개수 - 1부터 A 까지의 거의 소수 개수"이다.
 *
 * 거의 소수는 "소수의 N 제곱"이고 소수의 N 제곱이 A나 B이면 되기 때문에
 * 에라토스테네스의 체를 이용한 소수 판정은 2이상 Math.sqrt(B)이하 까지만 해주었다.
 *
 * 소수 판정한 값을 boolean 배열 형태로 저장했고,
 * 2부터 Math.sqrt(B)까지 순회하며 소수라면,
 * 소수의 N 제곱이 A보다 작을 때까지
 * 그리고 B보다 작거나 같을 때까지 순회하면서 count 를 세주었다.
 *
 * 그리고 bCount - aCount 를 구하면 답이었다.
 *
 * 왜 소수의 N 제곱이 A 미만까지 B 이하까지로 기준이 다르냐면 (미만과 이하)
 * 문제는 A보다 크거나 같고, B보다 작거나 같은 거의 소수의 개수를 구해야하기 때문에
 * 입력이 '4 4'와 같이 들어왔다면 답은 0이 아니라 1이다.
 * 
 * 그리고 에라토스테네스의 체를 구현할 때 i*i이 오버플로우가 발생하지 않도록
 * if((long) i*i > Integer.MAX_VALUE){
 *     break;
 * } 로 방어 로직을 작성해주었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <수학> '거의 소수'

public class BOJ1456 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int size = (int)Math.sqrt(B);

        boolean [] isNotPrime = new boolean[size + 1];

        isNotPrime[0] = isNotPrime[1] = true;
        for(int i=2;i<=size;i++) {
            if((long) i*i > Integer.MAX_VALUE){
                break;
            }

            for(int j=i*i;j<=size;j+=i) {
                isNotPrime[j] = true;
            }
        }

        int aCount = 0;
        for(int i=2;i<=(int)Math.sqrt(B);i++){
            if(!isNotPrime[i]){
                for(int j=2;Math.pow(i, j)<A;j++) {
                    aCount++;
                }
            }
        }

        int bCount = 0;
        for(int i=2;i<=(int)Math.sqrt(B);i++){
            if(!isNotPrime[i]){
                for(int j=2;Math.pow(i, j)<=B;j++) {
                    bCount++;
                }
            }
        }

        System.out.println(bCount - aCount);
    }
}
/**
 * @author choi
 * @date Jan 11, 2021
 * @see https://www.acmicpc.net/problem/1644
 * @mem 24,820kb
 * @time 204ms
 * @caution
 * [고려사항]
 * 소수 판정은 에라토스테네스의 체 알고리즘을 이용하였고(최근 소수 판정 문제),
 * 두 포인터 알고리즘을 미숙하게 사용하여 시간 초과나고 오래 걸렸던 문제...
 * input : 3999971, output : 2
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <두포인터> '소수의 연속합'
public class BOJ1644 {
    static final int MAX = 4000000;
    static boolean [] isPrime = new boolean[MAX+1];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        isPrime[0] = isPrime[1] = true;
        List<Integer> primeList = new ArrayList<>();
        for(int i=2;i*i<MAX;i++) {
            for(int j=i*i;j<MAX;j+=i) {
                isPrime[j] = true;
            }
        }

        for(int i=0;i<MAX;i++) {
            if(!isPrime[i])
                primeList.add(i);
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;

        while(true) {
            if(sum >= N) {
                sum -= primeList.get(start++);
            }else if(end == primeList.size()) {
                break;
            }else {
                sum += primeList.get(end++);
            }
            if(sum == N)
                count++;
        }

        System.out.println(count);
    }
}
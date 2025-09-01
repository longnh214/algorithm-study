/**
 * @author nakhoonchoi
 * @date 2025/09/02
 * @see https://boj.ma/16563
 * @mem 160,616kb
 * @time 984ms
 * @caution
 * [고려사항]
 * 일반적인 에라토스테네스의 체 로직으로는 시간 초과가 발생했다.
 * 하지만 기존의 로직에서 살짝 변형해서 문제를 해결할 수 있었다.
 *
 * 기존의 에라토스테네스의 체에서는 boolean 배열을 이용해서
 * 해당 수가 소수인지 아닌지를 확인할 수 있었고,
 * 소인수분해 시에 가장 작은 소수인 2부터 최대한 나눌 수 있는 만큼 나누고
 * 더 이상 안나누어진다면 다음 소수로 포인터를 올려서 나누어지는 지 판별할 수 있었다.
 * 하지만 이 방법은 입력 받을 수 있는 최대의 수(500000)에 대해서
 * isPrime 배열을 2부터 2237(= Math.sqrt(5000000)) 까지 계속 비효율적으로 순회를 해야했다.
 *
 * 하지만 살짝 변형해서 int 배열에 해당 수의 약수 중 1을 제외하고 가장 작은 수를 담는다면,
 * sieve[5000000]에는 2가 들어갈 것이고, sieve[49]에는 7이 들어갈 것이다.
 * 5000000을 소인수 분해 하더라도
 * 5000000(sieve[500000] = 2)
 * -> 2500000(sieve[2500000] = 2)
 * -> 1250000(sieve[1250000] = 2)
 * -> 625000(sieve[625000] = 2)
 * -> 312500(sieve[312500] = 2)
 * -> 156250(sieve[156250] = 2)
 * -> 78125(sieve[78125] = 5)
 * -> 15625(sieve[15625] = 5)
 * -> 3125(sieve[3125] = 5)
 * -> 625(sieve[625] = 5)
 * -> 125(sieve[125] = 5)
 * -> 25(sieve[25] = 5)
 * -> 5(sieve[5] = 5)
 * -> 1
 * 로 sieve 배열을 이용해 5000000을
 * (2^6 * 5^7)로 상대적으로 빠르게 소인수분해할 수 있다.
 *
 * 💡 소인수분해, 약수 관련 문제를 연습 중인데 문제를 많이 풀어서 여러 변형 문제에도 익숙해져야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <소수 판정> '어려운 소인수분해'

public class BOJ16563 {
    public static void main(String[] args) throws IOException{
        int [] sieve = new int[5000001];

        for(int i=0;i<5000001;i++){
            sieve[i] = i;
        }

        for(int i=2;i<=Math.sqrt(5000000);i++){
            for(int j=i*i;j<=5000000;j+=i){
                sieve[j] = Math.min(sieve[j], i);
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());

            while(num != 1){
                sb.append(sieve[num]).append(" ");
                num /= sieve[num];
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }

        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
}
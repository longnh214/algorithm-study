/**
 * @author nakhoonchoi
 * @date 2025/08/30
 * @see https://boj.ma/1565
 * @mem 20,028kb
 * @time 220ms
 * @caution
 * [고려사항]
 * 문제가 살짝 헷갈렸다. D 배열과 M 배열이 먼저 주어진다. 
 * M 배열의 값들에 대한 공통 약수들 중에서 D 배열의 모든 수에 대해 나누어떨어지는 수의 개수를 구하는 문제였다.
 * 
 * 1. D 배열의 모든 수에 대해 나누어떨어지는 경우를 구할 때 D 배열을 순회하면서 if(약수 % d[i] == 0)을 체크하는 경우도 있지만
 *   D 배열 전체에 대한 최소공배수를 미리 구해서 각 수마다 최소공배수를 나누면 한 번에 D 배열의 모든 수에 대해 나누어떨어지는 것을 확인할 수 있다.
 *   gcd(최대공약수) 로직과 lcm(최소공배수) 로직으로 D 배열의 모든 수에 대한 최소공배수를 lcm 변수에 저장했다.
 *   (D 배열이 6, 9, 12 라면 D 배열에 대한 최소공배수는 36이 된다.)
 *
 * 2. M 배열의 각 값에 대한 공통 약수를 구한다.
 *   위 흐름을 다음과 같은 순서로 나눴다.
 *   - 공통 약수를 저장할 list를 바깥에 선언한다.
 *   - M 배열을 순회하면서 m 값에 대한 약수를 구한다. (for(long m : M)을 순회한다는 가정하에)
 *   - 기존 공통 약수 list에 포함된 약수들만 필터링해서 공통 약수 list를 갱신한다.
 *
 * 2번에서 최종적으로 구한 공통 약수 list를 순회하면서 D 배열에 대한 최소공배수(1번에서 구한 값)를 나눴을 때
 * 나머지가 0이라면 count를 올려주는 방식으로 해결할 수 있었다.
 *
 * 💡 최대공약수(GCD) 구하는 로직이 항상 헷갈린다. 다른 최대공약수 구하는 문제도 풀어봐야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <수학> '수학'

public class BOJ1565 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long lcm = 1;
        for(int i=0;i<d;i++){
            long target = Long.parseLong(st.nextToken());
            lcm = lcm(lcm, target);
        }

        int count = 0;
        st = new StringTokenizer(br.readLine());
        List<Long> sameDivisors = getDivisors(Long.parseLong(st.nextToken()));

        for(int i=1;i<m;i++){
            long target = Long.parseLong(st.nextToken());

            List<Long> divisors = getDivisors(target);
            sameDivisors = getSameDivisors(sameDivisors, divisors);
        }

        for(long sameDivisor : sameDivisors){
            if(sameDivisor % lcm == 0){
                count++;
            }
        }

        System.out.println(count);
    }

    public static long gcd(long a, long b){
        if(b == 0){
            return a;
        }else {
            return gcd(b, a % b);
        }
    }

    public static long lcm(long a, long b){
        return a / gcd(a, b) * b;
    }

    public static List<Long> getSameDivisors(List<Long> sameDivisors, List<Long> divisors){
        List<Long> newSameDivisors = new ArrayList<>();

        for(long divisor : divisors){
            if(sameDivisors.contains(divisor)){
                newSameDivisors.add(divisor);
            }
        }

        return newSameDivisors;
    }

    public static List<Long> getDivisors(long target){
        long num = 1;
        List<Long> divisor = new ArrayList<>();
        List<Long> back = new ArrayList<>();
        while(true){
            if(target % num == 0){
                divisor.add(num);

                if((target / num) != num) {
                    back.add(target / num);
                }
            }
            num++;
            if(num > Math.sqrt(target)){
                break;
            }
        }

        Collections.reverse(back);
        divisor.addAll(back);
        return divisor;
    }
}
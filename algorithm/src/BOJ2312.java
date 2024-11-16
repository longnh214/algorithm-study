/**
 * @author nakhoonchoi
 * @date 2024/11/17
 * @see https://boj.ma/2312
 * @mem 13,616kb
 * @time 88ms
 * @caution
 * [고려사항]
 * 에라토스테네스의 체를 이용해서 소수를 구한다음,
 * 2부터 최대한 나누는 연산을 하며 나눠지면 map에 count를 하나씩 추가해주었다.
 * TreeMap을 이용해서 key를 오름차순으로 정렬된 keySet으로 출력하면 AC를 받을 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <수학> '수 복원하기'

public class BOJ2312 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean [] isNotPrime = new boolean[100001];

        for(int i=2;i<=100000;i++){
            if(isNotPrime[i]) {
                continue;
            }
            for(int j=2;j*i<=100000;j++){
                isNotPrime[j*i] = true;
            }
        }

        int N = Integer.parseInt(br.readLine());

        while(N-->0){
            int num = Integer.parseInt(br.readLine());
            int mod = 2;
            Map<Integer, Integer> map = new TreeMap<>();
            if(!isNotPrime[num]){
                sb.append(num).append(" ").append(1).append("\n");
                continue;
            }
            while(num != 1){
                if(num % mod == 0){
                    map.put(mod, map.getOrDefault(mod, 0) + 1);
                    num /= mod;
                    continue;
                }
                mod++;
            }

            for(int key : map.keySet()){
                sb.append(key).append(" ").append(map.get(key)).append("\n");
            }
        }

        System.out.println(sb.substring(0, sb.length()-1));
    }
}
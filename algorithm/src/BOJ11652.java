/**
 * @author nakhoon
 * @date 2022, 4월 22일
 * @see https://www.acmicpc.net/problem/11652
 * @mem 35,328kb
 * @time 368ms
 * @caution
 * [고려사항]
 * 2의 62승까지 커버해야하므로 int 형이 전혀 들어가면 안되고, long 형으로 풀어야 가능했다.
 * map을 이용해서 개수를 셌고, 그 중 최대 개수의 값 중 가장 작은 key를 출력했다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//백준 <자료 구조> '카드'
public class BOJ11652 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Long, Long> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        long maxIndex = -1;
        for(int i=0;i<N;i++){
            long num = Long.parseLong(br.readLine());
            maxIndex = num;
            map.put(num, map.getOrDefault(num, 0L) + 1);
        }
        long max = 1;

        for(long key : map.keySet()){
            long value = map.get(key);
            if(value > max){
                maxIndex = key;
                max = value;
            }
            if(value == max){
                maxIndex = Long.min(maxIndex, key);
            }
        }

        System.out.println(maxIndex);
    }
}
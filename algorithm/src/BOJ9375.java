/**
 * @author nakhoon
 * @date 2022, 5월 13일
 * @see https://www.acmicpc.net/problem/9375
 * @mem 11,800kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 조합의 공식으로 해결할 수 있는 문제이다. 타입마다 하나씩 입거나, 아예 안 입는 경우가 있으므로 (타입마다의 개수 + 1) * (다른 타입마다의 개수 + 1) * ...을
 * 계산해주고, 아무 것도 입지 않는 경우 1을 빼주면 총 경우의 수가 나오게 된다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//백준 <조합> '패션왕 신해빈'
public class BOJ9375 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-->0){
            int N = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int answer = 1;
            for(int value : map.values()){
                answer *= (value + 1);
            }
            System.out.println(answer - 1);
        }
    }
}
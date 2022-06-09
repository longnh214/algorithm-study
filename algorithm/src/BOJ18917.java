/**
 * @author nakhoon
 * @date 2022, 6월 9일
 * @see https://www.acmicpc.net/problem/18917
 * @mem 132,868kb
 * @time 820ms
 * @caution
 * [고려사항]
 * 배열을 저장하지 않고, 전체 합과 전체 xor 값을 저장하려고 했는데 xor을 빼는 경우를 어떻게 생각해야하는 지 어려웠다.
 * 자기 자신을 뺄 때도 xor을 하면 값이 갱신되었다. 이후에 전체 합과 xor을 출력했다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 <수학> '수열과 쿼리 38'
public class BOJ18917 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long sum = 0;
        long xor = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int count = st.countTokens();
            int command;
            int x = 0;
            command = Integer.parseInt(st.nextToken());
            if(count == 2){
                x = Integer.parseInt(st.nextToken());
            }

            switch(command){
                case 1:
                    sum += x;
                    xor ^= x;
                    break;
                case 2:
                    sum -= x;
                    xor ^= x;
                    break;
                case 3:
                    sb.append(sum).append("\n");
                    break;
                case 4:
                    sb.append(xor).append("\n");
                    break;
            }
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}
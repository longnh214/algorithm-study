/**
 * @author nakhoon
 * @date 2022, 4월 13일
 * @see https://www.acmicpc.net/problem/5555
 * @mem 11,624kb
 * @time 72ms
 * @caution
 * [고려사항]
 * StringBuilder를 통해 target의 길이-1까지만 추가하고 그 가변적인 문자열에 contains를 이용해서
 * 포함되는 지 포함 안되는 지 판별해서 더해주었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <문자열> '반지'
public class BOJ5555 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        
        for(int i=0;i<N;i++){
            StringBuilder sb = new StringBuilder();
            String str = br.readLine();
            sb.append(str).append(str.substring(0, target.length()-1));
            if(sb.toString().contains(target)){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
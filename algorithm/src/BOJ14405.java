/**
 * @author nakhoon
 * @date 2022, 5월 9일
 * @see https://www.acmicpc.net/problem/14405
 * @mem 11,632kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 맨 처음에는 replaceAll을 pi, ka, chu에 대해서 세번 수행했을 때에 틀렸습니다가 나왔고,
 * 정규 표현식을 이용해서 replaceAll을 한번 사용하면 pkai와 같은 문자열도 피카츄의 말로 이해할 수 있다.(ka 먼저, 다음에 pi 처리)
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <문자열> '피카츄'
public class BOJ14405 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.replaceAll("pi|ka|chu", "");

        if(str.length() == 0){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
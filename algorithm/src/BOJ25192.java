/**
 * @author nakhoon
 * @date 2022, 5월 15일
 * @see https://www.acmicpc.net/problem/25192
 * @mem 26,616kb
 * @time 236ms
 * @caution
 * [고려사항]
 * HashSet 자료구조를 이용해서 문제를 해결 할 수 있었다. ENTER 문자열이 입력 되었을 때 Set을 초기화하며 count를 세주는 방식으로 해결했다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//백준 <문자열> '인사성 밝은 곰곰이'
public class BOJ25192 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        Set<String> idSet = new HashSet<>();
        while(N-->0){
            String str = br.readLine();
            if(str.equals("ENTER")){
                count += idSet.size();
                idSet = new HashSet<>();
            }else{
                idSet.add(str);
            }
        }
        count += idSet.size();
        System.out.println(count);
    }
}
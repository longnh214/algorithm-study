/**
 * @author nakhoon
 * @date 2022, 5월 17일
 * @see https://www.acmicpc.net/problem/14425
 * @mem 38,984kb
 * @time 328ms
 * @caution
 * [고려사항]
 * Set 자료구조를 이용해서 중복을 제거한 집합을 저장하고, contains 내장 메소드로 set에 있는 지 없는 지 판별하였다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//백준 <자료구조> '문자열 집합'
public class BOJ14425 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for(int i=0;i<N;i++){
            set.add(br.readLine());
        }
        int count = 0;
        for(int i=0;i<M;i++){
            String str = br.readLine();
            if(set.contains(str)){
                count++;
            }
        }
        System.out.println(count);
    }
}
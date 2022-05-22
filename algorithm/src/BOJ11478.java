/**
 * @author nakhoon
 * @date 2022, 5월 22일
 * @see https://www.acmicpc.net/problem/11478
 * @mem 564,136kb
 * @time 1,112ms
 * @caution
 * [고려사항]
 * 문자열을 기준에 따라 자르고, HashSet 자료구조에 넣어 중복을 제거한 뒤 set의 size를 출력했다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//백준 <자료구조> '서로 다른 부분 문자열의 개수'
public class BOJ11478 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Set<String> set = new HashSet<>();

        for(int i=1;i<=str.length();i++){
            for(int j=0;j<str.length()-i+1;j++){
                String temp = str.substring(j, j+i);
                set.add(temp);
            }
        }
        System.out.println(set.size());
    }
}
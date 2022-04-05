/**
 * @author nakhoon
 * @date 2022, 4월 5일
 * @see https://www.acmicpc.net/problem/1302
 * @mem 11,760kb
 * @time 84ms
 * @caution
 * [고려사항]
 * key 값이 사전 순으로 정렬하기 위해 TreeMap을 사용해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

//백준 <자료 구조> '베스트셀러'
public class BOJ1302 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> countMap = new TreeMap<>();
        String answer = "";
        int count = 0;
        for(int i=0;i<N;i++){
            String str = br.readLine();
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        }
        for(String key : countMap.keySet()){
            if(countMap.get(key) > count){
                count = countMap.get(key);
                answer = key;
            }
        }
        System.out.println(answer);
    }
}
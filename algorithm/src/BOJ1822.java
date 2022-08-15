/**
 * @author nakhoon
 * @date 2022, 8월 15
 * @see https://www.acmicpc.net/problem/1822
 * @mem 184,180kb
 * @time 1,548ms
 * @caution
 * [고려사항]
 * 자바스크립트로 풀었던 추억의 문제이다.
 * TreeMap을 이용해서 문제를 해결했다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

//백준 <자료구조> '차집합'
public class BOJ1822 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<Integer> set = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            set.remove(Integer.parseInt(st.nextToken()));
        }

        if(set.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(set.size());
            StringBuilder sb = new StringBuilder();
            for(int num : set){
                sb.append(num).append(" ");
            }
            System.out.println(sb);
        }
    }
}
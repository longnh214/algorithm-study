/**
 * @author nakhoon
 * @date 2022, 2월 25일
 * @see https://www.acmicpc.net/problem/1764
 * @mem 25,848kb
 * @time 364ms
 * @caution
 * [고려사항]
 * 듣도 못한 사람을 저장할 HashSet과 듣도 보도 못한 사람을 저장할 TreeSet을 이용해서 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

//백준 <자료 구조> '듣보잡'
public class BOJ1764 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        Set<String> answerSet = new TreeSet<>();
        for(int i=0;i<N;i++){
            set.add(br.readLine());
        }
        for(int i=0;i<M;i++){
            String name = br.readLine();
            if(set.contains(name)){
                answerSet.add(name);
            }
        }
        System.out.println(answerSet.size());
        for(String name : answerSet){
            System.out.println(name);
        }
    }
}
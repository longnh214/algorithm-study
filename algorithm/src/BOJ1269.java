/**
 * @author nakhoon
 * @date 2022, 5월 18일
 * @see https://www.acmicpc.net/problem/1269
 * @mem 130,560kb
 * @time 828ms
 * @caution
 * [고려사항]
 * A 집합, B 집합을 입력 받고, 각각의 차집합 수를 집합에 저장하고 size를 출력하였다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//백준 <자료구조> '대칭 차집합'
public class BOJ1269 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();
        Set<Integer> answerSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            aSet.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            bSet.add(Integer.parseInt(st.nextToken()));
        }

        for(int num : aSet){
            if(!bSet.contains(num)){
                answerSet.add(num);
            }
        }

        for(int num : bSet){
            if(!aSet.contains(num)){
                answerSet.add(num);
            }
        }

        System.out.println(answerSet.size());
    }
}
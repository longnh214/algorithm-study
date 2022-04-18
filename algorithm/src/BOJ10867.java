/**
 * @author nakhoon
 * @date 2022, 4월 18일
 * @see https://www.acmicpc.net/problem/10867
 * @mem 24,004kb
 * @time 296ms
 * @caution
 * [고려사항]
 * Set의 구현체인 TreeSet 객체를 이용해서 문제를 해결할 수 있었다. 중복을 제거해주고, 정렬해준다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

//백준 <정렬> '중복 빼고 정렬하기'
public class BOJ10867 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> treeSet = new TreeSet<>();
        for(int i=0;i<N;i++){
            treeSet.add(Integer.parseInt(st.nextToken()));
        }
        StringBuilder sb = new StringBuilder();
        for(int num : treeSet){
            sb.append(num).append(" ");
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}
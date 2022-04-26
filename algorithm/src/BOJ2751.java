/**
 * @author nakhoon
 * @date 2022, 4월 26일
 * @see https://www.acmicpc.net/problem/2751
 * @mem 160,064kb
 * @time 1,352ms
 * @caution
 * [고려사항]
 * Arrays.sort()의 정렬 방식(dual-pivot Quicksort)으로는 시간 초과가 발생하고,
 * Collections.sort()로 통과할 수 있는 문제였다.
 * Collections.sort() - (는 Tim sort로 합병 및 삽입 정렬이 혼합된 정렬 - hybrid sorting algorithm)
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//백준 <정렬> '수 정렬하기 2'
public class BOJ2751 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int num : list){
            sb.append(num).append("\n");
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}
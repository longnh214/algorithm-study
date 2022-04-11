/**
 * @author nakhoon
 * @date 2022, 4월 11일
 * @see https://www.acmicpc.net/problem/11728
 * @mem 349,652kb
 * @time 1,448ms
 * @caution
 * [고려사항]
 * 리스트를 이용해서 정렬을 했을 때 실행 시간이 너무 길었다.
 * 하나의 배열에 전부 입력받아서 정렬했다면 더 단축이 됐을까...? 라는 생각이 들었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//백준 <정렬> '배열 합치기'
public class BOJ11728 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<first;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<second;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(int num : list){
            sb.append(num).append(" ");
        }

        System.out.println(sb.substring(0, sb.length()-1));
    }
}
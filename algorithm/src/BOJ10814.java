/**
 * @author nakhoon
 * @date 2022, 4월 9일
 * @see https://www.acmicpc.net/problem/10814
 * @mem 48,152kb
 * @time 564ms
 * @caution
 * [고려사항]
 * 리스트에 각 인적 사항 객체를 넣어서 정렬 기준에 따라 Comparable 인터페이스를 이용해서 정렬해주었다.
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

//백준 <정렬> '나이 순 정렬'
public class BOJ10814 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Info> infoList = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            infoList.add(new Info(i, name, age));
        }

        Collections.sort(infoList);

        StringBuilder sb = new StringBuilder();
        for(Info info : infoList){
            sb.append(info.age).append(" ").append(info.name).append("\n");
        }

        System.out.println(sb.substring(0, sb.length()-1));
    }
    static class Info implements Comparable<Info>{
        int index;
        String name;
        int age;

        public Info(int index, String name, int age) {
            this.index = index;
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Info o) {
            if(this.age == o.age){
                return Integer.compare(this.index, o.index);
            }
            return Integer.compare(this.age, o.age);
        }
    }
}
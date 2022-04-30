/**
 * @author nakhoon
 * @date 2022, 4월 30일
 * @see https://www.acmicpc.net/problem/10825
 * @mem 63,100kb
 * @time 660ms
 * @caution
 * [고려사항]
 * 객체에 Comparable상속을 통해 정렬 기준을 정해주어 정렬해줄 수 있었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//백준 <정렬> '국영수'
public class BOJ10825 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Data [] data = new Data[N];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            data[i] = new Data(name, korean, english, math);
        }

        Arrays.sort(data);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(data[i].name).append("\n");
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }

    static class Data implements Comparable<Data>{
        String name;
        int korean;
        int english;
        int math;

        Data(String name, int korean, int english, int math){
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Data o) {
            if(this.korean == o.korean){
                if(this.english == o.english){
                    if(this.math == o.math){
                        return this.name.compareTo(o.name);
                    }
                    return Integer.compare(this.math, o.math) * -1;
                }
                return Integer.compare(this.english, o.english);
            }
            return Integer.compare(this.korean, o.korean) * -1;
        }
    }
}
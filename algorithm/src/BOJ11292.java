/**
 * @author nakhoon
 * @date 2022, 6월 7일
 * @see https://www.acmicpc.net/problem/11292
 * @mem 11,732kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 배열을 이용한 정렬을 통해 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//백준 <정렬> '키 큰 사람'
public class BOJ11292 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        StringTokenizer st;
        while((N = Integer.parseInt(br.readLine())) != 0){
            Data [] arr = new Data[N];

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                double height = Double.parseDouble(st.nextToken());

                arr[i] = new Data(name, height, i);
            }

            Arrays.sort(arr);

            List<String> nameList = new ArrayList<>();
            double standard = arr[0].height;
            for(int i=0;i<N;i++){
                if(arr[i].height == standard){
                    nameList.add(arr[i].name);
                }else{
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            for(String name : nameList){
                sb.append(name).append(" ");
            }
            System.out.println(sb.substring(0, sb.length()-1));
        }
    }
    static class Data implements Comparable<Data>{
        String name;
        double height;
        int order;

        Data(String name, double height, int order){
            this.name = name;
            this.height = height;
            this.order = order;
        }

        @Override
        public int compareTo(Data o) {
            if(this.height == o.height){
                return Integer.compare(this.order, o.order);
            }
            return Double.compare(this.height, o.height) * -1;
        }
    }
}
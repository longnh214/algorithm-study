/**
 * @author nakhoon
 * @date 2022, 3월 31일
 * @see https://www.acmicpc.net/problem/11004
 * @mem 664,320kb
 * @time 3,272ms
 * @caution
 * [고려사항]
 * 시간 상 배열의 정렬로는 시간 초과가 발생했고, list의 정렬에서 통과가 되었다.
 * 배열에서 정렬하려면 quick selection sort라는 정렬을 이용해야 한다.
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

//백준 <정렬> 'K번째 수'
public class BOJ11004 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);
        System.out.println(list.get(K-1));
    }
}
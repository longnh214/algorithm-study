/**
 * @author nakhoon
 * @date 2022, 5월 25일
 * @see https://www.acmicpc.net/problem/9237
 * @mem 31,016kb
 * @time 416ms
 * @caution
 * [고려사항]
 * 먼저 나무들을 자라는 일 수에 대한 내림차순으로 정렬하고
 * 각 나무마다 심고 자라는 데 걸리는 일수를 계산하고 그 중 가장 최대값을 출력했다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//백준 <그리디> '이장님 초대'
public class BOJ9237 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer [] tree = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree, Collections.reverseOrder());
        int max=0;
        for(int i=0;i<N;i++) {
            tree[i]=tree[i]+i+1; //나무 자라는 일수+심는데 흐른 일수
            if(tree[i]>max)
                max=tree[i];
        }
        System.out.println(max+1);//1일에는 묘목 구매했음
    }
}
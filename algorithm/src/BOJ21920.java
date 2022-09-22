/**
 * @author nakhoon
 * @date 2022년 9월 22일
 * @see https://www.acmicpc.net/problem/21920
 * @mem 86,092kb
 * @time 588ms
 * @caution
 * [고려사항]
 * 일반적인 평균 구하는 공식으로는 답을 도출하지 못했고, 스트림의 average 함수를 이용한 평균 공식으로 정답을 출력했다.
 * 자바에서 스트림을 이용하지 않고 문제를 해결할 수 있는 방법이 궁금하다. 왜 난이도가 실버 4지...?
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <수학> '서로소 평균'
public class BOJ21920 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int X = Integer.parseInt(br.readLine());

        List<Integer> resultList = new ArrayList<>();
        for(int i=0;i<N;i++){
            if(gcd(arr[i], X) == 1){
                resultList.add(arr[i]);
            }
        }
        double average = resultList.stream().mapToInt(s -> s).average().getAsDouble();
        System.out.println(average);
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
/**
 * @author nakhoonchoi
 * @date 2025/04/15
 * @see https://boj.ma/1422
 * @mem 14,348kb
 * @time 108ms
 * @caution
 * [고려사항]
 * 정렬 기반 그리디 문제였다.
 * 문제를 보자마자 백준 16496번 '큰 수 만들기'가 생각났다.
 * 최근에 푼 문제여서 그런가? 숫자를 문자열 기반으로 정렬하고
 * 리스트를 순회하다가 가장 큰 수를 만나면 N-K 횟수만큼 sb에 append를 하면 되는 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <정렬> '숫자의 신'

public class BOJ1422{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        List<String> numList = new ArrayList<>();
        int biggest = 0;
        for(int i=0;i<K;i++){
            String str = br.readLine();
            numList.add(str);
            biggest = Math.max(biggest, Integer.parseInt(str));
        }

        numList.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1) * -1);

        StringBuilder sb = new StringBuilder();
        boolean flag = false;

        for(String num : numList){
            if(!flag && Integer.parseInt(num) == biggest){
                flag = true;
                for(int i=0;i<N-K;i++){
                    sb.append(biggest);
                }
            }
            sb.append(num);
        }

        System.out.println(sb);
    }
}
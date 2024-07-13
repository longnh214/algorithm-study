/**
 * @author nakhoonchoi
 * @date 2024/07/13
 * @see https://www.acmicpc.net/problem/20053
 * @mem 310,108kb
 * @time 772ms
 * @caution
 * [고려사항]
 * Math.min과 Math.max를 이용해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <구현> '최소, 최대 2'

public class BOJ20053 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-->0){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                int num = Integer.parseInt(st.nextToken());
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
            System.out.println(min + " " + max);
        }
    }
}
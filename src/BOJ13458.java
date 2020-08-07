/**
 * @author choi
 * @date 2020. 8. 7
 * @see https://www.acmicpc.net/problem/13458
 * @mem 127,200kb
 * @time 444ms
 * @caution
 * [고려사항] long형으로 답을 계산해야 틀리지 않는다.
 *        @주의 : 모든 시험장마다 총 감독관은 1명 필수다!
 *        부 감독관은 없어도 된다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디 알고리즘> - '시험 감독'
public class BOJ13458 {
    static int N,B,C;
    static long count;
    static long [] tester;
    public static void main(String[] args) throws IOException{
        count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        tester = new long[N];
        for(int i=0;i<N;i++) {
            tester[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++) {
            tester[i] -= B;
            count++;
            //...
            if(tester[i] < 0) {
                tester[i] = 0;
            }

            if(tester[i]%C != 0){
                count+=((tester[i]/C)+1);
            }else {
                count+=(tester[i]/C);
            }
        }

        System.out.println(count);
    }
}
/**
 * @author choi
 * @date Nov 2, 2020
 * @see https://www.acmicpc.net/problem/1062
 * @mem 13,412kb
 * @time 308ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <브루트포스> '가르침'
public class BOJ1062 {
    static int N,K,answer;
    static String [] strArr;
    static int [] alb = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        alb[0] = 1;
        alb[2] = 1;
        alb[8] = 1;
        alb[19] = 1;
        alb[13] = 1;

        answer = 0;

        strArr = new String[N];


        for(int i=0;i<N;i++) {
            strArr[i] = br.readLine();
        }

        comb(5,0);

        System.out.println(answer);
    }
    public static void comb(int cnt, int start) {
        if(cnt == K) {
            //단어 개수 판별
            int count = 0;
            outer : for(int i=0;i<N;i++) {
                for(int j=0;j<strArr[i].length();j++) {
                    int index = strArr[i].charAt(j) - 'a';
                    if(alb[index] != 1)
                        continue outer;
                }
                count++;
            }

            answer = Math.max(answer, count);
        }

        for(int i=start;i<26;i++) {
            if(alb[i] == 1) {
                continue;
            }else {
                alb[i] = 1;
                comb(cnt+1, i+1);
                alb[i] = 0;
            }
        }
    }
}
/**
 * @author choi
 * @date Aug 28, 2020
 * @see https://www.acmicpc.net/problem/1759
 * @mem 13,168kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 자음이 두 개 이상, 모음이 한 개 이상이라는 조건을 잘 보고 문제를 풀어야 겠다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <브루트포스> - '암호 만들기'
public class BOJ1759 {
    static int N, M;
    static char [] code;
    static char [] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        code = new char[M];
        temp = new char[N];
        for(int i=0;i<M;i++) {
            code[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(code);

        combination(0, 0);
    }

    public static void combination(int cnt, int start) {
        if(cnt == N) {
            StringBuilder sb = new StringBuilder();
            //모음, 자음 변수
            int aCount = 0;
            int bCount = 0;
            for(char ch : temp) {
                //해당 자수가 모음이라면 모음카운트++
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                    aCount++;
                sb.append(ch);
            }
            //문자열 길이 - 모음카운트 = 자음카운트
            bCount = sb.toString().length() - aCount;
            //모음이 1개 이상이고 자음이 두개 이상이라면.
            if(aCount >=1 && bCount >=2) {
                System.out.println(sb);
            }
            return;
        }
        for(int i=start;i<M;i++) {
            temp[cnt] = code[i];
            combination(cnt+1, i+1);
        }
    }
}
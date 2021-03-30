/**
 * @author choi
 * @date Dec 29, 2020
 * @see https://www.acmicpc.net/problem/1074
 * @mem 11,472kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 재귀적으로 탐색 - 결정 요인? r,c,len;
 * 불필요한 탐색 - 어떤 영역을 잘라봤더니... 거기는 답이 있을 턱이 없다!!! -> 탐색 할 필요도 없겠네...
 * [입력사항]
 * 항상 2^N * 2^N 크기 - 2의 지수승
 * [출력사항]
 * 몇 번째에서 탐색이 이뤄졌는가?
 */
import java.util.*;
import java.io.*;
//백준 <분할정복> 'Z'
public class BOJ1074 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,r,c,answer;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        answer = 0;

        recursion(0,0,(int)Math.pow(2, N));

        //System.out.println(answer);
    }

    public static void recursion(int i, int j, int size) {
        //기저 조건
        if(size == 1) {
            if(i == r && j == c) {
                System.out.println(answer);
                return;
            }
            answer++;
            return;
        }

        //현재 영역에 답이 없다면??
        if(!(i <= r && r < i + size && j <= c && c < j + size)) {
            answer += size*size;
            return;
        }

        //재귀조건 - 1칸이 아니면 쪼개기. - 4등분해서 다음 재귀 호출
        int next = size/2;
        recursion(i,j,next);
        recursion(i,j+next,next);
        recursion(i+next,j,next);
        recursion(i+next,j+next,next);
    }
}
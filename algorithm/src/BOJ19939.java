/**
 * @author nakhoon
 * @date 2022, 3월 4일
 * @see https://www.acmicpc.net/problem/19939
 * @mem 11,500kb
 * @time 72ms
 * @caution
 * [고려사항]
 * 먼저 1,2,3,4,...K(바구니 갯수) 만큼 채우고 그 뒤에 남은 수가 K로 나누어 떨어진다면 (바구니 개수 - 1)이 정답이 될 것이다.
 * 그리고 나머지가 있다면 가장 낮은 값은 1 + (N/K), 가장 높은 값은 K + 1 + (N/K)이 될 것이므로 바구니 갯수 K가 정답이 될 것이다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 <그리디> '박 터뜨리기'
public class BOJ19939 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for(int i=1;i<K+1;i++) {
            N-=i;
            if(N < 0) {
                break;
            }
        }
        if(N >= 0) {
            if(N%K > 0) {
                System.out.println(K);;
            }else {
                System.out.println(K-1);
            }
        }else {
            System.out.println(-1);
        }
    }
}
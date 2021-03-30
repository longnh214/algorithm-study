/**
 * @author choi
 * @date Aug 4, 2020
 * @see http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1136&sca=40&sfl=wr_hit&stx=1863
 * @mem 30MB
 * @time 453ms
 * @caution
 * [고려사항] bfs로 풀려했는데 안되어서 서로소 집합을 이용해 풀었습니다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//정올 <그래프 알고리즘> - '종교'
public class Jungol1863 {
    static int number[];
    static int rank[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        number = new int[N+1];
        rank = new int[N+1];

        for(int i=1;i<=N;i++) {
            number[i] = i;
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }

        int count = 0;
        for(int i=1;i<=N;i++) {
            if(number[i] == i)
                count++;
        }
        System.out.println(count);
    }

    public static int find(int x) {
        if(number[x] == x) {
            return x;
        }
        return number[x] = find(number[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        //rank union 적용
        if(rank[x] == rank[y]) {
            rank[x]++;
        }
        //rank가 작은 녀석을 큰 녀석에게 붙여주자.
        if(rank[x] > rank[y]) {
            number[y] = x;
        }else {
            number[x] = y;

        }
    }
}
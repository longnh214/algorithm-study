/**
 * @author choi
 * @date Aug 27, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD
 * @mem 21,656kb
 * @time 370ms
 * @caution
 * [고려사항]
 * 가지치기를 하기 위한 조건을 permutation 함수에 넣어주었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//SW Expert <D5> '최적경로'
public class Solution1247 {
    static int comX, comY, homeX, homeY, answer, N;
    static Point [] customer, temp;
    static boolean [] visited;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            answer = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            customer = new Point[N];
            temp = new Point[N];
            visited = new boolean[N];
            st = new StringTokenizer(br.readLine());
            comX = Integer.parseInt(st.nextToken());
            comY = Integer.parseInt(st.nextToken());
            homeX = Integer.parseInt(st.nextToken());
            homeY = Integer.parseInt(st.nextToken());
            for(int i=0;i<N;i++) {
                int customX = Integer.parseInt(st.nextToken());
                int customY = Integer.parseInt(st.nextToken());
                customer[i] = new Point(customX, customY);
            }
            permutation(0,0);
            System.out.println("#"+t+ " " + answer);
        }
    }

    public static void permutation(int cnt, int sum) {
        if(sum > answer)
            return;

        if(cnt == N) {
            answer = Math.min(answer, sum);
            return;
        }

        for(int i=0;i<N;i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp[cnt] = customer[i];
                if(cnt == 0)
                    permutation(cnt+1, sum + (Math.abs(temp[cnt].x - comX) + Math.abs(temp[cnt].y - comY)));
                else if(cnt == N-1)
                    permutation(cnt + 1, sum + (Math.abs(temp[cnt].x - temp[cnt - 1].x) + Math.abs(temp[cnt].y - temp[cnt - 1].y) + (Math.abs(homeX - temp[cnt].x) + Math.abs(homeY - temp[cnt].y))));
                else
                    permutation(cnt+1, sum + (Math.abs(temp[cnt].x - temp[cnt-1].x) + Math.abs(temp[cnt].y - temp[cnt-1].y)));
                visited[i] = false;
            }
        }
    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return x + ", " + y;
        }
    }
}
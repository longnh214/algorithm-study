/**
 * @author choi
 * @date Aug 26, 2020
 * @see https://www.acmicpc.net/problem/17406
 * @mem 21,612kb
 * @time 260ms
 * @caution
 * [고려사항] 배열을 회전할 때에 회전하는 for문의 인덱스를 잘못 변경해주어 회전이 이상하게 되는 경우가 많았다.
 * 		배열의 인덱스를 잘 체크해야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <브루트포스> - '배열 돌리기 4'
public class BOJ17406 {
    static int [][] arr;
    static int [][] copy;
    static int N,M,K,answer;
    static List<RotateIndex> rList = new ArrayList<>();
    static RotateIndex [] rArr;
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        arr = new int[N+1][M+1];
        copy = new int[N+1][M+1];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            rList.add(new RotateIndex(r,c,s));
        }
        visited = new boolean[rList.size()];
        rArr = new RotateIndex[rList.size()];

        permutation(0);
        System.out.println(answer);
    }

    public static void permutation(int cnt) {
        if(cnt == rList.size()) {
            arrCopy();
            for(int i=0;i<rArr.length;i++) {
                rotate(rArr[i].r,rArr[i].c,rArr[i].s);
            }
            int tempMin = Integer.MAX_VALUE;
            for(int i=1;i<=N;i++) {
                int sum = 0;
                for(int j=1;j<=M;j++) {
                    sum+=copy[i][j];
                }
                tempMin = Math.min(sum, tempMin);
            }
            answer = Math.min(answer, tempMin);
            return;
        }

        for(int i=0;i<rList.size();i++) {
            if(!visited[i]) {
                rArr[cnt] = rList.get(i);
                visited[i] = true;
                permutation(cnt+1);
                visited[i] = false;
            }
        }
    }

    public static void rotate(int r, int c, int s) {
        int startR = r-s;
        int startC = c-s;
        int endR = r+s;
        int endC = c+s;
        int range = 2*s+1;
        while(range > 1) {
            int temp = copy[startR][endC];
            int temp2;
            for(int i=0;i<range-1;i++) {
                copy[startR][endC-i] = copy[startR][endC-i-1];
            }

            temp2 = copy[endR][endC];
            for(int i=0;i<range-2;i++) {
                copy[endR-i][endC] = copy[endR-i-1][endC];
            }
            copy[startR+1][endC] = temp;
            temp = temp2;
            temp2 = copy[endR][startC];
            for(int i=0;i<range-2;i++) {
                copy[endR][startC+i] = copy[endR][startC+i+1];
            }
            copy[endR][endC-1] = temp;
            temp = temp2;
            for(int i=0;i<range-1;i++) {
                copy[startR+i][startC] = copy[startR+i+1][startC];
            }
            copy[endR-1][startC] = temp;
            startR+=1;
            startC+=1;
            endR-=1;
            endC-=1;

            range -= 2;
        }
    }

    public static void arrCopy() {
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                copy[i][j] = arr[i][j];
            }
        }
    }

    static class RotateIndex{
        int r;
        int c;
        int s;
        RotateIndex(int r,int c,int s){
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
}

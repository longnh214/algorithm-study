/**
 * @author choi
 * @date Aug 25, 2020
 * @see https://www.acmicpc.net/problem/1992
 * @mem 14,296kb
 * @time 140ms
 * @caution
 * [고려사항] 괄호를 언제 넣어야 하는 지 헷갈렸던 문제이다. z와 비슷했던 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <분할정복> - '쿼드 트리'
public class BOJ1992 {
    static int N;
    static int [][] arr;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0;i<N;i++) {
            String s = br.readLine();
            for(int j=0;j<N;j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        quadTree(0,0,N);
    }
    public static void quadTree(int x, int y, int size) {
        int cur = arr[x][y];
        boolean flag = true;
        for(int i=x;i<(x+size) && flag;i++) {
            for(int j=y;j<(y+size) && flag;j++) {
                if(cur != arr[i][j]) flag = false;
            }
        }
        if(flag) System.out.print(cur);
        else {
            System.out.print("(");
            quadTree(x,y,size/2);
            quadTree(x,y+size/2,size/2);
            quadTree(x+size/2,y,size/2);
            quadTree(x+size/2,y+size/2,size/2);
            System.out.print(")");
        }

    }
}
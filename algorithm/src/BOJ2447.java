/**
 * @author choi
 * @date Aug 30, 2020
 * @see https://www.acmicpc.net/problem/2447
 * @mem 35,620kb
 * @time 412ms
 * @caution
 * [고려사항]
 * 분할 정복을 하기 위해 flag를 두었다.
 * 공백을 출력할 때와 정상적으로
 * ***
 * * *
 * *** 을 출력할 때를 flag로 나눴다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <분할정복> '별 찍기 - 10'
public class BOJ2447 {
    static char [][] map;
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        star(N,0,0,true);
        for(int i=0;i<N;i++) {
            System.out.println(map[i]);
        }
    }

    public static void star(int n, int x, int y, boolean flag) {
        if(n == 3 && flag) {
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    if(i==1 && j==1) map[x+i][y+j] = ' ';
                    else map[x+i][y+j] = '*';
                }
            }
            return;
        }else if(n == 3 && !flag) {
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    map[x+i][y+j] = ' ';
                }
            }
            return;
        }
        int size = n/3;
        if(!flag) flag = false;
        star(size,x,y,flag);
        star(size,x,y+size,flag);
        star(size,x,y+2*size,flag);
        star(size,x+size,y,flag);
        star(size,x+size,y+size,false);
        star(size,x+size,y+2*size,flag);
        star(size,x+2*size,y,flag);
        star(size,x+2*size,y+size,flag);
        star(size,x+2*size,y+2*size,flag);
    }
}
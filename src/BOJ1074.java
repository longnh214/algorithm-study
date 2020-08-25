/**
 * @author choi
 * @date Aug 25, 2020
 * @see https://www.acmicpc.net/problem/1074
 * @mem 13516kb
 * @time 3668ms
 * @caution
 * [고려사항] 배열로 선언하면 배열의 인덱스가 2^15 * 2^15가 될 수 있으므로 메모리 초과가 날 수 밖에 없다.
 * 		시간 초과가 나는 부분을 개선해야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <분할정복> - 'Z'
public class BOJ1074 {
    static int N,r,c,count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        count = 0;
        z(0,0,2<<N);
    }

    public static void z(int i, int j, int size) {
        if(size == 1) {
            if(i == r && j == c)
                System.out.println(count);
            count++;
            return;
        }

        z(i,j,size/2);
        z(i,j+size/2,size/2);
        z(i+size/2,j,size/2);
        z(i+size/2,j+size/2,size/2);
    }
}
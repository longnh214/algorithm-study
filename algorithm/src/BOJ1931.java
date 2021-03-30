/**
 * @author choi
 * @date Aug 6, 2020
 * @see https://www.acmicpc.net/problem/1931
 * @mem 44,696kb
 * @time 484ms
 * @caution
 * [고려사항] 가장 끝나는 시간이 빠른 회의실을 고르면 무조건 최적의 해가 된다는 것을 알고나면 풀 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디 알고리즘> - '회의실 배정'
public class BOJ1931 {
    static int N;
    static int [][] conference;
    static int [] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        conference = new int[N][2];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            conference[i][0] = Integer.parseInt(st.nextToken());
            conference[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(conference, new Comparator<int []>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                else {
                    return Integer.compare(o1[1], o2[1]);
                }
            }
        });

        int count = 1;
        int end = conference[0][1];
        for(int i=1;i<N;i++) {
            if(conference[i][0] >= end) {
                end = conference[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
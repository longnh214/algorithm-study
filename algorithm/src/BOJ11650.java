/**
 * @author choi
 * @date Aug 9, 2020
 * @see https://www.acmicpc.net/problem/11650
 * @mem 213,256kb
 * @time 2,648ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <정렬> - '좌표 정렬하기'
public class BOJ11650 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Dot> list = new ArrayList<>();
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Dot(x,y));
        }

        Collections.sort(list);

        for(Dot dot : list) {
            System.out.printf("%d %d\n",dot.x,dot.y);
        }
    }
    static class Dot implements Comparable<Dot>{
        int x;
        int y;
        public Dot(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Dot o) {
            if(this.x != o.x) return Integer.compare(this.x, o.x);
            else return Integer.compare(this.y, o.y);
        }
    }
}
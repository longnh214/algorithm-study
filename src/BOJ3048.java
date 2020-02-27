import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ3048 {
    static char [] first;
    static char [] second;
    static ArrayList<Point> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    //StringBuilder가 StringBuffer보다 성능이 좋다. Synchronized를 사용해야하는 멀티쓰레드 프로그램이면 StringBuffer 객체 사용.
    //static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());
        first = new char[N1];
        second = new char[N2];
        first = br.readLine().toCharArray();
        for (int i = N1-1; i >= 0 ; i--) {
            list.add(new Point(first[i], 1));
        }
        second = br.readLine().toCharArray();
        for(int i=0;i<N2;i++){
            list.add(new Point(second[i], 2));
        }
        int T = Integer.parseInt(br.readLine());

        // 시뮬레이션 이전에 시간 초가 T보다 높으면 계산을 미리 끝내고 return
        if(N2 + N1 -1 <= T) {
            for (int i = 0; i < second.length; i++) {
                sb.append(second[i]);
            }

            for (int i = first.length-1; i >= 0; i--) {
                sb.append(first[i]);
            }
            System.out.println(sb.toString());
            return ;
        }

        while(T-- >0) {
            for (int i = 0; i < list.size()-1; i++) {
                Point cur = list.get(i);
                Point next = list.get(i+1);
                System.out.println("i : " + i);
                System.out.println("cur.c : " + cur.c + " cur.dir : " + cur.dir);
                System.out.println("next.c : " + next.c + " next.dir : " + next.dir);

                //cur.dir이 1이고 next.dir이 2일 때만 맞바꾼다.
                if(cur.dir==2 || cur.dir == next.dir) continue;

                list.set(i, next);
                list.set(i+1, cur);
                //이미 바뀐 두 index는 건드릴 필요가 없으므로 skip.
                i++;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).c);
        }
        System.out.println(sb.toString());
    }

    static class Point{
        char c;
        int dir;
        Point(char c, int dir){
            this.c = c;
            this.dir = dir;
        }
    }
}

/**
 * @author choi
 * @date 2020. 7. 31
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWGsRbk6AQIDFAVW&categoryId=AWGsRbk6AQIDFAVW&categoryType=CODE
 * @mem 28,624 kb
 * @time 203 ms
 * @caution
 * [고려사항] 큐를 두개 써서 번갈아서 poll하여 출력했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//SW expert <D3> - '퍼펙트 셔플'
public class Solution3499 {
    static Queue<String> first = new LinkedList<String>();
    static Queue<String> second = new LinkedList<String>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            int count = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            if(count % 2 == 0) {
                for(int i=0;i<count/2;i++) {
                    first.offer(st.nextToken());
                }
                for(int i=count/2;i<count;i++) {
                    second.offer(st.nextToken());
                }
            }else {
                for(int i=0;i<(count+1)/2;i++) {
                    first.offer(st.nextToken());
                }
                for(int i=(count+1)/2;i<count;i++) {
                    second.offer(st.nextToken());
                }
            }
            System.out.printf("#%d ",t);
            while(!first.isEmpty() || !second.isEmpty()) {
                if(!first.isEmpty())
                    System.out.printf("%s ",first.poll());
                if(!second.isEmpty())
                    System.out.printf("%s ",second.poll());
            }
            System.out.println();
        }
    }
}
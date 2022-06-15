/**
 * @author nakhoon
 * @date 2022, 6월 15일
 * @see https://www.acmicpc.net/problem/14235
 * @mem 35,308kb
 * @time 344ms
 * @caution
 * [고려사항]
 * 우선순위 큐를 이용해서 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//백준 <우선순위 큐> '크리스마스 선물'
public class BOJ14235 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int count;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2) * -1;
            }
        });
        while(N-->0){
            st = new StringTokenizer(br.readLine());
            count = st.countTokens();
            if(count == 1){
                if(pq.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(pq.poll()).append("\n");
                }
            }else{
                st.nextToken();
                for(int i=1;i<count;i++){
                    pq.offer(Integer.parseInt(st.nextToken()));
                }
            }
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}
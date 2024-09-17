/**
 * @author nakhoonchoi
 * @date 2024/09/17
 * @see https://www.acmicpc.net/problem/7662
 * @mem 454,588kb
 * @time 3,140ms
 * @caution
 * [고려사항]
 * maxPQ와 minPQ를 이용해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <우선순위 큐> '이중 우선순위 큐'
public class BOJ7662_3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> minPQ = new PriorityQueue<>();
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> map = new HashMap<>();

            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(command.equals("I")){
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    maxPQ.offer(num);
                    minPQ.offer(num);
                }else{
                    if(num == 1){
                        if(maxPQ.isEmpty())
                            continue;
                        int p = maxPQ.peek();
                        while (!map.containsKey(p)) {
                            p = maxPQ.poll();
                            if (maxPQ.isEmpty())
                                break;
                            p = maxPQ.peek();
                        }
                        if (!maxPQ.isEmpty()) {
                            p = maxPQ.poll();
                            if (map.get(p) == 1) {
                                map.remove(p);
                            } else {
                                map.put(p, map.get(p) - 1);
                            }
                        }
                    }else{
                        if(minPQ.isEmpty())
                            continue;
                        int p = minPQ.peek();
                        while (!map.containsKey(p)) {
                            p = minPQ.poll();
                            if (maxPQ.isEmpty())
                                break;
                            p = minPQ.peek();
                        }
                        if (!minPQ.isEmpty()) {
                            p = minPQ.poll();
                            if (map.get(p) == 1) {
                                map.remove(p);
                            } else {
                                map.put(p, map.get(p) - 1);
                            }
                        }
                    }
                    if(map.isEmpty()){
                        minPQ.clear();
                        maxPQ.clear();
                    }
                }
            }
            if (!maxPQ.isEmpty()) {
                int p = maxPQ.peek();
                while (!map.containsKey(p)) {
                    p = maxPQ.poll();
                    if (maxPQ.isEmpty())
                        break;
                    p = maxPQ.peek();
                }
            }
            if (!minPQ.isEmpty()) {
                int p = minPQ.peek();
                while (!map.containsKey(p)) {
                    p = minPQ.poll();
                    if (maxPQ.isEmpty())
                        break;
                    p = minPQ.peek();
                }
            }
            System.out.println(map.isEmpty() ? "EMPTY" : maxPQ.peek() + " " + minPQ.peek());
        }
    }
}

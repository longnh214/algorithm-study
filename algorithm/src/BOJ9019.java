/**
 * @author nakhoon
 * @date 2022, 2월 27일
 * @see https://www.acmicpc.net/problem/9019
 * @mem 328,364kb
 * @time 9,784ms
 * @caution
 * [고려사항]
 * 회전을 숫자의 나누기와 나머지 연산으로 수행하고 BFS로 완전 탐색해서 문제를 해결했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS> 'DSLR'
public class BOJ9019 {
    static int num, target;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());

            Set<Integer> visited = new HashSet<>();
            Queue<Status> q = new LinkedList<>();
            q.offer(new Status(num, ""));
            visited.add(num);
            while(!q.isEmpty()){
                Status cur = q.poll();

                if(cur.num == target){
                    System.out.println(cur.route);
                    break;
                }

                int D = (cur.num * 2) % 10000;
                if(!visited.contains(D)){
                    visited.add(D);
                    q.offer(new Status(D, cur.route + "D"));
                }
                int S = (cur.num == 0) ? 9999 : cur.num - 1;
                if(!visited.contains(S)) {
                    visited.add(S);
                    q.offer(new Status(S, cur.route + "S"));
                }
                int L = (cur.num % 1000) * 10 + (cur.num / 1000);
                if(!visited.contains(L)) {
                    visited.add(L);
                    q.offer(new Status(L, cur.route + "L"));
                }
                int R = (cur.num % 10) * 1000 + (cur.num / 10);
                if(!visited.contains(R)){
                    visited.add(R);
                    q.offer(new Status(R, cur.route + "R"));
                }
            }
        }
    }

    static class Status{
        int num;
        String route;
        Status(int num, String route){
            this.num = num;
            this.route = route;
        }
    }
}
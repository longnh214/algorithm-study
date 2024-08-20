/**
 * @author nakhoonchoi
 * @date 2024/08/20
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/42861
 * @caution
 * [고려사항]
 * 프로그래머스에서 문제 분류를 그리디로 해놓았지만,
 * 문제를 보자마자 MST 최소 신장 트리 문제인 것을 알 수 있었다.
 * 크루스칼, 프림 알고리즘이 있지만
 * 그 중 익숙한 크루스칼 알고리즘으로 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//프로그래머스 <그리디> '섬 연결하기'

public class Programmers42861 {
    static int [] parent;
    public static void main(String[] args) {
        int n = 4;
        int [][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        System.out.println(solution(n, costs));
    }

    public static int solution(int n, int[][] costs) {
        parent = new int[n];
        for(int i=0;i< parent.length;i++){
            parent[i] = i;
        }

        return kruskal(costs, n);
    }

    public static int kruskal(int [][] costs, int n){
        int cost = 0;
        PriorityQueue<Bridge> pq = new PriorityQueue<>();

        for(int i=0;i<costs.length;i++){
            pq.offer(new Bridge(costs[i][0], costs[i][1], costs[i][2]));
        }

        int count = 0;
        while(count != n-1){
            Bridge cur = pq.poll();
            if(find(cur.v) != find(cur.w)){
                cost += cur.cost;
                count++;
                union(cur.v, cur.w);
            }
        }
        return cost;
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x < y) parent[y] = x;
        else parent[x] = y;
    }

    public static int find(int x){
        if(parent[x] == x) return x;
        return find(parent[x]);
    }

    static class Bridge implements Comparable<Bridge>{
        int v;
        int w;
        int cost;

        Bridge(int v, int w, int cost){
            this.v = v;
            this.w = w;
            this.cost = cost;
        }
        @Override
        public int compareTo(Bridge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
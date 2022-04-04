/**
 * @author nakhoon
 * @date 2022, 4월 4일
 * @see https://www.acmicpc.net/problem/17352
 * @mem 89,696kb
 * @time 620ms
 * @caution
 * [고려사항]
 * 유니온 파인드 알고리즘 중 크루스칼을 이용해서 문제를 해결 하였다.
 * 부모의 원소에 대한 단계(rank)를 고려해야 문제를 AC 받을 수 있었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 <분리 집합> '여러분의 다리가 되어 드리겠습니다!'
public class BOJ17352 {
    static int [] parent, rank;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        rank = new int[N+1];
        for(int i=1;i<=N;i++){
            parent[i] = i;
            rank[i] = 1;
        }

        StringTokenizer st;
        for(int i=0;i<N-2;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a,b);
        }

        for(int i=1;i<N;i++){
            if(getParent(i) != getParent(i+1)){
                System.out.println(i + " " + (i+1));
                break;
            }
        }
    }

    public static int getParent(int target){
        if(target == parent[target]){
            return target;
        }else{
            return parent[target] = getParent(parent[target]);
        }
    }

    public static boolean union(int a, int b){
        int parentA = getParent(a);
        int parentB = getParent(b);

        if(parentA == parentB) {
            return false;
        }else {
            if(rank[parentA] == rank[parentB]) {
                rank[parentA]++;
            }

            if(rank[parentA] > rank[parentB]){
                parent[parentB] = parent[parentA];
            }else {
                parent[parentA] = parent[parentB];
            }
            return true;
        }
    }
}
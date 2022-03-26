/**
 * @author nakhoon
 * @date 2022, 3월 26일
 * @see https://www.acmicpc.net/problem/6416
 * @mem 11,688kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 입력이 어려웠던 문제이다. readLine()으로 입력을 받고 0 0이 들어오면 테스트 케이스 하나를 끝내고,
 * -1 -1이 들어오면 전체적인 반복을 끝냈다.
 * Set 자료구조를 통해 간선을 관리했고, Map 자료구조를 통해 한 노드에서 갈 수 있는 노드의 개수를 저장하였다.
 * set에 루트 노드는 저장하지 않으므로 루트의 수가 여러 개 이면 트리가 아니고,
 * 한 곳에 간선이 두 개가 들어 간다면 트리가 아니다.
 * 하지만 간선의 개수가 0이라면 트리가 맞다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 <트리> '트리인가?'
public class BOJ6416 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set;
        Map<Integer, Integer> map;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        outer: for(int T=1;;T++){
            map = new HashMap<>();
            set = new HashSet<>();
            boolean flag = false;

            st = new StringTokenizer(br.readLine());
            while(true){
                if(!st.hasMoreTokens()){
                    st = new StringTokenizer(br.readLine());
                }
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(a == 0) break;
                if(a == -1) break outer;

                if(!set.add(b)){//간선 두개 이상은 fail
                    flag = true;
                }
                map.put(a, map.getOrDefault(a,0) + 1);
            }

            if(set.size() != 0){
                int root = 0;
                for(int num : map.keySet()){
                    if(!set.contains(num)) root++;
                }
                //root 1개 이상 or 0이면 fail
                if(root != 1) flag = true;
            }

            if(flag){
                sb.append("Case " + T + " is not a tree.\n");
            }else{
                sb.append("Case " + T + " is a tree.\n");
            }
        }
        System.out.println(sb);
    }
}
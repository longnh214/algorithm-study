/**
 * @author nakhoon
 * @date 2022, 3월 3일
 * @see https://www.acmicpc.net/problem/2891
 * @mem 11,468kb
 * @time 76ms
 * @caution
 * [고려사항]
 * N의 개수는 정답과 전혀 관련 없고, 먼저 카약이 부서진 팀을 저장하는 집합을 만들고, 여분을 가지고 있는 팀의 인덱스를 받아
 * 여분을 가지고 있는 팀이 숫자를 기준으로 빌려줄 수 있는 지 없는 지를 판단했다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//백준 <그리디> '카약과 강풍'
public class BOJ2891 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        Set<Integer> breakSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<S;i++){
            breakSet.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<R;i++){
            if(breakSet.size() == 0) break;
            int cur = Integer.parseInt(st.nextToken());
            if(breakSet.contains(cur)) {
                breakSet.remove(cur);
            }else if(breakSet.contains(cur - 1)){
                breakSet.remove(cur - 1);
            }else if(breakSet.contains(cur + 1)){
                breakSet.remove(cur + 1);
            }
        }
        System.out.println(breakSet.size());
    }
}
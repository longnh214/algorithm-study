/**
 * @author nakhoon
 * @date 2024년 4월 29일
 * @see https://www.acmicpc.net/problem/2891
 * @mem 11,472kb
 * @time 76ms
 * @caution
 * [고려사항]
 * N의 개수는 정답과 전혀 관련 없고, 먼저 카약이 부서진 팀을 저장하는 집합을 만들고, 여분을 가지고 있는 팀의 인덱스를 받아
 * 여분을 가지고 있는 팀이 숫자를 기준으로 빌려줄 수 있는 지 없는 지를 판단했다.
 *
 * [2024.04.29 추가]
 * 카약이 부서진 팀이 만약 여분을 가지고 있었다면, 그 여분을 그 팀이 무조건 사용해야한다. 라는 조건으로 인해
 * 여분을 가지고 있는 팀이 카약을 빌려주는 부분에 우선순위가 존재함을 늦게 깨달았다.
 * 먼저 여분을 가지고 있는 팀의 카약이 부서진 경우를 처리하고, 양 옆 팀의 카약을 빌려주는 방식으로 처리한다.
 *
 * (+ 스트림 filter를 통한 원소 제거보다 list의 remove 메소드가 훨씬 속도 부분에서는 빠른 모습을 보였다.)
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
        Set<Integer> remainSet = new HashSet<>();

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
            }else{
                remainSet.add(cur);
            }
        }

        for(int remainTeam : remainSet){
            if(breakSet.contains(remainTeam - 1)){
                breakSet.remove(remainTeam - 1);
            }else if(breakSet.contains(remainTeam + 1)){
                breakSet.remove(remainTeam + 1);
            }
        }
        System.out.println(breakSet.size());
    }
}
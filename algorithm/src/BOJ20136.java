/**
 * @author nakhoonchoi
 * @date 2024/09/11
 * @see https://www.acmicpc.net/problem/20136
 * @mem 131,656kb
 * @time 764ms
 * @caution
 * [고려사항]
 * 백준 1700번 멀티탭 스케줄링 문제에서 N과 K의 범위가 50만까지 늘어났다.
 *
 * <1700번 문제와 차이점>
 * 1700번과 전체적인 로직은 비슷하되,
 * visited 배열을 통해 현재 기기가 사용되어지고 있는 지 판별했고,
 * 우선순위 큐에서 검색해서 지우지 않고 큐에는 계속 넣어준다.
 * (생각해보면 우선순위 큐에서 지우지 않더라도 지나간 앞 인덱스 내용이기 때문에 고려하지 않아도 된다.)
 * (그리고 poll() 로직에서 플러그를 뽑는 경우는 그대로 진행된다.)
 * 우선순위 큐의 size 대신 plugCount를 두어 현재 플러그에 몇 개나 꽂혀있는 지 계산했다.
 *
 * 우선순위 큐에서 기기를 검색해서 지우지 않으므로 객체의 hashCode와 equals 코드를 지웠다.
 *
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <그리디> '멀티탭 스케줄링 2'

public class BOJ20136 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> indexMap = new HashMap<>(); //기기 별 최근 순서를 저장
        int [] electricSequence = new int[K]; //전기 기기 사용 순서
        int [] nextIndexArr = new int[K]; //기기 별 다음 index를 나타내는 배열
        boolean [] visited = new boolean[500001];

        //nextIndex는 500001을 넘길 수 없다.
        Arrays.fill(nextIndexArr, 500001);

        for(int i=0;i<K;i++){
            electricSequence[i] = Integer.parseInt(st.nextToken());

            if(!indexMap.containsKey(electricSequence[i])){
                indexMap.put(electricSequence[i], i);
            }else{
                //입력 받으면서 각 기기 별(순서 별) 이전 인덱스에 현재 인덱스를 기록해준다.
                nextIndexArr[indexMap.get(electricSequence[i])] = i;
                indexMap.put(electricSequence[i], i);
            }
        }

        int answer = 0; //뽑은 횟수
        int plugCount = 0; //현재 플러그에 몇 개나 꽂혀있는 지
        PriorityQueue<ElectricThing> pq = new PriorityQueue<>();

        for(int i=0;i<K;i++){
            if(visited[electricSequence[i]]){
                pq.offer(new ElectricThing(electricSequence[i], nextIndexArr[i]));
                continue;
            }

            //플러그에 꽂힌 경우
            if(plugCount < N){
                plugCount++;
                visited[electricSequence[i]] = true;
                pq.offer(new ElectricThing(electricSequence[i], nextIndexArr[i]));
            }else{
                //뽑아야 하는 경우
                ElectricThing electricThing = pq.poll();
                //사용 체크
                visited[electricThing.number] = false;
                visited[electricSequence[i]] = true;
                pq.offer(new ElectricThing(electricSequence[i], nextIndexArr[i]));

                answer++;
            }
        }

        System.out.println(answer);
    }

    static class ElectricThing implements Comparable<ElectricThing>{
        int number;
        int nextSequence;

        ElectricThing(int number, int nextSequence){
            this.number = number;
            this.nextSequence = nextSequence;
        }

        @Override
        public int compareTo(ElectricThing o) {
            return Integer.compare(this.nextSequence, o.nextSequence) * -1;
        }
    }
}
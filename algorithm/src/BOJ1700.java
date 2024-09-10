/**
 * @author nakhoonchoi
 * @date 2024/09/10
 * @see https://www.acmicpc.net/problem/1700
 * @mem 11,712kb
 * @time 64ms
 * @caution
 * [고려사항]
 * 플러그 변경 횟수가 가장 적으려면 현재 플러그가 꽉 차있다는 가정 하에
 * 플러그에 꽂혀있는 기기들 중 다음 사용 횟수가 가장 늦은 기기를 뽑고 새로운 기기를 꽂는 것이 효율적이라고 생각했다.
 *
 * 멀티탭 플러그를 우선순위 큐로 표현했다.(다음 인덱스 기준 내림차순)
 * Map에는 현재 기기의 이전 인덱스를 저장한다.(배열에 덮어쓰기 위해서)
 * ElectricThing 객체에는 현재 기기의 번호와 이 기기 번호가 다음에 언제 나올 지가 구성된다.
 * 우선순위 큐에서 해당 기기 번호를 검색하기 위해 hashCode, equals를 구현해주었다.
 * (우선순위 큐에서 기기 번호를 검색하는 부분이 비효율적일 듯)
 *
 * <전체적인 로직>
 * - 플러그에 이미 기기가 꽂혀 있는 경우에는
 *   우선순위 큐에서 해당 기기의 정보를 remove 하고, 다음 index 정보로 대체해야한다.
 * - 플러그의 자리가 다 찰 때까지는 꽂는다.
 * - 플러그에 새로운 기기가 들어가야하는 경우에는 플러그에 꽂혀있는 기기 중
 *   다음 index가 가장 큰 기기를 뽑고, 새로운 기기의 정보를 큐에 넣는다.
 *   그리고 플러그에서 뽑은 count를 올린다.
 * [입력사항]
 * [출력사항]
 */

import java.io.*;
import java.util.*;
//백준 <그리디> '멀티탭 스케줄링'
public class BOJ1700 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        //2번째 기기 2 : 6 nextIndexArr[2] = 6; nextIndexArr[3] = 10;
        int [] electricSequence = new int[K]; //전기 기기 사용 순서
        int [] nextIndexArr = new int[K]; //현재 순서의 기기 번호 별 다음 index를 저장할 배열
        Map<Integer, Integer> indexMap = new HashMap<>(); //기기 번호 별 최근 순서를 저장 (기기 번호, 인덱스)

        //nextIndex는 101을 넘길 수 없다.
        Arrays.fill(nextIndexArr, 101);

        for(int i=0;i<K;i++){
            electricSequence[i] = Integer.parseInt(st.nextToken());

            if(!indexMap.containsKey(electricSequence[i])){
                indexMap.put(electricSequence[i], i);
            }else{
                //입력 받으면서 각 기기 별(순서 별) 이전 인덱스에 현재 인덱스를 기록해준다.
                //2번째 index 기기 번호가 다음에 몇 번째 나올 지 저장.
                nextIndexArr[indexMap.get(electricSequence[i])] = i;
                indexMap.put(electricSequence[i], i);
            }
        }

        int count = 0;
        PriorityQueue<ElectricThing> plugPq = new PriorityQueue<>();

        for(int i=0;i<K;i++){
            //이미 해당 번호가 꽂혀있는 경우. priorityQueue에서 제거하고, 새로운 다음 인덱스 정보로 큐에 넣어준다.
            if(plugPq.contains(new ElectricThing(electricSequence[i]))){
                plugPq.remove(new ElectricThing(electricSequence[i]));
                plugPq.offer(new ElectricThing(electricSequence[i], nextIndexArr[i]));
                continue;
            }

            if(plugPq.size() < N){
                plugPq.offer(new ElectricThing(electricSequence[i], nextIndexArr[i]));
            }else{
                //뽑아야 하는 경우
                plugPq.poll();
                plugPq.offer(new ElectricThing(electricSequence[i], nextIndexArr[i]));

                count++;
            }
        }

        System.out.println(count);
    }

    static class ElectricThing implements Comparable<ElectricThing>{
        int number;
        int nextSequence;

        ElectricThing(int number){
            this.number = number;
        }

        ElectricThing(int number, int nextSequence){
            this.number = number;
            this.nextSequence = nextSequence;
        }

        @Override
        public int compareTo(ElectricThing o) {
            return Integer.compare(this.nextSequence, o.nextSequence) * -1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ElectricThing that = (ElectricThing) o;

            return number == that.number;
        }

        @Override
        public int hashCode() {
            return number;
        }
    }
}
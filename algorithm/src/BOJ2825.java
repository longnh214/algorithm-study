/**
 * @author nakhoonchoi
 * @date 2025/06/12
 * @see https://boj.ma/2825
 * @mem 183,744kb
 * @time 624ms
 * @caution
 * [고려사항]
 * 해당 문제는 비트마스킹으로 문제를 해결할 수 있었고, BitSet 클래스로 문제를 해결했다.
 * 다만 갯수를 구하는 과정에서 조합과 수학을 이용해야했음을 알 수 있었다.
 *
 * 먼저 N개의 수를 입력 받으면서 bitSet 10비트에 각 수마다 비트를 set했다.
 * 예를 들어 4 숫자만 있다면 0000010000, 38이라면 0100001000로 저장될 것이다.
 * 그리고 그 bitSet 기반으로 count를 Map에 저장해주었다.
 *
 * 이제 모든 bitSet 종류가 나왔기 때문에 먼저 서로 다른 bitSet에서 갯수를 찾기 위해
 * 각 bitSet 별로 2중 for문을 반복하면서 두 bitSet의 intersect가 true라면(and 했을 때 cardinarity가 1이상이라면)
 * count를 올리고 아니라면 pass했다.
 *
 * 그리고 같은 bitSet 중에서도 경우의 수가 나올 수 있는데,
 * 예를 들어 4와 44의 수가 입력 받아졌다면 Map에 4비트만 켜진 bitSet의 개수는 2로 저장될 것이다.
 *
 * 이는 조합으로 N * (N-1) / 2 식에 개수를 넣게 되면 같은 비트에 대한 경우의 수를 알 수 있다.
 * 각 bitSet 별로 순회하면서 이 경우의 수를 더해주면 모든 경우의 수를 알 수 있다.
 * (count가 1이었다면 N * (N-1) / 2에서 0이 반환될 것이기에 신경쓰지 않아도 된다.)
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <비트마스킹> '수업시간에 교수님 몰래 교실을 나간 상근이'

public class BOJ2825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<BitSet, Integer> bitSetCount = new HashMap<>();

        for (int i=0;i<N;i++) {
            String num = br.readLine();
            BitSet bs = new BitSet(10);
            for(char c : num.toCharArray()){
                bs.set(c - '0');
            }
            bitSetCount.put(bs, bitSetCount.getOrDefault(bs, 0) + 1);
        }

        List<BitSet> bitSets = new ArrayList<>(bitSetCount.keySet());
        long result = 0;

        //서로 다른 마스크 처리
        for (int i=0;i<bitSets.size();i++){
            for (int j=i+1;j<bitSets.size();j++){
                BitSet bs1 = bitSets.get(i);
                BitSet bs2 = bitSets.get(j);
                if(bs1.intersects(bs2)){
                    result += (long) bitSetCount.get(bs1) * bitSetCount.get(bs2);
                }
            }
        }

        //같은 마스크인 경우는 조합 공식 nC2 사용
        for(BitSet bs : bitSets){
            int count = bitSetCount.get(bs);
            result += (long) count * (count - 1) / 2;
        }

        System.out.println(result);
    }
}
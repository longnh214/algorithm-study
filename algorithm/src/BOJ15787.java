/**
 * @author nakhoonchoi
 * @date 2024/10/18
 * @see https://www.acmicpc.net/problem/15787
 * @mem 56,400kb
 * @time 452ms
 * @caution
 * [고려사항]
 * BitSet을 이용해서 문제를 해결하였다.
 * 3, 4번의 경우 시프트 연산을 지원하지 않으므로
 * 비트를 순회하여 직접 비트를 찍어주었다.
 * BitSet 자체도 hashCode와 equals가 구현되어있기 때문에
 * Set으로 중복 제거가 가능하다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <비트마스킹> '기차가 어둠을 헤치고 은하수를 건너면'

public class BOJ15787 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        BitSet [] trains = new BitSet[N];
        for(int i=0;i<N;i++){
            trains[i] = new BitSet(20);
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int trainNum;
            int seatNum;
            BitSet shifted;

            switch(command){
                case 1:
                    trainNum = Integer.parseInt(st.nextToken()) - 1;
                    seatNum = Integer.parseInt(st.nextToken()) - 1;

                    trains[trainNum].set(seatNum);
                    break;
                case 2:
                    trainNum = Integer.parseInt(st.nextToken()) - 1;
                    seatNum = Integer.parseInt(st.nextToken()) - 1;

                    trains[trainNum].clear(seatNum);
                    break;
                case 3:
                    trainNum = Integer.parseInt(st.nextToken()) - 1;

                    shifted = new BitSet(20);
                    for (int j = 19; j > 0; j--) {
                        if (trains[trainNum].get(j - 1)) {
                            shifted.set(j);
                        }
                    }
                    trains[trainNum] = shifted;

                    break;
                case 4:
                    trainNum = Integer.parseInt(st.nextToken()) - 1;

                    shifted = new BitSet(20);
                    for (int j = 0; j < 19; j++) {
                        if (trains[trainNum].get(j + 1)) {
                            shifted.set(j);
                        }
                    }
                    trains[trainNum] = shifted;

                    break;
            }
        }

        Set<BitSet> set = new HashSet<>();
        for(int i=0;i<N;i++){
            set.add((BitSet) trains[i].clone());
        }

        for(BitSet train : set){
            System.out.println(train);
        }
        System.out.println(set.size());
    }
}
/**
 * @author nakhoonchoi
 * @date 2024/08/22
 * @see https://www.acmicpc.net/problem/9079
 * @mem 19,948kb
 * @time 108ms
 * @caution
 * [고려사항]
 * 비트마스킹 + BFS 문제로, BitSet 객체를 이용해서 문제를 해결하였다.
 * 가로 인덱스만큼 flip하면서, 인덱스를 잘못 계산하는 이슈 때문에 WA를 많이 받았다.
 * 인덱스를 주의해서 생각해야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <비트마스킹> '동전 게임'

public class BOJ9079 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(T-->0){
            BitSet bitSet = new BitSet(9);
            int index = 0;
            for(int i=0;i<3;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<3;j++){
                    boolean isTrue = st.nextToken().equals("H");
                    bitSet.set(index++, isTrue);
                }
            }

            System.out.println(bfs(bitSet));
        }
    }

    public static int bfs(BitSet bitSet){
        Map<String, Integer> visitedMap = new HashMap<>();
        Queue<BitSet> q = new ArrayDeque<>();
        q.offer(bitSet);
        visitedMap.put(bitSet.toString(), 0);

        while(!q.isEmpty()){
            BitSet cur = q.poll();
            BitSet clone;
            int depth = visitedMap.get(cur.toString());

            if(isCompleted(cur)){
                return depth;
            }

            //가로 뒤집기
            clone = (BitSet) cur.clone();
            for(int i=0;i<3;i++){
                clone.flip(i);
            }
            if(!visitedMap.containsKey(clone.toString()) || visitedMap.get(clone.toString()) > depth+1){
                q.offer(clone);
                visitedMap.put(clone.toString(), depth+1);
            }

            clone = (BitSet) cur.clone();
            for(int i=3;i<6;i++){
                clone.flip(i);
            }
            if(!visitedMap.containsKey(clone.toString()) || visitedMap.get(clone.toString()) > depth+1){
                q.offer(clone);
                visitedMap.put(clone.toString(), depth+1);
            }

            clone = (BitSet) cur.clone();
            for(int i=6;i<9;i++){
                clone.flip(i);
            }
            if(!visitedMap.containsKey(clone.toString()) || visitedMap.get(clone.toString()) > depth+1){
                q.offer(clone);
                visitedMap.put(clone.toString(), depth+1);
            }

            //세로 뒤집기
            clone = (BitSet) cur.clone();
            for(int i=0;i<9;i+=3){
                clone.flip(i);
            }
            if(!visitedMap.containsKey(clone.toString()) || visitedMap.get(clone.toString()) > depth+1){
                q.offer(clone);
                visitedMap.put(clone.toString(), depth+1);
            }

            clone = (BitSet) cur.clone();
            for(int i=1;i<9;i+=3){
                clone.flip(i);
            }
            if(!visitedMap.containsKey(clone.toString()) || visitedMap.get(clone.toString()) > depth+1){
                q.offer(clone);
                visitedMap.put(clone.toString(), depth+1);
            }

            clone = (BitSet) cur.clone();
            for(int i=2;i<9;i+=3){
                clone.flip(i);
            }
            if(!visitedMap.containsKey(clone.toString()) || visitedMap.get(clone.toString()) > depth+1){
                q.offer(clone);
                visitedMap.put(clone.toString(), depth+1);
            }

            //대각선 뒤집기
            clone = (BitSet) cur.clone();
            for(int i=0;i<9;i+=4){
                clone.flip(i);
            }
            if(!visitedMap.containsKey(clone.toString()) || visitedMap.get(clone.toString()) > depth+1){
                q.offer(clone);
                visitedMap.put(clone.toString(), depth+1);
            }

            clone = (BitSet) cur.clone();
            for(int i=2;i<7;i+=2){
                clone.flip(i);
            }
            if(!visitedMap.containsKey(clone.toString()) || visitedMap.get(clone.toString()) > depth+1){
                q.offer(clone);
                visitedMap.put(clone.toString(), depth+1);
            }
        }

        return -1;
    }

    public static boolean isCompleted(BitSet bitSet) {
        int cardinality = bitSet.cardinality();
        return cardinality == 0 || cardinality == 9;
    }
}
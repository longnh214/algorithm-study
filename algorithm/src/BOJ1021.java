/**
 * @author nakhoon
 * @date 2022년 9월 19일
 * @see https://www.acmicpc.net/problem/1021
 * @mem 11,616kb
 * @time 80ms
 * @caution
 * [고려사항]
 * list 중에서 목표로 하는 수의 인덱스에 따라 count를 올리는 식으로 문제를 해결했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <덱> '회전하는 큐'
public class BOJ1021{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();

        for (int i=1;i<=N;i++){
            deque.add(i);
        }

        int count = 0;
        String [] arr = br.readLine().split(" ");

        for (int i=0;i<M;i++){
            int size = deque.size();
            int index = deque.indexOf(Integer.parseInt(arr[i]));
            float mid = size / 2;
            if(index <= mid){
                for(int j=0;j<index;j++){
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    count++;
                }
            }else{
                for(int j=0;j<size-index;j++){
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.print(count);
    }
}
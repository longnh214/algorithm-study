/**
 * @author nakhoon
 * @date 2022, 3월 30일
 * @see https://www.acmicpc.net/problem/2164
 * @mem
 * @time
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//백준 <큐> '카드2'
public class BOJ2164 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            q.offer(i);
        }

        while(q.size() != 1){
            q.poll();
            int num = q.poll();
            q.offer(num);
        }
        System.out.println(q.poll());
    }
}
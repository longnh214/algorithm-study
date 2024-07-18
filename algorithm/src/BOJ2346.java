/**
 * @author nakhoonchoi
 * @date 2024/07/18
 * @see https://www.acmicpc.net/problem/2346
 * @mem 14,540kb
 * @time 136ms
 * @caution
 * [고려사항]
 * ArrayDeque 구현체를 이용해서 문제를 해결하였다.
 * pollFirst와 offerLast, pollLast와 offerFirst 짝을 이용해서 문제를 해결하였다.
 * command의 절댓값 -1 만큼 덱의 숫자를 이동해야하는 것에 주의해야했던 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <덱> '풍선 터뜨리기'

public class BOJ2346 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Balloon> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            int command = Integer.parseInt(st.nextToken());

            deque.offer(new Balloon(i+1, command));
        }

        StringBuilder sb = new StringBuilder();

        Balloon cur = deque.pollFirst();
        sb.append(cur.index).append(" ");
        outer: for(int i=0;i<N;i++){
            int command = cur.command;

            if(command > 0){
                for(int j=0;j<command - 1;j++){
                    if(!deque.isEmpty()) {
                        Balloon balloon = deque.pollFirst();
                        deque.offerLast(balloon);
                    }else{
                        break outer;
                    }
                }
                cur = deque.pollFirst();
                sb.append(cur.index).append(" ");
            }else{
                command *= -1;
                for(int j=0;j<command - 1;j++){
                    if(!deque.isEmpty()) {
                        Balloon balloon = deque.pollLast();
                        deque.offerFirst(balloon);
                    }else{
                        break outer;
                    }
                }
                cur = deque.pollLast();
                sb.append(cur.index).append(" ");
            }
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }

    static class Balloon{
        int index;
        int command;

        Balloon(int index, int command){
            this.index = index;
            this.command = command;
        }
    }
}
/**
 * @author nakhoon
 * @date 2021, 12월 6일
 * @see https://www.acmicpc.net/problem/18258
 * @mem 396,804kb
 * @time 1,528ms
 * @caution
 * [고려사항]
 * System.out.println을 이용해서 출력이 발생하는 명령어에 대해 바로 바로 출력하려고 하면 시간 초과가 발생했다.
 * StringBuilder나 BufferedWriter를 이용했다면 시간 초과가 전혀 발생하지 않았을 것 이다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//백준 <큐> '큐 2'
public class BOJ18258 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();
        int back = -1;
        for(int i=0;i<N;i++){
            String [] arr = br.readLine().split(" ");
            int num = arr.length == 2 ? Integer.parseInt(arr[1]) : -1;

            switch(arr[0]){
                case "push":
                    q.offer(num);
                    back = num;
                    break;
                case "front":
                    if(q.size() != 0){
                        sb.append(q.peek()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case "back":
                    if(q.size() != 0){
                        sb.append(back).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "pop":
                    if(q.size() != 0){
                        sb.append(q.poll()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }

                    if(q.size() == 0){
                        back = -1;
                    }
                    break;
            }
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}
/**
 * @author nakhoon
 * @date 2022, 4월 2일
 * @see https://www.acmicpc.net/problem/10845
 * @mem 19,044kb
 * @time 416ms
 * @caution
 * [고려사항]
 * System.out.println 안에 삼항 연산자를 넣었을 때 안되는 경우가 있었다. null과 int 형이 오토 박싱이 안되어서 나온 문제였다.
 * 형에 대해서 고려를 잘 하고 사용해야겠다고 생각했다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//백준 <큐> '큐'
public class BOJ10848 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

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
                        System.out.println(q.peek());
                    }else{
                        System.out.println(-1);
                    }
                    break;
                case "back":
                    if(q.size() != 0){
                        System.out.println(back);
                    }else{
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    System.out.println(q.isEmpty() ? 1 : 0);
                    break;
                case "pop":
                    if(q.size() != 0){
                        System.out.println(q.poll());
                    }else{
                        System.out.println(-1);
                    }

                    if(q.size() == 0){
                        back = -1;
                    }
                    break;
            }
        }
    }
}
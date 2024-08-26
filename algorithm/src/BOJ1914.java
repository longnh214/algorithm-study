/**
 * @author nakhoonchoi
 * @date 2024/08/26
 * @see https://www.acmicpc.net/problem/1914
 * @mem 208,732kb
 * @time 7,032ms
 * @caution
 * [고려사항]
 * 하노이 탑 이동 수는 2^N - 1이며, 재귀를 이용해서 문제를 해결하였다.
 * 첫번째와 이동될 곳, 그리고 나머지를 생각하여 재귀를 작성했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.math.BigInteger;
import java.util.*;
//백준 <재귀> '하노이 탑'

public class BOJ1914 {
    static List<Move> route = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        BigInteger count = new BigInteger("2").pow(N).subtract(new BigInteger("1"));

        System.out.println(count);

        if(N <= 20){
            setHanoiRoute(1, 3, 2, N);
            for(Move m : route){
                System.out.println(m.start + " " + m.end);
            }
        }
    }

    public static void setHanoiRoute(int start, int end, int rest, int depth){
        if(depth == 1){
            route.add(new Move(start, end));
        }else{
            setHanoiRoute(start, rest, end, depth-1);
            route.add(new Move(start, end));
            setHanoiRoute(rest, end, start, depth-1);
        }
    }

    static class Move{
        int start;
        int end;

        Move(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
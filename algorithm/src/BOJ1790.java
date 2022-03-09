/**
 * @author nakhoon
 * @date 2022, 3월 9일
 * @see https://www.acmicpc.net/problem/1790
 * @mem 11,528kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 현재 K 기준으로 마지막 수가 몇 인지 구한 다음에,
 * 해당 마지막 수가 N 보다 크면 -1을 출력,
 * 작다면 그 마지막 수 중에서 몇 번째 자리 수가 정답인 지 출력했다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 <구현> '수 이어 쓰기 2'
public class BOJ1790 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long temp = K;
        long finalNum = 0; //마지막 숫자
        long numLength = 1; //현재 몇 자리수인지(1 -> 1, 10 -> 2)
        long numCount = 9; //1자리 수는 9개, 2자리 수는 90개, 3자리 수는 900개

        while(temp > numLength * numCount){
            temp -= (numLength * numCount);
            finalNum += numCount;

            numLength++;
            numCount *= 10;
        }

        finalNum = (finalNum + 1) + (temp-1)/numLength;
        if(finalNum > N){
            System.out.println(-1);
        }else{
            int index = (int)((temp - 1) % numLength);
            System.out.println(String.valueOf(finalNum).charAt(index));
        }
    }
}
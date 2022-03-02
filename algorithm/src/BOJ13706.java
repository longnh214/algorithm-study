/**
 * @author nakhoon
 * @date 2022, 3월 2일
 * @see https://www.acmicpc.net/problem/13706
 * @mem 21,188kb
 * @time 200ms
 * @caution
 * [고려사항]
 * 입력으로 들어오는 숫자의 길이가 800자리 이내이므로 long 형으로도 다룰 수 없는 크기의 숫자가 들어온다.
 * 이 정도 크기의 숫자를 다룰 수 있는 객체인 BigInteger를 이용해서 문제를 해결했다.
 * 이분 탐색을 통해 제곱근을 찾았다.
 * BigInteger 객체 끼리의 숫자 비교에서 헷갈렸던 문제이다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

//백준 <이분 탐색> '제곱근'
public class BOJ13706 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        BigInteger bi = new BigInteger(str);
        sqrt(bi);
    }

    public static void sqrt(BigInteger bi){
        BigInteger left = new BigInteger("1");
        BigInteger right = new BigInteger(bi.toString());
        BigInteger mid = null;
        BigInteger two = new BigInteger("2");

        while(left.compareTo(right) < 0){
            mid = left.add(right).divide(two);
            BigInteger temp = mid.pow(2);

            if(bi.equals(temp)){
                break;
            }

            if(bi.compareTo(temp) < 0){
                right = mid;
            }else{
                left = mid.add(new BigInteger("1"));
            }
        }
        System.out.println(mid.toString());
    }
}
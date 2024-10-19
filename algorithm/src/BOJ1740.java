/**
 * @author nakhoonchoi
 * @date 2024/10/20
 * @see https://www.acmicpc.net/problem/1740
 * @mem 11,732kb
 * @time 68ms
 * @caution
 * [고려사항]
 * 입력 받은 N을 2진수로 바꾼 다음, 해당 수에 해당하는 3진수를
 * 10진수로 표현하면 정답이다.
 * 입력 받을 때 숫자가 커질 수 있으므로 long 형으로 입력받고,
 * 숫자를 출력할 때 BigInteger를 사용했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.math.BigInteger;
import java.util.*;
//백준 <진수 변환> '거듭제곱'

public class BOJ1740 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        BitSet bitSet = new BitSet();
        int i = 0;
        while(N != 0){
            long mod = N % 2;
            N /= 2;
            if(mod == 1){
                bitSet.set(i);
            }
            i++;
        }

        BigInteger bi = new BigInteger("0");
        BigInteger standard = new BigInteger("1");
        for(int j=0;j<bitSet.size();j++){
            if(bitSet.get(j)){
                bi = bi.add(standard);
            }
            standard = standard.multiply(new BigInteger("3"));
        }

        System.out.println(bi);
    }
}
/**
 * @author nakhoonchoi
 * @date 2024/10/21
 * @see https://www.acmicpc.net/problem/21968
 * @mem 28,340kb
 * @time 236ms
 * @caution
 * [고려사항]
 * 백준 1740번 '거듭제곱'과 같은 방식으로 풀었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.math.BigInteger;
import java.util.*;
//백준 <진법 변환> '선린의 터를'

public class BOJ21968 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
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
}
/**
 * @author nakhoonchoi
 * @date 2024/10/19
 * @see https://www.acmicpc.net/problem/17419
 * @mem 20,576kb
 * @time 156ms
 * @caution
 * [고려사항]
 * 문제에서 주어진 식 k=k-(k&((~K)+1))에 대한 이해가 필요하다.
 * ~k+1은 k의 2의 보수로, k=10110(2)=-10 이라면 ~k+1=01001(2)+1=01010(2)=10 이다.
 * 여기서 k와 그의 2의 보수인 ~k+1을 &연산하게 되면 둘의 비트 중 공통된 가장 작은 비트만 1로 남고 나머지는 0이 된다.
 * k&((~k)+1)=00010(2)
 * 따라서 주어진 식은 k가 갖고 있는 비트 중 값이 1인 최하위 비트를 구하는 것이었다.
 * 그런데 이가 0이 될 때까지 반복하라고 했으므로 k 내부의 비트 중 1의 개수를 구하는 것과 동일한 의미가 된다.
 * 따라서 k가 가진 1의 개수를 카운트하고 출력하면 정답이 된다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <비트마스킹> '비트가 넘쳐흘러'

public class BOJ17419 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BitSet bitSet = new BitSet(N);
        String str = br.readLine();
        for(int i=0;i<N;i++){
            if(str.charAt(i) == '1'){
                bitSet.set(N - i - 1);
            }
        }
        System.out.println(bitSet.cardinality());
    }
}
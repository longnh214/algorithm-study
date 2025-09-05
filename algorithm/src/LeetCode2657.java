/**
 * @author nakhoonchoi
 * @date 2025/09/05
 * @see https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/
 * @mem 45.50MB
 * @time 8ms
 * @caution
 * [고려사항]
 * A와 B 배열의 인덱스를 순회하면서 0부터 현재 인덱스까지
 * 공통 원소가 몇 개 있는지 찾아야하는 문제였다.
 *
 * 두 개의 Set 중에 공통 원소를 찾아야했기 때문에 BitSet을 이용해서 and 연산을 해주었다.
 * BitSet은 and 연산을 하면 기존 객체의 값을 변형시키기 때문에 clone 메소드를 이용해서 복사해서 진행해주었다.
 *
 * BitSet을 이용해서 풀었을 때에는 8ms가 나왔지만,
 * 간단하게 count 배열을 선언해서 값이 2가 되었을 때 answer 값을 +1 하면
 * 집합의 성격을 고려하지 않아도 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//LeetCode <LeetCode> 'Find the Prefix Common Array of Two Arrays'

public class LeetCode2657 {
    public int [] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        BitSet aBitSet = new BitSet(n+1);
        BitSet bBitSet = new BitSet(n+1);
        BitSet standard;
        int [] result = new int[n];

        for(int i=0;i<n;i++){
            aBitSet.set(A[i]);
            bBitSet.set(B[i]);

            standard = (BitSet) aBitSet.clone();
            standard.and(bBitSet);

            result[i] = standard.cardinality();
        }

        return result;
    }

    public int [] findThePrefixCommonArray2(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        int[] count = new int[n + 1];
        int common = 0;

        for(int i = 0; i < n; i++) {
            count[A[i]]++;
            if(count[A[i]] == 2) common++;
            count[B[i]]++;
            if(count[B[i]] == 2) common++;
            result[i] = common;
        }
        return result;
    }
}
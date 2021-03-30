/**
 * @author choi
 * @date Dec 20, 2020
 * @see https://www.acmicpc.net/problem/7453
 * @mem 147,872kb
 * @time 1,876ms
 * @caution
 * [고려사항]
 * 전에 시간 초과 났던 문제인데, 투 포인터를 익히고 나서
 * 네 개로 나뉘어진 배열을 각각 합쳐 두개로 나누어 더하는 식으로
 * 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <투포인터> '합이 0인 네 정수'
public class BOJ7453 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] a = new int[N];
        int [] b = new int[N];
        int [] c = new int[N];
        int [] d = new int[N];
        int [] ab = new int[N*N];
        int [] cd = new int[N*N];
        long answer = 0;

        StringTokenizer st;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                ab[index] = a[i] + b[j];
                cd[index] = c[i] + d[j];
                index++;
            }
        }
        //left : AB포인터
        //right : CD포인터
        int left = 0;
        int right = index - 1;
        Arrays.sort(ab);
        Arrays.sort(cd);

        while(left < N*N && right >= 0) {
            int abSum = ab[left];
            int cdSum = cd[right];
            int abCount = 0;
            int cdCount = 0;
            int tempSum = abSum + cdSum;

            if(tempSum == 0) {
                // AB에서 중복인 답의 개수를 체크
                while(left<N*N && abSum == ab[left]) {
                    left++;
                    abCount++;
                }
                // CD에서 중복인 답의 개수를 체크
                while(right>=0 && cdSum == cd[right]) {
                    right--;
                    cdCount++;
                }
                // AB count * CD count (중복된 경우의 수를 계산해서 answer에 더하기)
                answer+=(long)abCount*(long)cdCount;
            }else if(tempSum > 0) {
                right--;
            }else {
                left++;
            }
        }

        System.out.println(answer);
    }
}
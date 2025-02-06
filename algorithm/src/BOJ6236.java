/**
 * @author nakhoonchoi
 * @date 2025/02/06
 * @see https://boj.ma/6236
 * @mem 21,804kb
 * @time 192ms
 * @caution
 * [고려사항]
 * 이분 탐색 문제였다.
 * lower bound로 푸는 문제로 일반적인 이분 탐색 문제와 다르게 주어진 소비 금액을 정렬하면 안됐다.
 * start를 소비 금액 중 최댓값, end를 모든 소비 금액의 총 합으로 해서 이분 탐색을 한다.
 * 각 금액 별로 몇 번 용돈을 인출하는 지 판별하면서 최적의 K 값을 구하면 되었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <이분탐색> '용돈 관리'

public class BOJ6236 {
    static int [] outcome;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        outcome = new int[N];
        int max = 0;
        int end = 0;
        for(int i=0;i<N;i++){
            outcome[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, outcome[i]);
            end += outcome[i];
        }

        int start = max;
        int K = 0;

        while(start <= end){
            int mid = (start + end) / 2;

            if(M >= getCount(mid)){
                K = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        System.out.println(K);
    }

    public static int getCount(int income){
        int money = income;
        int count = 1;

        for(int i=0;i<N;i++){
            money -= outcome[i];

            if(money < 0){
                count++;
                money = income - outcome[i];
            }
        }

        return count;
    }
}
/**
 * @author nakhoonchoi
 * @date 2024/08/21
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/1843
 * @caution
 * [고려사항]
 * 레벨 4의 DP 문제 답게 해설을 참고하고 문제를 해결하였다.
 * 2차원 DP 배열을 통해 숫자 i번부터, j번까지의 최대값을 메모이제이션 해야하는 것은 알고 있었지만,
 * 빼기 연산을 할 때 최소값도 같이 관리해줘야하는 것을 몰라서 헤맸다.
 * 최소값을 갱신해주면서, 최대값 DP 배열을 갱신하여
 * 0번째 수부터 N-1번째 숫자까지 연산을 한 최대값인 maxDP[0][n-1]의 값을 출력해주었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//백준 <DP> '사칙연산'

public class Programmers1843 {
    public static void main(String[] args) {
        String [] arr = {"1", "-", "3", "+", "5", "-", "8"};
        String [] arr2 = {"5", "-", "3", "+", "1", "+", "2", "-", "4"};

        System.out.println(solution(arr));
        System.out.println(solution(arr2));
    }

    public static int solution(String arr[]) {
        int n = (arr.length + 1) / 2;
        int [] numArr = new int[n];
        int [][] maxDP = new int[n][n];
        int [][] minDP = new int[n][n];

        for(int i=0;i<n;i++){
            numArr[i] = Integer.parseInt(arr[i * 2]);

            Arrays.fill(maxDP[i], Integer.MIN_VALUE);
            Arrays.fill(minDP[i], Integer.MAX_VALUE);
        }

        for(int gap=0;gap<n;gap++){
            for(int i=0;i<n-gap;i++){
                int j = gap + i;

                if(gap == 0){
                    maxDP[i][i] = numArr[i];
                    minDP[i][i] = numArr[i];
                }else{
                    for(int k=i;k<j;k++){
                        if(arr[2 * k + 1].equals("+")){
                            maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] + maxDP[k+1][j]);
                            minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] + minDP[k+1][j]);
                        }else{
                            maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] - minDP[k+1][j]);
                            minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] - maxDP[k+1][j]);
                        }
                    }
                }
            }
        }

        return maxDP[0][n-1];
    }
}

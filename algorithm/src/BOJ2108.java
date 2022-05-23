/**
 * @author nakhoon
 * @date 2022, 5월 23일
 * @see https://www.acmicpc.net/problem/2108
 * @mem 48,556kb
 * @time 540ms
 * @caution
 * [고려사항]
 * 최빈값을 구할 때에 머리를 많이 써야 했던 문제이다.
 * 빈도수가 같은 수가 두 개 이상이라면 두 번째로 작은 수를 출력해야했기 때문이다.
 * flag를 하나 두어 count가 가장 큰 최빈수의 개수가 하나인 지 둘 이상인 지를 체크했다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//백준 <수학> '통계학'
public class BOJ2108 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        int sum = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);

        boolean flag = false;
        int mode_max = 0;
        int mode = 10000;

        for(int i=0;i<N;i++) {
            int jump = 0;	// 동일한 수가 나온만큼 i 값 jump 시킬 변수
            int count = 1;
            int i_value = arr[i];

            for(int j=i+1;j<N;j++){
                if(i_value != arr[j]) {
                    break;
                }
                count++;
                jump++;
            }

            if(count > mode_max) {
                mode_max = count;
                mode = i_value;
                flag = true;
            }else if(count == mode_max && flag == true) {
                mode = i_value;
                flag = false;
            }

            i += jump;
        }

        StringBuilder sb = new StringBuilder();
        sb.append((int)Math.round((double)sum / N)).append("\n");
        sb.append(arr[(N-1)/2]).append("\n");
        sb.append(mode).append("\n");
        sb.append(arr[N-1] - arr[0]).append("\n");
        System.out.println(sb.substring(0, sb.length()-1));
    }
}
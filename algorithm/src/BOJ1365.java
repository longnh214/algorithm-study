/**
 * @author nakhoonchoi
 * @date 2025/06/28
 * @see https://boj.ma/1365
 * @mem 25,752kb
 * @time 208ms
 * @caution
 * [고려사항]
 * 2352번과 같은 LIS(O(NlogN)) 문제이다.
 *
 * 전체 길이 N에서 이분탐색을 이용해서 구한 LIS 길이를 빼면 잘라야 하는 전깃줄의 길이가 나온다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <LIS(O(NlogN))> '꼬인 전깃줄'

public class BOJ1365 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int [] lastMinValueArr = new int[N];
        int lisLength = 0;

        for(int num : arr){
            int index = Arrays.binarySearch(lastMinValueArr, 0, lisLength, num);

            if(index < 0){
                index = (index + 1) * -1;
            }

            lastMinValueArr[index] = num;

            if(index == lisLength){
                lisLength++;
            }
        }

        System.out.println(N - lisLength);
    }
}
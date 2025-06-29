/**
 * @author nakhoonchoi
 * @date 2025/06/29
 * @see https://boj.ma/3745
 * @mem 28,956kb
 * @time 224ms
 * @caution
 * [고려사항]
 * LIS(O(NlogN))으로 풀 수 있는 문제였으나 입력 부분에서 많이 어려웠다.
 * 배열의 크기를 입력하는 부분에서 공백이 들어가는지, 입력받은 문자열을 trim() 해주어야 통과할 수 있었다.
 * (입력 부분만 타 코드 참고)
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <LIS(O(NlogN))> '오름세'

public class BOJ3745 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;
        StringBuilder sb = new StringBuilder();

        while((str = br.readLine()) != null){
            int N = Integer.parseInt(str.trim());
            int [] arr = new int[N];
            String numLine = br.readLine();

            st = new StringTokenizer(numLine);

            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int lisLength = 0;
            int [] lastMinValueArr = new int[N];

            for(int num : arr){
                int index = Arrays.binarySearch(lastMinValueArr, 0, lisLength, num);

                if(index < 0){
                    index = -1 * (index + 1);
                }

                lastMinValueArr[index] = num;

                if(index == lisLength) {
                    lisLength++;
                }
            }

            sb.append(lisLength).append('\n');
        }

        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
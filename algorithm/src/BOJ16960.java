/**
 * @author nakhoonchoi
 * @date 2024/06/19
 * @see https://www.acmicpc.net/problem/16960
 * @mem 15,708kb
 * @time 112ms
 * @caution
 * [고려사항]
 * 각 스위치에 속한 램프를 문자열 형태로 저장할 때
 * 리스트에 숫자로 변환하여 저장해주었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;

//백준 <구현> '스위치와 램프'
public class BOJ16960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] arr = new int[M];
        List<Integer> [] lamps = new ArrayList[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            lamps[i] = new ArrayList<>();

            for(int j=0;j<k;j++){
                int lampNum = Integer.parseInt(st.nextToken());

                arr[lampNum-1]++;

                lamps[i].add(lampNum - 1);
            }
        }

        for(int i=0;i<N;i++){

            for(int j=0;j<lamps[i].size();j++){
                arr[lamps[i].get(j)]--;
            }

            if(isAllOn(arr)){
                System.out.println(1);
                return;
            }

            for(int j=0;j<lamps[i].size();j++){
                arr[lamps[i].get(j)]++;
            }
        }

        System.out.println(0);
    }

    public static boolean isAllOn(int [] arr){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                return false;
            }
        }
        return true;
    }
}
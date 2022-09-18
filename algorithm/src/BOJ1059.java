/**
 * @author nakhoon
 * @date 2022년 9월 18일
 * @see https://www.acmicpc.net/problem/1059
 * @mem 11,708kb
 * @time 96ms
 * @caution
 * [고려사항]
 * 집합의 크기가 1일 때를 고려해서 문제를 해결해야했다. 집합의 크기가 1일 때는 집합에 0과 집합에 들어가는 수, 두 개가 있다고 생각하고 문제를 해결해야 했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <정렬> '좋은 구간'
public class BOJ1059 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int target = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=0;i<N;i++){
            if(arr[i] < target && arr[i+1] > target){
                for(int j=arr[i]+1;j<=arr[i+1]-1;j++){
                    for(int k=j+1;k<=arr[i+1]-1;k++){
                        if(isIn(j,k,target)) count++;
                    }
                }
                break;
            }
        }
        System.out.println(count);
    }

    public static boolean isIn(int start, int end, int target){
        if(start <= target && target <= end && start != end){
            return true;
        }
        return false;
    }
}
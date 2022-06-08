/**
 * @author nakhoon
 * @date 2022, 6월 8일
 * @see https://www.acmicpc.net/problem/13019
 * @mem 11,536kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 문자열을 char 형 배열로 변환 후 정렬해서 만들 수 있는 지 확인하고, 그 뒤에 A는 역방향으로, B는 정방향으로 같은 알파벳이 있다면 연산 횟수를 1 올려주었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//백준 <그리디> 'A를 B로'
public class BOJ13019 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        char [] arr1 = A.toCharArray();
        char [] arr2 = B.toCharArray();

        int size = A.length();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i=0;i<size;i++){
            if(arr1[i] != arr2[i]){
                System.out.println(-1);
                return;
            }
        }

        int count = 0;
        for(int i=size-1;i>=0;i--){
            if(A.charAt(i) == B.charAt(size - 1 - count)){
                count++;
            }
        }
        System.out.println(size - count);
    }
}
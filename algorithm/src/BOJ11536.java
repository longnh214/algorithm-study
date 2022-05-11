/**
 * @author nakhoon
 * @date 2022, 5월 11일
 * @see https://www.acmicpc.net/problem/11536
 * @mem 11,456kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 기준 문자열 배열과 비교군 문자열 배열을 두고 비교군을 정렬한 뒤, 오름차순인 지 내림차순인 지 확인하고, 둘 다 아니라면 NEITHER를 출력해주었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//백준 <문자열> '줄 세우기'
public class BOJ11536 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] base = new String[N];
        String [] diff = new String[N];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            base[i] = str;
            diff[i] = str;
        }
        Arrays.sort(diff);
        boolean incFlag = true;
        boolean decFlag = true;
        for(int i=0;i<N;i++){
            if(!base[i].equals(diff[i])){
                incFlag = false;
            }
            if(!base[i].equals(diff[N-i-1])){
                decFlag = false;
            }
        }
        if(incFlag){
            System.out.println("INCREASING");
        }else if(decFlag){
            System.out.println("DECREASING");
        }else{
            System.out.println("NEITHER");
        }
    }
}
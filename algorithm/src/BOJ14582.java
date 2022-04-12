/**
 * @author nakhoon
 * @date 2022, 4월 12일
 * @see https://www.acmicpc.net/problem/14582
 * @mem 11,328kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 9회까지 점수를 돌면서 울림이 이겼던 적이 있는 지, 그리고 스타트링크가 이기고 있는 지를 boolean으로
 * 관리를 해서 경기가 끝났을 때 울림이 이겼던 적이 있으면서 스타트링크가 이겼는 지를 판별해서
 * 정답을 출력할 수 있었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 <구현> '오늘도 졌다'
public class BOJ14582 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] ulim = new int[9];
        int [] startLink = new int[9];
        boolean ulimWin = false, startLinkWin = false;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<9;i++){
            ulim[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<9;i++){
            startLink[i] = Integer.parseInt(st.nextToken());
        }
        int totalUlim = 0;
        int totalStart = 0;

        for(int i=0;i<9;i++){
            totalUlim += ulim[i];
            if(totalUlim > totalStart){
                ulimWin = true;
                startLinkWin = false;
            }
            totalStart += startLink[i];
            if(totalStart > totalUlim){
                startLinkWin = true;
            }
        }

        if(ulimWin && startLinkWin){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}

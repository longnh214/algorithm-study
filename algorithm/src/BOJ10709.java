/**
 * @author nakhoonchoi
 * @date 2024/06/20
 * @see https://www.acmicpc.net/problem/10709
 * @mem 14,204kb
 * @time 248ms
 * @caution
 * [고려사항]
 * 이차원 배열을 이용해서 문제를 해결하였다. 구름의 yIndex를 갱신해주는 방식을 이용했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <구현> '기상캐스터'
public class BOJ10709 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char [][] arr = new char[N][M];
        int [][] answer = new int[N][M];
        for(int i=0;i<N;i++){
            arr[i] = br.readLine().toCharArray();
            Arrays.fill(answer[i], -1);
        }

        for(int i=0;i<N;i++){
            int cIndex = -1;
            for(int j=0;j<M;j++){
                if(arr[i][j] == 'c'){
                    cIndex = j;
                    answer[i][j] = 0;
                }else if(arr[i][j] == '.'){
                    if(cIndex != -1){
                        answer[i][j] = j - cIndex;
                    }
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
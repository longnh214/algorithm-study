/**
 * @author nakhoon
 * @date 2022, 2월 26일
 * @see https://www.acmicpc.net/problem/1244
 * @mem 11,604kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 배열의 인덱스는 0부터 시작하고, 스위치의 인덱스는 1부터 시작한다는 점에서 주의해야 한다.
 * 그리고 스위치는 20개씩 출력하므로 20개 스위치를 출력할 때마다 개행을 해주어야 한다.
 * 여학생의 규칙에서 대칭이 아니라면 바로 break문을 걸어주었어야 했다.(이 부분 때문에 많이 틀렸다.)
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현> '스위치 켜고 끄기'
public class BOJ1244 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean [] status = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            String str = st.nextToken();
            if(str.equals("1")){
                status[i] = true;
            }
        }
        int M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            if(gender == 1){
                for(int j=1;j*index<=N;j++){
                    status[j*index-1] = !status[j*index-1];
                }
            }else{
                for(int j=index-2;j>=0;j--){
                    if(2 * index - 2 - j >= N) break;
                    if(status[j] == status[2 * index - 2 - j]){
                        status[j] = !status[j];
                        status[2 * index - 2 - j] = !status[2 * index - 2 - j];
                    }else{
                        break;
                    }
                }
                status[index - 1] = !status[index - 1];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(status[i] ? "1" : "0").append(" ");
            if(i % 20 == 19){
                sb = new StringBuilder(sb.substring(0, sb.length()-1));
                sb.append("\n");
            }
        }
        System.out.print(sb.substring(0, sb.length()-1));
    }
}
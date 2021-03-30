/**
 * @author choi
 * @date Aug 28, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWAe7XSKfUUDFAUw
 * @mem 20,716 kb
 * @time 849ms
 * @caution
 * [고려사항]
 * left와 right에 대한 temp 배열을 생성해서 문제를 해결하려 했으나,
 * sum 연산, 배열 값 갱신 등 시간 초과가 나는 요인이 많아 solve에
 * 매개 변수로 left와 right를 두어 연산 과정(시간)을 줄여 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//SW Expert <D4> - '준환이의 양팔저울'
public class Solution3234 {
    static int [] num,temp;
    static boolean [] visited;
    static int N, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            answer = 0;
            N = Integer.parseInt(br.readLine());
            num  = new int[N];
            temp = new int[N];
            visited = new boolean[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            permutation(0);
            System.out.println("#" + t + " " + answer);
        }
    }
    public static void permutation(int cnt) {
        if(cnt == N) {
            //여기서 무게 추에 달아보자.
            solve(0,0,0);
            return;
        }

        for(int i=0;i<N;i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp[cnt] = num[i];
                permutation(cnt+1);
                visited[i] = false;
            }
        }
    }

    public static void solve(int cnt, int left, int right) {
        //왼쪽보다 오른쪽이 커진다면 무조건 return
        if(left < right) {
            return;
        }
        //끝까지 도달했다면 완성된 경우이므로 answer++
        if(cnt == N) {
            answer++;
            return;
        }
        //첫번째 턴에는 무조건 왼쪽 저울에 올려야한다.(가지치기)
        else if(cnt == 0){
            solve(cnt+1, left+temp[cnt],right);
        }
        //첫번째 턴 이외에는 왼쪽 오른쪽 어디에 두어도 상관없다.
        else {
            solve(cnt+1, left+temp[cnt],right);
            solve(cnt+1, left,right+temp[cnt]);
        }
    }
}
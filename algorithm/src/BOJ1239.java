/**
 * @author nakhoonchoi
 * @date 2025/07/22
 * @see https://boj.ma/1239
 * @mem 15,424kb
 * @time 140ms
 * @caution
 * [고려사항]
 * 순열로 푸는 문제였다. 조합으로 생각해서 문제를 풀려다가 맞왜틀이 계속 발생했다.
 *
 * 원형 판에서 각 비율들의 합이 정확히 50이 되는 순간 원을 이등분하는 선이 생긴다고 생각했다.
 * 그래서 순열로 비율에 대한 모든 경우의 수를 본 뒤에 비율들을 더해가면서 정확히 50이 되는 순간이 몇 번 있는지 확인하고,
 * 반대로 세면 절반인 경우의 수가 두 번 나올 수 있기 때문에 경우의 수의 절반만큼을 선의 개수라고 생각했다.
 * answer = Math.max(경우의 수 / 2, answer);
 *
 * N이 최대 8이기 때문에 N! * N으로 순열에 대한 모든 경우의 수를 생각한다면 40320 * 8로 적당한 시간 복잡도를 가진다고 생각했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <브루트포스> '차트'

public class BOJ1239 {
    static int [] value;
    static int N;
    static int [] temp;
    static boolean [] visited;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        value = new int[N];
        temp = new int[N];
        visited = new boolean[N];
        boolean flag = false;
        for(int i=0;i<N;i++){
            value[i] = Integer.parseInt(st.nextToken());

            if(value[i] > 50){
                flag = true;
            }
        }

        if(flag){
            System.out.println(0);
        }else{
            perm(0);

            System.out.println(answer);
        }
    }

    public static void perm(int count){
        if(count == N){
            int halfCount = 0;
            for(int i=0;i<N;i++){
                int sum = 0;
                for(int j=0;j<N;j++){
                    sum += temp[(i+j) % N];
                    if(sum == 50){
                        halfCount++;
                        break;
                    }else if(sum > 50){
                        break;
                    }
                }
            }

            answer = Math.max(answer, halfCount / 2);

            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]) {
                visited[i] = true;
                temp[count] = value[i];
                perm(count + 1);
                visited[i] = false;
            }
        }
    }
}
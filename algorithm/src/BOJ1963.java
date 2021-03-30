/**
 * @author choi
 * @date Jan 8, 2021
 * @see https://www.acmicpc.net/problem/1963
 * @mem 31,480kb
 * @time 188ms
 * @caution
 * [고려사항]
 * 소수를 판별하는 문제는 에라토스테네스의 체 알고리즘이 유용하다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <소수/BFS> '소수 경로'
public class BOJ1963 {
    static boolean [] isPrime;
    static int start, end,answer;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        isPrime = new boolean[10000];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i=2;i*i<10000;i++) {
            for(int j=i*i;j<10000;j+=i) {
                isPrime[j] = false;
            }
        }

        for(int t=1;t<=T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            answer = -1;
            bfs();
            System.out.println(answer == -1 ? "Impossible" : answer);
        }
    }

    public static void bfs() {
        Queue<Password> q = new LinkedList<>();
        boolean [] visited = new boolean[10000];

        q.offer(new Password(start, 0));
        visited[start] = true;

        while(!q.isEmpty()) {
            Password temp = q.poll();

            if(temp.password == end) {
                answer = temp.depth;
                return;
            }

            int firstDegit = temp.password / 1000;
            int secondDegit = (temp.password % 1000) / 100;
            int thirdDegit = (temp.password % 100) / 10;
            int fourthDegit = (temp.password % 10);
            int tempPassword = -1;
            StringBuilder sb;

            for(int i=1;i<=9;i++) {
                if(firstDegit != i) {
                    sb = new StringBuilder();
                    sb.append(i).append(secondDegit).append(thirdDegit).append(fourthDegit);

                    tempPassword = Integer.parseInt(sb.toString());

                    if(!visited[tempPassword] && isPrime[tempPassword]) {
                        visited[tempPassword] = true;
                        q.offer(new Password(tempPassword,temp.depth+1));
                    }
                }
            }

            for(int i=0;i<=9;i++) {
                if(secondDegit != i) {
                    sb = new StringBuilder();
                    sb.append(firstDegit).append(i).append(thirdDegit).append(fourthDegit);

                    tempPassword = Integer.parseInt(sb.toString());
                    if(!visited[tempPassword] && isPrime[tempPassword]) {
                        visited[tempPassword] = true;
                        q.offer(new Password(tempPassword,temp.depth+1));
                    }
                }
            }

            for(int i=0;i<=9;i++) {
                if(thirdDegit != i) {
                    sb = new StringBuilder();
                    sb.append(firstDegit).append(secondDegit).append(i).append(fourthDegit);

                    tempPassword = Integer.parseInt(sb.toString());
                    if(!visited[tempPassword] && isPrime[tempPassword]) {
                        visited[tempPassword] = true;
                        q.offer(new Password(tempPassword,temp.depth+1));
                    }
                }
            }

            for(int i=0;i<=9;i++) {
                if(secondDegit != i) {
                    sb = new StringBuilder();
                    sb.append(firstDegit).append(secondDegit).append(thirdDegit).append(i);

                    tempPassword = Integer.parseInt(sb.toString());
                    if(!visited[tempPassword] && isPrime[tempPassword]) {
                        visited[tempPassword] = true;
                        q.offer(new Password(tempPassword,temp.depth+1));
                    }
                }
            }
        }
    }

    static class Password{
        int password;
        int depth;
        Password(int password, int depth){
            this.password = password;
            this.depth = depth;
        }
    }
}
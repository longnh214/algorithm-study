/**
 * @author choi
 * @date Aug 30, 2020
 * @see https://www.acmicpc.net/problem/15666
 * @mem 21,872kb
 * @time 160ms
 * @caution
 * [고려사항]
 * TreeSet을 문자열로 만들어서, 문자열로 사전 순으로 출력하려 했지만
 * 9와 10을 문자열 사전 순으로 비교하면 10이 9보다 앞이 되어 원하는 결과 값이 나오지 않는다.
 * TreeSet은 넣은 값에 따라 순서가 정해지고 LinkedHashSet은 넣은 순서에 따라 순서가 정해 진다는 것을 알 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

// 백준 <브루트포스> - 'N과 M(12)'
public class BOJ15666 {
    static int[] num;
    static boolean[] visited;
    static int[] temp;
    static int N, M;
    static Set<List<Integer>> numSet;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        numSet = new LinkedHashSet<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];

        temp = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        permutation(0,0);

        for (List<Integer> list : numSet) {
            for (int i : list) {
                bw.write(i + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void permutation(int cnt, int start) {
        if (cnt == M) {
            List<Integer> list = new ArrayList<>();
            for (int i : temp) {
                list.add(i);
            }
            numSet.add(list);
            return;
        }

        for (int i = start; i < N; i++) {
            temp[cnt] = num[i];
            permutation(cnt + 1, i);
        }
    }
}
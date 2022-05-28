/**
 * @author nakhoon
 * @date 2022, 5월 28일
 * @see https://www.acmicpc.net/problem/1940
 * @mem 15,068kb
 * @time 148ms
 * @caution
 * [고려사항]
 * 정렬과 투 포인터를 이용해서 문제를 해결 할 수 있었다.
 * [입력사항]
 * [출력사항]
 */

//백준 <정렬> '주몽'
public class BOJ1940 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int count = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == M) {
                count++;
                left++;
            } else if (sum < M) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(count);
    }
}
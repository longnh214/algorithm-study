/**
 * @author choi
 * @date Jan 7, 2021
 * @see https://www.acmicpc.net/problem/18870
 * @mem 359,104kb
 * @time 1868ms
 * @caution
 * [고려사항]
 * 배열의 복사와 map을 이용해서 좌표를 압축할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <값/좌표압축> '좌표 압축'
public class BOJ18870 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int [] temp = Arrays.copyOf(arr, N);
        Arrays.sort(temp);

        Map<Integer,Integer> map = new HashMap<>();
        int idx = 0;
        for(int i=0;i<N;i++) {
            if(!map.containsKey(temp[i]))
                map.put(temp[i], idx++);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            sb.append(map.get(arr[i])).append(" ");
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}
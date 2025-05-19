/**
 * @author nakhoonchoi
 * @date 2025/05/19
 * @see https://boj.ma/16570
 * @mem 115,548kb
 * @time 696ms
 * @caution
 * [고려사항]
 * 아이디어는 금방 떠올렸는데 청멍 비용 때문에 WA를 받았다.
 *
 * 입력의 수는 한 자리수가 아니라 -2^31 과 2^31-1 의 수가 들어올 수 있었기 때문에
 * 배열은 char가 아닌 int 형으로 선언했어야 했다.
 *
 * 입력을 역순으로 받아서 앞부분을 자르는 것이 아니라 뒷 부분을 자르는 것이라고 발상의 전환을 한 뒤에
 * LPS 배열을 만들면서 TreeMap에 len 기준으로 횟수를 담아서 가장 맨 처음의 key와 그 value를 출력하면 되었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <KMP> '앞뒤가 맞는 수열'

public class BOJ16570 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> countMap = new TreeMap<>((o1, o2) -> Integer.compare(o1, o2) * -1);

        int [] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=N-1;i>=0;i--){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int len = 0;
        int [] pi = new int[N];
        for(int i=1;i<N;i++){
            while(len > 0 && arr[len] != arr[i]){
                len = pi[len - 1];
            }
            if(arr[len] == arr[i]){
                len++;
                pi[i] = len;
                countMap.put(len, countMap.getOrDefault(len, 0) + 1);
            }
        }

        if(!countMap.isEmpty()) {
            for (int key : countMap.keySet()) {
                System.out.println((key) + " " + countMap.get(key));
                break;
            }
        }else{
            System.out.println(-1);
        }
    }
}
/**
 * @author nakhoonchoi
 * @date 2025/02/10
 * @see https://boj.ma/2343
 * @mem 22,500kb
 * @time 216ms
 * @caution
 * [고려사항]
 * 백준 6236 용돈 관리 문제와 똑같은 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <이분탐색> '기타 레슨'

public class BOJ2343 {
    static int [] guitarClass;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        guitarClass = new int[N];
        int max = 0;
        int end = 0;

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            guitarClass[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, guitarClass[i]);
            end += guitarClass[i];
        }

        int start = max;
        int result = 0;

        while(start <= end){
            int mid = (start + end) / 2;

            int count = getCount(mid);
            if(M >= count){
                result = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        System.out.println(result);
    }

    public static int getCount(int size){
        int blueRaySize = size;
        int count = 1;

        for(int i=0;i<N;i++){
            blueRaySize -= guitarClass[i];

            if(blueRaySize < 0){
                count++;
                blueRaySize = size - guitarClass[i];
            }
        }

        return count;
    }
}
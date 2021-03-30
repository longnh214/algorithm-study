import java.util.*;
import java.io.*;
//백준 2003번 <투포인터> - '수 들의 합 2'
public class BOJ2003 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;
        while(true){
            //합계가 기준보다 크면 start 값을 하나 올리며 합계에서 start 인덱스 배열 값을 뺀다.
            if(sum >= M)
                sum -= arr[start++];
            //end 값이 배열 인덱스를 넘어가면 반복문에 break를 건다.
            else if(end == N)
                break;
            //위 if에 해당이 전혀 안된다면 end 인덱스를 하나 늘리고 sum에 해당 index값을 더 해준다.
            else
                sum += arr[end++];
            //sum과 기준 값이 같다면 count 값을 +1 해준다.
            if(sum == M)
                count++;
        }
        System.out.println(count);
    }
}
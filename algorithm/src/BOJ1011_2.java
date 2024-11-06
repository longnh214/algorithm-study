import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1011_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int gap = end - start;
            int answer = 0;
            int k = 1;

            while(gap > 0){
                if(gap > 2 * k){
                    gap -= 2 * k;
                    answer += 2;
                }else{
                    gap -= k;
                    answer++;
                }
                k++;
            }
            System.out.println(answer);
        }
    }
}
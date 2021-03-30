import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//백준 1065번 <완전탐색> - '한수'
public class BOJ1065 {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=1;i<=N;i++){
            check(i);
        }
        System.out.println(count);
    }

    public static void check(int n){
        String intToStr = Integer.toString(n);
        if(intToStr.length() == 1 || intToStr.length() == 2){
            count++;
            return;
        }else{
            int len = intToStr.length();
            String [] arr = intToStr.split("");
            int diff = Integer.parseInt(arr[1]) - Integer.parseInt(arr[0]);
            for(int i=1;i<len-1;i++){
                if(diff != Integer.parseInt(arr[i+1]) - Integer.parseInt(arr[i]))
                    return;
                else continue;
            }
            count++;
            return;
        }
    }
}
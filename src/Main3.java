import java.io.*;
public class Main3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        if(n%2==0){//짝수일 때에는 1을 많이 쓰는 것이 가장 최대이다.
            int a = n/2;
            for(int i=0;i<a;i++){
                sb.append(1);
            }
        }else{//홀수라면 가장 맨 앞자리에 7을 쓰는 것이 가장 최대이다.
            int a = n/2;
            sb.append(7);
            for(int i=0;i<a-1;i++){
                sb.append(1);
            }
        }
        System.out.println(sb.toString());
    }
}
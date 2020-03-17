import java.util.*;
import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cost;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int [] arr = new int[n];
        ArrayList<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if(n==k){
            cost = 0;
        }else if(k==0){
            for(int i=0;i<n;i++){
                max = Math.max(max,arr[i]);
                min = Math.max(min,arr[i]);
            }
            cost = max - min;
        }else{
            for(int i=0;i<n;i++) {
                list.add(arr[i]);
            };
            while(k-->1){
                list.remove(Collections.max(list));
            }
            max = Collections.max(list);
            min = Collections.min(list);
            cost = max - min;
        }
        System.out.println(cost);
    }
}

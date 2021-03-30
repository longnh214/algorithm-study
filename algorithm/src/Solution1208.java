import java.util.*;
import java.io.*;
//SW Expert 1208번 <D3> - 'Flatten'
public class Solution1208 {

    public static void main(String[] args) throws IOException {
        int [] map = new int[100];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t=1;t<=10;t++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int maxIndex = 0;
            int minIndex = 99;
            int dump = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<map.length;i++) {
                map[i] = Integer.parseInt(st.nextToken());
                if(max < map[i]) {
                    max = map[i];
                    maxIndex = i;
                }
                if(min > map[i]) {
                    min = map[i];
                    minIndex = i;
                }
            }

            for(int i=0;i<dump;i++) {
                map[maxIndex]--;
                map[minIndex]++;
                //초기화.
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                for(int j=0;j<map.length;j++) {
                    if(max < map[j]) {
                        max = map[j];
                        maxIndex = j;
                    }
                    if(min > map[j]) {
                        min = map[j];
                        minIndex = j;
                    }
                }
            }
            System.out.printf("#%d %d\n",t,map[maxIndex] - map[minIndex]);
        }
    }
}
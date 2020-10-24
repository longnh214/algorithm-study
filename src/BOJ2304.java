/**
 * @author choi
 * @date Oct 25, 2020
 * @see https://www.acmicpc.net/problem/2304
 * @mem 13,824kb
 * @time 136ms
 * @caution
 * [고려사항]
 * 백준의 빗물 문제와 비슷하다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현> '창고 다각형'
public class BOJ2304 {
    static Height [] heightTempArr;
    static int [] heightArr;


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        heightTempArr = new Height[N];
        StringTokenizer st = null;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());

            int index = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            heightTempArr[i] = new Height(index, height);
        }

        Arrays.sort(heightTempArr);

        int length = heightTempArr[N-1].index - heightTempArr[0].index + 1;

        heightArr = new int[length];

        for(int i=0;i<N;i++) {
            heightArr[heightTempArr[i].index - heightTempArr[0].index] = heightTempArr[i].height;
        }

        for(int i=1;i<length-1;i++) {
            int leftHeight = Integer.MIN_VALUE;
            int rightHeight = Integer.MIN_VALUE;

            for(int j=0;j<i;j++) {
                leftHeight = Math.max(leftHeight, heightArr[j]);
            }
            for(int j=i+1;j<length;j++) {
                rightHeight = Math.max(rightHeight, heightArr[j]);
            }

            int temp = Math.min(leftHeight, rightHeight);

            if(temp - heightArr[i] < 0) continue;

            heightArr[i] = temp;
        }
        int sum = 0;
        for(int i=0;i<length;i++) {
            sum += heightArr[i];
        }
        System.out.println(sum);
    }

    static class Height implements Comparable<Height>{
        int index;
        int height;

        Height(int index, int height){
            this.index = index;
            this.height = height;
        }

        @Override
        public int compareTo(Height o) {
            // TODO Auto-generated method stub
            return Integer.compare(this.index, o.index);
        }
    }
}
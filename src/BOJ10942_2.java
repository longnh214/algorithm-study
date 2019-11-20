import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://yhk-0811.tistory.com/29 참고
public class BOJ10942_2{

    static int[] numArr;
    static int[][] palAfrr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        numArr = new int[cnt+1];
        palAfrr = new int[cnt+1][cnt+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= cnt; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int cmdCnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= cmdCnt; i++) {
            st = new StringTokenizer(br.readLine());
            if(isPalindrom(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) == 2){
                sb.append("1\n");
            }
            else {
                sb.append("0\n");
            }
        }

        System.out.println(sb.toString());

    }

    private static int isPalindrom(int start, int end ) {
        if (start == end)
            return 2;

        if (start + 1 == end) {
            if (numArr[start] == numArr[end])
                return 2;
            return 1;
        }

        if(palAfrr[start][end] >= 1)
            return palAfrr[start][end];

        if (numArr[start] != numArr[end])
            return 1;
        else {
            return (palAfrr[start][end] = isPalindrom(start + 1, end - 1));
        }
    }

}
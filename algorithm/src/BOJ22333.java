/**
 * @author nakhoonchoi
 * @date 2024/07/10
 * @see https://www.acmicpc.net/problem/22333
 * @mem 300,664kb
 * @time 3,156ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <자료 구조> '가희와 키워드'
public class BOJ22333 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int strCount = Integer.parseInt(st.nextToken());
        int cmdCount = Integer.parseInt(st.nextToken());

        Set<String> dataSet = new HashSet<>();
        for(int i=0;i<strCount;i++){
            String str = br.readLine();
            dataSet.add(str);
        }
        for(int i=0;i<cmdCount;i++){
            String [] cmdArr = br.readLine().split(",");
            for(int j=0;j<cmdArr.length;j++){
                dataSet.remove(cmdArr[j]);
            }
            System.out.println(dataSet.size());
        }
    }
}
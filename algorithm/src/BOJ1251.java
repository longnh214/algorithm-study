/**
 * @author nakhoonchoi
 * @date 2023/07/02
 * @see https://www.acmicpc.net/problem/1251
 * @mem 13,192kb
 * @time 96ms
 * @caution
 * [고려사항]
 * 오랜만에 풀어본 알고리즘 문제!
 * 이중 for문을 이용해 문자열을 나누고 뒤집어서 합치고 정렬했다!
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
public class BOJ1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String [] temp = new String[3];

        List<String> strList = new ArrayList<>();

        for(int i=1;i<str.length()-1;i++){
            for(int j=i+1;j<str.length();j++){
                temp[0] = str.substring(0, i);
                temp[1] = str.substring(i,j);
                temp[2] = str.substring(j,str.length());

                StringBuilder sb = new StringBuilder();
                for(int k=0;k<3;k++){
                    for(int l=temp[k].length()-1;l>=0;l--){
                        sb.append(temp[k].charAt(l));
                    }
                }

                strList.add(sb.toString());

                sb.setLength(0);
            }
        }

        Collections.sort(strList);

        System.out.println(strList.get(0));
    }
}
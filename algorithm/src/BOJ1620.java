import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//백준 1620번 <자료구조> - '나는야 포켓몬 마스터 이다솜'
public class BOJ1620 {
    public static void main(String[] args) throws IOException {
        HashMap<String,String> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            String pokeName = br.readLine();
            map.put(Integer.toString(i+1),pokeName);
            map.put(pokeName,Integer.toString(i+1));
        }

        while(M-->0){
            String question = br.readLine();
            System.out.println(map.get(question));
        }
    }
}
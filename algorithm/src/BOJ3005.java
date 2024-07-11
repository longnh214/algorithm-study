/**
 * @author nakhoonchoi
 * @date 2024/07/11
 * @see https://www.acmicpc.net/problem/3005
 * @mem 11,620kb
 * @time 68ms
 * @caution
 * [고려사항]
 * #에 막혀있는 1자리 글자수를 제외한 모든 글자를 wordList에 넣고, 정렬해서 첫 번째 글자를 출력하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <문자열> '크로스워드 퍼즐 쳐다보기'

public class BOJ3005 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char [][] puzzle = new char[R][C];

        List<String> wordList = new ArrayList<>();

        for(int i=0;i<R;i++){
            puzzle[i] = br.readLine().toCharArray();
        }

        for(int i=0;i<R;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<C;j++){
                if(puzzle[i][j] == '#'){
                    if(sb.length() > 1) {
                        wordList.add(sb.toString());
                    }else{
                        sb = new StringBuilder();
                    }
                }else{
                    sb.append(puzzle[i][j]);
                }
            }
            if(sb.length() > 1) {
                wordList.add(sb.toString());
            }
        }

        for(int i=0;i<C;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<R;j++){
                if(puzzle[j][i] == '#'){
                    if(sb.length() > 1) {
                        wordList.add(sb.toString());
                    }else{
                        sb = new StringBuilder();
                    }
                }else{
                    sb.append(puzzle[j][i]);
                }
            }
            if(sb.length() > 1) {
                wordList.add(sb.toString());
            }
        }
        Collections.sort(wordList);

        System.out.println(wordList.get(0));
    }
}
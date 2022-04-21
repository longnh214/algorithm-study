/**
 * @author nakhoon
 * @date 2022, 4월 21일
 * @see https://www.acmicpc.net/problem/2947
 * @mem 11,424kb
 * @time 72ms
 * @caution
 * [고려사항]
 * 버블 정렬과 헷갈려서 많이 틀렸습니다를 받았던 문제이다. swap 할 때마다 StringBuilder에 넣어주어야 한다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 <구현> '나무 조각'
public class BOJ2947 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] tree = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<5;i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder answer = new StringBuilder();
        while(!isEnd(tree)){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<tree.length-1;i++){
                if(tree[i] > tree[i+1]){
                    swap(tree, i);

                    for(int j=0;j<tree.length;j++){
                        sb.append(tree[j]).append(" ");
                    }

                    sb = new StringBuilder(sb.substring(0, sb.length()-1)).append("\n");
                }
            }
            answer.append(sb);
        }

        System.out.println(answer.substring(0, answer.length()-1));
    }

    public static void swap(int [] tree, int index){
        int temp = tree[index];
        tree[index] = tree[index+1];
        tree[index+1] = temp;
    }

    public static boolean isEnd(int [] tree){
        for(int i=0;i<tree.length;i++){
            if(tree[i] != i+1){
                return false;
            }
        }
        return true;
    }
}
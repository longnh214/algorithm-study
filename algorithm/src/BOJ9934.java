/**
 * @author choi
 * @date Dec 17, 2020
 * @see https://www.acmicpc.net/problem/9934
 * @mem 11,944kb
 * @time 88ms
 * @caution
 * [고려사항]
 * 배열을 완전 이진 트리로 바꾸는 재귀 함수 작성이 요구된 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <트리> '완전 이진 트리'
public class BOJ9934 {
    static int K,totalLen;
    static int [] arr;
    static List<Integer> [] treeList;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        totalLen = pow(2,K)-1;
        arr = new int[totalLen];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<totalLen;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        treeList = new ArrayList[K];

        for(int i=0;i<K;i++) {
            treeList[i] = new ArrayList<>();
        }

        tree(0,totalLen-1,0);

        StringBuilder sb;
        for(int i=0;i<K;i++) {
            sb = new StringBuilder();
            for(int temp : treeList[i]) {
                sb.append(temp).append(" ");
            }
            System.out.println(sb.substring(0,sb.length()-1));
        }
    }

    public static int pow(int a, int b) {
        if(b == 0)
            return 1;
        else {
            int temp = pow(a,b/2);
            if(b%2==0) return (temp * temp);
            else return ((temp * temp) * a);
        }

    }

    public static void tree(int start, int end, int level) {
        if(level == K) return;
        int mid = (start + end) / 2;
        treeList[level].add(arr[mid]);
        tree(start,mid-1,level+1);
        tree(mid+1,end,level+1);
    }
}
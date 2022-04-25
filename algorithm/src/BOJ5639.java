/**
 * @author nakhoon
 * @date 2022, 4월 25일
 * @see https://www.acmicpc.net/problem/5639
 * @mem 33,440kb
 * @time 652ms
 * @caution
 * [고려사항]
 * 입력이 어려웠던 문제이다. input이 공백이거나 null일 경우에 while문을 탈출해주었다.
 * 전위 순회는 상위-왼쪽-오른쪽 순서의 순회이고, 후위 순회는 왼쪽-오른쪽-상위 순서의 순회이다.
 * 재귀를 이용해서 먼저 왼쪽 오른쪽 자식들에 대해 출력해주고, 마지막에 루트의 수를 출력하는 것을
 * 중첩하면 문제를 해결 할 수 있다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <트리> '이진 검색 트리'
public class BOJ5639 {
    static int [] tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tree = new int[10001];
        String str;
        int index = 0;
        while(true){
            str = br.readLine();
            if(str == null || str.equals("")){
                break;
            }
            int num = Integer.parseInt(str);
            tree[index++] = num;
        }

        postOrder(0, index - 1);
    }

    static void postOrder(int n, int end) {
        if (n > end)
            return;

        int mid = n + 1;
        while (mid <= end && tree[mid] < tree[n])
            mid++;

        postOrder(n + 1, mid - 1);
        postOrder(mid, end);
        System.out.println(tree[n]);
    }
}

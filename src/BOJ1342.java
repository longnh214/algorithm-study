/**
 * @author choi
 * @date Sep 16, 2020
 * @see https://www.acmicpc.net/problem/1342
 * @mem 17,080kb
 * @time 592ms
 * @caution
 * [고려사항]
 * 같은 알파벳 개수 만큼 겹치기 때문에 완전탐색을 한 후,
 * 알파벳 마다 개수 만큼 나눠주면 result 값을 찾을 수 있다.
 * result = 모든 경우의 수 / (a의 개수)! * ... (z의 개수)!
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <브루트포스> '행운의 문자열'
public class BOJ1342 {
    static int result=0;
    static String str;
    static ArrayList<Character> arrList = new ArrayList<>();
    static int alphaCount[] = new int[26];
    static char arr[] = new char[10];
    static boolean visit[] = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        for(int i=0; i<str.length(); i++) {
            alphaCount[str.charAt(i)-'a']++;
        }

        permutation(0);

        for(int i=0; i<26; i++) {
            if(alphaCount[i] > 1) {
                result /= factorial(alphaCount[i]);
            }
        }
        System.out.println(result);
    }
    public static boolean check() {

        for(int i=0; i<arrList.size()-1; i++) {
            if(arrList.get(i)==arrList.get(i+1))
                return false;
        }
        return true;
    }
    public static int factorial(int N) {
        if(N==1)
            return 1;

        return N*factorial(N-1);
    }
    public static void permutation(int count) {
        if(count == str.length()) {
            if(check()) {
                result++;
                return;
            }
        }
        for(int i=0; i<str.length(); i++) {
            if(!visit[i]) {
                visit[i] = true;
                arrList.add(str.charAt(i));
                permutation(count+1);
                arrList.remove(arrList.size()-1);
                visit[i] = false;
            }
        }
    }
}
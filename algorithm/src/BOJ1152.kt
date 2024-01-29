/**
 * @author naknak
 * @date 1/29/24
 * @see https://www.acmicpc.net/problem/1152
 * @mem 20,688kb
 * @time 188ms
 * @caution
 * [고려사항]
 * 입력이 " " 공백 하나만 들어올 경우도 있기 때문에 trim으로 계산하면 정답이 1이 나온다.
 * StringTokenizer로 문제를 해결해야했던 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;

//백준 <문자열> '단어의 갯수'
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine());
    val count : Int = st.countTokens();
    print(count);
}
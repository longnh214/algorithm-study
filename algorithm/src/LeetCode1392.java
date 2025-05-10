/**
 * @author nakhoonchoi
 * @date 2025/05/10
 * @see https://leetcode.com/problems/longest-happy-prefix/
 * @mem 45.44MB
 * @time 9ms
 * @caution
 * [고려사항]
 * KMP 알고리즘에 기반이 되는 LPS 알고리즘에 대한 기초 문제였다.
 * (Longest proper Prefix which is also Suffix)
 *
 * pi 배열에는 s[0...i]까지 prefix와 suffix의 공통으로 가장 긴 길이를 저장해두는 배열이고
 *
 * len이라는 현재 접두사 접미사 공통 최장 길이를 저장할 변수를 선언하고
 * i를 1부터 s.length()-1까지 순회하며 아래와 같이 로직을 수행했다.
 *
 * if s의 i번째 문자 == s의 len번째 문자 (이전의 최장 길이의 문자열에서 연장되는 경우)
 *    len++
 *    pi[i] = len
 *    i++
 * else (이전의 최장 길이의 문자열에서 연장 되지않는 경우)
 *    if len != 0
 *       len = pi[len - 1] (pi[len - 1] 값으로 len을 줄이면 앞쪽에서 이미 부분적으로 일치했던 접두사/접미사 정보를 재사용할 수 있음.)
 *    else
 *       pi[i] = 0
 *       i++
 *
 * 순회한 뒤에 s.substring(0, pi[n-1]) 을 출력해주면 접두사/접미사 최장 공통 문자열이 출력될 것이다.
 * [입력사항]
 * [출력사항]
 */
//LeetCode <LeetCode> 'Longest Happy Prefix'

public class LeetCode1392 {
    public String longestPrefix(String s) {
        int n = s.length();
        int [] pi = new int[n];

        int len = 0;

        for(int i=1;i<n;){
            if(s.charAt(len) == s.charAt(i)){
                len++;
                pi[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = pi[len - 1];
                }else{
                    pi[i] = 0;
                    i++;
                }
            }
        }

        return s.substring(0, pi[n - 1]);
    }
}
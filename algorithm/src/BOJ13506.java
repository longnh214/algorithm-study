/**
 * @author nakhoonchoi
 * @date 2025/05/14
 * @see https://boj.ma/13506
 * @mem 339,088kb
 * @time 744ms
 * @caution
 * [고려사항]
 * KMP 알고리즘에 흥미를 느끼고 있다.
 *
 * 우선 해당 문제는 문자열 s 안에서 카멜레온 부분 문자열 중 가장 긴 문자열을 찾아야 한다.
 * 💡 카멜레온 부분 문자열이란 문자열 s 중
 * 접두사(Prefix)도 될 수 있고, 접미사(Prefix)도 될 수 있고, 두 경우가 아닌 위치에도 등장하는 부분 문자열을 의미한다.
 *
 * 우선 LPS 알고리즘을 이용해서 문자열 s에 대해 접두사와 접미사가 될 수 있는 가장 긴 문자열의 길이를 구했다.
 * -> pi[n-1]에는 가장 긴 공통 부분 문자열의 길이가 저장될 것이다.
 *
 * 하지만 항상 pi[n-1] 만큼의 부분 문자열이 문자열의 중간에 있으리라는 법은 없다.
 * 그래서 아래 범위 반복문에서 위 조건에 만족하는 부분 문자열이 있는지 찾아주었다.
 *
 * for(int i=originPi[n-1];i>=1;i--){
 *      String pattern = s[n-i...n] -> 접미사를 특정 길이만큼 자른 패턴
 *      if(s[0...i]과 패턴이 일치하고 && s 안에 pattern이 3번 이상 등장한다면){
 *          조건 만족;
 *          syso(pattern);
 *          return;
 *      }
 * }
 *
 * 그리고 위 반복문에서 카멜레온 부분 문자열을 찾지 못했다면 -1을 출력해주었다.
 *
 * ⚠️ 메모리와 소요 시간이 비효율적이여서 수정할 수 있는 부분을 생각해보았는데
 * for(int i=originPi[n-1];i>=1;i--){ 에서 i--를 해서 최장 길이부터 1까지 가능한 모든 접두사 접미사를 판별하고 있었다.
 * pi 배열을 효율적으로 쓴다면
 * for(int i=originPi[n-1];i>=1;i = originPi[i-1]){ 로 다음 i 탐방 로직을 바꾼다면
 * if문 안에서 접두사와 접미사가 같은지 확인할 필요가 없다.
 * pi 배열을 이용해서 다음으로 가능한 문자열을 즉시 찾아갈 수 있기 때문이다.
 *
 * 만약 위 로직으로만 통과될 수 있었다면 난이도가 더 올라갔을 것 같다...
 * 문자열 찾기 로직은 어려운데 열심히 공부해야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <KMP> '카멜레온 부분 문자열'

public class BOJ13506 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        int [] originPi = getPi(str);

        for(int i=originPi[n-1];i>=1;i--){
            String pattern = str.substring(n-i);
            if(str.substring(0, i).equals(pattern) && KMP(str, pattern) >= 3){
                System.out.println(pattern);
                return;
            }
        }

        System.out.println(-1);
    }

    public static int [] getPi(String pattern){
        int n = pattern.length();
        int [] pi = new int[n];
        int len = 0;
        Map<Integer, Integer> piCountMap = new HashMap<>();

        for(int i=1;i<n;i++){
            while(len > 0 && pattern.charAt(len) != pattern.charAt(i)){
                len = pi[len - 1];
            }
            if(pattern.charAt(len) == pattern.charAt(i)){
                len++;
                pi[i] = len;
                piCountMap.put(len, piCountMap.getOrDefault(len, 1) + 1);
            }
        }

        return pi;
    }

    public static int KMP(String origin, String pattern){
        if(origin.length() < pattern.length()){
            return -1;
        }

        int [] pi = getPi(pattern);
        int index = 0;

        int count = 0;

        for(int i=0;i<origin.length();i++){
            while(index > 0 && origin.charAt(i) != pattern.charAt(index)){
                index = pi[index - 1];
            }
            if(origin.charAt(i) == pattern.charAt(index)){
                if(index == pattern.length() - 1){
                    count++;
                    index = pi[index];
                }else{
                    index++;
                }
            }
        }

        return count;
    }

    public static boolean kmp(String origin, String pattern){
        int [] pi = getPi(pattern);
        int index = 0;

        for(int i=0;i<origin.length();i++){
            while(index > 0 && origin.charAt(i) != pattern.charAt(index)){
                index = pi[index - 1];
            }
            if(origin.charAt(i) == pattern.charAt(index)){
                if(index == pattern.length() - 1){
                    return true;
                }else{
                    index++;
                }
            }
        }

        return false;
    }
}
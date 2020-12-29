/**
 * @author choi
 * @date Dec 30, 2020
 * @see https://www.acmicpc.net/problem/1339
 * @mem 11,692kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 해시맵에서 value에 대한 정렬을 구현하면 풀 수 있는 문제였다.
 * 각 알파벳에 대한 계수들의 합을 map에 저장하고, 그 map의 value(계수의 합)으로 정렬하여 가장 큰 값부터 9,8,7,6... 순으로 주면 된다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
// 백준 <자료구조> '단어 수학'
public class BOJ1339 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int len = str.length();

            for (int j = 0; j < len; j++) {
                char c = str.charAt(j);

                map.put(c, map.getOrDefault(c, 0) + (int) Math.pow(10, len - j-1));
            }
        }

        List<Character> list = new ArrayList<>(map.keySet());

        Collections.sort(list, new Comparator<Character>() {

            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });

        int answer = 0;
        int num = 9;
        for(char c : list) {
            answer += (num * map.get(c));
            num--;
        }
        System.out.println(answer);
    }
}
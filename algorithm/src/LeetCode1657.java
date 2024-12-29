/**
 * @author nakhoonchoi
 * @date 2024/12/29
 * @see https://leetcode.com/problems/determine-if-two-strings-are-close/description/
 * @mem 45,84MB
 * @time 12ms
 * @caution
 * [고려사항]
 * 문자열의 길이, 각 문자의 갯수, 문자 갯수의 정렬, 교환 가능한 지 판별의 분기처리를 통해 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.util.stream.*;
//LeetCode <LeetCode 75> 'Determine if Two Strings Are Close'

public class LeetCode1657 {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }

        char [] word1Arr = word1.toCharArray();
        char [] word2Arr = word2.toCharArray();

        int [] word1CountArr = new int[26];
        int [] word2CountArr = new int[26];

        for(int i=0;i<word1Arr.length;i++){
            word1CountArr[word1Arr[i] - 'a']++;
        }

        for(int i=0;i<word2Arr.length;i++){
            word2CountArr[word2Arr[i] - 'a']++;
        }

        for(int i=0;i<26;i++){
            if((word1CountArr[i] == 0 && word2CountArr[i] != 0) || word2CountArr[i] == 0 && word1CountArr[i] != 0){
                return false;
            }
        }

        List<Integer> word1CountList = Arrays.stream(word1CountArr).filter(num -> num != 0).boxed().collect(Collectors.toList());
        List<Integer> word2CountList = Arrays.stream(word2CountArr).filter(num -> num != 0).boxed().collect(Collectors.toList());

        if(word1CountList.size() != word2CountList.size()){
            return false;
        }

        Collections.sort(word1CountList);
        Collections.sort(word2CountList);

        for(int i=0;i<word1CountList.size();i++){
            if(!Objects.equals(word1CountList.get(i), word2CountList.get(i))){
                return false;
            }
        }

        return true;
    }
}
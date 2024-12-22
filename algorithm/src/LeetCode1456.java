/**
 * @author nakhoonchoi
 * @date 2024/12/22
 * @see https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
 * @mem 44.91MB
 * @time 25ms
 * @caution
 * [고려사항]
 * 모음을 판별할 때 Set을 이용해서 속도가 늦은걸까 했는데, 조건문을 수정해도 실행 속도에 차이가 많이 나지 않았다.
 * 투 포인터를 잘 이용하면 답을 얻을 수 있을 것같다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//LeetCode <LeetCode 75> 'Maximum Number of Vowels in a Substring of Given Length'

public class LeetCode1456 {
    public int maxVowels(String s, int k) {
        int answer;
        int count = 0;
        Set<Character> vowelSet = Set.of('a','e','i','o','u');

        for(int i=0;i<k;i++){
            if(vowelSet.contains(s.charAt(i))){
                count++;
            }
        }
        answer = count;

        for(int i=1;i<s.length()-k+1;i++){
            if(vowelSet.contains(s.charAt(i-1))){
                count--;
            }

            if(vowelSet.contains(s.charAt(i+k-1))){
                count++;
            }

            if(answer < count){
                answer = count;
            }

            if(answer == k){
                return answer;
            }
        }

        return answer;
    }

    public int maxVowels2(String s, int k) {
        int answer;
        int count = 0;

        for(int i=0;i<k;i++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
                count++;
            }
        }
        answer = count;

        for(int i=1;i<s.length()-k+1;i++){
            if(s.charAt(i-1) == 'a' || s.charAt(i-1) == 'e' || s.charAt(i-1) == 'i' || s.charAt(i-1) == 'o' || s.charAt(i-1) == 'u'){
                count--;
            }

            if(s.charAt(i+k-1) == 'a' || s.charAt(i+k-1) == 'e' || s.charAt(i+k-1) == 'i' || s.charAt(i+k-1) == 'o' || s.charAt(i+k-1) == 'u'){
                count++;
            }

            if(answer < count){
                answer = count;
            }

            if(answer == k){
                return answer;
            }
        }

        return answer;
    }
}
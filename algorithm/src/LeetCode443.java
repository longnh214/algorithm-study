import java.util.Arrays;

/**
 * @author nakhoonchoi
 * @date 2024/12/19
 * @see https://leetcode.com/problems/string-compression/description/
 * @mem 44.28MB
 * @time 1ms
 * @caution
 * [고려사항]
 * chars 배열도 변경해야하고, 변환 이후의 배열의 길이를 반환해야하는 문제였다.
 * 처음에는 group 중 숫자(길이)로 변경해야하는 부분을 구해서 replace 하려했는데
 * 문제 고려사항 중 상수에 대한 변수만 선언할 수 있다고 되어있었다.
 *
 * medium이 아니라 hard 문제 같다...
 *
 * 다른 해답을 참고했다.
 * while 문으로 인덱스를 증가시키면서 groupLength를 계산하고 다른 문자가 나타났을 때
 * chars 배열을 갱신해주고, result 변수로 정답의 길이를 관리했다.
 * 배열을 재선언할 필요가 없었다. LeetCode 플랫폼 내부에서 배열을 잘라주는 듯?
 * [입력사항]
 * [출력사항]
 */
//LeetCode <LeetCode> 'String Compression'

public class LeetCode443 {
    public int compress(char[] chars) {
        int i = 0;
        int result = 0;

        while(i < chars.length){
            int groupLength = 1;

            while(i + groupLength < chars.length && chars[i + groupLength] == chars[i]){
                groupLength++;
            }

            chars[result++] = chars[i];

            if(groupLength > 1){
                for(char c : Integer.toString(groupLength).toCharArray()){
                    chars[result++] = c;
                }
            }

            i += groupLength;
        }

        return result;
    }

    public int compress2(char[] chars) {
        int answer = 1;
        int count = 1;

        if(chars.length == 1){
            return answer;
        }

        for(int i=1;i<chars.length;i++){
            if(chars[i-1] == chars[i]){
                count++;
            }else{
                answer++;

                if(count > 1){
                    answer += (String.valueOf(count).length());
                }

                count = 1;
            }
        }

        answer++;
        if(count > 1){
            answer += (String.valueOf(count).length());
        }

        return answer - 1;
    }
}
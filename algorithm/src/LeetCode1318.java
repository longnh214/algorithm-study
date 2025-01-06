/**
 * @author nakhoonchoi
 * @date 2025/01/06
 * @see https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/
 * @mem 40.14MB
 * @time 0ms
 * @caution
 * [고려사항]
 * a,b,c 숫자들 중 2진수로 변환했을 때 가장 길이가 긴 수를 찾아서
 * 그 길이로 a,b,c에 대한 boolean 배열을 선언해준다.
 * (0 -> false, 1 -> true)의 형태로 변환해준다.
 * 0부터 maxLength까지 순회하면서 OR 연산이니까
 * c의 값이 true이면 a와 b 둘 중에 하나만 true이면 되고,
 * c의 값이 false이면 a와 b 둘 다 false여야 함을 맞추도록 count를 세주면 된다.
 * [입력사항]
 * [출력사항]
 */
//LeetCode <LeetCode 75> 'Minimum Flips to Make a OR b Equal to c'

public class LeetCode1318 {
    public static void main(String[] args) {
        int a = 2;
        int b = 6;
        int c = 5;

        minFlips(a,b,c);
    }
    public static int minFlips(int a, int b, int c) {
        int maxLength = 0;
        maxLength = Math.max(maxLength, Integer.toString(a, 2).length());
        maxLength = Math.max(maxLength, Integer.toString(b, 2).length());
        maxLength = Math.max(maxLength, Integer.toString(c, 2).length());

        boolean [] intToBoolA = bitToBool(a, maxLength);
        boolean [] intToBoolB = bitToBool(b, maxLength);
        boolean [] intToBoolC = bitToBool(c, maxLength);

        int answer = 0;
        for(int i=0;i<maxLength;i++){
            if(intToBoolC[i]){ //true일 경우
                if(!intToBoolA[i] && !intToBoolB[i]){
                    answer++;
                }
            }else{ //false일 경우
                if(intToBoolA[i] && intToBoolB[i]){
                    answer+=2;
                }else if(intToBoolA[i] || intToBoolB[i]){
                    answer++;
                }
            }
        }

        return answer;
    }

    public static boolean [] bitToBool(int num, int length){
        boolean [] bitBool = new boolean[length];
        char [] numToChar = Integer.toString(num, 2).toCharArray();
        int j=0;
        for(int i=numToChar.length - 1;i>=0;i--){
            bitBool[j++] = numToChar[i] == '1';
        }
        return bitBool;
    }
}
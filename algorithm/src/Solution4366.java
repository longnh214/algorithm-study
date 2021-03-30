/**
 * @author choi
 * @date Sep 4, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWMeRLz6kC0DFAXd
 * @mem 19,388kb
 * @time 102ms
 * @caution
 * [고려사항]
 * 사용해야 할 자료구조가 딱히 생각나지 않아 Set으로 나올 경우의 수를 모두 Set에 넣어주는 방식으로
 * visited를 체크하고, 2진수에서 나올 수 있는 모든 경우의 수를 set에 담고,
 * 3진수에서 나오는 모든 경우의 수를 set과 체크해서 겹치는 수 하나를 출력하도록 했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//SW Expert <D4> '정식이의 은행 업무'
public class Solution4366 {
    static long answer;
    static long [] pow2;
    static long [] pow3;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Set<Long> set = new HashSet<>();
        pow2 = new long[40];
        pow3 = new long[40];
        pow2[0] = 1;
        pow3[0] = 1;
        for(int i=1;i<pow2.length;i++) {
            pow2[i] = pow2[i-1] * 2;
            pow3[i] = pow3[i-1] * 3;
        }

        for(int t=1;t<=T;t++) {
            String str2 = br.readLine();
            String str3 = br.readLine();
            long sum2 = 0;
            long sum3 = 0;
            for(int i=str2.length()-1;i>=0;i--) {
                int n = str2.charAt(str2.length() - i - 1) - '0';
                sum2 += (pow2[i] * n);
            }
            for(int i=str3.length()-1;i>=0;i--) {
                int n = str3.charAt(str3.length() - i - 1) - '0';
                sum3 += (pow3[i] * n);
            }
            for(int i=str2.length()-1;i>=0;i--) {
                int n = str2.charAt(str2.length() - i - 1) - '0';
                if(n == 0) {
                    set.add(sum2 + pow2[i]);
                }else {
                    set.add(sum2 - pow2[i]);
                }
            }

            for(int i=str3.length()-1;i>=0;i--) {
                int n = str3.charAt(str3.length() - i - 1) - '0';
                if(n == 0) {
                    if(set.contains(sum3 + pow3[i])) {
                        answer = sum3 + pow3[i];

                        break;
                    }
                    else
                        set.add(sum3 + pow3[i]);
                    if(set.contains(sum3 + (pow3[i] * 2))) {
                        answer = sum3 + (pow3[i] * 2);

                        break;
                    }
                    else
                        set.add(sum3 + (pow3[i] * 2));
                }else if(n == 1){
                    if(set.contains(sum3 - pow3[i])) {
                        answer = sum3 - pow3[i];

                        break;
                    }
                    else
                        set.add(sum3 - pow3[i]);
                    if(set.contains(sum3 + pow3[i])) {
                        answer = sum3 + pow3[i];

                        break;
                    }
                    else
                        set.add(sum3 + pow3[i]);
                }else {
                    if(set.contains(sum3 - pow3[i])) {
                        answer = sum3 - pow3[i];

                        break;
                    }else
                        set.add(sum3 - pow3[i]);
                    if(set.contains(sum3 - (pow3[i] * 2))) {
                        answer = sum3 - (pow3[i] * 2);

                        break;
                    }
                    else
                        set.add(sum3 - (pow3[i] * 2));
                }
            }
            System.out.println("#"+t+ " " + answer);
        }
    }
}
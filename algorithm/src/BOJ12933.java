/**
 * @author nakhoonchoi
 * @date 2024/07/14
 * @see https://www.acmicpc.net/problem/12933
 * @mem 11,744kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 먼저 주어진 울음소리가 5로 나누어지지 않으면 정상적이지 않은 소리라고 판단해주었고,
 * q,u,a,c,k 순서대로 임의의 문자로 바꾸고, 마지막까지 치환이 되었다면 오리의 마리 수를,
 * 치환될 문자가 남았다면 정상적이지 않은 소리이기 때문에 -1을 출력해주었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <그리디> '오리'

public class BOJ12933 {
    static char [] duckSounds = {'q','u','a','c','k'};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] sound = br.readLine().toCharArray();

        if (sound.length % 5 != 0) {
            System.out.println(-1);
            return;
        }

        int remain = sound.length;
        int count = 0;
        while (remain != 0) {
            int pt = 0;
            int index = 0;
            boolean check = false;
            int[] temp = new int[5];
            while (index < sound.length) {
                if (sound[index] == duckSounds[pt]) {
                    temp[pt++] = index;
                    if (pt==5) {
                        check = true;
                        remain -= 5;
                        pt = 0;
                        for (int i = 0; i < 5; i++) {
                            sound[temp[i]] = '\0';
                        }
                    }
                }
                index++;
            }
            if (check) {
                count++;
            }
            else break;
        }
        System.out.println(remain == 0 ? count : -1);
    }
}
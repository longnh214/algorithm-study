/**
 * @author choi
 * @date 2020. 7. 29
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LyE7KD2ADFAXc&categoryId=AV5LyE7KD2ADFAXc&categoryType=CODE
 * @mem 81,124 kb
 * @time 362 ms
 * @caution
 * [고려사항] 배열의 범위, 인덱스, 방향마다 인덱스의 변화를 정확히 고려해야한다. 이것 때문에 실수 했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//SW expert 1873번 <D3> - '상호의 배틀필드'
public class Solution1873 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char [][] map;
    static char [] uCmd;
    static int H,W,cmd;

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            int curX = -1, curY = -1;
            map = new char[H][W];
            for(int i=0;i<H;i++) {
                String str = br.readLine();
                for(int j=0;j<W;j++) {
                    map[i][j] = str.charAt(j);
                    if(str.charAt(j) == '<' || str.charAt(j) == '^' || str.charAt(j) == 'v' || str.charAt(j) == '>') {
                        curX = j;
                        curY = i;
                    }
                }
            }

            cmd = Integer.parseInt(br.readLine());
            uCmd = new char[cmd];
            String str = br.readLine();
            for(int i=0;i<cmd;i++) {
                uCmd[i] = str.charAt(i);
            }

            for(int i=0;i<cmd;i++) {
                switch(uCmd[i]) {
                    case 'U':
                        map[curY][curX] = '^';
                        if(isIn(curY-1,curX) && map[curY-1][curX] == '.') {
                            map[curY--][curX] = '.';
                            map[curY][curX] = '^';
                        }
                        break;
                    case 'D':
                        map[curY][curX] = 'v';
                        if(isIn(curY+1,curX) && map[curY+1][curX] == '.') {
                            map[curY++][curX] = '.';
                            map[curY][curX] = 'v';
                        }
                        break;
                    case 'L':
                        map[curY][curX] = '<';
                        if(isIn(curY,curX-1) && map[curY][curX-1] == '.') {
                            map[curY][curX--] = '.';
                            map[curY][curX] = '<';
                        }
                        break;
                    case 'R':
                        map[curY][curX] = '>';
                        if(isIn(curY,curX+1) && map[curY][curX+1] == '.') {
                            map[curY][curX++] = '.';
                            map[curY][curX] = '>';
                        }
                        break;
                    case 'S':
                        switch(map[curY][curX]) {
                            case '^':
                                for(int j=curY-1;j>=0;j--) {
                                    if(isIn(j,curX) && (map[j][curX] == '.' || map[j][curX] == '-')) {
                                        continue;
                                    }else if(!isIn(j,curX) || map[j][curX] == '#') {
                                        break;
                                    }else if(isIn(j,curX) && map[j][curX] == '*') {
                                        map[j][curX] = '.';
                                        break;
                                    }
                                }
                                break;
                            case 'v':
                                for(int j=curY+1;j<H;j++) {
                                    if(isIn(j,curX) && (map[j][curX] == '.' || map[j][curX] == '-')) {
                                        continue;
                                    }else if(!isIn(j,curX) || map[j][curX] == '#') {
                                        break;
                                    }else if(isIn(j,curX) && map[j][curX] == '*') {
                                        map[j][curX] = '.';
                                        break;
                                    }
                                }
                                break;
                            case '<':
                                for(int j=curX-1;j>=0;j--) {
                                    if(isIn(curY,j) && (map[curY][j] == '.' || map[curY][j] == '-')) {
                                        continue;
                                    }else if(!isIn(curY,j) || map[curY][j] == '#') {
                                        break;
                                    }else if(isIn(curY,j) && map[curY][j] == '*') {
                                        map[curY][j] = '.';
                                        break;
                                    }
                                }
                                break;
                            case '>':
                                for(int j=curX+1;j<W;j++) {
                                    if(isIn(curY,j) && (map[curY][j] == '.' || map[curY][j] == '-')) {
                                        continue;
                                    }else if(!isIn(curY,j) || map[curY][j] == '#') {
                                        break;
                                    }else if(isIn(curY,j) && map[curY][j] == '*') {
                                        map[curY][j] = '.';
                                        break;
                                    }
                                }
                                break;
                        }
                        break;
                }
            }

            //여기에 출력.
            System.out.printf("#%d ",t);
            for(int i=0;i<H;i++) {
                for(int j=0;j<W;j++) {
                    System.out.printf("%c",map[i][j]);
                }
                if(i<H-1)
                    System.out.println();
            }
        }
    }

    public static boolean isIn(int Y, int X) {
        return Y>=0 && Y<H && X>=0 && X<W;
    }
}
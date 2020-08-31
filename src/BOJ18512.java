/**
 * @author choi
 * @date Aug 31, 2020
 * @see https://www.acmicpc.net/problem/18512
 * @mem 12,952kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 한 줄 한 줄 주석
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <브루트포스/수학> '점프 점프'
public class BOJ18512 {
    //문제 풀이에 필요한 변수 X, Y, H1, H2, 그리고 정답을 저장하는 answer.
    //두 사람의 뜀뛰기 보폭 X,Y, 각 자의 출발점 위치 H1, H2
    static int X, Y, H1, H2, answer;
    //방문 했는 지 안 했는 지를 저장하는 visited 배열.
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        //값을 입력 받기 위한 buffer 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //문자열을 토큰으로 자르기 위한 StringTokenizer
        StringTokenizer st = new StringTokenizer(br.readLine());

        //각 변수 입력.
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        H1 = Integer.parseInt(st.nextToken());
        H2 = Integer.parseInt(st.nextToken());
        //answer는 초기 값으로 -1 입력.(정답을 못 찾을 경우 -1를 그대로 출력.)
        answer = -1;
        //좌표는 10000을 넘어가지 않을 것이므로 10001 크기만큼 boolean 배열 선언.
        visited = new boolean[10001];


        //각자 집의 좌표는 visited true를 해준다.
        visited[H1] = true;
        visited[H2] = true;

        //그리고 각자의 집을 temp 변수에 각자 담는다.
        int tempX = H1;
        int tempY = H2;

        //정답을 찾거나 좌표가 10000이 넘어갈 때까지 무한 반복.
        while(true) {
            //한번 껑충 건넜을 때의 좌표를 갱신한다.(X,Y)
            tempX += X;
            tempY += Y;

            //혹시라도 두 갱신된 좌표 중에 10000이 넘는 값이 나왔다면
            if(tempX > 10000 || tempY > 10000)
                //answer를 갱신 안해주고 break 한다.
                break;

            //갱신된 좌표 tempX가 처음 방문 하는 곳이라면.
            if(!visited[tempX])
                //visited 값을 true로 해준다.
                visited[tempX] = true;
                //혹시라도 갱신된 좌표 tempX가 이미 방문 되었던 곳이라면.
            else {
                //answer에 해당 좌표를 저장하고
                //반복문을 빠져나간다.
                answer = tempX;
                break;
            }
            //갱신된 좌표 tempY가 처음 방문 하는 곳이라면.
            if(!visited[tempY])
                //visited 값을 true로 해준다.
                visited[tempY] = true;
                //혹시라도 갱신된 좌표 tempX가 이미 방문 되었던 곳이라면.
            else {
                //answer에 해당 좌표를 저장하고
                answer = tempY;
                //반복문을 빠져나간다.
                break;
            }
        }
        //처음 만난 좌표를 출력한다. 정답을 못 찾았을 경우에는 -1을 출력한다.
        System.out.println(answer);
    }
}
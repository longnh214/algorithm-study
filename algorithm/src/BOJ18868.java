/**
 * @author choi
 * @date Aug 31, 2020
 * @see https://www.acmicpc.net/problem/18868
 * @mem 15,076kb
 * @time 124ms
 * @caution
 * [고려사항]
 * 한 줄 한 줄 주석.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <브루트포스/정렬> '멀티버스 I'
public class BOJ18868 {
    //N과 M, 정답 변수 answer를 선언.
    //M은 반의 수, N은 학생의 수.
    static int N,M,answer;
    //각 반 학생들의 점수를 저장할 score 2차원 배열
    static int [][] score;
    //두 조합의 결과 값을 저장할 1차원 배열 tempCombN, tempCombM
    static int [] tempCombN, tempCombM;
    //combPair의 결과인 쌍을 저장하는 리스트를 선언.
    static List<Pair> pairList;
    public static void main(String[] args) throws IOException {
        //값을 입력 받기 위한 buffer 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //문자열을 토큰으로 자르기 위한 StringTokenizer
        StringTokenizer st = new StringTokenizer(br.readLine());
        //N,M 값을 입력 받는다.
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        //score 배열 크기 선언.
        score = new int[M][N];
        //쌍의 인덱스들을 저장할 리스트.
        pairList = new ArrayList<>();
        //조합의 결과가 저장될 두 1차원 배열.
        tempCombN = new int[2];
        tempCombM = new int[2];

        //score 배열의 값을 순차적으로 돌며 입력 받는다.
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //먼저 pairList에 나올 수 있는 쌍의 모든 경우의 수를 저장해둔다.
        combPair(0,0);

        //이후에 M개의 반에서 2개의 반을 조합하여 뽑는 함수를 실행하여
        //실력이 비슷한 반인지 판별한다.
        combClass(0,0);

        System.out.println(answer);
    }

    //M개의 반에서 2개의 반을 조합하여 비슷한 실력인 지 판별하는 함수.
    public static void combClass(int cnt, int start) {
        //두개의 반을 다 뽑았다면.
        if(cnt == 2) {
            //pairList의 값 만큼 모든 학생들의 점수 비교가 똑같은 지 세는 count 변수.
            int count = 0;
            //pairList에 저장된 쌍의 값 만큼 전부 대입.
            for(Pair pair : pairList) {
                //flag는 두개의 반 중 앞 반, flag2는 두개의 반 중 뒷 반의 점수 비교 결과 값이 저장되는 변수.
                int flag = 0;
                int flag2 = 0;
                //쌍의 인덱스 i, 인덱스 j를 불러온다.
                int i = pair.i;
                int j = pair.j;

                //반의 학생 두명의 점수를 비교해서 그 결과 값을 flag에 저장한다.
                //j가 크다면 flag에 1, i가 크다면 2, 같다면 3을 저장한다.
                if(score[tempCombN[0]][i] < score[tempCombN[0]][j]) {
                    flag = 1;
                }else if(score[tempCombN[0]][i] > score[tempCombN[0]][j]) {
                    flag = 2;
                }else {
                    flag = 3;
                }

                //반의 학생 두명의 점수를 비교해서 그 결과 값을 flag2에 저장한다.
                //j가 크다면 flag2에 1, i가 크다면 2, 같다면 3을 저장한다.
                if(score[tempCombN[1]][i] < score[tempCombN[1]][j]) {
                    flag2 = 1;
                }else if(score[tempCombN[1]][i] > score[tempCombN[1]][j]) {
                    flag2 = 2;
                }else {
                    flag2 = 3;
                }
                //비교를 해서 결과 flag가 같으면 count를 올리고,
                if(flag == flag2) {
                    count++;
                }
                //다르다면 실력이 비슷한 두 반이 아니므로 바로 break 후 return.
                else {
                    return;
                }
            }
            //끝까지 pairList 반복문을 돌았을 때, count가 pairList의 크기 값과 같다면
            //두 반은 모든 쌍마다 점수 비교 flag가 같았다는 뜻이므로 answer의 값에 +1을 해준다.
            if(count == pairList.size()) {
                answer++;
            }
            return;
        }

        //오름차순으로 조합을 뽑기 위해서 start부터 조합을 진행한다.
        for(int i=start;i<M;i++) {
            //값을 temp 배열에 저장한다.
            tempCombN[cnt] = i;
            //cnt와 i 변수를 각각 +1하여 다음 자리에 넣을 수를 찾는다.
            combClass(cnt+1, i+1);
        }
    }

    //학생 수 N에서 2개를 조합해서 뽑아 쌍의 모든 경우의 수를 찾는 조합 함수이다.
    public static void combPair(int cnt, int start) {
        //두개의 수를 모두 뽑아냈다면 temp 배열의 두 값을 Pair 클래스의 멤버 변수에 저장해 pairList에 그 객체를 저장한다.
        if(cnt == 2) {
            pairList.add(new Pair(tempCombM[0],tempCombM[1]));
            return;
        }
        //오름차순으로 조합을 뽑기 위해서 start부터 조합을 진행한다.
        for(int i=start;i<N;i++) {
            //값을 temp 배열에 저장한다.
            tempCombM[cnt] = i;
            //cnt와 i 변수를 각각 +1하여 다음 자리에 넣을 수를 찾는다.
            combPair(cnt+1, i+1);
        }
    }
    //쌍을 저장하는 클래스이다.
    static class Pair{
        //멤버 변수 i와 j이다.
        int i;
        int j;
        //매개변수를 i와 j를 가진 Pair클래스의 생성자이다.
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
/**
 * @author nakhoonchoi
 * @date 2024/10/29
 * @caution
 * [고려사항]
 * 프로그래머스 배열 input 수정 코드
 * [입력사항]
 * [출력사항]
 */
//프로그래머스 <입출력>

public class ProgrammersArrInput {
    public static void main(String[] args) {
        String input = "[[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0],[0,0,0,0,0,1,0,0],[0,0,0,0,1,0,0,0],[0,0,0,1,0,0,0,1],[0,0,1,0,0,0,1,0],[0,1,0,0,0,1,0,0],[1,0,0,0,0,0,0,0]]";
        System.out.println(input.replace("[", "{").replace("]", "}"));
    }
}
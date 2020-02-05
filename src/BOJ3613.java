import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        char [] chars = string.toCharArray();

        //첫 글자가 _거나 끝 글자가 _거나 대문자로 시작하는 경우는 Error
        if(chars[0] == '_' || chars[chars.length-1] == '_' || ('A' <= chars[0] && chars[0] <= 'Z')){
            System.out.println("Error!");
            return;
        }

        boolean isJava = true;//자바 변수인지
        boolean isCpp = true;//C++ 변수인지

        for(int i=0;i < chars.length;i++){
            if(chars[i] == '_'){
                //연속으로 '_'가 두번 쓰인 경우 Error
                if(i>1 && chars[i-1] == '_'){
                    System.out.println("Error!");
                    return;
                }
                //'_'가 있는 경우는 무조건 C++변수이거나 오류
                isJava = false;
            }
            else if('A' <= chars[i] && chars[i] <= 'Z') {
                //'_'가 없으면서 대문자가 있는 경우는 자바 변수
                isCpp = false;
            }
        }

        //'_'와 대문자가 같이 쓰인 경우 Error
        if(!isCpp && !isJava){
            System.out.println("Error!");
            return;
        }

        //모든 글자가 소문자라서 C++과 자바 변수에 해당되는 경우
        if(isCpp && isJava){
            System.out.println(string);
            return;
        }

        StringBuilder sb = new StringBuilder();

        if(isJava){
            for(char c : chars){
                //대문자를 빼고 '_'와 소문자를 넣는다.
                if('A' <= c && c <= 'Z'){
                    sb.append('_').append((char)(c + 32));
                }
                else
                    sb.append(c);
            }
        }
        else if(isCpp){
            for(int i=0;i<chars.length;i++){
                //'_'를 빼고 대문자를 넣는다.
                if(chars[i] == '_' && i < chars.length - 1)
                    sb.append((char)(chars[++i] - 32));
                else
                    sb.append(chars[i]);
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}
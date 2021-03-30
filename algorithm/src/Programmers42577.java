//프로그래머스 코딩테스트 연습 <해쉬> - '전화번호 목록' 문제
public class Programmers42577 {
    //해쉬를 이용하는 방법이 생각 안나서 2중 for문으로 푼 방법
    //substring(0,i) : String을 0부터 i까지 자르기 가능
    //O(n*n)으로 다소 효율적이진 못하다.
    public static boolean solution1(String[] phone_book) {
        for (String i : phone_book) {
            for (String j : phone_book) {
                if (i.length() < j.length() && i.equals(j.substring(0, i.length())))
                    return false;
            }
        }
        return true;
    }

    //타인의 코드 중 가장 직관적으로 잘 보이는 코드.
    //String.startsWith(String prefix) 메소드 공부.
    //String.endsWith(String suffix) 메소드도 있다.(끝나는 문자열)
    public boolean solution2(String[] phoneBook) {
        for(int i=0; i<phoneBook.length-1; i++) {
            for(int j=i+1; j<phoneBook.length; j++) {
                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
            }
        }
        return true;
    }
}
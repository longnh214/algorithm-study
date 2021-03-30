//프로그래머스 코딩테스트 연습 <DFS/BFS> - '단어 변환' 문제
public class Programmers43163 {
    static boolean [] visited;
    static int answer;

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String [] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        answer = Integer.MAX_VALUE;
        //words 배열에 target이 있는 지 없는 지 판단하는 isPossible
        boolean isPossible = false;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(target)) {
                isPossible = true;
                break;
            }
        }
        if(isPossible == false) return 0;
        else dfs(words,begin,target,0);
        //dfs를 통해 지속적으로 갱신된 최소값 return.
        return answer;
    }
    //두 String의 철자 차이가 1개인지 확인하는 함수
    public static boolean oneCharDiff(String s1, String s2){
        int alphabet = 0;
        for(int j=0;j<s1.length();j++){
            if(s1.charAt(j) != s2.charAt(j))
                alphabet++;
            if(alphabet > 1){
                alphabet = 0;
                break;
            }
        }
        if(alphabet == 1) return true;
        else return false;
    }
    //dfs로 모든 경우의 수를 다 탐색하여 최소값의 depth를 갱신한다.
    public static void dfs(String [] words, String word, String target, int depth){
        if(word.equals(target)){
            answer = Math.min(answer, depth);
            return;
        }
        for(int i=0;i<words.length;i++){
            if(!visited[i] && oneCharDiff(word, words[i])){
                visited[i] = true;
                dfs(words, words[i], target, depth + 1);
                visited[i] = false;
            }
        }
    }
}

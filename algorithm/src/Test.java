import java.util.LinkedList;

class Test {
    static int numberArray[];
    static int ans[] = new int[9999999];
    static int answer = 0;
    public static int solution(String numbers) {
        numberArray = new int[numbers.length()];
        for(int i=0; i<numberArray.length; i++){
            numberArray[i] = Integer.parseInt(numbers.charAt(i)+"");
        }

        int n = numberArray.length;
        for(int i=1; i<=numberArray.length; i++){
            LinkedList<Integer> perArr = new LinkedList<Integer>();
            int[] perCheck = new int[n];
            permutation(n, i, perArr, perCheck);
        }

        return answer;
    }

    //순열 (순서있게 배열)
    private static void permutation(int n, int r, LinkedList<Integer> perArr, int[] perCheck) {
        if(perArr.size() == r){
            String tmpNum ="";
            for(int i : perArr){
                //System.out.print("a" + numberArray[i]+" \n");
                tmpNum += numberArray[i]+"";
            }

            if(ans[Integer.parseInt(tmpNum)] == 0){
                //소수 판별 로직 수행
                // 0 미수행, 1소수아님, 2소수임
                if(checkPrime(Integer.parseInt(tmpNum)) == 2){
                    answer++;
                }
            }
            //수행
            ans[Integer.parseInt(tmpNum)] = 1;

            return;
        }

        for(int i=0; i<n; i++){
            if(perCheck[i] == 0){
                perArr.add(i);
                perCheck[i] = 1;
                permutation(n, r, perArr, perCheck);
                perCheck[i] = 0;
                perArr.removeLast();
            }
        }
    }

    //소수인지 아닌지 체크하는 함수
    private static int checkPrime(int num) {
        //1,0은 소수가 아님
        if(num == 1 || num == 0)return 1;
        for(int i=2; i<num; i++){
            if(num%i == 0){
                //소수가 아님
                return 1;
            }
        }
        //소수임
        return 2;
    }

    public static void main(String[] args) {
        System.out.println(solution("12345"));
    }
}
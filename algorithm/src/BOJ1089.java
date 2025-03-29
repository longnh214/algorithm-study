/**
 * @author nakhoonchoi
 * @date 2025/03/29
 * @see https://boj.ma/1089
 * @mem 11,988kb
 * @time 72ms
 * @caution
 * [고려사항]
 * 문제 자체는 구현하는 데에 어렵지 않았으나 평균을 구하는 로직에서 시간 초과가 발생했다.
 *
 * Map을 이용해서 5*3 char 배열을 초기화한 후 좌표를 비교해서 모든 위치를 비교해서
 * 같은 위치의 input 문자가 #이고, digit char 배열 문자 값이 .이면 가능하지 않은 숫자라고 판단했다.
 * 각 구간 별로 가능한 숫자를 모아서 List 배열에 넣는다. 이 때 가능한 숫자가 없다면 바로 -1을 반환했다.
 *
 * 평균 구하는 로직을 (모든 경우의 수의 합 / 경우의 수)와 같이 단순하게 생각했다.
 * 하지만 모든 경우의 수를 구하는 과정에서 순열을 이용하면 10^9로 시간 초과가 발생했다.
 *
 * 그래도 모든 경우의 수의 합과 경우의 수는 구해야한다. 하지만 방법을 살짝 다르게 해보려고 한다.
 * 순열을 쓰지 않으려고 한다.
 *
 * 경우의 수를 구하는 방법은 초기 값으로 totalCount = 1로 놓고,
 * 각 자리 수 별로 가능한 수 만큼 계속 곱해주면 경우의 수를 구할 수 있다.
 *
 * 그리고 모든 경우의 수의 합은 각 자리 수 별로
 * (자리에 들어갈 수 있는 숫자의 합) * 10^(자리수) * (현재 자리 수가 나올 수 있는 횟수)를 구해서 합하면 된다.
 *
 * - 자리에 들어갈 수 있는 숫자의 합은 List 배열의 원소 합으로 구하면 된다.
 * - 10^(자리수)는 Math.pow나 pow 배열을 기반으로 구하면 된다.
 * - 현재 자리 수가 나올 수 있는 횟수는 (모든 경우의 수 / 현재 경우의 수)이다. 아래에서 이유를 설명하고자 한다.
 *
 * 생각해보면 _ _ _와 같이 세 자리고,
 * 100의 자리에는 3,6,9가 들어갈 수 있고
 * 10의 자리에는 2,8이 들어갈 수 있고
 * 1의 자리에는 1,2,3,4가 들어갈 수 있다면
 * 100의 자리 3,6,9는 각각 10의 자리 수와 1의 자리 수의 곱인 8번씩 나올 것이다.
 * 그리고 10의 자리 수 2, 8은 각각 100의 자리 수와 1의 자리 수의 곱인 12번씩 나올 것이다.
 * 이는 (전체 경우의 수 3*2*4=24에서 현재 자리 수의 경우의 수를 나눈 수)가 현재 자리 수가 나올 수 있는 횟수가 된다.
 *
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <수학> '스타트 링크 타워'

public class BOJ1089 {
    static Map<Integer, char[][]> digitMap = new HashMap<>();
    static char[][] input;
    static List<Integer>[] possibleDigitList;
    static final int digitX = 5;
    static final int digitY = 3;
    static int N;
    static long totalSum;
    static long totalCount;
    static long [] pow10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new char[5][N * 4 - 1];
        possibleDigitList = new List[N];
        pow10 = new long[N + 1];
        pow10[0] = 1L;
        for (int i=1;i<=N;i++) {
            pow10[i] = pow10[i - 1] * 10;
        }

        initDigitMap();

        for (int i=0;i<digitX;i++) {
            String str = br.readLine();
            input[i] = str.toCharArray();
        }

        for (int i=0;i<N;i++) {
            possibleDigitList[i] = new ArrayList<>();
        }

        for (int i=0;i<N;i++) {
            char[][] curCharacter = new char[digitX][digitY];
            int startIndex = i * 4;

            for (int j=0;j<digitX;j++) {
                for (int k=0;k<digitY;k++) {
                    curCharacter[j][k] = input[j][startIndex + k];
                }
            }

            for (int key : digitMap.keySet()) {
                char[][] digit = digitMap.get(key);
                if (isMatch(curCharacter, digit)) {
                    possibleDigitList[i].add(key);
                }
            }

            if (possibleDigitList[i].isEmpty()) {
                System.out.println(-1);
                return;
            }
        }

        totalSum = 0;
        totalCount = 1;

        calculateAverage();

        System.out.printf("%.6f\n", (double) totalSum / totalCount);
    }

    private static void calculateAverage() {
        double[] sumPerPosition = new double[N];
        double[] countPerPosition = new double[N];

        // 각 자릿수에서 가능한 숫자들의 합을 구하고, 경우의 수를 계산
        for (int i=0;i<N;i++) {
            double sum = 0;
            int count = possibleDigitList[i].size();

            for (int digit : possibleDigitList[i]) {
                sum += digit;
            }

            sumPerPosition[i] = sum;
            countPerPosition[i] = count;
            totalCount *= countPerPosition[i];
        }

        // 각 자리에 대해 계산된 값을 합산하여 총합을 구함
        for (int i=0;i<N;i++) {
            double positionSum = sumPerPosition[i] * pow10[N - 1 - i] * (totalCount / countPerPosition[i]);
            totalSum += positionSum;
        }
    }

    private static boolean isMatch(char[][] standard, char[][] digit) {
        for (int i=0;i<digitX;i++) {
            for (int j=0;j<digitY;j++) {
                if (standard[i][j] == '#' && digit[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void initDigitMap() {
        digitMap.put(0, new char[][]{
                {'#', '#', '#'},
                {'#', '.', '#'},
                {'#', '.', '#'},
                {'#', '.', '#'},
                {'#', '#', '#'}
        });

        digitMap.put(1, new char[][]{
                {'.', '.', '#'},
                {'.', '.', '#'},
                {'.', '.', '#'},
                {'.', '.', '#'},
                {'.', '.', '#'}
        });

        digitMap.put(2, new char[][]{
                {'#', '#', '#'},
                {'.', '.', '#'},
                {'#', '#', '#'},
                {'#', '.', '.'},
                {'#', '#', '#'}
        });

        digitMap.put(3, new char[][]{
                {'#', '#', '#'},
                {'.', '.', '#'},
                {'#', '#', '#'},
                {'.', '.', '#'},
                {'#', '#', '#'}
        });

        digitMap.put(4, new char[][]{
                {'#', '.', '#'},
                {'#', '.', '#'},
                {'#', '#', '#'},
                {'.', '.', '#'},
                {'.', '.', '#'}
        });

        digitMap.put(5, new char[][]{
                {'#', '#', '#'},
                {'#', '.', '.'},
                {'#', '#', '#'},
                {'.', '.', '#'},
                {'#', '#', '#'}
        });

        digitMap.put(6, new char[][]{
                {'#', '#', '#'},
                {'#', '.', '.'},
                {'#', '#', '#'},
                {'#', '.', '#'},
                {'#', '#', '#'}
        });

        digitMap.put(7, new char[][]{
                {'#', '#', '#'},
                {'.', '.', '#'},
                {'.', '.', '#'},
                {'.', '.', '#'},
                {'.', '.', '#'}
        });

        digitMap.put(8, new char[][]{
                {'#', '#', '#'},
                {'#', '.', '#'},
                {'#', '#', '#'},
                {'#', '.', '#'},
                {'#', '#', '#'}
        });

        digitMap.put(9, new char[][]{
                {'#', '#', '#'},
                {'#', '.', '#'},
                {'#', '#', '#'},
                {'.', '.', '#'},
                {'#', '#', '#'}
        });
    }
}
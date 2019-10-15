import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BufferReaderTest {
    //BufferReader는 Exception 처리를 따로 해주어야하기 때문에 throws를 해주어야 한다.
    //정석 : try ~ catch로 예외 처리를 해주어야 합니다.
    public static void main(String[] args) throws Exception{
        //BufferReader 객체 생성
        //InputStreamReader와 System.in을 이용한 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //StringTokenizer 객체 생성
        StringTokenizer st = null;

        //String Line이므로 parseInt를 해주어야 한다.
        int n = Integer.parseInt(br.readLine());

        //"1 3 5 7..."식의 공란 포함 String Line을 숫자 배열에 입력 시에
        int [] arr = new int[n+1];
        //StringTokenizer 객체에 String Line을 등록한다.
        st = new StringTokenizer(br.readLine());

        //각 토큰마다 parseInt를 해주어 배열에 저장시킨다.
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            System.out.println(arr[i]);
        }
    }
}

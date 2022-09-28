import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일이될때까지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int minus1 = 0;
        //N - (minus1) = K*multiplyK;

        while(!((N - (minus1))%K == 0)) {
            minus1++;
        }


        int multiplyK = 1;
        int tmp = N - minus1;
        while(!(tmp / K == 1)) {
            tmp /= K;
            multiplyK++;
        }

        System.out.println("minus1: " + minus1 + " multiplyK: " + multiplyK);
        System.out.println(minus1 + multiplyK);
    }
}

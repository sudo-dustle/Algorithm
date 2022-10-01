import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 곱하기혹은더하기 {
    //12시 27분 ~ 41
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();

        String[] arr = string.split("");

        long answer = 0;

        for(String s : arr) {
            int tmp = Integer.parseInt(s);

            if(answer == 0 || tmp == 0 || tmp == 1) {
                answer += tmp;
            }
            else answer *= tmp;
        }

        System.out.println(answer);
    }
}

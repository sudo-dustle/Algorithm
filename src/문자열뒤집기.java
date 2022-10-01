import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열뒤집기 {
    //12시 51 ~ 1시 51
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();

        String[] arr = string.split("");
        String flag = arr[0];

        int tmp0 = 0;
        int tmp1 = 0;

        if(flag.equals("0")) {
            tmp0++;
        }
        else {
            tmp1++;
        }

        for (int i = 0; i < arr.length; i++) {

            if (!arr[i].equals(flag)) {
                flag = arr[i];

                if(flag.equals("0")) {
                    tmp0++;
                }
                else {
                    tmp1++;
                }
            }
        }

        System.out.println(Integer.min(tmp0, tmp1));
    }
}

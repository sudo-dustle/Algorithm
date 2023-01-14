import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 아카라카 {
    public static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String readLine = br.readLine();
        String[] split = readLine.split("");

        recursive(split);

        if (flag) {
            System.out.println("AKARAKA");
        } else {
            System.out.println("IPSELENTI");
        }
    }

    public static void recursive(String[] palindrome) {
        if (palindrome.length == 1) {
            flag = true;
            return;
        }

        for (int i = 0; i < palindrome.length; i++) {
            if (!palindrome[i].equals(palindrome[palindrome.length - i - 1])) {
                flag = false;
                return;
            }
        }

        int cutPosition = palindrome.length / 2;
        String[] tmp = Arrays.copyOfRange(palindrome, 0, cutPosition);
        recursive(tmp);
    }
}

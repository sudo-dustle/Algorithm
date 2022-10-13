import java.io.*;
import java.math.BigInteger;

public class 하노이탑 {
    static int N;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        BigInteger integer = new BigInteger("2").pow(N).subtract(BigInteger.ONE);

        bw.write(integer + "\n");
        if(N <= 20) recursion(N, 1, 2 ,3);
        bw.flush();
    }
    static void recursion(int cnt, int start, int mid, int end) throws IOException {
        if(cnt == 1) {
            bw.write(start + " " + end + "\n");
            return;
        }

        recursion(cnt-1, start, end, mid);
        bw.write(start + " " + end + "\n");
        recursion(cnt-1, mid, start, end);
    }
}

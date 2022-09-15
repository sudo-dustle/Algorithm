import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/2075
public class N번째큰수List {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] list = new int[n*n];
        int idx = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                list[idx++] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(list);
        System.out.println(list[n*n - n]);
    }
}

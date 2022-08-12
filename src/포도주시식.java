import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int[] dp = new int[n];//여태 먹은거에 최대값

        dp[0] = arr[0];

        if(n > 1) dp[1] = dp[0] + arr[1];
        if(n > 2) dp[2] = Math.max(dp[1], Math.max(dp[0] + arr[2], arr[1] + arr[2]));

        for(int i = 3; i < n; i++)
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));

        System.out.println(dp[n-1]);
    }
}

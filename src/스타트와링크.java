import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//10시 10분 ~
public class 스타트와링크 {
    static int N;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0, 0);
        System.out.println(min);
    }
    static void recursive(int r, int start) {
        if(r == N/2) {
            answer();
            return;
        }

        if(start < N) {
            visited[start] = true;
            recursive(r + 1, start + 1);

            visited[start] = false;
            recursive(r, start + 1);
        }
    }

    static void answer() {
        int tmp1 = 0;
        int tmp2 = 0;

        for(int i = 0; i < N ; i ++ ) {
            for(int j = 0; j < N ; j ++) {

                if(visited[i] && visited[j]) {
                    tmp1 += arr[i][j];
                }
                if(!visited[i] && !visited[j]) {
                    tmp2 += arr[i][j];
                }
            }
        }
        int tmp = Math.abs(tmp1 - tmp2);
        min = Math.min(tmp, min);
    }
}

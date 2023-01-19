import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 에너지모으기 {
    public static int N;
    public static int[] balls;
    public static boolean[] visited;
    public static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        balls = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            balls[i] = Integer.parseInt(st.nextToken());
            visited[i] = false;
        }

        recursive(N, 0);
        System.out.println(answer);
    }

    public static void recursive(int count, int total) {
        if(count <= 2) {
            answer = Math.max(answer, total);
            return;
        }

        for(int i = 1; i < N - 1; i++) {
            if(!visited[i]) {
                visited[i] = true;
                int sideWeight = getSideWeight(i);
                recursive(count - 1, total + sideWeight);
                visited[i] = false;
            }
        }
    }

    private static int getSideWeight(int position) {
        int total = 1;

        for(int i = position - 1; i >= 0; i--) {
            if(!visited[i]) {
                total *= balls[i];
                break;
            }
        }

        for(int i = position + 1; i < N; i++) {
            if(!visited[i]) {
                total *= balls[i];
                break;
            }
        }

        return total;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미친로봇 {
    public static int N;
    public static boolean[][] map = new boolean[30][30];
    public static int[] di = {0, 0, -1, 1};
    public static int[] dj = {1, -1, 0, 0};
    public static double[] percent = new double[4];
    public static double answer = 0.0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < 4; i++) {
            percent[i] = Integer.parseInt(st.nextToken()) / 100.0;
        }

        recursive(N, 14, 14, 1);
        System.out.println(answer);
    }
    public static void recursive(int count, int i, int j, double success) {
        if(count <= 0) {
            answer += success;
            return;
        }

        map[i][j] = true;

        for(int k = 0; k < 4; k++) {
            int tmpI = i + di[k];
            int tmpJ = j + dj[k];

            if(percent[k] == 0) continue;

            if(!map[tmpI][tmpJ]) {
                recursive(count - 1, tmpI, tmpJ, success * percent[k]);
            }
        }

        map[i][j] = false;
    }
}

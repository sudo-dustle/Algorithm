import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연구소 {
    public static int[] X = {1, -1, 0, 0};//오왼위아래
    public static int[] Y = {0, 0, 1, -1};
    public static int N;
    public static int M;
    public static int[][] lab;
    public static boolean[][] visited;
    public static int rsl = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                lab[i][j] = tmp;
                visited[i][j] = false;
            }
        }
        comb(0);
        System.out.println(rsl);
    }
    static void comb(int depth) {
        if (depth == 3) {
            findVirus(lab);
            rsl = Math.max(countSafeArea(lab), rsl);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(lab[i][j] == 0) {
                    lab[i][j] = 1;
                    comb(depth + 1);
                    lab[i][j] = 0;
                }
            }
        }
    }
    static void findVirus(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 2 && !visited[i][j]){
                    map[i][j] = 3;
                    virus(map, i, j);
                }
            }
        }
    }
    static int countSafeArea(int[][] map) {
        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = false;
                if(map[i][j] == 2) map[i][j] = 0;
                else if (map[i][j] == 3) map[i][j] = 2;
                else if(map[i][j] == 0) safeArea++;
            }
        }
        return safeArea;
    }

    static void virus(int[][] lab, int n, int m){
        visited[n][m] = true;
        for(int i = 0; i < 4; i++){
            int tmpX = X[i] + n;
            int tmpY =Y[i] + m;

            if(tmpX >= 0 && tmpX < N && tmpY >= 0 && tmpY < M){
                if(lab[tmpX][tmpY] == 0){
                    lab[tmpX][tmpY] = 2;
                    virus(lab, tmpX, tmpY);
                }
            }
        }
    }
}

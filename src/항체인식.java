import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 항체인식 {
    public static int[][] before;
    public static int[][] after;
    public static boolean[][] visited;
    public static int[][] tmp;
    public static int N;
    public static int M;
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, -1, 1};
    public static String answer = "YES";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        before = new int[N][M];
        after = new int[N][M];
        tmp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                before[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                after[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (before[i][j] != after[i][j]) {
                    dfs(i, j, before[i][j]);
                    makeTmp(after[i][j]);
                    if (isVaccine()) {
                        break;
                    } else {
                        answer = "NO";
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static void makeTmp(int goal) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    tmp[i][j] = goal;
                } else {
                    tmp[i][j] = before[i][j];
                }
            }
        }
    }

    private static boolean isVaccine() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] != after[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void dfs(int i, int j, int beforeCell) {
        visited[i][j] = true;

        for (int n = 0; n < 4; n++) {
            int tmpI = i + di[n];
            int tmpJ = j + dj[n];

            if (tmpI < 0 || tmpI >= N || tmpJ < 0 || tmpJ >= M) continue;

            if (before[tmpI][tmpJ] == beforeCell && !visited[tmpI][tmpJ]) {
                dfs(tmpI, tmpJ, beforeCell);
            }
        }
    }
}

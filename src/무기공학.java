import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 무기공학 {
    public static int[] di = {0, 1, -1, 0, -1, 0, 1, 0};
    public static int[] dj = {-1, 0, 0, -1, 0, 1, 0, 1};
    public static int N;
    public static int M;
    public static int[][] map;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = false;
            }
        }

        System.out.println(recursive(0, 0, 0));
    }

    private static int recursive(int sum, int startI, int startJ) {
        int answer = sum;
        int tmpStartJ = startJ;

        for (int i = startI; i < N; i++) {
            for (int j = tmpStartJ; j < M; j++) {
                if (!visited[i][j]) {
                    for (int k = 0; k < 8; k += 2) {
                        int total = 0;
                        total += map[i][j] * 2;

                        int tmpJ = dj[k] + j;
                        int tmpI = di[k] + i;

                        if (tmpJ < 0 || tmpJ >= M || tmpI < 0 || tmpI >= N || visited[tmpI][tmpJ]) continue;
                        total += map[tmpI][tmpJ];

                        int tmpJ2 = dj[k + 1] + j;
                        int tmpI2 = di[k + 1] + i;

                        if (tmpJ2 < 0 || tmpJ2 >= M || tmpI2 < 0 || tmpI2 >= N || visited[tmpI2][tmpJ2]) continue;
                        total += map[tmpI2][tmpJ2];

                        visited[i][j] = true;
                        visited[tmpI2][tmpJ2] = true;
                        visited[tmpI][tmpJ] = true;

                        answer = Math.max(recursive(sum + total, i, j), answer);
                        visited[i][j] = false;
                        visited[tmpI2][tmpJ2] = false;
                        visited[tmpI][tmpJ] = false;
                    }
                }
            }
            tmpStartJ = 0;
        }

        return answer;
    }
}

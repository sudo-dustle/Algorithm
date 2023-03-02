import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기돼지와늑대 {
    public static int N;
    public static int M;
    public static String[][] map;
    public static boolean[][] visited;
    public static Queue<Wolf> queue = new ArrayDeque<>();
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] split = s.split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = split[j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j].equals("W")) {
                    queue.offer(new Wolf(i, j));
                }
            }
        }

        bfs();
        findPigSafeZone();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static void findPigSafeZone() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j].equals(".")) {
                    map[i][j] = "P";
                }
            }
        }
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Wolf wolf = queue.poll();

            for (int n = 0; n < 4; n++) {
                int tmpI = wolf.i + di[n];
                int tmpJ = wolf.j + dj[n];

                if (tmpI < 0 || tmpI >= N || tmpJ < 0 || tmpJ >= M) continue;

                if (map[tmpI][tmpJ].equals("#")) continue;

                if (map[tmpI][tmpJ].equals("+") && !visited[tmpI][tmpJ]) {
                    while (true) {
                        tmpI += di[n];
                        tmpJ += dj[n];

                        if(map[tmpI][tmpJ].equals(".")) break;
                        if(map[tmpI][tmpJ].equals("#")) {
                            tmpI -= di[n];
                            tmpJ -= dj[n];
                            break;
                        }
                    }
                }

                if (!visited[tmpI][tmpJ]) {
                    visited[tmpI][tmpJ] = true;
                    queue.offer(new Wolf(tmpI, tmpJ));
                }
            }
        }
    }

    static class Wolf {
        private int i;
        private int j;

        public Wolf(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

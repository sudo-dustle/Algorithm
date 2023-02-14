import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불 {
    public static int N;
    public static int M;
    public static String[][] map;
    public static int[][] dist;
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, -1, 1};
    public static Queue<Struct> jihoonQueue = new ArrayDeque();
    public static Queue<Struct> fireQueue = new ArrayDeque();
    public static String answer = "IMPOSSIBLE";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            String[] split = s.split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = split[j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j].equals("J")) {
                    jihoonQueue.offer(new Struct(i, j));
                }

                if (map[i][j].equals("F")) {
                    fireQueue.offer(new Struct(i, j));
                }
            }
        }

        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        while (true) {
            int fireSize = fireQueue.size();
            int jihoonSize = jihoonQueue.size();

            if(jihoonSize == 0) return;

            for (int i = 0; i < fireSize; i++) {
                Struct fire = fireQueue.poll();

                for (int n = 0; n < 4; n++) {
                    int tmpFireI = fire.i + di[n];
                    int tmpFireJ = fire.j + dj[n];

                    if (tmpFireI < 0 || tmpFireI >= N || tmpFireJ < 0 || tmpFireJ >= M) continue;
                    if (map[tmpFireI][tmpFireJ].equals("#") || map[tmpFireI][tmpFireJ].equals("F")) continue;

                    map[tmpFireI][tmpFireJ] = "F";
                    fireQueue.offer(new Struct(tmpFireI, tmpFireJ));
                }
            }

            for (int i = 0; i < jihoonSize; i++) {
                Struct jihoon = jihoonQueue.poll();
                for (int n = 0; n < 4; n++) {
                    int tmpJihoonI = jihoon.i + di[n];
                    int tmpJihoonJ = jihoon.j + dj[n];

                    if (tmpJihoonI < 0 || tmpJihoonI >= N || tmpJihoonJ < 0 || tmpJihoonJ >= M) {
                        answer = String.valueOf(dist[jihoon.i][jihoon.j] + 1);
                        return;
                    }

                    if (map[tmpJihoonI][tmpJihoonJ].equals(".")) {
                        map[tmpJihoonI][tmpJihoonJ] = "J";
                        dist[tmpJihoonI][tmpJihoonJ] = dist[jihoon.i][jihoon.j] + 1;
                        jihoonQueue.offer(new Struct(tmpJihoonI, tmpJihoonJ));
                    }
                }
            }
        }
    }

    static class Struct {
        int i;
        int j;

        public Struct(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

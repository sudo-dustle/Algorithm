import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리만들기 {
    public static int N;
    public static int[][] map;
    public static int[][] dist;
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, -1, 1};
    public static Queue<Struct> queue = new ArrayDeque();
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int init = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    classifyIsland(i, j, init);
                    init += 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 0) {
                    queue.offer(new Struct(i, j));
                }
            }
        }

        makeBridge();
        System.out.println(answer);
    }

    public static void classifyIsland(int i, int j, int init) {
        map[i][j] = init;

        for (int n = 0; n < 4; n++) {
            int tmpI = i + di[n];
            int tmpJ = j + dj[n];

            if (tmpI < 0 || tmpI >= N || tmpJ < 0 || tmpJ >= N) continue;

            if (map[tmpI][tmpJ] == 1) {
                classifyIsland(tmpI, tmpJ, init);
            }
        }
    }

    public static void makeBridge() {
        while (!queue.isEmpty()) {
            Struct struct = queue.poll();

            for (int n = 0; n < 4; n++) {
                int tmpI = struct.i + di[n];
                int tmpJ = struct.j + dj[n];

                if (tmpI < 0 || tmpI >= N || tmpJ < 0 || tmpJ >= N) continue;

                if (map[tmpI][tmpJ] == 0) {
                    map[tmpI][tmpJ] = map[struct.i][struct.j];
                    dist[tmpI][tmpJ] = dist[struct.i][struct.j] + 1;
                    queue.offer(new Struct(tmpI, tmpJ));
                }

                if (map[tmpI][tmpJ] > 0 && map[tmpI][tmpJ] != map[struct.i][struct.j]) {
                    answer = Math.min(dist[struct.i][struct.j] + dist[tmpI][tmpJ], answer);
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

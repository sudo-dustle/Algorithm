import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기_1 {
    public static int N;
    public static int M;
    public static String[][] map;
    public static boolean[][][] visited;
    public static Queue<Struct> queue = new LinkedList<>();
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            map[i] = tmp.split("");
        }

        queue.offer(new Struct(0, 0, 1, 0));
        visited[0][0][0] = true;
        System.out.println(bfs());
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            Struct struct = queue.poll();

            if (struct.i == N - 1 && struct.j == M - 1) {
                return struct.count;
            }

            for (int n = 0; n < 4; n++) {
                int tmpI = struct.i + di[n];
                int tmpJ = struct.j + dj[n];
                int breakCount = struct.breakCount;

                if (tmpI < 0 || tmpI >= N || tmpJ < 0 || tmpJ >= M || visited[tmpI][tmpJ][breakCount] == true) continue;
                if (map[tmpI][tmpJ].equals("1") && struct.breakCount == 1) continue;

                if (map[tmpI][tmpJ].equals("1") && struct.breakCount == 0) {
                    breakCount = 1;
                }

                visited[tmpI][tmpJ][breakCount] = true;
                queue.offer(new Struct(tmpI, tmpJ, struct.count + 1, breakCount));
            }
        }

        return -1;
    }

    static class Struct {
        int i;
        int j;
        int count;
        int breakCount;

        public Struct(int i, int j, int count, int breakCount) {
            this.i = i;
            this.j = j;
            this.count = count;
            this.breakCount = breakCount;
        }
    }
}

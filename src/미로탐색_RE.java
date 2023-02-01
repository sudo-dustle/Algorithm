import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_RE {
    public static int N;
    public static int M;
    public static String[][] map;
    public static int[][] visited;
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
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            map[i] = tmp.split("");
        }

        shortCut();
        System.out.println(visited[N - 1][M - 1] + 1);
    }

    public static void shortCut() {
        queue.offer(new Struct(0, 0));

        while (!queue.isEmpty()) {
            Struct poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int tmpI = poll.i + di[i];
                int tmpJ = poll.j + dj[i];

                if (tmpI < 0 || tmpI >= N || tmpJ < 0 || tmpJ >= M) continue;
                if (visited[tmpI][tmpJ] > 0 || map[tmpI][tmpJ].equals("0")) continue;

                visited[tmpI][tmpJ] = visited[poll.i][poll.j] + 1;
                queue.offer(new Struct(tmpI, tmpJ));
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

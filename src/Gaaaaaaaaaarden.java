import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gaaaaaaaaaarden {
    public static int N;
    public static int M;
    public static int G;

    public static int R;
    public static String[][] map;
    public static int[][] visited;

    public static Queue<Garden> GQueue = new ArrayDeque<>();
    public static Queue<Garden> RQueue = new ArrayDeque<>();
    public static int[] di = {0, 0, 1, -1};
    public static int[] dj = {1, -1, 0, 0};
    public static int flower = Integer.MIN_VALUE;
    public static int trueCheck = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new String[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = st.nextToken();
            }
        }

        pickGardenG(map, 0, 0);
        System.out.println(flower);
    }

    public static void print(String[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void pickGardenG(String[][] map, int start, int depth) {
        if (G == depth) {
            pickGardenR(map, 0, 0);
            return;
        }

        for (int i = start; i < N * M; i++) {
            int x = i / M;
            int y = i % M;

            if (map[x][y].equals("2")) {
                map[x][y] = "G";
                pickGardenG(map, i + 1, depth + 1);
                map[x][y] = "2";
            }
        }
    }

    public static void pickGardenR(String[][] map, int start, int depth) {
        if (R == depth) {
            offerQueue(map);
            bfs(map);
            return;
        }

        for (int i = start; i < N * M; i++) {
            int x = i / M;
            int y = i % M;

            if (map[x][y].equals("2")) {
                map[x][y] = "R";
                pickGardenR(map, i + 1, depth + 1);
                map[x][y] = "2";
            }
        }
    }

    public static void bfs(String[][] tmpMap) {
        String[][] map = new String[N][M];
        trueCheck++;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = tmpMap[i][j];
            }
        }

        while (true) {
            int Gsize = GQueue.size();
            int Rsize = RQueue.size();
            Set<Garden> tmp = new HashSet<>();

            if (Gsize == 0 && Rsize == 0) break;

            for (int g = 0; g < Gsize; g++) {
                Garden garden = GQueue.poll();

                if(map[garden.i][garden.j].equals("F")) continue;

                for (int n = 0; n < 4; n++) {
                    int tmpI = garden.i + di[n];
                    int tmpJ = garden.j + dj[n];

                    if (tmpI < 0 || tmpI >= N || tmpJ < 0 || tmpJ >= M) continue;
                    if (map[tmpI][tmpJ].equals("0")) continue;

                    if (visited[tmpI][tmpJ] != trueCheck && (map[tmpI][tmpJ].equals("2") || map[tmpI][tmpJ].equals("1"))) {
                        visited[tmpI][tmpJ] = trueCheck;
                        map[tmpI][tmpJ] = "G";
                        tmp.add(new Garden(tmpI, tmpJ));
                        GQueue.add(new Garden(tmpI, tmpJ));
                    }
                }
            }

            for (int r = 0; r < Rsize; r++) {
                Garden garden = RQueue.poll();

                for (int n = 0; n < 4; n++) {
                    int tmpI = garden.i + di[n];
                    int tmpJ = garden.j + dj[n];

                    if (tmpI < 0 || tmpI >= N || tmpJ < 0 || tmpJ >= M) continue;
                    if (map[tmpI][tmpJ].equals("0")) continue;

                    Garden tmpGarden = new Garden(tmpI, tmpJ);

                    if (tmp.contains(tmpGarden)) {
                        map[tmpI][tmpJ] = "F";
                    } else {
                        if (visited[tmpI][tmpJ] != trueCheck  && (map[tmpI][tmpJ].equals("2") || map[tmpI][tmpJ].equals("1"))) {
                            visited[tmpI][tmpJ] = trueCheck;
                            map[tmpI][tmpJ] = "R";
                            RQueue.add(tmpGarden);
                        }
                    }
                }
            }
        }

        flower = Math.max(flower, findFlower(map));
    }

    public static int findFlower(String map[][]) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j].equals("F")) {
                    count += 1;
                }
            }
        }

        return count;
    }

    public static void offerQueue(String[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j].equals("G")) {
                    GQueue.offer(new Garden(i, j));
                }
                if (map[i][j].equals("R")) {
                    RQueue.offer(new Garden(i, j));
                }
            }
        }
    }

    static class Garden {
        private int i;
        private int j;

        public Garden(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Garden garden = (Garden) o;
            return i == garden.i && j == garden.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

        @Override
        public String toString() {
            return "Garden{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }
}

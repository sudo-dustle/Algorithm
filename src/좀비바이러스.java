import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 좀비바이러스 {
    public static int N;
    public static int M;
    public static int[][] map;
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, -1, 1};
    public static int cnt1, cnt2, cnt3;
    public static Queue<Virus> virus1 = new ArrayDeque<>();
    public static Queue<Virus> virus2 = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    virus1.offer(new Virus(i, j));
                }
                if (map[i][j] == 2) {
                    virus2.offer(new Virus(i, j));
                }
            }
        }

        bfs();
        countVirus();
        System.out.println(cnt1 + " " + cnt2 + " " + cnt3);
    }

    private static void countVirus() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    cnt1 += 1;
                }
                if (map[i][j] == 2) {
                    cnt2 += 1;
                }
                if (map[i][j] == 3) {
                    cnt3 += 1;
                }
            }
        }
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void bfs() {
        while (true) {
            int virus1Size = virus1.size();
            int virus2Size = virus2.size();

            Set<Virus> tmp = new HashSet<>();

            if (virus1Size == 0 && virus2Size == 0) break;

            for (int i = 0; i < virus1Size; i++) {
                Virus virus = virus1.poll();

                if (map[virus.i][virus.j] == 3) continue;

                for (int n = 0; n < 4; n++) {
                    int tmpI = di[n] + virus.i;
                    int tmpJ = dj[n] + virus.j;

                    if (tmpI < 0 || tmpI >= N || tmpJ < 0 || tmpJ >= M) continue;

                    if (map[tmpI][tmpJ] != -1 && map[tmpI][tmpJ] < 1) {
                        map[tmpI][tmpJ] = 1;
                        tmp.add(new Virus(tmpI, tmpJ));

                        virus1.offer(new Virus(tmpI, tmpJ));
                    }
                }
            }

            for (int i = 0; i < virus2Size; i++) {
                Virus virus = virus2.poll();

                for (int n = 0; n < 4; n++) {
                    int tmpI = di[n] + virus.i;
                    int tmpJ = dj[n] + virus.j;

                    if (tmpI < 0 || tmpI >= N || tmpJ < 0 || tmpJ >= M) continue;

                    Virus tmpVirus = new Virus(tmpI, tmpJ);

                    if (tmp.contains(tmpVirus)) {
                        if (map[tmpI][tmpJ] != -1 && map[tmpI][tmpJ] < 2) {
                            map[tmpI][tmpJ] += 2;
                        }
                    } else {
                        if (map[tmpI][tmpJ] != -1 && map[tmpI][tmpJ] == 0) {
                            map[tmpI][tmpJ] = 2;
                            virus2.offer(tmpVirus);
                        }
                    }
                }
            }

            tmp.clear();
        }
    }

    public static class Virus {
        private int i;
        private int j;

        public Virus(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Virus virus = (Virus) o;
            return i == virus.i && j == virus.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}

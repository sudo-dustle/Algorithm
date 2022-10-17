
class NQueen {
    static int[][] arr;
    static int cnt = 0;
    static int N;
    static int[] dx = {0, 1, 1, 1};
    static int[] dy = {1, -1, 0, 1};

    public static void main(String[] args) {
        solution(4);
        System.out.println(cnt);
    }

    public static int solution(int n) {
        int answer = 0;
        N = n;
        arr = new int[N][N];

        recursive(0, 0);

        return answer;
    }

    public static void recursive(int r, int a) {
        if (N == r) {
            cnt++;
            return;
        }
        for (int j = 0; j < N; j++) {
            if (arr[a][j] < 0) continue;
            else {
                m(a, j, -1);
                recursive(r + 1, a + 1);
                m(a, j, 1);
            }
        }
    }

    static void m(int i, int j, int c) {
        for (int k = 0; k < 4; k++) {
            int tmpi = i;
            int tmpj = j;
            while (tmpi >= 0 && tmpi < N && tmpj >= 0 && tmpj < N) {
                tmpi = tmpi + dx[k];
                tmpj = tmpj + dy[k];
                if (tmpi >= 0 && tmpi < N && tmpj >= 0 && tmpj < N) {
                    arr[tmpi][tmpj] += c;
                }
            }
        }
    }
}

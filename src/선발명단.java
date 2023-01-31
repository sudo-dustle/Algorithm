import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 선발명단 {
    public static int[][] map = new int[11][11];
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            for (int i = 0; i < 11; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int sum = recursive(0, new Stack<>());

            if (sum > -1) {
                System.out.println(sum);
            }
        }
    }

    private static int recursive(int player, Stack<Integer> positions) {
        if (positions.size() == 11) {
            return 0;
        }

        int answer = Integer.MIN_VALUE;

        for (int j = 0; j < 11; j++) {
            if (positions.contains(j) || map[player][j] == 0) continue;

            positions.add(j);

            answer = Math.max(recursive(player + 1, positions) + map[player][j], answer);
            positions.pop();
        }

        return answer;
    }
}

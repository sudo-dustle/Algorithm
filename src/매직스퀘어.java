
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 매직스퀘어 {
    public static int[] map = new int[9];
    public static int[] numbers = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i <= 9; i++) {
            numbers[i - 1] = i;
        }

        int idx = 0;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            map[idx] = Integer.parseInt(st.nextToken());
            map[idx + 1] = Integer.parseInt(st.nextToken());
            map[idx + 2] = Integer.parseInt(st.nextToken());
            idx += 3;
        }

        System.out.println(recursive(0, numbers));


    }

    public static int recursive(int start, int[] numbers) {
        int cost = Integer.MAX_VALUE;

        if (start == 9) {
            if (isMagicSquare(numbers)) {
                return getCost(numbers);
            }
            return Integer.MAX_VALUE;
        }

        for (int i = start; i < 9; i++) {
            int tmp;
            tmp = numbers[i];
            numbers[i] = numbers[start];
            numbers[start] = tmp;

            cost = Math.min(recursive(start + 1, numbers), cost);

            tmp = numbers[i];
            numbers[i] = numbers[start];
            numbers[start] = tmp;
        }

        return cost;
    }

    private static int getCost(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            if(numbers[i] != map[i]) {
                sum += Math.abs(numbers[i] - map[i]);
            }
        }
        return sum;
    }


    private static boolean isMagicSquare(int[] numbers) {
        int[][] tmp = new int[3][3];
        int idx = 0;
        int total = 15;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tmp[i][j] = numbers[idx];
                idx += 1;
            }
        }

        for (int i = 0; i < 3; i++) {
            int sum = 0;
            sum += tmp[i][0];
            sum += tmp[i][1];
            sum += tmp[i][2];
            if (sum != total) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            int sum = 0;
            sum += tmp[0][i];
            sum += tmp[1][i];
            sum += tmp[2][i];
            if (sum != total) {
                return false;
            }
        }

        if (tmp[0][0] + tmp[1][1] + tmp[2][2] != total || tmp[0][2] + tmp[1][1] + tmp[2][0] != total) {
            return false;
        }

        return true;
    }
}

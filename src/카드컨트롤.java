import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 카드컨트롤 {
    public static int N;
    public static Queue<CardGame> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<String> cards = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            cards.add(st.nextToken());
        }

        queue.add(new CardGame(cards, 0));
        System.out.println(bfs());
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            CardGame cardGame = queue.poll();
            ArrayList<String> cards = cardGame.getCards();

            if (isJunsuckWin(cards)) {
                return cardGame.count;
            }

            for (int i = 1; i < N * 2; i++) {
                String tmp = cards.get(i);
                cards.remove(i);
                cards.add(0, tmp);

                queue.offer(new CardGame(cards, cardGame.count + 1));
            }
        }

        return -1;
    }

    public static boolean isJunsuckWin(ArrayList<String> cards) {
        int junsuck = 0;
        int suhyun = 0;

        for (int i = 0; i < N * 2; i += 2) {
            String first = cards.get(i);
            String second = cards.get(i + 1);

            if (first.equals("O") && second.equals("X")) {
                junsuck += 1;
            } else if (first.equals("X") && second.equals("O")) {
                suhyun += 1;
            }
        }

        return junsuck > suhyun;
    }

    public static class CardGame {
        private ArrayList<String> cards;
        private int count;

        public ArrayList<String> getCards() {
            return cards;
        }

        public CardGame(ArrayList<String> cards, int count) {
            this.cards = new ArrayList<>();
            for (int i = 0; i < cards.size(); i++) {
                this.cards.add(cards.get(i));
            }
            this.count = count;
        }
    }
}

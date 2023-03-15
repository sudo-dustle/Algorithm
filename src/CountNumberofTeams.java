public class CountNumberofTeams {
    public static void main(String[] args) {
        int[] rating = {1, 2, 3, 4};
        int answer = numTeams(rating);
        System.out.println(answer);
    }

    public static int numTeams(int[] rating) {
        int count = 0;
        int length = rating.length;

        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                if (rating[i] < rating[j]) {
                    for (int k = j + 1; k < length; k++) {
                        if (rating[j] < rating[k]) {
                            count += 1;
                        }
                    }
                }
                if (rating[i] > rating[j]) {
                    for (int k = j + 1; k < length; k++) {
                        if (rating[j] > rating[k]) {
                            count += 1;
                        }
                    }
                }
            }
        }

        return count;
    }
}

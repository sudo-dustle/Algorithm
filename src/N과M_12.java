import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class N과M_12 {
    static int N;
    static int M;
    static int[] arr;
    static int[] answer;
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        arr = new int[N];
        answer = new int[M];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        recursive(0, 0);

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    static void recursive(int r, int start) {
        if(r == M) {
            String tmp = "";
            for(int i : answer) tmp += i + " ";
            set.add(tmp);
            return;
        }

        for(int i = start; i < N; i++) {
            answer[r] = arr[i];
            recursive(r + 1, i);
        }
    }
}

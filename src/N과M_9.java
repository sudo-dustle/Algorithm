import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class N과M_9 {
    static int N;
    static int M;
    static int[] arr;
    static int[] answer;
    static boolean[] visited;
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        arr = new int[N];
        answer = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        recursive(0);

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    static void recursive(int r) {
        if(r == M) {
            String tmp = "";
            for(int i : answer) tmp += i + " ";
            set.add(tmp);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            answer[r] = arr[i];
            recursive(r + 1);
            visited[i] = false;
        }
    }
}

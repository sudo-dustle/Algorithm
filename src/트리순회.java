
import java.io.*;
import java.util.StringTokenizer;

public class 트리순회 {
    static BufferedWriter pre = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedWriter in = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedWriter post = new BufferedWriter(new OutputStreamWriter(System.out));
    //8시 30분
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Tree t = new Tree();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            t.init(root, left, right);
        }

        t.order(t.root, 0);
        pre.write("\n");
        in.write("\n");
        pre.flush();
        in.flush();
        post.flush();
    }
    public static class Node {
        char data;
        Node left;
        Node right;

        Node(char data) {
            this.data = data;
        }
    }
    public static class Tree {
        public Node root;

        public void init(char data, char left, char right) {
            if(root == null) {
                root =  new Node(data);
                root.left = left != '.' ? new Node(left) : null;
                root.right = right != '.' ? new Node(right) : null;
            } else {
                fill(root, data, left, right);
            }
        }
        public void fill(Node node, char data, char left, char right) {
            if(node == null) {
                return;
            } else if (node.data == data) {
                node.left = left != '.' ? new Node(left) : null;
                node.right = right != '.' ? new Node(right) : null;
            } else {
                fill(node.left, data, left, right);
                fill(node.right, data, left, right);
            }
        }
        public void order(Node node, int idx) throws IOException {
            if(node != null) {
                pre.write(node.data);
                if (node.left != null) order(node.left, idx + 1);
                in.write(node.data);
                if (node.right != null) order(node.right, idx + 1);
                post.write(node.data);
            }
        }
    }
}




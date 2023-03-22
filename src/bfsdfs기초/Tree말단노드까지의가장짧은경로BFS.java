package bfsdfs기초;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Tree말단노드까지의가장짧은경로BFS {

    static Queue<Node> queue = new LinkedList<>();

    static class Node {

        int value;
        Node lt;
        Node rt;

        public Node(int value) {
            this.value = value;
            lt = rt = null;
        }
    }

    static class Tree {

        Node root;

        public int bfs(Node root) {

            queue.offer(root);
            int L = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node poll = queue.poll();
                    if (poll.lt == null && poll.rt == null) {
                        return L;

                    }

                    if (poll.lt != null) {
                        queue.offer(poll.lt);
                    }
                    if (poll.rt != null) {
                        queue.offer(poll.rt);
                    }
                }
                L++;
            }
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {

        Tree tree = new Tree();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.println(tree.bfs(tree.root));
    }
}

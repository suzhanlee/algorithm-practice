package bfsdfs기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 이진트리레벨탐색 {

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

        public void bfs(Node root) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            int L = 0;

            while (!queue.isEmpty()) {

                int size = queue.size();
                System.out.print(L + " : ");
                for (int i = 0; i < size; i++) {
                    Node poll = queue.poll();
                    System.out.print(poll.value + " ");

                    if (poll.lt != null) {
                        queue.offer(poll.lt);
                    }
                    if (poll.rt != null) {
                        queue.offer(poll.rt);
                    }
                }
                System.out.println();
                L++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Tree tree = new Tree();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.bfs(tree.root);
    }
}

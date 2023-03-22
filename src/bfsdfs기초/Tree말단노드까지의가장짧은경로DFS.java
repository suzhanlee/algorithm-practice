package bfsdfs기초;

import java.io.IOException;

public class Tree말단노드까지의가장짧은경로DFS {

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

        public int dfs(int L, Node root) {

            if (root.lt == null && root.rt == null) {
                return L;
            } else {
                return Math.min(dfs(L + 1, root.lt), dfs(L + 1, root.rt));
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Tree tree = new Tree();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        System.out.println(tree.dfs(0, tree.root));
    }
}

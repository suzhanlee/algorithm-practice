package bfsdfs기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진트리순회 {

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

        public void dfs(Node root) {

            if (root == null) {
                return;

            } else {
                System.out.print(root.value + " ");
                dfs(root.lt);
                dfs(root.rt);
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

        tree.dfs(tree.root);
    }
}

//package 백준.최단거리;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class BJ1753 {
//
//    static int V, E, K;
//    static ArrayList<ArrayList<Integer>> graph;
//    static int[][] weight;
//
//    public static void bfs() {
//
//    }
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        V = Integer.parseInt(st.nextToken());
//        E = Integer.parseInt(st.nextToken());
//
//        K = Integer.parseInt(br.readLine());
//
//        graph = new ArrayList<ArrayList<Integer>>();
//
//        for (int i = 1; i <= V; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < V; i++) {
//            StringTokenizer st1 = new StringTokenizer(br.readLine());
//            int i1 = Integer.parseInt(st1.nextToken());
//            int i2 = Integer.parseInt(st1.nextToken());
//            int i3 = Integer.parseInt(st1.nextToken());
//
//            graph.get(i1).add(i2,i3);
//        }
//
//
//
//
//    }
//
//}

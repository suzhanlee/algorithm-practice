//package 백준.브루트포스;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class BJ17626 {
//
//    static int N;
//    static int answer;
//
//    public static void solution() {
//        boolean flag = true;
//
//        for (int i = 1; i * i <= N; i++) {
//            if (i * i == N) {
//                answer = 1;
//                flag = false;
//                break;
//            }
//        }
//
//        if (flag) {
////            boolean fg = false;
////            int max = 0;
////            for (int i = 1; i*i <= N ; i++) {
////                int num = N - (i * i);
////
////                for (int j = 1; j * j <= N; j++) {
////                    if (j * j == N) {
////                        fg = true;
////                        break;
////                    }
////                }
////
////                if(fg) {
////                    fg = false;
////                    max =
////                }
////
////
////
////
////            }
//        }
//
//
//    }
//
//    public static void bfs() {
//        Queue<Integer> queue = new LinkedList<>();
//
//        queue.offer(0);
//
//        while (!queue.isEmpty()) {
//
//            Integer poll = queue.poll();
//
//            for (int i = 0; i*i <= N ; i++) {
//                queue.offer(i * i);
//
//
//            }
//
//        }
//
//
//    }
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        N = Integer.parseInt(br.readLine());
//
//        System.out.println(answer);
//    }
//}

//package 백준.그리디;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class BJ2212 {
//
//    static int N, K;
//    static int[] arr;
//    static PriorityQueue<Integer> pQ = new PriorityQueue<>();
//    static int answer;
//
//    public static void solution() {
//
//        pQ.offer(arr[0]);
//        int min = Integer.MAX_VALUE;
//
//        for (int i = 1; i < arr.length; i++) {
//
//            if(pQ.size() != K) {
//                pQ.offer(arr[i]);
//                min =
//
//            }
//        }
//
//
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
//        K = Integer.parseInt(br.readLine());
//
//        arr = new int[N];
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        Arrays.sort(arr);
//
//        solution();
//
//
//
//
//    }
//
//}

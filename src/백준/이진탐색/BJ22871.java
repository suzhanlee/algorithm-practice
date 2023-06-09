//package 백준.이진탐색;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class BJ22871 {
//
//    static int N;
//    static long[] arr;
//    static long[] dp;
//
//    public static long solution(int x) {
//
//        if (x == N - 1) {
//            return 0;
//        }
//
//        if (dp[x] != -1) {
//            return dp[x];
//        }
//
//        dp[x] = Long.MAX_VALUE;
//
//        for (int i = x + 1; i < N; i++) {
//            dp[x] = Math.min(dp[x], Math.max(go(i), (i - x) * (1 + Math.abs(arr[x] - arr[i]))));
//        }
//
//        return dp[x];
//    }
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        N = Integer.parseInt(br.readLine());
//
//        arr = new long[N];
//        dp = new long[N];
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        for (int i = 0; i < N; i++) {
//
//            arr[i] = Long.parseLong(st.nextToken());
//            dp[i] = -1;
//
//        }
//
//        System.out.println(solution(0));
//
//    }
//
//
//}

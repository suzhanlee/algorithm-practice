//package 프로그래머스.프로그래머스_dp;
//
//public class N으로_표현 {
//
//    static int min = Integer.MAX_VALUE;
//    static int N;
//    static int number;
//
//    public int solution(int N, int number) {
//        this.N = N;
//        this.number = number;
//
//        dfs(0, 0);
//
//        if (min == Integer.MAX_VALUE) {
//            return -1;
//        }
//        return min;
//    }
//
//    public void dfs(int L, int sum) {
//
//        if (L > 8) {
//            return;
//        }
//
//        if (number == sum) {
//            min = Math.min(L, min);
//            return;
//        }
//
//        int tmp = 0;
//
//        for (int i = 0; i < 8; i++) {
//            if (L + i < 8) {
//                tmp = tmp * 10 + N;
//                dfs(L + i + 1, sum + tmp);
//                dfs(L + i + 1, sum - tmp);
//                dfs(L + i + 1, sum / tmp);
//                dfs(L + i + 1, sum * tmp);
//            }
//        }
//    }
//}
//package 백준.브루트포스;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class BJ14717 {
//
//    static int A, B;
//    static double totalCase;
//    static double caseCnt;
//
//    public static void solution1() { // N == M
//
//        caseCnt = 10 - A;
//
//    }
//
//    public static void solution2() { // N != M
//
//        caseCnt = 10;
//        int num = A + B;
//        String s = String.valueOf(num);
//        char c = s.charAt(s.length() - 1);
//        num = c - '0';
//
//        for (int i = 1; i <= 10; i++) {
//            if(i != A && i != B) {
//
//                for (int j = i + 1; j <= 10; j++) {
//
//                    if (j != B && j != A) {
//
//                        int tmp1 = i + j;
//                        String s1 = String.valueOf(tmp1);
//                        char c1 = s1.charAt(s1.length() - 1);
//
//                        if (c1 - '0' >= num) {
//                            caseCnt+=4;
//
//                        }
//                    }
//
//                }
//            }
//
//        }
//
//    }
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        A = Integer.parseInt(st.nextToken());
//        B = Integer.parseInt(st.nextToken());
//
//        if (A == B) {
//            totalCase = (long) ((18 * 17) / 2);
//            solution1();
//            caseCnt = totalCase - caseCnt;
//
//
//        } else {
//            totalCase = (long) ((16 * 15) / 2);
//            solution2();
//            caseCnt = totalCase - caseCnt;
//
//        }
//
//        System.out.println(Math.round((caseCnt / totalCase) * 1000) / 1000.0);
//
//    }
//}

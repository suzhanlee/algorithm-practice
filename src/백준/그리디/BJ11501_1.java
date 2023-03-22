//package 백준.그리디;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class BJ11501_1 {
//
//    static int T;
//    static int N;
//    static int[] arr;
//    static StringBuilder sb = new StringBuilder();
//    static long answer;
//    static ArrayList<Integer> maxArr = new ArrayList<>();
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        T = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < T; i++) {
//
//            N = Integer.parseInt(br.readLine());
//            arr = new int[N];
//            maxArr = new ArrayList<>();
//
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N; j++) {
//                arr[j] = Integer.parseInt(st.nextToken());
//            }
//
//            int max = arr[0];
//
//            for (int j = 1; j < N; j++) {
//
//                if (arr[j] > max) {
//                    max = arr[j];
//                } else if (arr[j] < max) {
//                    if(maxArr.size() == 0 || ) {
//                        maxArr.add(max);
//                        max = arr[j];
//                    }
//                }
//
//
//            }
//
//            sb.append(answer).append('\n');
//            answer = 0;
//
//
//        }
//
//        System.out.println(sb);
//
//    }
//
//}

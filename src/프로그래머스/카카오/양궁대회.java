//package 프로그래머스.카카오;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//public class 양궁대회 {
//
//    static int N; // 화살 : N 발
//    static int[] info; // 어피치가 맞힌 과녁 점수의  점수 배열
//    static Map<Integer, Integer> map = new LinkedHashMap<>();
//    static List<Integer> answerList = new ArrayList<>();
//
////    	[2,1,1,1,0,0,0,0,0,0,0]
//
//    public int[] solution(int n, int[] info) {
//        int[] answer = {};
//
//        Arrays.sort(info);
//
//        for (int i = 0; i < info.length; i++) {
//
//            if (info[i] != 0) {
//                map.put(info[i], map.getOrDefault(info[i], 0) + 1);
//            }
//        }
//
//        for (int i = 10; i >= 0; i--) {
//
//            boolean flag = map.containsKey(i);
//            if (!flag) {
//                map.
//            }
//
//        }
//
//        return answer;
//    }
//
//    public static void main(String[] args) {
//
//    }
//
//
//}

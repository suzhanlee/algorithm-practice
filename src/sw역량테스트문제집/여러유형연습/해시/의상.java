//package sw역량테스트문제집.여러유형연습.해시;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class 의상 {
//
//    public int solution(String[][] clothes) {
//
//        int answer = 0;
//        Map<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < clothes.length; i++) {
//            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
//        }
//
//        for (int i = 0; i < map.size(); i++) {
//            map.get(i);
//        }
//
//
//    }
//
//    public static void main(String[] args) {
//        의상 main = new 의상();
//        int solution = main.solution(
//            new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"},
//                {"green_turban", "headgear"}});
//        System.out.println(solution);
//    }
//
//}

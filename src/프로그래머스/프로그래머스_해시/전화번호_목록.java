package 프로그래머스.프로그래머스_해시;

import java.util.HashMap;
import java.util.Map;

public class 전화번호_목록 {

    static boolean answer = true;

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Boolean> phones = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            phones.put(phone_book[i], false);
        }

        OUTER :
        for (String key : phones.keySet()) {
            for (int i = 1; i < key.length(); i++) {
                if (phones.containsKey(key.substring(0, i))) {
                    answer = false;
                    break OUTER;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        String[] phone_book = new String[]{"119", "97674223", "1195524421"};

        boolean answer = solution(phone_book);
        System.out.println(answer);


    }

}

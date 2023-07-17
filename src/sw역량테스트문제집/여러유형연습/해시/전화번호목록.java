package sw역량테스트문제집.여러유형연습.해시;

import java.util.HashMap;
import java.util.Map;

public class 전화번호목록 {

    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        전화번호목록 main = new 전화번호목록();
        boolean solution = main.solution(new String[]{"119", "97674223", "1195524421"});
        System.out.println(solution);

    }


}

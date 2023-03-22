package 프로그래머스.스킬체크;

import java.util.ArrayList;
import java.util.HashMap;

public class 문제2 {

    public static int[] solution(String[] gems) {
        int answerlength = Integer.MAX_VALUE;

        Section section = null;

        for (int k = 0; k < gems.length; k++) {

            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i < gems.length; i++) {

                map.put(gems[i], 1);
            }


            for (int i = k; i < gems.length; i++) {

                if (map.containsKey(gems[i])) {
                    map.remove(gems[i]);

                } else {

                    int length = k - i + 1;

                    if (answerlength > length) {
                        section = new Section(k, i);
                    }

                    break;
                }
            }


        }

        ArrayList arrayList = new ArrayList();
        arrayList.add(section.start);
        arrayList.add(section.end);

        int[] answer = new int[2];

        for (int i = 0; i < 2; i++) {

            answer[i] = (int) arrayList.get(i);
        }

        return answer;
    }

    static class Section {

        int start;
        int end;

        public Section(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {

        String[] strings = new String[]{"AA", "AB", "AC", "AA", "AC"};

        int[] solution = solution(strings);
        for (int i : solution) {
            System.out.println(i);
        }

    }

}

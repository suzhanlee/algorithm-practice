package 코테대비52문제.그리디;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
public class 전투게임 {

    public int[] solution(String[] students) {

        int n = students.length;
        int[] answer = new int[n];

        ArrayList<Info> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            Character a = students[i].split(" ")[0].charAt(0);
            int b = Integer.parseInt(students[i].split(" ")[1]);
            arrayList.add(new Info(i, a, b));
        }

        Collections.sort(arrayList);

        HashMap<Character, Integer> Tp = new HashMap<>();

        int j = 0, total = 0;

        for (int i = 1; i < n; i++) {

            for (; j < n; j++) {

                if (arrayList.get(j).power < arrayList.get(i).power) {

                    total += arrayList.get(j).power;
                    char x = arrayList.get(j).team;
                    Tp.put(x, Tp.getOrDefault(x, 0) + arrayList.get(j).power);

                } else {
                    break;
                }
            }

            answer[arrayList.get(i).idx] = total - Tp.getOrDefault(arrayList.get(i).team, 0);

        }
        return answer;
    }

    static class Info implements Comparable<Info> {

        public int idx;
        public Character team;
        public int power;

        Info(int idx, Character team, int power) {
            this.idx = idx;
            this.team = team;
            this.power = power;
        }

        @Override
        public int compareTo(Info ob) {
            return this.power - ob.power;
        }
    }

    public static void main(String[] args) {

        전투게임 T = new 전투게임();

        System.out.println(
            Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(
            T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(
            T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(
            T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}
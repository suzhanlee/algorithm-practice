package 자바_코딩테스트.해싱_시간파싱;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class 회장선거 {

    public String solution(String[] votes, int k) {

        String answer = " ";

        HashMap<String, HashSet<String>> voteHash = new HashMap<>();
        HashMap<String, Integer> candidate = new HashMap<>();
        HashMap<String, Integer> present = new HashMap<>();

        for (String x : votes) {

            String a = x.split(" ")[0];
            String b = x.split(" ")[1];

            voteHash.putIfAbsent(a, new HashSet<String>());
            voteHash.get(a).add(b);
            candidate.put(b, candidate.getOrDefault(b, 0) + 1);

        }

        int max = Integer.MIN_VALUE;

        for (String a : voteHash.keySet()) {

            int cnt = 0;

            for (String b : voteHash.get(a)) {
                if (candidate.get(b) >= k) {
                    cnt++;
                }
            }

            present.put(a, cnt);
            max = Math.max(max, cnt);

        }

        ArrayList<String> tmp = new ArrayList<>();

        for (String name : present.keySet()) {

            if (present.get(name) == max) {
                tmp.add(name);
            }

        }

        tmp.sort((a, b) -> a.compareTo(b));

        answer = tmp.get(0);

        return answer;
    }
}

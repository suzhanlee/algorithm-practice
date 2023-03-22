package 프로그래머스.프로그래머스_해시;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class 베스트_앨범 {

    static int[] answer = {};
    static ArrayList<Integer> answers = new ArrayList<>();
    static HashMap<String, Integer> map = new HashMap<>();
    static ArrayList<Song> songs = new ArrayList<>();

    static class Song implements Comparable<Song> {

        String genre;
        int play;
        int index;

        public Song(String genre, int play, int index) {
            this.genre = genre;
            this.play = play;
            this.index = index;
        }

        @Override
        public int compareTo(Song o) {
            return this.play - o.play;
        }
    }

    public static int[] solution(String[] genres, int[] plays) {

        // 장르 배열
        for (int i = 0; i < genres.length; i++) {

            songs.add(new Song(genres[i], plays[i], i));
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);

        }

        List<Entry<String, Integer>> entryList = new ArrayList<Entry<String, Integer>>(
            map.entrySet());

        Collections.sort(entryList, new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return -(o1.getValue() - o2.getValue());
            }
        });

        Collections.sort(songs, Collections.reverseOrder());

        // 해당 장르내 많이 들은 순서로 2개만 answer 배열에 넣기
        for (Entry<String, Integer> entry : entryList) {

            String key = entry.getKey();
            int cnt = 0;
            for (int i = 0; i < songs.size(); i++) {

                if (key.equals(songs.get(i).genre)) {

                    answers.add(songs.get(i).index);

                    cnt++;
                    if (cnt == 2) {
                        break;
                    }
                }
            }
        }

        answer = new int[answers.size()];
        for (int i = 0; i < answers.size(); i++) {
            answer[i] = answers.get(i);

        }

        return answer;
    }

    public static void main(String[] args) {

        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};

        int[] answer = solution(genres, plays);

        for (int x : answer) {
            System.out.println(x);

        }

    }

}

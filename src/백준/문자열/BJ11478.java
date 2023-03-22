package 백준.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class BJ11478 {

    static String S;
    static char[] chars;
    static ArrayList<String> arrayList = new ArrayList<>();
    static HashSet<String> set;

//    public static void dfs(int L, String str) {
//
//        if (L == S.length()) {
//            for (int i = 0; i < arrayList.size(); i++) {
//                if(arrayList.get(i).equals(str)) {
//                    return;
//                }
//            }
//            arrayList.add(str);
//        } else {
//            dfs(L + 1, str + S.charAt(L));
//            dfs(L + 1, str);
//        }
//
//    }

    public static void solution() {

        set = new HashSet<>();

        for (int i = 0; i < S.length(); i++) {
            String str = S.substring(i);
            for (int j = S.length() - i; j >= 1; j--) {
                String substring = str.substring(0, j);
                set.add(substring);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        chars = new char[S.length()];

        for (int i = 0; i < S.length(); i++) {
            chars[i] = S.charAt(i);
        }

//        dfs(0, "");
        solution();

        System.out.println(set.size());


    }

}

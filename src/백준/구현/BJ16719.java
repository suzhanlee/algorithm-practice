//package 백준.구현;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class BJ16719 {
//
//    static String str;
//    static StringBuilder sb = new StringBuilder();
//    static ArrayList<Alpa> alpas = new ArrayList<>();
//
//    static class Alpa implements Comparable<Alpa>{
//
//        char c;
//        int order;
//
//        public Alpa(char c, int order) {
//            this.c = c;
//            this.order = order;
//        }
//
//        @Override
//        public int compareTo(Alpa o) {
//            if(this.c == o.c) {
//                return this.order - o.order;
//            } else {
//                return this.c - o.c;
//            }
//        }
//    }
//
//    static class Alpa1 implements Comparable<Alpa1>{
//
//        char c;
//        int order;
//
//        public Alpa1(char c, int order) {
//            this.c = c;
//            this.order = order;
//        }
//
//
//        @Override
//        public int compareTo(Alpa1 o) {
//            return this.order - o.order;
//        }
//    }
//
//    public static void solution() {
//
//        for (int i = 0; i < str.length(); i++) {
//            ArrayList<Alpa1> alpa1s = new ArrayList<>();
//            for (int j = 0; j < i+1; j++) {
//
//                Alpa alpa = alpas.get(j);
//                alpa1s.add(new Alpa1(alpa.c, alpa.order));
//            }
//
//            Collections.sort(alpa1s);
//
//            for (Alpa1 alpa1 : alpa1s) {
//                sb.append(alpa1.c);
//            }
//
//
//            sb.append('\n');
//
//        }
//
//
//
//    }
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        str = br.readLine();
//
//        for (int i = 0; i < str.length(); i++) {
//
//            alpas.add(new Alpa(str.charAt(i), i));
//
//        }
//
//        Collections.sort(alpas);
//        solution();
//
//        System.out.println(sb);
//
//
//
//
//    }
//
//}

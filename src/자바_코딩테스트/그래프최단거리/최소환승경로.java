package 자바_코딩테스트.그래프최단거리;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class 최소환승경로 {

    public int solution(int[][] routes, int s, int e){
        int answer = 0;
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        int n = routes.length;

        for(int i = 0; i < n; i++){

            for(int x : routes[i]){

                graph.putIfAbsent(x, new HashSet<Integer>());
                graph.get(x).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n];
        queue.offer(s);
        int L = 0;

        while(!queue.isEmpty()){
            int len = queue.size();

            for(int i = 0; i < len; i++){
                int curStop = queue.poll();

                for(int line : graph.get(curStop)){
                    if(visited[line] == 1) continue;
                    visited[line] = 1;

                    for(int stop : routes[line]){
                        if(stop == e) return L;
                        queue.offer(stop);
                    }
                }
            }

            L++;
        }
        return -1;
    }
}


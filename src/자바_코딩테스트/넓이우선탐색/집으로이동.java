package 자바_코딩테스트.넓이우선탐색;

import java.util.LinkedList;
import java.util.Queue;

class 집으로이동 {
    public int solution(int[] pool, int a, int b, int home){
        int[][] visited = new int[2][10001];
        for(int x : pool){
            visited[0][x] = 1;
            visited[1][x] = 1;
        }
        Queue<int[]> Q = new LinkedList<>();
        visited[0][0] = 1;
        visited[1][0] = 1;
        Q.offer(new int[]{0, 0});
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i < len; i++){
                int[] cur = Q.poll();
                if(cur[0] == home) return L;
                int nx = cur[0] + a;
                if(nx <= 10001 && visited[0][nx] == 0){
                    visited[0][nx] = 1;
                    Q.offer(new int[]{nx, 0});
                }
                nx = cur[0] - b;
                if(nx >= 0 && visited[1][nx] == 0 && cur[1] == 0){
                    visited[1][nx] = 1;
                    Q.offer(new int[]{nx, 1});
                }
            }
            L++;
        }
        return -1;
    }
}

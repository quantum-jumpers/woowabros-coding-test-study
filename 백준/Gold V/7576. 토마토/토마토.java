import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        // {x, y, day=1}
        int[][] box = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] delta = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        int remain = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (box[i][j] == 1) {
                    queue.offer(new int[]{i, j, 1});
                }
                else if (box[i][j] == 0) {
                    remain += 1;
                }
            }
        }

        if (remain == 0) {
            System.out.println(0);
            return;
        }

        while (!queue.isEmpty()) {
            int[] tomato = queue.poll();
            for (int[] d : delta) {
                int dx = tomato[0] + d[0];
                int dy = tomato[1] + d[1];
                if (dx < 0 || dx >= N) continue;
                if (dy < 0 || dy >= M) continue;
                if (box[dx][dy] == 0) {
                    box[dx][dy] = 1;
                    remain -= 1;
                    if (remain == 0) {
                        System.out.println(tomato[2]);
                        return;
                    }
                    queue.offer(new int[]{dx, dy, tomato[2] + 1});
                }
            }
        }

        if (remain > 0) {
            System.out.println(-1);
            return;
        }
    }
}

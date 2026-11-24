import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        // {row, col, height, day}
        Deque<int[]> queue = new ArrayDeque<>();
        int remain = 0;
        int[][][] box = new int[N][M][H];
        for (int i=0; i<H; i++) {
            for (int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k=0; k<M; k++) {
                    int status = Integer.parseInt(st.nextToken());
                    box[j][k][i] = status;
                    if (status == 1) queue.offer(new int[]{j, k, i, 1});
                    if (status == 0) remain += 1;
                }
            }
        }

        if (remain == 0) {
            System.out.println(0);
            return;
        }

        int[][] delta = {
                {1, 0, 0},
                {-1, 0, 0},
                {0, 1, 0},
                {0, -1, 0},
                {0, 0, 1},
                {0, 0, -1}
        };

        while (!queue.isEmpty()) {
            int[] tomato = queue.poll();
            for (int[] d : delta) {
                int dx = tomato[0] + d[0];
                int dy = tomato[1] + d[1];
                int dz = tomato[2] + d[2];
                if (dx < 0 || dx >= N) continue;
                if (dy < 0 || dy >= M) continue;
                if (dz < 0 || dz >= H) continue;

                if (box[dx][dy][dz] == 0) {
                    box[dx][dy][dz] = 1;
                    remain -= 1;
                    queue.offer(new int[]{dx, dy, dz, tomato[3] + 1});
                }
                if (remain == 0) {
                    System.out.println(tomato[3]);
                    return;
                }
            }
        }

        if (remain > 0) {
            System.out.println(-1);
            return;
        }
    }
}

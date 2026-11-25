import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] delta = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] mat = new int[N][M];
            for (int i = 1; i <= K; i++) {
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());
                mat[row][col] = 1;
            }

            Deque<int[]> queue = new ArrayDeque<>();
            boolean[][] visited = new boolean[N][M];
            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (mat[i][j] == 0) continue;
                    if (visited[i][j]) continue;

                    queue.offer(new int[]{i, j});
                    result += 1;
                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        for (int[] d : delta) {
                            int nextRow = curr[0] + d[0];
                            int nextCol = curr[1] + d[1];
                            if (nextRow < 0 || nextRow >= N) continue;
                            if (nextCol < 0 || nextCol >= M) continue;
                            if (mat[nextRow][nextCol] == 0) continue;
                            if (visited[nextRow][nextCol]) continue;

                            visited[nextRow][nextCol] = true;
                            queue.offer(new int[]{nextRow, nextCol});
                        }
                    }
                }
            }

            System.out.println(result);
        }
    }
}

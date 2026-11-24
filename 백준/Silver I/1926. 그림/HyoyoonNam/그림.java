import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] mat = new int[N + 1][M + 1];
        boolean[][] visited = new boolean[N + 1][M + 1];

        int count = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
                if (mat[i][j] == 1) count += 1;
            }
        }

        if (count == 0) {
            System.out.printf("%d%n%d", 0, 0);
            return;
        }

        int[][] delta = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        // {row, col}
        Deque<int[]> queue = new ArrayDeque<>();
        int answerCount = 0;
        int answerSize = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (mat[i][j] == 0 || visited[i][j]) continue;

                answerCount += 1;
                int size = 0;

                visited[i][j] = true;
                queue.offer(new int[]{i, j});

                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    size += 1;

                    for (int[] d : delta) {
                        int nextRow = curr[0] + d[0];
                        int nextCol = curr[1] + d[1];
                        if (nextRow < 1 || nextRow > N) continue;
                        if (nextCol < 1 || nextCol > M) continue;
                        if (visited[nextRow][nextCol]) continue;
                        if (mat[nextRow][nextCol] == 0) continue;
                        visited[nextRow][nextCol] = true;

                        queue.offer(new int[]{nextRow, nextCol});
                    }
                }

                answerSize = Math.max(answerSize, size);
            }
        }

        System.out.printf("%d%n%d", answerCount, answerSize);
    }
}

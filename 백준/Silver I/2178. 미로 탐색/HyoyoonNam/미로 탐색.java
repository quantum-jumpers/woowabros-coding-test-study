import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[N + 1][M + 1];
        int[][] mat = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String row = br.readLine();
            for (int j = 1; j <= M; j++) {
                mat[i][j] = row.charAt(j - 1) - '0';
            }
        }

        int[][] delta = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        // {row, col, dist=1}
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 1, 1});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == N && curr[1] == M) {
                System.out.println(curr[2]);
                return;
            }
            for (int[] d : delta) {
                int nextRow = curr[0] + d[0];
                int nextCol = curr[1] + d[1];
                if (nextRow < 1 || nextRow > N) continue;
                if (nextCol < 1 || nextCol > M) continue;
                if (visited[nextRow][nextCol]) continue;
                if (mat[nextRow][nextCol] != 1) continue;
                visited[nextRow][nextCol] = true;
                queue.offer(new int[]{nextRow, nextCol, curr[2] + 1});
            }
        }

        System.out.println(-1);
    }
}

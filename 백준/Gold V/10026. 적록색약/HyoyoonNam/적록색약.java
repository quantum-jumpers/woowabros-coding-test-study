import java.io.*;
import java.util.*;

/*
 Output:
 {적록색약 x가 본 구역의 수} {적록색약 o가 본 구역의 수}
 */
public class Main {
    public static void main(String[] args) throws IOException {
        int result1 = 0;
        int result2 = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] mat = new String[N];

        for (int i = 0; i < N; i++) {
            mat[i] = br.readLine();
        }

        int[][] delta = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        // case 1. 적록색약 x
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                queue.offer(new int[]{i, j});
                result1 += 1;
                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    for (int[] d : delta) {
                        int nextRow = curr[0] + d[0];
                        int nextCol = curr[1] + d[1];
                        if (nextRow < 0 || nextRow >= N) continue;
                        if (nextCol < 0 || nextCol >= N) continue;
                        if (visited[nextRow][nextCol]) continue;
                        if (mat[nextRow].charAt(nextCol) != mat[curr[0]].charAt(curr[1])) continue;
                        visited[nextRow][nextCol] = true;
                        queue.offer(new int[]{nextRow, nextCol});
                    }
                }
            }
        }

        // case 2. 적록색약 o: R == G
        queue = new ArrayDeque<>();
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                queue.offer(new int[]{i, j});
                result2 += 1;
                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    for (int[] d : delta) {
                        int nextRow = curr[0] + d[0];
                        int nextCol = curr[1] + d[1];
                        if (nextRow < 0 || nextRow >= N) continue;
                        if (nextCol < 0 || nextCol >= N) continue;
                        if (visited[nextRow][nextCol]) continue;
                        char currColor = mat[curr[0]].charAt(curr[1]);
                        char nextColor = mat[nextRow].charAt(nextCol);
                        if (notSame(currColor, nextColor)) continue;
                        visited[nextRow][nextCol] = true;
                        queue.offer(new int[]{nextRow, nextCol});
                    }
                }
            }
        }

        System.out.printf("%d %d%n", result1, result2);
    }

    static boolean notSame(char currColor, char nextColor) {
        if (currColor == 'B') {
            return nextColor != 'B';
        }
        else {
            return nextColor == 'B';
        }
    }
}

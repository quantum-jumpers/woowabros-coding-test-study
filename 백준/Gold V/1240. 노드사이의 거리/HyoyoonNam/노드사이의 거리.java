// ref: https://dev.to/paulike/representing-weighted-graphs-151c
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // initialize
        // {to, weight}
        List<List<int[]>> adj = new ArrayList<>();
        /* 이거 1001까지 해줘야 node=1 ~ node=1000 모두 가능 */
        for (int i = 1; i <= 1001; i++) adj.add(new ArrayList<>());
        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            adj.get(from).add(new int[]{to, dist});
            adj.get(to).add(new int[]{from, dist});
        }

        // goals
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Deque<int[]> queue = new ArrayDeque<>();
            List<int[]> nextNodes = adj.get(start);
            // {curr, prev, totalDist}
            for (int[] nextNode : nextNodes) {
                queue.offer(new int[]{nextNode[0], start, 0 + nextNode[1]});
            }

//            List<Integer> minDists = new ArrayList<>(); // sol2
            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                if (curr[0] == end) {
                    System.out.println(curr[2]);
                    break;
                }
                List<int[]> candidates = adj.get(curr[0]);
                for (int[] candidate : candidates) {
                    if (candidate[0] == curr[1]) continue;
                    queue.offer(new int[]{candidate[0], curr[0], curr[2] + candidate[1]});
                }
            }
        }
    }
}

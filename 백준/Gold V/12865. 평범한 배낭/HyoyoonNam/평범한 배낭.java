import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][K+1];
        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        for (int j=W; j<=K; j++) {
            dp[1][j] = V;
        }


        for (int i=2; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            for (int j=1; j<=K; j++) {
                // 어차피 이번의 i번 물품은 못 넣으니까, 이전 물품까지 고려했을 때의 최대 value
                if (j < W) dp[i][j] = dp[i-1][j];
                // 이번 거를 넣는다고 확정했을 때랑, 넣지 않고 그 무게에 다른 거 넣었을 때 최대 value를 비교
                else {
                    dp[i][j] = Math.max(
                            dp[i-1][j],
                            V + dp[i-1][j-W]
                    );
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}

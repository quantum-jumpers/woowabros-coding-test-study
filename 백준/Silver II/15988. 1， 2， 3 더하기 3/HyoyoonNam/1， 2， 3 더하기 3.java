import java.io.*;

public class Main {

    static final int SIZE = 1_000_000;
    static final long MOD = 1_000_000_009L;

    public static void main(String[] args) throws IOException {
        long[] dp = new long[SIZE+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i=4; i<=SIZE; i++) {
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % MOD;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i=1; i<=T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append(System.lineSeparator());
        }

        System.out.println(sb.toString());
    }
}

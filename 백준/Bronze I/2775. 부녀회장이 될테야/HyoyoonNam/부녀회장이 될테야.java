import java.io.*;
import java.util.*;

public class Main {
    private static long[][] dp = new long[20][20];
    static {
        for (int row = 0; row < 15; row++) {
            for (int col = 1; col < 15; col++) {
                if (row == 0) dp[row][col] = col;
                else if (col == 1) dp[row][col] = 1;
                else {
                    dp[row][col] = dp[row][col - 1] + dp[row - 1][col];
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            
            sb.append(dp[k][n]).append('\n');
        }
        
        System.out.print(sb);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader for faster input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n + 1];
        boolean[][] dp = new boolean[n + 1][n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        // Initialize dp table
        for (int i = 1; i <= n; i++) {
            dp[i][i] = true; // Single elements are palindromes
        }

        for (int i = 1; i < n; i++) {
            if (a[i] == a[i + 1]) {
                dp[i][i + 1] = true; // Pairs of equal elements are palindromes
            }
        }

        // Fill dp table for subsequences longer than 2
        for (int length = 3; length <= n; length++) {
            for (int i = 1; i <= n - length + 1; i++) {
                int j = i + length - 1;
                if (a[i] == a[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        // Read the number of queries
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < t; q++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            sb.append(dp[from][to] ? 1 : 0).append("\n");
        }

        // Use StringBuilder for faster output
        System.out.print(sb.toString());
    }
}
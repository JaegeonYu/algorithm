import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final int MAX_N = 16;
    private static final int INF = 987654321;
    private static int n;
    private static int[][] dp = new int[MAX_N][1 << MAX_N];
    private static int[][] dist = new int[MAX_N][MAX_N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < MAX_N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(tsp(0, 1));
    }

    private static int tsp(int here, int visited) {
        if (visited == (1 << n) - 1) {
            return dist[here][0] != 0 ? dist[here][0] : INF;
        }

        if (dp[here][visited] != -1) {
            return dp[here][visited];
        }

        dp[here][visited] = INF;
        for (int i = 0; i < n; i++) {
            if ((visited & (1 << i)) != 0) {
                continue;
            }
            if (dist[here][i] == 0) {
                continue;
            }
            dp[here][visited] = Math.min(dp[here][visited], tsp(i, visited | (1 << i)) + dist[here][i]);
        }
        return dp[here][visited];
    }
}
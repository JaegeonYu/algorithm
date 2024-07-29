import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] A, nutrients;
    static List<Tree> trees;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

    static class Tree implements Comparable<Tree> {
        int x, y, age;

        Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return Integer.compare(this.age, o.age);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        nutrients = new int[N][N];
        trees = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                nutrients[i][j] = 5;  // 초기 양분
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x, y, z));
        }

        while (K-- > 0) {
            springAndSummer();
            autumn();
            winter();
        }

        System.out.println(trees.size());
    }

    private static void springAndSummer() {
        Collections.sort(trees);
        List<Tree> alive = new ArrayList<>();
        int[][] deadNutrients = new int[N][N];

        for (Tree tree : trees) {
            if (nutrients[tree.x][tree.y] >= tree.age) {
                nutrients[tree.x][tree.y] -= tree.age;
                tree.age++;
                alive.add(tree);
            } else {
                deadNutrients[tree.x][tree.y] += tree.age / 2;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nutrients[i][j] += deadNutrients[i][j];
            }
        }

        trees = alive;
    }

    private static void autumn() {
        List<Tree> newTrees = new ArrayList<>();
        for (Tree tree : trees) {
            if (tree.age % 5 == 0) {
                for (int d = 0; d < 8; d++) {
                    int nx = tree.x + dx[d];
                    int ny = tree.y + dy[d];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        newTrees.add(new Tree(nx, ny, 1));
                    }
                }
            }
        }
        trees.addAll(0, newTrees);
    }

    private static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nutrients[i][j] += A[i][j];
            }
        }
    }
}
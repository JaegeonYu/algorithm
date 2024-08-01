import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

    static int a, b, c, d;
    static Map<Pair, Integer> m = new HashMap<>();
    static Queue<Pair> q = new LinkedList<>();

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        sc.close();

        System.out.println(bfs(0, 0));
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }

    static void enqueue(int x, int y, int d) {
        Pair p = new Pair(x, y);
        if (m.containsKey(p)) return;
        m.put(p, d + 1);
        q.offer(p);
    }

    static int bfs(int x, int y) {
        Pair start = new Pair(x, y);
        m.put(start, 1);
        q.offer(start);
        while (!q.isEmpty()) {
            Pair p = q.poll();
            x = p.x;
            y = p.y;

            enqueue(a, y, m.get(p));
            enqueue(x, b, m.get(p));
            enqueue(0, y, m.get(p));
            enqueue(x, 0, m.get(p));
            enqueue(Math.min(x + y, a), Math.max(0, x + y - a), m.get(p));
            enqueue(Math.max(0, x + y - b), Math.min(x + y, b), m.get(p));
        }
        Pair target = new Pair(c, d);
        return m.getOrDefault(target, 0) - 1;
    }
}
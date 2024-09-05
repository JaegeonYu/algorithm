import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, a[][], vis[][];
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0)break;

            a = new int[N][N];
            vis = new int[N][N];
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    a[i][j] = Integer.parseInt(st.nextToken());
                    vis[i][j] = Integer.MAX_VALUE;
                }
            }

            sb.append("Problem "+ cnt+ ": " + answer()+"\n");

            cnt++;
        }
        System.out.println(sb.toString());

    }

    private static int answer() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        pq.offer(new int[]{0,0,a[0][0]});
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int y = now[0];
            int x = now[1];
            int weight = now[2];

            for(int i=0;i<4;i++){
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N)continue;

                if(vis[ny][nx] > weight+a[ny][nx]){
                    vis[ny][nx] = weight+a[ny][nx];
                    pq.offer(new int[]{ny, nx, weight+a[ny][nx]});
                }
            }
        }
        return vis[N-1][N-1];
    }

}
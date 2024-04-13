import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, a[][], change[][], output[] ,ret = Integer.MAX_VALUE;
    static boolean vis[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        a = new int[N][M];
        change = new int[K][3];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            change[i][0] = Integer.parseInt(st.nextToken());
            change[i][1] = Integer.parseInt(st.nextToken());
            change[i][2] = Integer.parseInt(st.nextToken());
        }
        vis = new boolean[K];
        output = new int[K];
        // 순열 -> 마지막에 순서대로 돌리고 최신화
        permu(output, vis, 0);
        System.out.println(ret);
    }

    private static void permu(int[] output, boolean[] vis, int depth) {
        if(depth == K){
            game(output);
            return;
        }

        for(int i=0;i<K;i++){
            if(!vis[i]){
                vis[i] = true;
                output[depth] = i;
                permu(output, vis, depth+1);
                vis[i] = false;
            }
        }
    }

    private static void game(int[] output) {
        int[][] copyArr = copyArr(a);

        for (int pos : output){
            int r = change[pos][0];
            int c = change[pos][1];
            int s = change[pos][2];

            int x1 = c-s-1;
            int y1 = r-s-1;
            int x2 = c+s-1;
            int y2 = r+s-1;

            while(x1 < x2 && y1 < y2){
                // 돌리기
                int tmpRight = copyArr[y1][x2];
                for(int i=x2;i>x1;i--){
                    copyArr[y1][i] = copyArr[y1][i-1];
                }


                int tmpRightDown = copyArr[y2][x2];


                for(int i=y2;i>y1+1;i--){
                    copyArr[i][x2] = copyArr[i-1][x2];
                }
                copyArr[y1+1][x2] = tmpRight;

                int tmpLeftDown = copyArr[y2][x1];

                for(int i=x1;i<x2;i++){
                    copyArr[y2][i] = copyArr[y2][i+1];
                }
                copyArr[y2][x2-1] = tmpRightDown;

                for(int i=y1;i<y2;i++){
                    copyArr[i][x1] = copyArr[i+1][x1];
                }
                copyArr[y2-1][x1] = tmpLeftDown;

                // 줄이기
                x1++;
                y1++;
                x2--;
                y2--;
     
            }


        }
        for(int i=0;i<N;i++){
            int sum = 0;
            for(int j=0;j<M;j++){
                sum += copyArr[i][j];
            }
            ret = Math.min(sum, ret);
        }
    }
    public static void print(int[][] a){
        System.out.println("============================");
        for (int i=0;i<N;i++){
            System.out.println(Arrays.toString(a[i]));
        }
    }

    private static int[][] copyArr(int[][] a) {
        int[][] arr = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr[i][j] = a[i][j];
            }
        }
        return arr;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, a[][], map[][];
	static int dx[] = {1,-1,0,0,1,1,-1,-1};
	static int dy[] = {0,0,1,-1,1,-1,1,-1};
	static class Tree implements Comparable<Tree>{
		int y;
		int x;
		int age;
		boolean alive;
		@Override
		public int compareTo(Tree o) {
			return Integer.compare(this.age, o.age);
		}

		public Tree(int y, int x, int age) {
			super();
			this.y = y;
			this.x = x;
			this.age = age;
			this.alive = true;
		}
	}
	static List<Tree> trees = new ArrayList<>();
	static List<Tree> dies;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		a = new int[N][N];
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			trees.add(new Tree(y, x, z));
		}
		
		while(K-- > 0) {
			spring();
			summer();
			fall();
			winter();
		}
		
		int ret = 0;

		System.out.println(trees.size());
	}
	private static void winter() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] += a[i][j];
			}
		}
		
	}
	private static void fall() {
		List<Tree> newTree = new ArrayList<>();
		for(Tree tree :trees) {
			if(tree.age % 5 == 0) {
				for(int d=0;d<8;d++) {
					int ny = tree.y+dy[d];
					int nx = tree.x+dx[d];
					if(nx <0 || nx >= N || ny < 0 || ny >= N)continue;
					newTree.add(new Tree(ny, nx, 1));
				}
			}
		}
		trees.addAll(newTree);
	}
	private static void summer() {
		List<Tree> aliveTree = new ArrayList<>();
		for(Tree tree: trees) {
			if(tree.alive) {
				aliveTree.add(new Tree(tree.y, tree.x, tree.age));
			}else {
				map[tree.y][tree.x] += tree.age/2;
			}
		}
		trees = aliveTree;
	}
	private static void spring() {
		Collections.sort(trees);
		for(Tree tree : trees) {
			if(tree.age <= map[tree.y][tree.x]) {
				map[tree.y][tree.x] -= tree.age;
				tree.age++;
			}else {
				tree.alive = false;
			}
		}
	}

}
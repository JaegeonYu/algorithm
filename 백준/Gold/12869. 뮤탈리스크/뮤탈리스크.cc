#include<bits/stdc++.h>
using namespace std;
int n, a[4], vis[64][64][64], cnt;
int d[6][3]={
	{1,3,9},
	{1,9,3},
	{3,1,9},
	{3,9,1},
	{9,3,1},
	{9,1,3}
};
struct A{
	int x, y, z;
};
int main(){
	cin >> n;
	for(int i=0;i<n;i++){
		cin >> a[i];
	}
	queue<A> q;
	q.push({a[0],a[1],a[2]});
	vis[a[0]][a[1]][a[2]]=1;
	while(q.size()){
		A temp = q.front();q.pop();
		if(vis[0][0][0])break;
		for(int i=0;i<6;i++){
			int nx = max(temp.x-d[i][0],0);
			int ny = max(temp.y-d[i][1],0);
			int nz = max(temp.z-d[i][2],0);
			if(vis[nx][ny][nz])continue;
			vis[nx][ny][nz]=vis[temp.x][temp.y][temp.z]+1;
			q.push({nx,ny,nz});
		}
		// min 0
	}
	cout << vis[0][0][0]-1 << "\n";
	return 0;
}
#include<bits/stdc++.h>
using namespace std;
#define ll long long
/*
思路：
贪心即可：1.用一个结构体储存衡中坐标、当前步数。
         2.读取起点，此时步数step为1，分别向四个方向读取可探索的点，step++并入队
         3.此时的点出队，然后继续同样的方法判断下一个点
         4.这样的方法下判断第一个读到出口的就是最短路径。
         5.队列为空还是没有读到出口，则没有路径。 

*/
struct point {
    int x;    //横坐标 
    int y;    //纵坐标 
    int step; //当前走了几步 
};
int main() {
    int n, i, j;
    point tmp, next;
    int maze[100][100];
    queue<point> q;
    cout<<"输入迷宫的大小："<<endl;
    cin>>n;
    while(q.size() != 0) q.pop();   //初始化清空队列 
    for (i = 0; i < n; i++) {      //读取迷宫  1表示挡板，0表示可以走 
        for (j = 0; j < n; j++)
            cin >> maze[i][j];
    }
        maze[0][0] = 1;               //读取起点，并放入队列 
        tmp.x = tmp.y = 0;
        tmp.step = 1;
        q.push(tmp);
        
        while(!q.empty()) {             //队列非空时 
            tmp = q.front();
            if (tmp.x == n - 1 && tmp.y == n - 1) break; //读到出口，跳出循环 
            if (tmp.x - 1 >= 0 && !maze[tmp.x - 1][tmp.y]) {  //上上
                next.x = tmp.x - 1;
                next.y = tmp.y;
                next.step = tmp.step + 1;//记录成下一步并入队 
                q.push(next);
                maze[tmp.x - 1][tmp.y] = 1;//记录此处
            }
            if (tmp.y - 1 >= 0 && !maze[tmp.x][tmp.y - 1]) {//右右
                next.x = tmp.x;
                next.y = tmp.y - 1;
                next.step = tmp.step + 1;//记录成下一步并入队 
                q.push(next);
                maze[tmp.x][tmp.y - 1] = 1;//记录此处
            }
            if (tmp.x + 1 < n && !maze[tmp.x + 1][tmp.y]) {//下下 
                next.x = tmp.x + 1;
                next.y = tmp.y;
                next.step = tmp.step + 1;//记录成下一步并入队 
                q.push(next);
                maze[tmp.x + 1][tmp.y] = 1;//记录此处
            }
            if (tmp.y + 1 < n && !maze[tmp.x][tmp.y + 1]) {//左左 
                next.x = tmp.x;
                next.y = tmp.y + 1;
                next.step = tmp.step + 1;//记录成下一步并入队 
                q.push(next);
                maze[tmp.x][tmp.y + 1] = 1;//记录此处
            }
            q.pop();//当前所处出队，继续下一步判断 
        }
        
        if (tmp.x == n - 1 && tmp.y == n - 1)//若读取到出口，输出当前步数 
            cout << q.front().step << endl;
        else
            cout << "0" << endl;
}               

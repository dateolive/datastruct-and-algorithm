#include<bits/stdc++.h>
using namespace std;
#define ll long long
/*
˼·��
̰�ļ��ɣ�1.��һ���ṹ�崢��������ꡢ��ǰ������
         2.��ȡ��㣬��ʱ����stepΪ1���ֱ����ĸ������ȡ��̽���ĵ㣬step++�����
         3.��ʱ�ĵ���ӣ�Ȼ�����ͬ���ķ����ж���һ����
         4.�����ķ������жϵ�һ���������ڵľ������·����
         5.����Ϊ�ջ���û�ж������ڣ���û��·���� 

*/
struct point {
    int x;    //������ 
    int y;    //������ 
    int step; //��ǰ���˼��� 
};
int main() {
    int n, i, j;
    point tmp, next;
    int maze[100][100];
    queue<point> q;
    cout<<"�����Թ��Ĵ�С��"<<endl;
    cin>>n;
    while(q.size() != 0) q.pop();   //��ʼ����ն��� 
    for (i = 0; i < n; i++) {      //��ȡ�Թ�  1��ʾ���壬0��ʾ������ 
        for (j = 0; j < n; j++)
            cin >> maze[i][j];
    }
        maze[0][0] = 1;               //��ȡ��㣬��������� 
        tmp.x = tmp.y = 0;
        tmp.step = 1;
        q.push(tmp);
        
        while(!q.empty()) {             //���зǿ�ʱ 
            tmp = q.front();
            if (tmp.x == n - 1 && tmp.y == n - 1) break; //�������ڣ�����ѭ�� 
            if (tmp.x - 1 >= 0 && !maze[tmp.x - 1][tmp.y]) {  //����
                next.x = tmp.x - 1;
                next.y = tmp.y;
                next.step = tmp.step + 1;//��¼����һ������� 
                q.push(next);
                maze[tmp.x - 1][tmp.y] = 1;//��¼�˴�
            }
            if (tmp.y - 1 >= 0 && !maze[tmp.x][tmp.y - 1]) {//����
                next.x = tmp.x;
                next.y = tmp.y - 1;
                next.step = tmp.step + 1;//��¼����һ������� 
                q.push(next);
                maze[tmp.x][tmp.y - 1] = 1;//��¼�˴�
            }
            if (tmp.x + 1 < n && !maze[tmp.x + 1][tmp.y]) {//���� 
                next.x = tmp.x + 1;
                next.y = tmp.y;
                next.step = tmp.step + 1;//��¼����һ������� 
                q.push(next);
                maze[tmp.x + 1][tmp.y] = 1;//��¼�˴�
            }
            if (tmp.y + 1 < n && !maze[tmp.x][tmp.y + 1]) {//���� 
                next.x = tmp.x;
                next.y = tmp.y + 1;
                next.step = tmp.step + 1;//��¼����һ������� 
                q.push(next);
                maze[tmp.x][tmp.y + 1] = 1;//��¼�˴�
            }
            q.pop();//��ǰ�������ӣ�������һ���ж� 
        }
        
        if (tmp.x == n - 1 && tmp.y == n - 1)//����ȡ�����ڣ������ǰ���� 
            cout << q.front().step << endl;
        else
            cout << "0" << endl;
}               

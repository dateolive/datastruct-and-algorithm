#include<bits/stdc++.h>
using namespace std;
typedef struct LNode{
	int data;
	struct LNode *next;
}LNode,*LinkStack;
//初始化 
int Init(LinkStack &S){
	S = NULL;
	return 1;
}
//入栈 
int Push(LinkStack &S) {
	LNode *p = new LNode;
	srand((unsigned)time(0));
	p->data = rand() % 899 + 100;
	p->next = S;
	S = p;
	return 1;
}
//出栈 
int Pop(LinkStack &S){
	if (S == NULL) return 0;
	LNode *p = S;
	cout << S->data << "\t";
	S = S->next;
	delete p;
	return 1;
}
int main()
{
	LinkStack S;
	Init(S);
	cout << "随机生成三位整数，并存入链表中" << endl;
	for (int i = 0; i < 10; i++)
	{
		Push(S);
	}
	cout << endl;

	for (int i = 0; i < 10; i++)
	{
		Pop(S);
	}
}



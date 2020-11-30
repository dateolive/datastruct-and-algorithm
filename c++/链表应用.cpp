#include<bits/stdc++.h>
using namespace std;
struct linklist
{
	int data;
	linklist *next;
	int length;
};
//初始化 
void init(linklist *&list);
//插入 
void insert(linklist *&list, int data);
//查找 
void find(linklist *&list);
//线上 
void show(linklist*&list);
//插入指定位置的数据 
void posinsert(linklist*&list, int pos, int data);
//删除数据 
void Delete(linklist *&list, int data);
//反转 
void reverse(linklist *&list);
//提示 
void print();
//基准值 
linklist* midpatern(linklist *&list,int data);
int main()
{
	srand((int)time(0));
	int cnt = 1;
	linklist *list;
	init(list);
	while (cnt<=10)
	{
		insert(list, rand() % 900 + 100);
		cnt++;
	}
	int choose = 7;
	print();
	while (choose)
	{
		switch (choose)
		{
		case 1:show(list); break;
		case 2:find(list); break;
			case 3:
		{
			int pos;
			int data;
			cout << "要插入的整数：";
			cin >> data;
			cout << "要插入的位置：";
			cin >> pos;
			posinsert(list, pos, data); break;
		}
		case 4:
			int data;
			cout << "要删除的整数：";
			cin >> data;
			Delete(list, data);
			break;
		case 5:
			reverse(list); break;
		case 6:
			int data3;
			cout<<"请输入你的基准值"<<endl;
			cin>>data3;
			list=midpatern(list,data3);break;
		default:
			break;
		}
		cout << "执行操作";
		cin >> choose;
	}
}

void print()
{
	puts("0：退出");
	puts("1：显示链表的数据");
	puts("2：读入一个整数，查看该整数是否在表中");
	puts("3：读入一个整数和要插入的位置");
	puts("4：读入一个整数，若该整数在链表里，删除该数据，输出链表的内容");
	puts("5：把链表的内容翻转，输出链表的内容");
	puts("6.读入一个整数，以该值为基准把单链表分割为两部分，所有小于该值的结点排在大于或等于该值的结点之前。");
}
void init(linklist *&list)//初始化链表
{
	list = new linklist;
	list->next = NULL;
	list->length = 0;
}

void insert(linklist *&list, int data)
{
	linklist *p, *temp;
	p = list;
	temp = new linklist;
	temp->data = data;
	temp->next = NULL;
	while (p->next!=NULL)
	{
		p = p->next;
	}
	p->next = temp;
	list->length++;
}
void show(linklist*&list)
{
	linklist *p = list->next;
	int cnt = 1;
	while (p != NULL)
	{
		cout << "第" << cnt << "位的数值是：" << p->data<<endl;
		p = p->next;
		cnt++;
	}
}

void find(linklist *&list)
{
	linklist *p = list->next;
	int cnt = 1;
	int data;
	cout << "请输入要查找整数:";
	cin >> data;
	while (p!=NULL)
	{
		if (p->data == data) { cout << "该数所在位置为：" << cnt << endl; return; }
		cnt++;
		p = p->next;
	}
	cout << "表中无该整数\n";
}

void posinsert(linklist*&list, int pos, int data)
{
	if (pos < 1 || pos>list->length + 1){ 
		cout << "插入位置错误，请检查！"; 
		return; 
	}
	linklist *temp = new linklist;
	temp->data = data;
	temp->next = NULL;
	int cnt = 0;
	linklist *p = list;
	while (pos - 1 != cnt)
	{
		p = p->next;
		cnt++;
	}
	temp->next = p->next;
	p->next = temp;
	list->length++;
	cout << data << "插入到第" << pos << "位成功！\n";
}

void Delete(linklist *&list, int data)
{
	linklist *p = list;
	while (p->next!=NULL)
	{
		if (p->next->data == data)
		{
			linklist *q = p->next;
			p->next = q->next;
			delete q;
			cout << "找到" << data << "并删除成功\n";
			list->length--;
			show(list);
			return;
		}
		p = p->next;
	}
	if (!p) cout << "找不到数据\n";
}

void reverse(linklist *&list)
{
	linklist *p = list->next;
	linklist *temp;
	init(temp);
	while (p!=NULL)
	{
		linklist *q = p->next;
		p->next = temp->next;
		temp->next = p;
		p = q;
	}
	list = temp;
	cout << "翻转成功！\n";
}
//应用 
linklist* midpatern(linklist *&list,int data){
	if(list==NULL||list->next==NULL)return list;
	linklist *max;
	linklist *min;
	init(max);init(min);
	linklist* pmax=max;
	linklist* pmin=min;
	list=list->next;
	while(list){
		if(list->data>data){
			pmax->next=list;
			pmax=pmax->next;
			list=list->next;
			pmax->next=NULL;
		}else{
			pmin->next=list;
			pmin=pmin->next;
			list=list->next;
			pmin->next=NULL;
		}
	}
	pmin->next=max->next;
	return min;
	
}

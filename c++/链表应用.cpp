#include<bits/stdc++.h>
using namespace std;
struct linklist
{
	int data;
	linklist *next;
	int length;
};
//��ʼ�� 
void init(linklist *&list);
//���� 
void insert(linklist *&list, int data);
//���� 
void find(linklist *&list);
//���� 
void show(linklist*&list);
//����ָ��λ�õ����� 
void posinsert(linklist*&list, int pos, int data);
//ɾ������ 
void Delete(linklist *&list, int data);
//��ת 
void reverse(linklist *&list);
//��ʾ 
void print();
//��׼ֵ 
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
			cout << "Ҫ�����������";
			cin >> data;
			cout << "Ҫ�����λ�ã�";
			cin >> pos;
			posinsert(list, pos, data); break;
		}
		case 4:
			int data;
			cout << "Ҫɾ����������";
			cin >> data;
			Delete(list, data);
			break;
		case 5:
			reverse(list); break;
		case 6:
			int data3;
			cout<<"��������Ļ�׼ֵ"<<endl;
			cin>>data3;
			list=midpatern(list,data3);break;
		default:
			break;
		}
		cout << "ִ�в���";
		cin >> choose;
	}
}

void print()
{
	puts("0���˳�");
	puts("1����ʾ���������");
	puts("2������һ���������鿴�������Ƿ��ڱ���");
	puts("3������һ��������Ҫ�����λ��");
	puts("4������һ�����������������������ɾ�������ݣ�������������");
	puts("5������������ݷ�ת��������������");
	puts("6.����һ���������Ը�ֵΪ��׼�ѵ�����ָ�Ϊ�����֣�����С�ڸ�ֵ�Ľ�����ڴ��ڻ���ڸ�ֵ�Ľ��֮ǰ��");
}
void init(linklist *&list)//��ʼ������
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
		cout << "��" << cnt << "λ����ֵ�ǣ�" << p->data<<endl;
		p = p->next;
		cnt++;
	}
}

void find(linklist *&list)
{
	linklist *p = list->next;
	int cnt = 1;
	int data;
	cout << "������Ҫ��������:";
	cin >> data;
	while (p!=NULL)
	{
		if (p->data == data) { cout << "��������λ��Ϊ��" << cnt << endl; return; }
		cnt++;
		p = p->next;
	}
	cout << "�����޸�����\n";
}

void posinsert(linklist*&list, int pos, int data)
{
	if (pos < 1 || pos>list->length + 1){ 
		cout << "����λ�ô������飡"; 
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
	cout << data << "���뵽��" << pos << "λ�ɹ���\n";
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
			cout << "�ҵ�" << data << "��ɾ���ɹ�\n";
			list->length--;
			show(list);
			return;
		}
		p = p->next;
	}
	if (!p) cout << "�Ҳ�������\n";
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
	cout << "��ת�ɹ���\n";
}
//Ӧ�� 
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

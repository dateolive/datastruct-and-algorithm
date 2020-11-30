#include<bits/stdc++.h>
#define MaxSize 1000
using namespace std;
typedef struct Node{
	char data;
	int ltag;//0=>ָ�������� 1=>ָ��ǰ���ڵ� 
	int rtag;//0=?ָ�������� 1=>ָ���̽ڵ� 
	Node *lchild, *rchild;  //�������ҽڵ� 
}*BitTree, BitTNode;
BitTree pre=NULL;//��������ָ��ǰ����ǰ������ָ�� 
//���������� 
void CreateBinaryTree(BitTree &T){
	BitTree Tre[MaxSize];    
	BitTNode *p = NULL;
	int cnt=0,isLChild;
	T=NULL;
	T->ltag=0;T->rtag=1;
	char ch;
	cin>>ch;
	while(ch!='#'){
		switch(ch){
			case '(':Tre[++cnt]=p,isLChild=1;break;
			case ')':--cnt;break;
			case ',':isLChild=2;break;
			default:
				p=new BitTNode;
				p->data=ch;
				p->lchild=p->rchild=NULL;
				if(T==NULL){
					T=p;
				}else{
					switch(isLChild){
						case 1:Tre[cnt]->lchild=p;break;
						case 2:Tre[cnt]->rchild=p;break;
					}
				}
				break;
				
		}
		cin>>ch;
	}
	cout<<"�����ɹ�"<<endl;
}
//��������� 
void ShowOrder(BitTree T){
	cout<<T->data;
	if(T->lchild!=NULL||T->rchild!=NULL){
		cout<<"(";
		if(T->lchild!=NULL){
			ShowOrder(T->lchild);
		}
		if(T->rchild!=NULL){
			cout<<",";
			ShowOrder(T->rchild);
			cout<<")";	
		}
	}
}
//�����H���ڵ�����Һ��ӽ��ֵ��
bool GetHNodeValues(BitTree T){
	if(T==NULL) return false;
	else if(T->data=='H'){
		cout<<T->lchild->data<<" "<<T->rchild->data<<endl;
		return true;
	}else{
		GetHNodeValues(T->lchild);
		GetHNodeValues(T->rchild);
	}
	return false;
}

//����ö������Ľ�����
int GetBitTNodeCnt(BitTree T){
	if(T==NULL)
	return 0;
	else{
		return GetBitTNodeCnt(T->lchild)+GetBitTNodeCnt(T->rchild)+1;
	}
}
//Ҷ�ӽ�����
int GetBitTChildCnt(BitTree T){
	if(T==NULL)return 0;
	else if(T->rchild==NULL&& T->lchild==NULL)return 1;
	else return GetBitTChildCnt(T->lchild)+GetBitTChildCnt(T->rchild);
}
//�������Ķ�
int GetBitTDegree(BitTree T){
    if (T == NULL)return 0;
    else if ((T->lchild == NULL && T->rchild != NULL)||(T->lchild != NULL && T->rchild == NULL))return 1;
	else if (T->lchild != NULL && T->rchild != NULL)return 2;
}
//�������ĸ߶� 
int GetBitTHight(BitTree T){
	if(T==NULL)return 0;
	else{
		int lheight=GetBitTHight(T->lchild);
		int rheight=GetBitTHight(T->rchild);
		if(lheight>rheight)return lheight+1;
		else return rheight+1;
	}
}

//�ݹ� 
//ǰ�����
void PreOrder(BitTree T){
	if(T!=NULL){
	cout<<T->data;
	PreOrder(T->lchild);
	PreOrder(T->rchild);	
	}
} 
//�������
void InFixOrder(BitTree T){
	if(T!=NULL){
	InFixOrder(T->lchild);
	cout<<T->data;
	InFixOrder(T->rchild);	
	}
} 
//�������
void PostOrder(BitTree T){
	if(T!=NULL){
	PostOrder(T->lchild);
	PostOrder(T->rchild);
	cout<<T->data;	
	}
} 
//�ǵݹ�ǰ����� 
void NorecursivePreOrder(BitTree T){
	if(T!=NULL){
			stack<BitTree>p;
	while(T!=NULL || !p.empty()){
		if(T){
			cout<<T->data;
			p.push(T);
			T=T->lchild;
		}
		else{
			T=p.top();
			p.pop();
			T=T->rchild;
		}
	}
	}

} 
//�ǵݹ�������� 
void NorecursiveInFixOrder(BitTree T){
	if(T!=NULL){
			stack<BitTree>p;
	while(T!=NULL || !p.empty()){
		if(T){
			p.push(T);
			T=T->lchild;
		}
		else{
			T=p.top();
			p.pop();
			cout<<T->data;
			T=T->rchild;
		}
	}
	}

} 
//�ǵݹ������� 
//������->������->���ڵ�
//���������������ڵ㵽���������ٷ��ʸ��ڵ� 
//�����������ظ��ڵ���� 
void NorecursivePostOrder(BitTree T){
	if(T!=NULL){
	stack<BitTree>p;
	BitTree Tcur=T,TLast=NULL;//��ǰ�ڵ����һ���ڵ�
	while(Tcur){
		p.push(Tcur);//
		Tcur=Tcur->lchild;
	} 
	while(!p.empty()){
		Tcur=p.top();
		p.pop();
		//һ�����ڵ㱻���ʣ��������������������ڵ㱻���� 
		if(Tcur->rchild==NULL||TLast==Tcur->rchild){
			cout<<Tcur->data;
			TLast=Tcur;
		}else{
			//��ǰ��������������ڵ㣬�����������ڵ� 
			p.push(Tcur);
			Tcur=Tcur->rchild;
			while(Tcur){
				p.push(Tcur);
				Tcur=Tcur->lchild;
			}
		}
	}
}
} 
//������������
//�����������������������ҳ�������ǰ���ͺ�̡�
void ThreadBinaryTree(BitTree T){
	if(T){
			 ThreadBinaryTree(T->lchild);//��������������
	 //����ǰ�ڵ��ǰ���ڵ� 
	 if(T->lchild==NULL){
	 	T->lchild=pre;
		T->ltag=1; 
	 }
	//�����̽ڵ�
	if(pre!=NULL&&pre->rchild==NULL){
		pre->rchild=T;
		pre->rtag=1;
	} 
	pre=T;
	ThreadBinaryTree(T->rchild);
	} 
		
} 
int main(){
	BitTree T;
	//A(B(D,E(H(J,K(L,M(,N))))),C(F,G(,I)))#
	CreateBinaryTree(T);
	cout<<"���������:"; 
	ShowOrder(T);
	cout<<"\nH�ڵ�����Һ�����:";
	GetHNodeValues(T);
	cout<<"�������ڵ�ĸ���:"<<GetBitTNodeCnt(T)<<endl;
	cout<<"������Ҷ�ӽڵ����:"<<GetBitTChildCnt(T)<<endl;
	cout<<"�������Ķ�:"<<GetBitTDegree(T)<<endl;
	cout<<"�������ĸ߶�:"<<GetBitTHight(T)<<endl;
	cout<<"�ݹ�ǰ�����:";
	PreOrder(T);
	cout<<"\n�ݹ��������:";
	InFixOrder(T);
	cout<<"\n�ݹ�������:";
	PostOrder(T);
	cout<<"\n�ǵݹ�ǰ�����:";
	NorecursivePreOrder(T);
	cout<<"\n�ǵݹ��������:";
	NorecursiveInFixOrder(T);
	cout<<"\n�ǵݹ�������";
	NorecursivePostOrder(T);
	cout<<"\n����������������";
	ThreadBinaryTree(T);
	cout<<T->lchild->data<<" "<<T->rchild->data<<endl; 
}


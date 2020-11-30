#include<bits/stdc++.h>
#define MaxSize 1000
using namespace std;
typedef struct Node{
	char data;
	int ltag;//0=>指向左子树 1=>指向前驱节点 
	int rtag;//0=?指向右子树 1=>指向后继节点 
	Node *lchild, *rchild;  //定义左右节点 
}*BitTree, BitTNode;
BitTree pre=NULL;//线索化，指向当前结点的前驱结点的指针 
//二叉树创建 
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
	cout<<"创建成功"<<endl;
}
//输出二叉树 
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
//输出‘H’节点的左、右孩子结点值；
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

//输出该二叉树的结点个数
int GetBitTNodeCnt(BitTree T){
	if(T==NULL)
	return 0;
	else{
		return GetBitTNodeCnt(T->lchild)+GetBitTNodeCnt(T->rchild)+1;
	}
}
//叶子结点个数
int GetBitTChildCnt(BitTree T){
	if(T==NULL)return 0;
	else if(T->rchild==NULL&& T->lchild==NULL)return 1;
	else return GetBitTChildCnt(T->lchild)+GetBitTChildCnt(T->rchild);
}
//二叉树的度
int GetBitTDegree(BitTree T){
    if (T == NULL)return 0;
    else if ((T->lchild == NULL && T->rchild != NULL)||(T->lchild != NULL && T->rchild == NULL))return 1;
	else if (T->lchild != NULL && T->rchild != NULL)return 2;
}
//二叉树的高度 
int GetBitTHight(BitTree T){
	if(T==NULL)return 0;
	else{
		int lheight=GetBitTHight(T->lchild);
		int rheight=GetBitTHight(T->rchild);
		if(lheight>rheight)return lheight+1;
		else return rheight+1;
	}
}

//递归 
//前序遍历
void PreOrder(BitTree T){
	if(T!=NULL){
	cout<<T->data;
	PreOrder(T->lchild);
	PreOrder(T->rchild);	
	}
} 
//中序遍历
void InFixOrder(BitTree T){
	if(T!=NULL){
	InFixOrder(T->lchild);
	cout<<T->data;
	InFixOrder(T->rchild);	
	}
} 
//后序遍历
void PostOrder(BitTree T){
	if(T!=NULL){
	PostOrder(T->lchild);
	PostOrder(T->rchild);
	cout<<T->data;	
	}
} 
//非递归前序遍历 
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
//非递归中序遍历 
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
//非递归后序遍历 
//左子树->右子树->根节点
//左子树，跳过根节点到右子树，再访问根节点 
//右子树，返回根节点继续 
void NorecursivePostOrder(BitTree T){
	if(T!=NULL){
	stack<BitTree>p;
	BitTree Tcur=T,TLast=NULL;//当前节点和上一个节点
	while(Tcur){
		p.push(Tcur);//
		Tcur=Tcur->lchild;
	} 
	while(!p.empty()){
		Tcur=p.top();
		p.pop();
		//一个根节点被访问，无右子树或者右子树节点被访问 
		if(Tcur->rchild==NULL||TLast==Tcur->rchild){
			cout<<Tcur->data;
			TLast=Tcur;
		}else{
			//当前左子树，保存根节点，跳到右子树节点 
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
//线索化二叉树
//中序线索化上述二叉树并找出根结点的前驱和后继。
void ThreadBinaryTree(BitTree T){
	if(T){
			 ThreadBinaryTree(T->lchild);//先线索化左子树
	 //处理当前节点的前驱节点 
	 if(T->lchild==NULL){
	 	T->lchild=pre;
		T->ltag=1; 
	 }
	//处理后继节点
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
	cout<<"二叉树输出:"; 
	ShowOrder(T);
	cout<<"\nH节点的左右孩子是:";
	GetHNodeValues(T);
	cout<<"二叉树节点的个数:"<<GetBitTNodeCnt(T)<<endl;
	cout<<"二叉树叶子节点个数:"<<GetBitTChildCnt(T)<<endl;
	cout<<"二叉树的度:"<<GetBitTDegree(T)<<endl;
	cout<<"二叉树的高度:"<<GetBitTHight(T)<<endl;
	cout<<"递归前序遍历:";
	PreOrder(T);
	cout<<"\n递归中序遍历:";
	InFixOrder(T);
	cout<<"\n递归后序遍历:";
	PostOrder(T);
	cout<<"\n非递归前序遍历:";
	NorecursivePreOrder(T);
	cout<<"\n非递归中序遍历:";
	NorecursiveInFixOrder(T);
	cout<<"\n非递归后序遍历";
	NorecursivePostOrder(T);
	cout<<"\n中序线索化二叉树";
	ThreadBinaryTree(T);
	cout<<T->lchild->data<<" "<<T->rchild->data<<endl; 
}


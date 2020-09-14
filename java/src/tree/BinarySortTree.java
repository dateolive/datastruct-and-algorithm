package tree;
/**
 
 二叉排序树：BST: (Binary Sort(Search) Tree), 对于二叉排序树的任何一个非叶子节点，要求左子节点的值比当前节点的值小，
 右子节点的值比当前节点的值大。
 特别说明：如果有相同的值，可以将该节点放在左子节点或右子节点
 * @author Lenovo
 *
 */
public class BinarySortTree {

	public static void main(String[] args) {
		int arr[] = {7,3,10,12,5,1,9};
		Binarysort tree=new Binarysort();
		for(int i=0;i<arr.length;i++){
			tree.add(new Node2(arr[i]));
		}
		System.out.println("中序遍历二叉排序树");
		tree.infixOrder();
		//测试一下删除叶子节点
		tree.delNode(1);
		tree.delNode(3);
		System.out.println("删除后的节点:");
		tree.infixOrder(); // 0,1,3,5,9,10,12

	}

}
//创建Node2节点
class Node2{
	int value;
	Node2 leftNode2;
	Node2 rightNode2;
	
	public Node2(int value){
		this.value=value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node2 [value=" + value + "]";
	}
	//添加节点
	//递归的形式添加结点,注意需要满足二叉排序树的要求
	public void add(Node2 node){
		if(node==null){
			return;
		}
		//如果要添加的节点小于当前子树的根节点，则添加在左边
		if(node.value<this.value){
			//如果当前的左子节点为空，则添加
			if(this.leftNode2==null){
				this.leftNode2=node;
			}else{
				//如果当前的左子节点不为空，则递归
				this.leftNode2.add(node);
			}
		}else{
			//如果要添加的节点大于等于当前字树的根节点，则添加在右边
			//如果当前的右子节点为空，则添加
			if(this.rightNode2==null){
				this.rightNode2=node;
			}else{
				//不为空则递归
				this.rightNode2.add(node);
			}
		}
	}
	//中序遍历
	public void infixOrder(){
		if(this.leftNode2!=null){
			this.leftNode2.infixOrder();
		}
		System.out.println(this);
		if(this.rightNode2!=null){
			this.rightNode2.infixOrder();
		}
	}

	//寻找要删除的节点
	public Node2 search(int value){
		if(this.value==value){
			//如果找到了，则返回
			return this;
		}else if(this.value>value){
			//如果当前节点大于要找的节点的值，则向左查找
			if(this.leftNode2==null){
				return null;//左子树为空
			}
			return this.leftNode2.search(value);
		}else{
			if(this.rightNode2==null){
				return null;
			}
			return this.rightNode2.search(value);
		}
	}
	//查找要删除的父节点
	public Node2 searchParent(int value){
		//如果当前的下一个左(右)子节点不为空，且值与查找的值相同，则返回当前的节点
		if((this.leftNode2!=null&&this.leftNode2.value==value)||(this.rightNode2!=null&&this.rightNode2.value==value)){
			return this;
		}else{
			//如果查找的值小于当前结点的值,且当前结点的左子结点不为空
			if(this.leftNode2!=null&&this.value>value){
				return this.leftNode2.searchParent(value);//递归向左子树查找
			}else if(this.rightNode2!=null&&this.value<=value){
				return this.rightNode2.searchParent(value);
			}else{
				return null;
			}
		}
	}
	
}
//创建一个二叉排序树
class Binarysort{
	private Node2 root;
	
	//编写添加节点
	public void add(Node2 node){
		if(root==null){
			root=node;
		}else{
			root.add(node);
		}
	}
	
	//编写中序遍历
	public void infixOrder(){
		if(root==null){
			System.out.println("二叉排序树为空！！！");
		}else{
			root.infixOrder();
		}
	}
	//查找要删除的节点
	public Node2 search(int value){
		if(root==null)
			return null;
		return root.search(value);
	}
	//查找要删除的节点的父节点
	public Node2 searchParent(int value){
		if(root==null)
			return null;
		return root.searchParent(value);
	}
	/**
第一种情况: 删除叶子节点 (比如：2, 5, 9, 12)
思路
(1) 需求先去找到要删除的结点  targetNode
(2) 找到targetNode 的 父结点 parent 
(3) 确定 targetNode 是 parent的左子结点 还是右子结点
(4) 根据前面的情况来对应删除
	左子结点 parent.left = null
	右子结点 parent.right = null;
第二种情况: 删除只有一颗子树的节点 比如 1
思路
(1) 需求先去找到要删除的结点  targetNode
(2) 找到targetNode 的 父结点 parent 
(3) 确定targetNode 的子结点是左子结点还是右子结点
(4) targetNode 是 parent 的左子结点还是右子结点
(5) 如果targetNode 有左子结点
	5.1 如果 targetNode 是 parent 的左子结点
		parent.left = targetNode.left;
	5.2 如果 targetNode 是 parent 的右子结点
		parent.right = targetNode.left;
(6) 如果targetNode 有右子结点
	6.1 如果 targetNode 是 parent 的左子结点
		parent.left = targetNode.right;
	6.2 如果 targetNode 是 parent 的右子结点
		parent.right = targetNode.right
		
情况三: 删除有两颗子树的节点. (比如：7, 3，10 )
思路
(1) 需求先去找到要删除的结点  targetNode
(2) 找到targetNode 的 父结点 parent 
(3) 从targetNode 的右子树找到最小的结点
(4) 用一个临时变量，将 最小结点的值保存 temp = 11
(5) 删除该最小结点
(6) targetNode.value = temp

	 */
	//删除节点
	public void delNode(int value){
		if(root==null)
			return;
		else{
			//需求先去找到要删除的结点  targetNode
			Node2 targetNode=search(value);
			//要找的节点为空
			if(targetNode==null)
				return;
			//如果当前二叉排序树的结点只有一个
			if(root.leftNode2==null&&root.rightNode2==null){
				root=null;
				return;
			}
			//找到targetNode 的 父结点 parent 
			Node2 parent=searchParent(value);
			//判断当前的是叶子节点
			if(targetNode.leftNode2==null&&targetNode.rightNode2==null){
				//判断tar是parent的左子节点
				if(parent.leftNode2!=null&&parent.leftNode2.value==value){
					parent.leftNode2=null;
				}else if(parent.rightNode2!=null&&parent.rightNode2.value==value){
					parent.rightNode2=null;
				}
			}else if(targetNode.leftNode2!=null&&targetNode.rightNode2!=null)
			{
				//判断当前是有两颗子树的节点
				int minval=delRightT(targetNode.rightNode2);
				//int maxval=delLeftT(targetNode.leftNode2);
				targetNode.value=minval;
				
				
				
			}else{
				//判断当前是只有一颗子树的节点
				//如果targetNode 的子结点是左子结点
				if(targetNode.leftNode2!=null){
					//判断当前的父节点是否为空
					if(parent!=null){
						//如果 targetNode 是 parent 的左子结点
						if(parent.leftNode2.value==value){
							parent.leftNode2=targetNode.leftNode2;
						}else{
							//如果 targetNode 是 parent 的右子结点
							parent.rightNode2=targetNode.leftNode2;
						}
					}else{
						root=targetNode.leftNode2;
					}
				}else{
					//如果targetNode 的子结点是右子结点
					//判断当前父节点是否为空
					if(parent!=null){
						if(parent.leftNode2.value==value){
							parent.leftNode2=targetNode.rightNode2;
						}else{
							parent.rightNode2=targetNode.rightNode2;
						}
					}else{
						root=targetNode.rightNode2;
					}
				}
			}
			
			
			
		}
	}
	//编写方法
		//1.返回的 以node 为根结点的二叉排序树的最小结点的值
		//2.删除node 为根结点的二叉排序树的最小结点
		/**
		  * 
		  * @Description 
		  * @param node 传入的结点(为二叉排序树的根结点),传入的节点是要删除节点的右子节点
		  * @return 返回的 以node 为根结点的二叉排序树的最小结点的值//从targetNode 的右子树找到最小的结点
		 */
	public int delRightT(Node2 node){
		Node2 tar = node;
		//循环的查找左子节点，就会找到最小值
		while(tar.leftNode2 != null){
			tar = tar.leftNode2;
		}
		//这时 target就指向了最小结点
		//删除最小结点
		delNode(tar.value);
		return tar.value;
	}

	// 编写方法
	// 1.返回的 以node 为根结点的二叉排序树的最大结点的值
	// 2.删除node 为根结点的二叉排序树的最大结点
	/**
	 * 
	 * @Description
	 * @param node
	 *            传入的结点(为二叉排序树的根结点),传入的节点是要删除节点的左子节点
	 * @return 返回的 以node 为根结点的二叉排序树的最大结点的值//从targetNode 的左子树找到最大的结点
	 */
	public int delLeftT(Node2 node) {
		Node2 tar = node;
		while (tar.rightNode2 != null) {
			tar = tar.rightNode2;
		}
		delNode(tar.value);
		return tar.value;

	}
	
}

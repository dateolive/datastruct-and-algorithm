package tree;
/**
 * 1.平衡二叉树也叫平衡二叉搜索树（Self-balancing binary search tree）又被称为AVL树， 可以保证查询效率较高。
2.具有以下特点：它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。平衡二
叉树的常用实现方法有红黑树、AVL、替罪羊树、Treap、伸展树等。
 * @author Lenovo
 *
 */
public class AVLTree {

	public static void main(String[] args) {
		//int[] arr = { 4, 3, 6, 5, 7, 8 };
		//int arr[] = { 10,12, 8, 9, 7, 6};
		int arr[] = { 10,12, 8, 9, 7, 6};
		// 创建一个 AVLTree对象
		AVLtreedemo avlTree = new AVLtreedemo();

		// 添加结点
		for (int i = 0; i < arr.length; i++) {
			avlTree.add(new Node3(arr[i]));
		}

		// 中序遍历
		System.out.println("中序遍历:");
		avlTree.infixOrder(); // 3,4,5,6,7,8

		System.out.println("经过平衡处理的树:");
		System.out.println("树的高度:" + avlTree.getRoot().heigth()); // 3
		System.out.println("树的左子树高度:" + avlTree.getRoot().leftheight()); // 2
		System.out.println("树的右子树高度:" + avlTree.getRoot().rightheight()); // 2
		System.out.println("当前的根节点:" + avlTree.getRoot());//8

	}

}
//创建Node结点
class Node3 {
	int value;
	Node3 left;
	Node3 right;

	public Node3(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node3 [value=" + value + "]";
	}

	// 添加节点的方法
	// 递归的形式添加结点,注意需要满足二叉排序树的要求
	public void add(Node3 node) {
		if (node == null) {
			return;
		}

		// 判断传入的结点的值,和当前子树的根结点的值的关系
		if (node.value < this.value) {
			if (this.left == null) { // 如果当前结点左子结点为null
				this.left = node;
			} else {
				// 递归的向左子树添加
				this.left.add(node);
			}
		} else { // 添加的节点的值大于当前结点的值
			if (this.right == null) {
				this.right = node;
			} else {
				// 递归的向右子树添加
				this.right.add(node);
			}
		}
		//添加完一个节点，发现右子树-左子树的高度>1，则左旋转
		if(rightheight()-leftheight()>1){
			//如果它的右子树的左子树高度大于它右子树的右子树的高度，
			if(right!=null&&(right.leftheight()>right.rightheight())){
				//先进行右旋转
				right.rightRate();
				leftRate();
			}else{
			leftRate();
			}
			return;//不return的话很可能陷入死循环
		}
		//添加完一个节点，发现左子树-右子树的高度>1，则右旋转
		if(leftheight()-rightheight()>1){
			//如果它的左子树的右子树高度大于它的左子树的高度
			if(left!=null&&(left.rightheight()>left.leftheight()))
			{
				//先进行左旋转
				left.leftRate();
				rightRate();
			}else{
				rightRate();
			}
			
		}
		
	}

	// 中序遍历
	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOrder();
		}
	}

	// 查找要删除的节点
	/**
	 * 
	 * @Description
	 * @param value
	 *            希望删除的结点的值
	 * @return 如果找到该值返回,未找到返回null
	 */
	public Node3 search(int value) {
		if (value == this.value) { // 说明找到了
			return this;
		} else if (value < this.value) { // 查找的值小于当前结点的值,向左子树查找
			if (this.left == null) { // 左子结点为空
				return null;
			}
			return this.left.search(value);
		} else { // 查找的值不小于当前结点的值,向右子树查找
			if (this.right == null) {
				return null;
			}
			return this.right.search(value);
		}
	}

	// 查找要删除结点的父结点
	/**
	 * 
	 * @param value
	 *            希望删除的结点的值
	 * @return 返回的是要删除的结点的父结点,如果没有就返回null
	 */
	public Node3 searchP(int value) {
		// 如果当前结点是要删除的结点的父结点,如果没有就返回null
		if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
			return this;
		} else {
			// 如果查找的值小于当前结点的值,且当前结点的左子结点不为空
			if (value < this.value && this.left != null) {
				return this.left.searchP(value); // 向左子树查找
			} else if (value >= this.value && this.right != null) {
				return this.right.searchP(value); // 向右子树递归查找
			} else {
				return null; // 未找到父结点
			}
		}
	}
	//返回该节点为根节点的树的高度
	public int heigth(){
		return Math.max(left==null?0:left.heigth(),right==null?0:right.heigth())+1;
	}
	
	//返回左子树的高度
	public int leftheight(){
		if(left==null)
			return 0;
		return left.heigth();
	}
	//返回右子树的高度
	public int rightheight(){
		if(right==null)
			return 0;
		return right.heigth();
	}
	
	public void leftRate(){
		// 创建新的结点，以当前根结点的值
		Node3 newNode=new Node3(value);
		// 把新的结点的左子树设置成当前结点的左子树
		newNode.left=left;
		// 把新的结点的右子树设置成当前结点的右子树的左子树
		newNode.right=right.left;
		//把当前节点的右子节点的值赋给当前节点
		value=right.value;
		// 把当前结点的右子树设置成当前结点右子树的右子树
		right=right.right;
		//把当前节点的左子树设置成新的节点
		left=newNode;
		
	}
	public void rightRate(){
		Node3 newNode=new Node3(value);
		newNode.right=right;
		newNode.left=left.right;
		value=left.value;
		left=left.left;
		right=newNode;
	}
	



}

//创建AVL树
class AVLtreedemo {
	private Node3 root;

	public Node3 getRoot() {
		return root;
	}

	// 添加结点的方法
	public void add(Node3 node) {
		if (root == null) {
			root = node; // 如果root为空则直接让root指向node
		} else {
			root.add(node);
		}
	}

	// 遍历方法
	public void infixOrder() {
		if (root != null) {
			root.infixOrder();
		} else {
			System.out.println("二叉排序树为空！！！");
		}
	}

	// 查找要刪除的结点
	public Node3 search(int value) {
		if (root == null) {
			return null;
		} else {
			return root.search(value);
		}
	}

	// 查找要删除的节点的父节点
	public Node3 searchP(int value) {
		if (root == null) {
			return null;
		} else {
			return root.searchP(value);
		}
	}

	// 删除节点
	public void delNode(int value) {
		if (root == null) {
			return;
		} else {
			// 1.需求先去找到要删除的结点 targetNode
			Node3 targetNode = search(value);
			// 如果没有找到要删除的结点
			if (targetNode == null) {
				return;
			}
			// 如果我们发现当前这颗二叉排序树只有一个结点
			if (root.left == null && root.right == null) {
				root = null;
				return;
			}
			// 去找到targetNode的父结点
			Node3 parent = searchP(value);
			// 如果要删除的节点为叶子节点
			if (targetNode.left == null && targetNode.right == null) {
				// 判断targetNode是父节点的左子结点,还是右子节点
				if (parent.left != null && parent.left.value == value) { // 左子节点
					parent.left = null;
				} else if (parent.right != null && parent.right.value == value) { // 右子节点
					parent.right = null;
				}
			} else if (targetNode.left != null && targetNode.right != null) { // 删除有两颗子树的节点
				int minVa = delRightT(targetNode.right);
				targetNode.value = minVa;
			} else { // 删除只有一个字树的节点
				// 如果要删除的结点有左子结点
				if (targetNode.left != null) {
					if (parent != null) {
						// 如果 targetNode 是 parent 的左子结点
						if (parent.left.value == value) {
							parent.left = targetNode.left;
						} else { // targetNode 是 parent 的右子结点
							parent.right = targetNode.left;
						}
					} else {
						root = targetNode.left;
					}
				} else { // 如果要删除的结点有右子结点
					if (parent != null) {
						// 如果 targetNode 是 parent 的左子结点
						if (parent.left.value == value) {
							parent.left = targetNode.right;
						} else { // 如果 targetNode 是 parent 的右子结点
							parent.right = targetNode.right;
						}
					} else {
						root = targetNode.right;
					}
				}
			}
		}
	}

	// 编写方法
	// 1.返回的 以node 为根结点的二叉排序树的最小结点的值
	// 2.删除node 为根结点的二叉排序树的最小结点
	/**
	 * 
	 * @Description
	 * @param node
	 *            传入的结点(为二叉排序树的根结点)
	 * @return 返回的 以node 为根结点的二叉排序树的最小结点的值
	 */
	public int delRightT(Node3 node) {
		Node3 tar = node;
		// 循环的查找左子节点，就会找到最小值
		while (tar.left != null) {
			tar = tar.left;
		}
		// 这时 target就指向了最小结点
		// 删除最小结点
		delNode(tar.value);
		return tar.value;
	}
}
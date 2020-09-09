package tree;
/**
 * 问题分析: 
1.当我们对上面的二叉树进行中序遍历时，数列为 {8, 3, 10, 1, 6, 14 }
2.但是 6, 8, 10, 14 这几个节点的 左右指针，并没有完全的利用上.
3.如果我们希望充分的利用 各个节点的左右指针， 让各个节点可以指向自己的前后节点,怎么办?
 * @author Lenovo
 *
 */
public class ThreadedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//测试中序线索二叉树的功能
				 StuNode root = new StuNode(1, "Z1");
				 StuNode node2 = new StuNode(3, "S5");
				 StuNode node3 = new StuNode(6, "R6");
				 StuNode node4 = new StuNode(8, "G4");
				 StuNode node5 = new StuNode(10, "P8");
				 StuNode node6 = new StuNode(14, "Q1");
				
				//二叉树，后面需要要递归创建,所以先简单处理使用手动创建
				root.setLeft(node2);
				root.setRight(node3);
				node2.setLeft(node4);
				node2.setRight(node5);
				node3.setLeft(node6);
				
				//测试中序线索化
				ThreadeTree threadTree = new ThreadeTree();
				threadTree.setRoot(root);
				threadTree.treadNodes();
				
				//测试:以10号节点测试
				 StuNode left = node5.getLeft();
				 StuNode right = node5.getRight();
				System.out.println("10号节点的前驱是:" + left);
				System.out.println("10号节点的后继是:" + right);
	}
	
}
/**
 * 创建一个 StuNode 结点
 * 
 */
class StuNode{
	private int id;
	private String name;
	private StuNode  left; // 默认为null,左子节点
	private StuNode  right; // 默认为null,右子节点
	//1.如果leftType == 0 表示指向的是左子树, 如果 1 则表示指向前驱结点
	//2.如果rightType == 0 表示指向是右子树, 如果 1表示指向后继结点
	private int leftType;
	private int rightType;
	/**
	 * 对 StuNode 进行重载
	 * @param id 编号
	 * @param name  姓名
	 */
	public StuNode (int id,String name){
		this.id=id;
		this.name=name;
		
	}
	/**
	 * @return the leftType
	 */
	public int getLeftType() {
		return leftType;
	}
	/**
	 * @param leftType the leftType to set
	 */
	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}
	/**
	 * @return the rightType
	 */
	public int getRightType() {
		return rightType;
	}
	/**
	 * @param rightType the rightType to set
	 */
	public void setRightType(int rightType) {
		this.rightType = rightType;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the left
	 */
	public  StuNode  getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft( StuNode  left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public  StuNode  getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight( StuNode  right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return " StuNode  [id=" + id + ", name=" + name + "]";
	}
}
/**
 * 	n个结点的二叉链表中含有n+1 【公式 2n-(n-1)=n+1】 个空指针域。利用二叉链表中的空指针域，
 * 	存放指向该结点在某种遍历次序下的前驱和后继结点的指针（这种附加的指针称为"线索"
	这种加上了线索的二叉链表称为线索链表，相应的二叉树称为线索二叉树(Threaded BinaryTree)。
	根据线索性质的不同，线索二叉树可分为前序线索二叉树、中序线索二叉树和后序线索二叉树三种
	一个结点的前一个结点，称为前驱结点
	一个结点的后一个结点，称为后继结点
 */
//定义一个线索化二叉树，实现对二叉树的线索化
class ThreadeTree{
	private  StuNode  root;
	//为了实现线索化,需要创建要给指向当前结点的前驱结点的指针
	//在递归进行线索化时,pre 总是保留前一个结点
	private  StuNode  pre=null;
	/**
	 * @return the root
	 */
	public  StuNode  getRoot() {
		return root;
	}
	/**
	 * @param root the root to set
	 */
	public void setRoot( StuNode  root) {
		this.root = root;
	}
	//重载 线索化的方法treadNodes
	public void treadNodes(){
		this.treadNodes(root);
	}
	//编写对二叉树进行中序线索化的方法
	//node 即当前需要线索化的结点
	public void treadNodes(StuNode  node){
		//如果node为空，直接返回
		if(node==null){
			return;
		}
		
		//对二叉树进行中序线索化，
		//1.先线索化左子树
		treadNodes(node.getLeft());
		//2.线索化当前结点
		//线索化当前结点的前驱结点
		if(node.getLeft()==null){
			//让当前的结点指向前驱结点
			node.setLeft(pre);
			//然后修改当前节点的指针类型
			node.setLeftType(1);
		}
		//线索化当前结点的后继结点
		if(pre!=null&&pre.getRight()==null)
		{
			//让前驱结点的右指针指向当前结点
			pre.setRight(node);
			//修改当前结点的指针类型
			pre.setRightType(1);
		}
		//重要  每处理一个结点后,让当前结点是下一个结点的前驱结点
		pre=node;
		//3.优化右子树
		treadNodes(node.getRight());
	}
	
}


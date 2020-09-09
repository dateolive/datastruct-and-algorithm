package tree;

public class ArrBinaryTree {
	//顺序存储二叉树
	/**
	 * 要求:
		1.上图的二叉树的结点，要求以数组的方式来存放 arr : [1, 2, 3, 4, 5, 6, 6]
		2.要求在遍历数组 arr时，仍然可以用前序遍历，中序遍历和后序遍历的方式完成结点的遍历
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr={1, 2, 3, 4, 5, 6, 7 };
		ArraryBinaryTree Btree=new ArraryBinaryTree(arr);
		System.out.println("前序遍历");
		Btree.preOrder();
		System.out.println("中序遍历");
		Btree.infixOrder();
		System.out.println("后序遍历");
		Btree.postOrder();
	}
	
}
/**
 *  1.顺序二叉树通常只考虑完全二叉树
	2.第n个元素的左子节点为  2 * n + 1 
	3.第n个元素的右子节点为  2 * n + 2
	4.第n个元素的父节点为  (n-1) / 2
	5.n : 表示二叉树中的第几个元素(按0开始编号)
 */
//实现顺序存储二叉树遍历
class ArraryBinaryTree{
	private int[] arr;
	public ArraryBinaryTree(int[] arr){
		super();
		this.arr=arr;
	}
	//重载方法
	public void preOrder(){
		this.preOrder(0);
	}
	public void infixOrder(){
		this.infixOrder(0);
	}
	public void postOrder(){
		this.postOrder(0);
	}
	/**
	 * 实现顺序存储二叉树的前序遍历
	 * @param index  数组下标
	 */

	public void preOrder(int index){
		if(arr==null||arr.length==0){
			System.out.println("数组为空,无法遍历查找。");
		}
		System.out.println(arr[index]);
		//向左递归遍历
		if((index*2+1)<arr.length){
			preOrder(index*2+1);
		}
		//向右递归遍历
		if((index*2+2)<arr.length){
			preOrder(index*2+2);
		}
	}
	/**
	 * 实现顺序存储二叉树的中序遍历
	 * @param index 数组下标
	 */
	public void infixOrder(int index){
		if(arr==null||arr.length==0){
			System.out.println("数组为空,无法遍历查找。");
		}
		if((2*index+1)<arr.length){
			infixOrder(index*2+1);
		}
		System.out.println(arr[index]);
		if((2*index+2)<arr.length){
			infixOrder(index*2+2);
		}
		
	}
	/**
	 * 实现顺序存储二叉树的后序遍历
	 * @param index 数组下标
	 */
	public void postOrder(int index){
		if(arr==null||arr.length==0){
			System.out.println("数组为空,无法遍历查找。");
		}
		if((index*2+1)<arr.length){
			postOrder(index*2+1);
		}
		if((index*2+2)<arr.length){
			postOrder(index*2+2);
		}
		System.out.println(arr[index]);
	}
	
}

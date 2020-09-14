package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 给定n个权值作为n个叶子结点，构造一棵二叉树，若该树的带权路径长度(wpl)达到最小，称这样的二叉树为最优二叉树，也称为哈夫曼树(Huffman Tree)
 赫夫曼树是带权路径长度最短的树，权值较大的结点离根较近。

1.路径和路径长度：在一棵树中，从一个结点往下可以达到的孩子或孙子结点之间的通路，称为路径。通路中分支的数目称为路径长度。若规定根结点的层数为1，
则从根结点到第L层结点的路径长度为L-1
2.结点的权及带权路径长度：若将树中结点赋给一个有着某种含义的数值，则这个数值称为该结点的权。结点的带权路径长度为：从根结点到该结点之间的路径长度
与该结点的权的乘积
3.树的带权路径长度：树的带权路径长度规定为所有叶子结点的带权路径长度之和，记为WPL(weighted path length) ,权值越大的结点离根结点越近的二叉树
才是最优二叉树。
4.WPL最小的就是赫夫曼树


 * @author Lenovo
 *
 */
public class Huffmantree {
	/**
	 * 
构成赫夫曼树的步骤：
1.从小到大进行排序, 将每一个数据，每个数据都是一个节点 ， 每个节点可以看成是一颗最简单的二叉树
2.取出根节点权值最小的两颗二叉树
3.组成一颗新的二叉树, 该新的二叉树的根节点的权值是前面两颗二叉树根节点权值的和
4.再将这颗新的二叉树，以根节点的权值大小 再次排序， 不断重复 1-2-3-4 的步骤，直到数列中，所有的数据都被处理，就得到一颗赫夫曼树
	 * @param args
	 */

	public static void main(String[] args) {
		int arr[]={13, 7, 8, 3, 29, 6, 1 };
		Node root=hufuManTree(arr);
		PreOrder(root);
		

	}
	//前序遍历方法
	public static void PreOrder(Node root){
		if(root!=null){
			root.PreOrder();
		}else{
			System.out.println("空树，无法遍历");
		}
		
	}
	//创建hufuman树
	public static Node hufuManTree(int[] arr){
		// 第一步,为了操作方法
		// 1.遍历 arr 数组
		// 2.将arr的每个元素构成一个Node
		// 3.将Node 放入到ArrayList中
		List<Node> nodes=new ArrayList<Node>();
		for(int value:arr){
			nodes.add(new Node(value));
		}
		//循环操作
		while(nodes.size()>1){
			//从小到大排序
			Collections.sort(nodes);
			// 取出根节点权值最小的两颗二叉树
			// (1)取出权值最小的结点(二叉树)
			Node leftNode=nodes.get(0);
			//(2)取出权值次小的节点
			Node rightNode=nodes.get(1);
			// (3)构建一个新的二叉树
			Node parent=new Node(leftNode.value+rightNode.value);
			parent.leftNode=leftNode;
			parent.rightNode=rightNode;
			// (4)从ArrayList删除处理过的二叉树
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			// (5)将parent加入到nodes
			nodes.add(parent);
		}
		// 返回赫夫曼树的root结点
		return nodes.get(0);
		
	}
	


}
//创建一个节点
// 为了让Node 对象持续排序Collections集合排序
// 让Node 实现Comparable接口
class Node implements Comparable<Node>{
	int value;//权值
	Node leftNode;//左子节点
	Node rightNode;//右子节点
	
	public Node(int value){
		this.value=value;
	}
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	@Override
	public int compareTo(Node o) {
		// 表示从小到大排序
		return this.value - o.value;
	}
	//前序遍历
	public void PreOrder(){
		System.out.println(this);
		if(this.leftNode!=null)
			this.leftNode.PreOrder();
		if(this.rightNode!=null)
			this.rightNode.PreOrder();
	}

	
}
